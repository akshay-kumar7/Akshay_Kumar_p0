package dao;

import exception.SystemException;
import pojos.UserPojo;

public interface UserDao {

	UserPojo createUser(UserPojo userPojo) throws SystemException; // Registering a new user

	UserPojo loginUser(UserPojo userPojo) throws SystemException; // Login an existing user

	void exit();

}
