package com.nareshit.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.ecommerce.Model.Shipper;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper, Integer> {

}
