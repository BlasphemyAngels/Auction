package com.wc.service.impl;


import com.wc.dao.impl.UserDaoImpl;
import com.wc.domain.User;


public class BussinessServiceImpl{

	private static BussinessServiceImpl instance = new BussinessServiceImpl();
	private UserDaoImpl userDao = new UserDaoImpl();

	private BussinessServiceImpl() {
	}

	public User login(String username, String password) {
		//password = ServiceUtils.md5(password);
		User user = userDao.find(username, password);
		return user;
	}

	/*public void register(User user) throws UserExitException {
		user.setPassword(ServiceUtils.md5(user.getPassword()));
		User user1 = userDao.find(user.getUsername());
		if (user1 != null) {
			throw new UserExitException();
		} else {
			UserTypeDao userTypeDao = UserTypeDaoImpl.getInstance();
			UserType userType = userTypeDao.find("common");
			user.setUserTypeId(userType.getUserTypeId());
			userDao.add(user);
		}
	}
*/

/*	public void deleteUser(Integer userId) throws DeleteUserFailedException {
		int retVal = userDao.deleteById(userId);
		if (retVal <= 0) {
			throw new DeleteUserFailedException();
		}
	}
*/
	
	public static BussinessServiceImpl getInstance() {
		return instance;
	}
	
}
