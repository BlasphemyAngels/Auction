package com.wc.service.impl;


import java.util.List;

import com.wc.Exception.UserExistException;
import com.wc.dao.impl.CommodityDaoImpl;
import com.wc.dao.impl.UserDaoImpl;
import com.wc.domain.Commodity;
import com.wc.domain.User;
import com.wc.web.form.UpdatePswForm;

/**
 * 处理业务逻辑的类
 * @author ccl
 *
 */
public class BussinessServiceImpl{

	private static BussinessServiceImpl instance = new BussinessServiceImpl();
	private UserDaoImpl userDao = new UserDaoImpl();
	private CommodityDaoImpl commDao = new CommodityDaoImpl();
	private BussinessServiceImpl() {
	}
	/**
	 * 处理用户登录业务
	 * @param username 用户名
	 * @param password 密码
	 * @return 登录成功的用户名
	 */
	public User login(String username, String password) {
		//password = ServiceUtils.md5(password);
		User user = userDao.find(username, password);
		return user;
	}
	/**
	 * 处理用户注册业务
	 * @param user 要注册的用户的信息
	 * @throws UserExistException 若用户名已经存在抛出异常
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
	public int getCommodityNums(){
		return commDao.count();
		
	}
	
	public boolean updatePsw(int userId, UpdatePswForm upForm){
		return userDao.updatePsw(userId, upForm.getNewPassword());
	}
	public boolean checkPsw(int userId, String psw){
		User user = userDao.find(userId);
		if (user != null && user.getPassword().equals(psw)){
			return true;
		}
		return false;
	}
	
	public List<Commodity> findCommoditys(int start, int pageSize){
		return commDao.find(start, pageSize);
	}
	
	public static BussinessServiceImpl getInstance() {
		return instance;
	}
	
}
