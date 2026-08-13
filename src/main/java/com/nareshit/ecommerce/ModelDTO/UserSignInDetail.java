package com.nareshit.ecommerce.ModelDTO;

import lombok.Data;
import lombok.NoArgsConstructor;


public class UserSignInDetail {
    Integer id;
    String firstNAme;
    String lastName;
    String signinStatus;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstNAme() {
		return firstNAme;
	}
	public void setFirstNAme(String firstNAme) {
		this.firstNAme = firstNAme;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSigninStatus() {
		return signinStatus;
	}
	public void setSigninStatus(String signinStatus) {
		this.signinStatus = signinStatus;
	}
	public UserSignInDetail(Integer id, String firstNAme, String lastName, String signinStatus) {
		super();
		this.id = id;
		this.firstNAme = firstNAme;
		this.lastName = lastName;
		this.signinStatus = signinStatus;
	}
	@Override
	public String toString() {
		return "UserSignInDetail [id=" + id + ", firstNAme=" + firstNAme + ", lastName=" + lastName + ", signinStatus="
				+ signinStatus + "]";
	}
    
    
	public UserSignInDetail() {}

}
