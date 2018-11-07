package com.Cmail.DAO;

import java.sql.*;

import com.Cmail.ConnectionConfig.DBConfig;
import com.Cmail.Model.Users;

public class UserDaoImp implements UserDao{

	public boolean addUsers(Users user) {
		// TODO Auto-generated method stub
		
		try {
			Connection conn=DBConfig.getConnection();
			PreparedStatement pr=conn.prepareStatement("insert into User values(?,?,?,?)");
			pr.setString(1, user.getEmail());
            pr.setString(2, user.getPassword());
            pr.setString(3, user.getFirstName());
            pr.setString(4, user.getLastName());
			
            int i=pr.executeUpdate();
            conn.close();
            
            System.out.println("Here is check"+i);
             if(i==1) {
            	 return true;
             }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	public Users validateUser(Users user) {
		// TODO Auto-generated method stub
		try {
			Connection conn=DBConfig.getConnection();
			PreparedStatement pr=conn.prepareStatement("Select * from user where email=? and password=?");
			
			pr.setString(1, user.getEmail());
            pr.setString(2, user.getPassword());
			
            ResultSet rs=pr.executeQuery();
			System.out.println("preparedstatment "+rs);

            if(rs.next()){
    			Users user1=new Users();
    			user1.setEmail(rs.getString(1));
    			user1.setPassword(rs.getString(2));
    			user1.setFirstName(rs.getString(3));
    			user1.setLastName(rs.getString(4));
    			return user1;
    		}
    		
		    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

	}

}
