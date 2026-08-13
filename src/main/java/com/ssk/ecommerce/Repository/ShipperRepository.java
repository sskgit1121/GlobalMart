package com.ssk.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssk.ecommerce.Model.Shipper;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper, Integer> {

}
