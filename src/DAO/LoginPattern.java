package DAO;

import BUS.LoginBUS;
import DTO.nhanvienDTO;

public class LoginPattern {

	private static nhanvienDTO user;
	
	public nhanvienDTO getUser() {
		return user;
	}

	public void setUser(nhanvienDTO nvDTO) {
		this.user = nvDTO;
	}
        public void logout(){
            this.user = null;
        }

	private static LoginPattern instance;
	
	private LoginPattern() {}
	
	public static LoginPattern getInstance() {
		if(instance == null)
			return new LoginPattern();
		return instance;
	}
	
	
	
	
}
