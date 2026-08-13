package com.ssk.ecommerce.ModelDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ProductDTO {

    @NotNull(message = "Product name is Mandatory ,can Not Be Null")
    @NotBlank(message = "Product name is Mandatory")
    private String name;

    @NotNull(message = "Product Image is Mandatory ,can Not Be Null")
    @NotBlank(message = "Product Image is Mandatory")
    private String imageUrl;

    @NotNull(message = "Product description is Mandatory ,can Not Be Null")
    @NotBlank(message = "Product description is Mandatory")
    @Size(min = 10, max = 50)
    private String description;

    @NotNull(message = "Product price is Mandatory ,can Not Be Null")
    private Double price;

    @NotNull(message = "Product category_name is Mandatory ,can Not Be Null")
    @NotBlank(message = "Product category_name is Mandatory")
    private String category;

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

	public ProductDTO(
			@NotNull(message = "Product name is Mandatory ,can Not Be Null") @NotBlank(message = "Product name is Mandatory") String name,
			@NotNull(message = "Product Image is Mandatory ,can Not Be Null") @NotBlank(message = "Product Image is Mandatory") String imageUrl,
			@NotNull(message = "Product description is Mandatory ,can Not Be Null") @NotBlank(message = "Product description is Mandatory") @Size(min = 10, max = 50) String description,
			@NotNull(message = "Product price is Mandatory ,can Not Be Null") Double price,
			@NotNull(message = "Product category_name is Mandatory ,can Not Be Null") @NotBlank(message = "Product category_name is Mandatory") String category) {
		super();
		this.name = name;
		this.imageUrl = imageUrl;
		this.description = description;
		this.price = price;
		this.category = category;
	}
    
	public ProductDTO() {}

	@Override
	public String toString() {
		return "ProductDTO [name=" + name + ", imageUrl=" + imageUrl + ", description=" + description + ", price="
				+ price + ", category=" + category + "]";
	}
	
	
    

}
