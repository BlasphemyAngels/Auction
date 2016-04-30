package junit.test;

import java.sql.Timestamp;

import org.junit.Test;

import com.wc.dao.impl.BuyedDaoImpl;
import com.wc.domain.Buyed;

public class BuyedDaoTest {
	private BuyedDaoImpl buyDao = new BuyedDaoImpl();
	@Test
	public void testAdd(){
		Buyed buy = new Buyed();
		buy.setBuyTime(new Timestamp(System.currentTimeMillis()));
		buy.setCommId(10);
		buy.setNote("hehe");
		buy.setPrice(700);
		buy.setUserId(3);
		buyDao.add(buy);
	}
	
}
