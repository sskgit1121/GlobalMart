package com.nareshit.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nareshit.ecommerce.Model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	
}
