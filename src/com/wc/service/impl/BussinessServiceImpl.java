package com.wc.service.impl;


import com.wc.Exception.UserExistException;
import com.wc.dao.impl.UserDaoImpl;
import com.wc.domain.User;

/**
 * ����ҵ���߼�����
 * @author ccl
 *
 */
public class BussinessServiceImpl{

	private static BussinessServiceImpl instance = new BussinessServiceImpl();
	private UserDaoImpl userDao = new UserDaoImpl();

	private BussinessServiceImpl() {
	}
	/**
	 * �����û���¼ҵ��
	 * @param username �û���
	 * @param password ����
	 * @return ��¼�ɹ����û���
	 */
	public User login(String username, String password) {
		//password = ServiceUtils.md5(password);
		User user = userDao.find(username, password);
		return user;
	}
	/**
	 * �����û�ע��ҵ��
	 * @param user Ҫע����û�����Ϣ
	 * @throws UserExistException ���û����Ѿ������׳��쳣
	 */
	public void register(User user) throws UserExistException {
		//user.setPassword(ServiceUtils.md5(user.getPassword()));
		user.setUserType(0);
		userDao.addUser(user);
	}

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
