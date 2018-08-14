package com.Project0.daos;

import com.Project0.bean.User;
import com.Project0.daos.ZeroUserDao;
//import com.revature.daos.UserSerializer;

public interface ZeroUserDao {
public static final ZeroUserDao currentUserDao = new ZeroSerializer();
	
	void createUser(User u);
	User findByUsernameAndPassword(String username, String password);
	void updateUser(User u);
	void deleteUser(User u);

}
