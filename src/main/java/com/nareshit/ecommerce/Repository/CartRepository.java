package com.nareshit.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.ecommerce.Model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {


}
