package com.ssk.ecommerce.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssk.ecommerce.Enum.OrderStatus;
import com.ssk.ecommerce.Exception.OrdersException;
import com.ssk.ecommerce.Exception.UserException;
import com.ssk.ecommerce.Model.Cart;
import com.ssk.ecommerce.Model.CartItem;
import com.ssk.ecommerce.Model.OrderItem;
import com.ssk.ecommerce.Model.Orders;
import com.ssk.ecommerce.Model.User;
import com.ssk.ecommerce.ModelDTO.OrdersDTO;
import com.ssk.ecommerce.Repository.CartItemRepository;
import com.ssk.ecommerce.Repository.CartRepository;
import com.ssk.ecommerce.Repository.OrderItemRepository;
import com.ssk.ecommerce.Repository.OrderRepository;
import com.ssk.ecommerce.Repository.ProductRepository;
import com.ssk.ecommerce.Repository.UserRepository;
import com.ssk.ecommerce.Service.OrdersService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service

public class OrdersServiceImpl implements OrdersService {

	@Autowired
    private  OrderRepository orderRepository;
	@Autowired
    private  UserRepository userRepository;
	@Autowired
    private  OrderItemRepository orderItemRepository;
	@Autowired
    private  ProductRepository productRepository;
	@Autowired
    private  CartItemRepository cartItemRepository;

	@Autowired
    private  CartRepository cartRepository;

    @Override
    public OrdersDTO placeOrder(Integer userId) throws OrdersException {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new UserException("User Not Found In Database"));

        Cart usercart = existingUser.getCart();
        if(usercart.getTotalAmount()==0){
            throw new OrdersException("Add item To the cart first.......");
        }
        Integer cartId = usercart.getCartId();

        Orders newOrder = new Orders();

        newOrder.setOrderDate(LocalDateTime.now());
        newOrder.setStatus(OrderStatus.PENDING);

        existingUser.getOrders().add(newOrder);
        newOrder.setUser(existingUser);
        userRepository.save(existingUser);
        orderRepository.save(newOrder);

        List<OrderItem> orderItems = new ArrayList<>();

        for (CartItem itemDTO : usercart.getCartItems()) {
            System.out.println("inside the loop");
            if (itemDTO.getCart().getCartId() == cartId) {

                OrderItem orderItem = new OrderItem();// creating New orderItem;

                orderItem.setQuantity(itemDTO.getQuantity());
                orderItem.setProduct(itemDTO.getProduct());
                orderItem.setOrderId(newOrder.getOrderId());
                orderItems.add(orderItem);
                System.out.println("inside the loop and if");
            }
        }

        newOrder.setOrderItem(orderItems);
        newOrder.setTotalAmount(usercart.getTotalAmount());
        orderRepository.save(newOrder);


        usercart.setTotalAmount(usercart.getTotalAmount() - newOrder.getTotalAmount());
        cartItemRepository.removeAllProductFromCart(cartId);
        cartRepository.save(usercart);

        OrdersDTO orderdata=new OrdersDTO();
        orderdata.setOrderId(newOrder.getOrderId());
        orderdata.setOrderAmount(newOrder.getTotalAmount());
        orderdata.setStatus("Pending");
        orderdata.setPaymentStatus("Pending");
        orderdata.setOrderDate("Currebt Date");
        return orderdata;

    }

    @Transactional
    public Orders getOrdersDetails(Integer orderId) throws OrdersException {

        Orders order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrdersException("Order not found in the database."));
        return order;
    }

    @Override
    public List<Orders> getAllUserOrder(Integer userId) throws OrdersException {
        try {
            List<Orders> orders = orderRepository.getAllOrderByUserId(userId);
            if (orders.isEmpty()) {
                throw new OrdersException("No orders found for the user in the database.");
            }
            return orders;
        } catch (Exception e) {
            throw new OrdersException("Failed to fetch orders for the user: " + e.getMessage());
        }
    }

    @Override
    public List<Orders> viewAllOrders() throws OrdersException {

        List<Orders> orders = orderRepository.findAll();

        if (orders.isEmpty()) {
            throw new OrdersException("No orders found in the database.");
        }
        return orders;
    }

    @Override
    public List<Orders> viewAllOrderByDate(Date date) throws OrdersException {

        List<Orders> orders = orderRepository.findByOrderDateGreaterThanEqual(date);

        if (orders.isEmpty()) {
            throw new OrdersException("No orders found for the given date.");
        }

        return orders;

    }

    @Override
    public void deleteOrders(Integer userId, Integer Orderid) throws OrdersException {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new UserException("User Not Found In Database"));
        Orders existingOrder = orderRepository.findById(Orderid)
                .orElseThrow(() -> new UserException("order Not Found In Database"));

        orderRepository.delete(existingOrder);
    }

    @Override
    public Orders updateOrders(Integer ordersid, OrdersDTO orderDTo) throws OrdersException {

        return null;
    }

}
