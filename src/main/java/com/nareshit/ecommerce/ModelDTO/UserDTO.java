package com.nareshit.ecommerce.ModelDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


public class UserDTO {

    @NotBlank(message = "New password can not be Blank..")
    @NotNull(message = "New password Can not be Null..")
    @Size(min = 5,max = 10)
    private String newPassword;

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public UserDTO(
			@NotBlank(message = "New password can not be Blank..") @NotNull(message = "New password Can not be Null..") @Size(min = 5, max = 10) String newPassword) {
		super();
		this.newPassword = newPassword;
	}
    
    
	public UserDTO() {}

	@Override
	public String toString() {
		return "UserDTO [newPassword=" + newPassword + "]";
	}
	
	
}
