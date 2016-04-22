package junit.test;

import org.junit.Test;

import com.wc.Exception.UserDetailExitException;
import com.wc.Exception.UserDetailNotExitException;
import com.wc.dao.impl.UserDetailDaoImpl;
import com.wc.domain.UserDetail;

public class UserDetailDaoImplTest {
	UserDetailDaoImpl udDao = new UserDetailDaoImpl();
	@Test
	public void testAdd(){
		try {
			UserDetail ud = new UserDetail();
			ud.setUserId(1);
			udDao.add(ud);
		} catch (UserDetailExitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testFind(){
		System.out.println(udDao.find(1));
	}
	@Test
	public void testUpdate() throws UserDetailExitException, UserDetailNotExitException{
		UserDetail ud = new UserDetail(1, "ccl", "15764236514@163.com", "370785199310017470", "15764236514", "´ú¼Ò×¯", false);
		udDao.update(ud);
	}
	@Test
	public void testDelete() throws UserDetailNotExitException{
		udDao.delete(1);
	}
}
