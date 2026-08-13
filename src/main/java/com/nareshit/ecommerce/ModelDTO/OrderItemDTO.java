package com.nareshit.ecommerce.ModelDTO;

import java.math.BigDecimal;

import lombok.Data;


public class OrderItemDTO {

	    private int productId;
	    private int quantity;
	    private BigDecimal price;
	    
	    
		public int getProductId() {
			return productId;
		}
		public void setProductId(int productId) {
			this.productId = productId;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public BigDecimal getPrice() {
			return price;
		}
		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		public OrderItemDTO(int productId, int quantity, BigDecimal price) {
			super();
			this.productId = productId;
			this.quantity = quantity;
			this.price = price;
		}
		@Override
		public String toString() {
			return "OrderItemDTO [productId=" + productId + ", quantity=" + quantity + ", price=" + price + "]";
		}
	    
		
		
	    
	    
}
