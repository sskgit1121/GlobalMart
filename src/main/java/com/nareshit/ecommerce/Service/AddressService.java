package com.nareshit.ecommerce.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nareshit.ecommerce.Exception.AddressException;
import com.nareshit.ecommerce.Model.Address;

@Service
public interface AddressService {
	
	public Address addAddressToUser(Integer userId,Address address) throws AddressException;
	
	public Address updateAddress( Address address,Integer addressId) throws AddressException ;
	
	public void   removeAddress(Integer addressId)throws AddressException;
	
	public List<Address> getAllUserAddress(Integer userId)throws AddressException;

}
