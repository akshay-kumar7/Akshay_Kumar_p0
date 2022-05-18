package service;

import dao.UserDao;
import dao.UserDaoDatabaseImpl;
import exception.SystemException;
import pojos.UserPojo;

public class UserServiceImpl implements UserService {

	UserDao userDao;

	public UserServiceImpl() {
		userDao = new UserDaoDatabaseImpl();
	}

	@Override
	public UserPojo createUser(UserPojo userPojo) throws SystemException {

		return userDao.createUser(userPojo);

	}

	@Override
	public UserPojo loginUser(UserPojo userPojo) throws SystemException {
		UserPojo returnedUserPojo = this.userDao.loginUser(userPojo);
		return returnedUserPojo;
	}

	@Override
	public void exitApplication() {
		userDao.exit();
		
	}

}
