/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.LoginDAO;
import DAO.nhanvienDAO;
import DTO.nhanvienDTO;

/**
 *
 * @author ad
 */
public class LoginBUS {
    public LoginBUS(){}
    public int Login(String user,String password){
        LoginDAO lgDAO = new LoginDAO();
        if(lgDAO.getLogin(user,password)== "Thành Công"){
            return 1;
        }else{
            return 0;
        }
    }
}
