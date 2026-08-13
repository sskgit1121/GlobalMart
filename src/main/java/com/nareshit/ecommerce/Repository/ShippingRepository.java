package com.nareshit.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nareshit.ecommerce.Model.ShippingDetails;

public interface ShippingRepository extends JpaRepository<ShippingDetails, Integer> {

}
