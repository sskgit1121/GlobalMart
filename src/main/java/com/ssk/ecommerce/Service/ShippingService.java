package com.ssk.ecommerce.Service;

import com.ssk.ecommerce.Exception.ShippingException;
import com.ssk.ecommerce.Model.ShippingDetails;
import com.ssk.ecommerce.ModelDTO.ShippingDTO;

public interface ShippingService {
	
  public ShippingDetails setShippingDetails(Integer orderId,Integer shipperId,ShippingDetails shippingDetails) throws ShippingException;
  
  public ShippingDetails updateShippingAddress(Integer shippingId,ShippingDTO shippingDTO)throws ShippingException;
  
  public void deleteShippingDetails(Integer shippingId)throws ShippingException;
  
  
}
