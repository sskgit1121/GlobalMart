package com.ssk.ecommerce.Service;

import java.util.List;

import com.ssk.ecommerce.Exception.ProductException;
import com.ssk.ecommerce.Model.Product;
import com.ssk.ecommerce.ModelDTO.ProductDTO;

public interface ProductService {
	
	public Product addProduct(Product products)throws ProductException;
	
	public Product updateProduct(Integer productId,ProductDTO product)throws ProductException;
	
	public List<Product> getProductByName(String name)throws ProductException;
	
	public List<Product> getAllProduct(String keyword, String sortDirection, String sortBy)throws ProductException;
	
	public List<Product> getProductByCategory(String catagory) throws ProductException;
	
	public void removeProduct(Integer productId)throws ProductException;

	public Product getSingleProduct(Integer productId);
}
 