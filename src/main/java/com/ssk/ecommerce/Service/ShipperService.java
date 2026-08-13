package com.ssk.ecommerce.Service;

import java.util.List;

import com.ssk.ecommerce.Exception.ShipperException;
import com.ssk.ecommerce.Model.Shipper;

public interface ShipperService {

	public void deleteShipperById(Integer id) throws ShipperException;

	public Shipper saveShipper(Shipper shipper) throws ShipperException;

	public Shipper getShipperById(Integer id) throws ShipperException;

	public List<Shipper> getAllShippers() throws ShipperException;

}
