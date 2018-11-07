package com.Cmail.DAO;

import com.Cmail.Model.Users;

public interface  UserDao {
          public boolean addUsers(Users user);
          public Users validateUser(Users user);
}
