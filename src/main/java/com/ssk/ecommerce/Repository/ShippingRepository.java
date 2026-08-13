package com.ssk.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssk.ecommerce.Model.ShippingDetails;

public interface ShippingRepository extends JpaRepository<ShippingDetails, Integer> {

}
