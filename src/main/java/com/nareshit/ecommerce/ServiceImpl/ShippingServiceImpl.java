package com.nareshit.ecommerce.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.ecommerce.Exception.ShippingException;
import com.nareshit.ecommerce.Model.Orders;
import com.nareshit.ecommerce.Model.Shipper;
import com.nareshit.ecommerce.Model.ShippingDetails;
import com.nareshit.ecommerce.ModelDTO.ShippingDTO;
import com.nareshit.ecommerce.Repository.OrderRepository;
import com.nareshit.ecommerce.Repository.ShipperRepository;
import com.nareshit.ecommerce.Repository.ShippingRepository;
import com.nareshit.ecommerce.Service.ShippingService;

import lombok.RequiredArgsConstructor;

@Service

public class ShippingServiceImpl implements ShippingService {

	@Autowired
	private  ShippingRepository shippingRepository;

	@Autowired
	private  OrderRepository orderRepository;

	@Autowired
	private  ShipperRepository shipperRepository;

	@Override
	public ShippingDetails setShippingDetails(Integer orderId, Integer shipperId, ShippingDetails shippingDetails)
	        throws ShippingException {
	    if (shippingDetails == null)
	        throw new ShippingException("ShippingDetails cannot be null");

	    Orders existingOrder = orderRepository.findById(orderId)
	            .orElseThrow(() -> new ShippingException("Order not found"));

	    Shipper existingShipper = shipperRepository.findById(shipperId)
	            .orElseThrow(() -> new ShippingException("Shipper not found"));

	    // Save the ShippingDetails entity first
	    shippingDetails.setOrders(existingOrder);
	    shippingDetails.setShipper(existingShipper);
	    shippingDetails = shippingRepository.save(shippingDetails);

	    // Now update the Orders entity with the saved ShippingDetails
	    existingOrder.setShippingDetails(shippingDetails);
	    orderRepository.save(existingOrder);

	    return shippingDetails;
	}


	@Override
	public ShippingDetails updateShippingAddress(Integer shippingId, ShippingDTO shippingDTO) throws ShippingException {
		ShippingDetails existing = shippingRepository.findById(shippingId)
				.orElseThrow(() -> new ShippingException("Shipping detail not found"));

		existing.setState(shippingDTO.getState());
		existing.setAddress(shippingDTO.getAddress());
		existing.setCity(shippingDTO.getCity());
		existing.setPostalCode(shippingDTO.getPostalCode());
		return shippingRepository.save(existing);
	}

	@Override
	public void deleteShippingDetails(Integer shippingId) throws ShippingException {
		ShippingDetails existing = shippingRepository.findById(shippingId)
				.orElseThrow(() -> new ShippingException("Shipping detail not found"));

		shippingRepository.delete(existing);

	}

}
