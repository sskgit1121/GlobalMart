package com.nareshit.ecommerce.Service;

import com.nareshit.ecommerce.Exception.ShippingException;
import com.nareshit.ecommerce.Model.ShippingDetails;
import com.nareshit.ecommerce.ModelDTO.ShippingDTO;

public interface ShippingService {
	
  public ShippingDetails setShippingDetails(Integer orderId,Integer shipperId,ShippingDetails shippingDetails) throws ShippingException;
  
  public ShippingDetails updateShippingAddress(Integer shippingId,ShippingDTO shippingDTO)throws ShippingException;
  
  public void deleteShippingDetails(Integer shippingId)throws ShippingException;
  
  
}
