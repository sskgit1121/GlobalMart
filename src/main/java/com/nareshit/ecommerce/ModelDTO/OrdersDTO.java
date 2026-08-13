package com.nareshit.ecommerce.ModelDTO;





public class OrdersDTO {

    private Integer orderId;
    private String status;
    private String orderDate;
    private Double orderAmount;
    private String paymentStatus;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public Double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public OrdersDTO(Integer orderId, String status, String orderDate, Double orderAmount, String paymentStatus) {
		super();
		this.orderId = orderId;
		this.status = status;
		this.orderDate = orderDate;
		this.orderAmount = orderAmount;
		this.paymentStatus = paymentStatus;
	}
	public OrdersDTO() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrdersDTO [orderId=" + orderId + ", status=" + status + ", orderDate=" + orderDate + ", orderAmount="
				+ orderAmount + ", paymentStatus=" + paymentStatus + "]";
	}
    
    
    

}
