package com.nareshit.ecommerce.Service;

import java.util.List;

import com.nareshit.ecommerce.Exception.ShipperException;
import com.nareshit.ecommerce.Model.Shipper;

public interface ShipperService {

	public void deleteShipperById(Integer id) throws ShipperException;

	public Shipper saveShipper(Shipper shipper) throws ShipperException;

	public Shipper getShipperById(Integer id) throws ShipperException;

	public List<Shipper> getAllShippers() throws ShipperException;

}
