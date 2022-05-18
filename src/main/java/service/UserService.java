package service;

import exception.SystemException;
import pojos.UserPojo;

public interface UserService {
	
	UserPojo createUser(UserPojo userPojo) throws SystemException;
	UserPojo loginUser(UserPojo userPojo) throws SystemException;
	void exitApplication();
	
}
