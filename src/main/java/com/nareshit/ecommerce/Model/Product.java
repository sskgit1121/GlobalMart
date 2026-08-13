package com.nareshit.ecommerce.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;



@Entity
@Table(name = "Products")
public class Product {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @NotNull(message = "Product name is Mandatory ,can Not Be Null")
	@NotBlank(message = "Product name is Mandatory")
    @Column(name = "name")
    private String name;
    
    @NotNull(message = "Product Image is Mandatory ,can Not Be Null")
	@NotBlank(message = "Product Image is Mandatory")
    @Column(name = "imageUrl")
    private String imageUrl;
    
    @Column(name = "isAvailable")
    private boolean isAvailable=true;
    
    @NotNull(message = "Product description is Mandatory ,can Not Be Null")
  	@NotBlank(message = "Product description is Mandatory")
    @Size(min=10,max = 50)
    @Column(name = "description")
    private String description;

    @NotNull(message = "Product price is Mandatory ,can Not Be Null")
    @Column(name = "price")
    private Double price;
 
    @NotNull(message = "Product category_name is Mandatory ,can Not Be Null")
  	@NotBlank(message = "Product category_name is Mandatory")
    @Column(name = "category_name")
    private String category; 
    

    @JsonIgnore
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<OrderItem> orderItem= new ArrayList<>();;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<Review> reviews= new ArrayList<>();

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Product(Integer productId,
			@NotNull(message = "Product name is Mandatory ,can Not Be Null") @NotBlank(message = "Product name is Mandatory") String name,
			@NotNull(message = "Product Image is Mandatory ,can Not Be Null") @NotBlank(message = "Product Image is Mandatory") String imageUrl,
			boolean isAvailable,
			@NotNull(message = "Product description is Mandatory ,can Not Be Null") @NotBlank(message = "Product description is Mandatory") @Size(min = 10, max = 50) String description,
			@NotNull(message = "Product price is Mandatory ,can Not Be Null") Double price,
			@NotNull(message = "Product category_name is Mandatory ,can Not Be Null") @NotBlank(message = "Product category_name is Mandatory") String category,
			List<OrderItem> orderItem, List<Review> reviews) {
		super();
		this.productId = productId;
		this.name = name;
		this.imageUrl = imageUrl;
		this.isAvailable = isAvailable;
		this.description = description;
		this.price = price;
		this.category = category;
		this.orderItem = orderItem;
		this.reviews = reviews;
	};
    
    
    
	public Product(){}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", imageUrl=" + imageUrl + ", isAvailable="
				+ isAvailable + ", description=" + description + ", price=" + price + ", category=" + category
				+ ", orderItem=" + orderItem + ", reviews=" + reviews + "]";
	}
	
	
	
	
   
}

