package com.ssk.ecommerce.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssk.ecommerce.Exception.UserException;
import com.ssk.ecommerce.Model.User;
import com.ssk.ecommerce.ModelDTO.AdminDTO;
import com.ssk.ecommerce.ModelDTO.CustomerDTO;
import com.ssk.ecommerce.ModelDTO.UserDTO;


@Service
public interface UserService {
	
	
	
	public User getUserByEmailId(String emailId)throws UserException;

	public User addUser(CustomerDTO customer)  throws UserException;
	
	public User addUserAdmin(AdminDTO admin	)  throws UserException;

	public User changePassword(Integer userId, UserDTO customer)  throws UserException;

	public String deactivateUser(Integer userId) throws UserException;

	public User getUserDetails(Integer userId)throws UserException;

	public List<User> getAllUserDetails() throws UserException;
}
