package com.ssk.ecommerce.Service;

import com.ssk.ecommerce.Exception.PaymentException;
import com.ssk.ecommerce.Model.Payment;

public interface PaymentService {
	
	 Payment makePayment(Integer orderId,Integer userId) throws PaymentException;
}
