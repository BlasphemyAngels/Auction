package junit.test;

import org.junit.Test;

import com.wc.dao.impl.UserCheckDaoImpl;
import com.wc.domain.UserCheck;

public class UserCheckDaoImplTest {
	UserCheckDaoImpl dao = new UserCheckDaoImpl();
	@Test
	public void testAdd(){
		dao.add(new UserCheck(1, false));
	}
	@Test
	public void testFind(){
		UserCheck uc = dao.find(2);
		System.out.println(uc.getUserId()+":"+uc.isCheckState());
	}
	@Test
	public void testUpdate(){
		dao.alterState(1);
		System.out.println(dao.find(1).isCheckState());
	}
	@Test
	public void testDelete(){
		dao.delete(1);
	}
}
