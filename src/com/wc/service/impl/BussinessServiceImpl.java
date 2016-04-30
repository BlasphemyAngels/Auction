package com.wc.service.impl;

import java.util.List;

import javax.swing.JEditorPane;

import com.wc.Exception.UserDetailExitException;
import com.wc.Exception.UserExistException;
import com.wc.dao.impl.BidDaoImpl;
import com.wc.dao.impl.BuyedDaoImpl;
import com.wc.dao.impl.CommodityDaoImpl;
import com.wc.dao.impl.UserCheckDaoImpl;
import com.wc.dao.impl.UserDaoImpl;
import com.wc.dao.impl.UserDetailDaoImpl;
import com.wc.domain.Bid;
import com.wc.domain.Buyed;
import com.wc.domain.Commodity;
import com.wc.domain.User;
import com.wc.domain.UserCheck;
import com.wc.domain.UserDetail;
import com.wc.domain.UserState;
import com.wc.utils.WebUtils;
import com.wc.web.form.UpdatePswForm;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 处理业务逻辑的类
 * 
 * @author ccl
 *
 */
public class BussinessServiceImpl {

	private static BussinessServiceImpl instance = new BussinessServiceImpl();
	private UserDaoImpl userDao = new UserDaoImpl();
	private CommodityDaoImpl commDao = new CommodityDaoImpl();
	private UserDetailDaoImpl udDao = new UserDetailDaoImpl();
	private UserCheckDaoImpl ucDao = new UserCheckDaoImpl();
	private BidDaoImpl bdDao = new BidDaoImpl();
	private BuyedDaoImpl buyDao = new BuyedDaoImpl();
	private BussinessServiceImpl() {
	}

	/**
	 * 处理用户登录业务
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return 登录成功的用户名
	 */
	public User login(String username, String password) {
		// password = ServiceUtils.md5(password);
		User user = userDao.find(username, password);
		return user;
	}

	/**
	 * 处理用户注册业务
	 * 
	 * @param user
	 *            要注册的用户的信息
	 * @throws UserExistException
	 *             若用户名已经存在抛出异常
	 */
	public void register(User user) throws UserExistException {
		// user.setPassword(ServiceUtils.md5(user.getPassword()));
		user.setUserType(0);
		userDao.addUser(user);
	}

	/*
	 * public void deleteUser(Integer userId) throws DeleteUserFailedException {
	 * int retVal = userDao.deleteById(userId); if (retVal <= 0) { throw new
	 * DeleteUserFailedException(); } }
	 */
	public int getCommodityNums() {
		return commDao.count();

	}

	public UserCheck getUC(int userId) {
		return ucDao.find(userId);
	}

	public boolean updatePsw(int userId, UpdatePswForm upForm) {
		return userDao.updatePsw(userId, upForm.getNewPassword());
	}

	public boolean checkPsw(int userId, String psw) {
		User user = userDao.find(userId);
		if (user != null && user.getPassword().equals(psw)) {
			return true;
		}
		return false;
	}

	public List<Commodity> findCommoditys(int start, int pageSize) {
		return commDao.find(start, pageSize);
	}

	public static BussinessServiceImpl getInstance() {
		return instance;
	}

	public boolean completeInfo(UserDetail ud) {
		try {
			udDao.add(ud);
		} catch (UserDetailExitException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}

	public boolean add(Bid bid){
		return bdDao.add(bid);
	}
	
	public UserState getUserState(int userId) {
		UserDetail ud = udDao.find(userId);
		if (ud == null)
			return UserState.USER_NOCHECK;
		UserCheck uc = ucDao.find(userId);
		if (uc.isCheckState()) {
			return UserState.USER_CHECKED;
		}
		return UserState.USER_SUBMIT;
	}

	public Commodity findCommById(int commId){
		return commDao.find(commId);
	}
	
	public User findUser(int userId) {
		return userDao.find(userId);
	}

	public List<Commodity> getCommoditiesBy(String tPart, String uPart, int price) {
		return commDao.find(tPart, uPart, price);
	}

	public void makeAdmin(int userId, int st) {
		userDao.alterUserType(userId, st);
	}

	public void checkUserDetail(int userId) {
		ucDao.alterState(userId);
		udDao.alterState(userId);
	}

	public Buyed getBuyedInfo(int commId) {
		return buyDao.findBuy(commId);
	}

	public JSONArray findByPartTitle(String value) {
		List<Bid> bids = bdDao.find();
		JSONArray members = new JSONArray();
		for (Bid bid : bids) {
			Commodity comm = commDao.find(bid.getCommId());
			if (!comm.getTitle().contains(value)) {
				continue;
			}
			JSONObject member = new JSONObject();
			member.put("commId", bid.getCommId());
			member.put("title", comm.getTitle());
			User user = userDao.find(bid.getBuyer());
			member.put("buyer", user.getUsername());
			member.put("cdate", WebUtils.formatDate(bid.getcDate()));
			member.put("price", bid.getPrice());
			UserDetail buy = udDao.find(user.getUserId());
			member.put("buyertel", buy.getTel());
			UserDetail ud = udDao.find(comm.getOwner());
			member.put("ownertel", ud.getTel());
			member.put("addr", buy.getAddr());
			member.put("note", bid.getNote());
			members.add(member);
		}
		return members;
	}

	public JSONArray findBidByBuyer(String value) {
		List<Bid> bids = bdDao.find();
		JSONArray members = new JSONArray();
		for (Bid bid : bids) {
			User buy = userDao.find(bid.getBuyer());
			if (!buy.getUsername().contains(value)) {
				continue;
			}
			JSONObject member = new JSONObject();
			Commodity comm = commDao.find(bid.getCommId());
			member.put("commId", bid.getCommId());
			member.put("title", comm.getTitle());
			member.put("buyer", buy.getUsername());
			member.put("cdate", WebUtils.formatDate(bid.getcDate()));
			member.put("price", bid.getPrice());
			UserDetail buyUd = udDao.find(buy.getUserId());
			member.put("buyertel", buyUd.getTel());
			UserDetail ud = udDao.find(comm.getOwner());
			member.put("ownertel", ud.getTel());
			member.put("addr", buyUd.getAddr());
			member.put("note", bid.getNote());
			members.add(member);
		}
		return members;
	}
	public JSONArray findBidByOwner(String value) {
		List<Bid> bids = bdDao.find();
		JSONArray members = new JSONArray();
		for (Bid bid : bids) {
			Commodity comm = commDao.find(bid.getCommId());
			User own = userDao.find(comm.getOwner());
			if (!own.getUsername().contains(value)) {
				continue;
			}
			JSONObject member = new JSONObject();
			member.put("commId", bid.getCommId());
			member.put("title", comm.getTitle());
			User buy = userDao.find(bid.getBuyer());
			member.put("buyer", buy.getUsername());
			member.put("cdate", WebUtils.formatDate(bid.getcDate()));
			member.put("price", bid.getPrice());
			UserDetail buyUd = udDao.find(buy.getUserId());
			member.put("buyertel", buyUd.getTel());
			UserDetail ud = udDao.find(comm.getOwner());
			member.put("ownertel", ud.getTel());
			member.put("addr", buyUd.getAddr());
			member.put("note", bid.getNote());
			members.add(member);
		}
		return members;
	}
	
	public boolean add(Commodity comm){
		return commDao.add(comm);
	}
}
