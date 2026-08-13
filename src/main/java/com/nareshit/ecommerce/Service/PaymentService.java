package com.nareshit.ecommerce.Service;

import com.nareshit.ecommerce.Exception.PaymentException;
import com.nareshit.ecommerce.Model.Payment;

public interface PaymentService {
	
	 Payment makePayment(Integer orderId,Integer userId) throws PaymentException;
}
