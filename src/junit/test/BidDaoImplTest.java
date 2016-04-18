package junit.test;

import java.sql.Date;

import org.junit.Test;

import com.wc.dao.impl.BidDaoImpl;
import com.wc.domain.Bid;

public class BidDaoImplTest {
	BidDaoImpl dao = new BidDaoImpl();
	
	@Test
	public void testAdd(){
		Bid bid = new Bid();
		bid.setCommId(4);
		bid.setBuyer(2);
		bid.setPrice(1000);
		bid.setcDate(new Date(System.currentTimeMillis()));
		bid.setNote("ÓÊ¼Äµ½Çàµº");
		dao.add(bid);
	}
	
	@Test
	public void testFindBuyer(){
		System.out.println(dao.findBuyer(4));
	}
	
}







