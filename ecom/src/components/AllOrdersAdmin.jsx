import React,{ useState,useEffect } from "react";
import "../comp_css/AllOrderAdmin.css";
import { useNavigate,Link } from "react-router-dom";
import axios from "axios";
import api from "../Router/api";

const AllOrdersAdmin = () =>{

    const [orders,setOrders]=useState([]);
    const [loading,setLoading]=useState(true);

    //All Orders Back End Call
    useEffect(
        ()=>{
            api.get("/ecom/orders/all")
            .then(
                (response)=>{
                    setOrders(response.data);
                    setLoading(false);
                }
            )
            .catch((error)=>{
                console.error("Error Fetching the Data:",error);
                setLoading(false);
            })
        },[]
    )

    return (
        <>


<h2 style={{textAlign:"center",margin:"10px"}}>All Order Details</h2>

<div className="admin-orders">

    {loading ? (<p> Loading.....</p>) : (

        orders.map((order)=>(
            <div className="order-card" key={order.orderId}>
                  <div className="orderpart">

                    <h3>Order Details</h3>
                    <p>OrderId: {order.orderId}</p>
                    <p>Status:{order.status}</p>
                    <p>OrderDate: {order.orderDate}</p>
                    <hr />
                    {order.orderItem.map(
                        (item)=>(

                            <div className="order-item" key={item.orderItemId}>
                                <p>Product: {item.product.name}</p>
                                 <p>Price: {item.product.price}</p>
                                  <p>Quantity: {item.quantity}</p>
                                </div>
                        )

                        
                    )}



                    <div className="customerdetails">

                        <h3>Customer Details</h3>
                        <p>UserId: {order.user.userId}</p>
                        <p>Customer Name: {order.user.firstName}  {order.user.lastName} </p>
                        <p>Phone Number: {order.user.phoneNumber}</p>


                        <h3>Payment Details</h3>
                        {order.payment?(<>
                            <p>Payment Id: {order.payment.paymentId}</p>
                            <p>Payment Date: {order.payment.paymentDate}</p>
                            <p>Payment Amount: {order.payment.paymentAmount}</p>
                              <p>Payment Method: {order.payment.paymentMethod}</p>
                               <p>Payment Status: {order.payment.paymentStatus}</p>
                        
                        </>):
                        
                        (<p>NO Payment Details Available </p>)}
                    </div>



                    </div>
                </div>
        )

        )
    )}
</div>
        </>
    )
}
export default AllOrdersAdmin;