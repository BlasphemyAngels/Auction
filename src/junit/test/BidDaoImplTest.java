package junit.test;

import java.sql.Date;
import java.sql.Timestamp;

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
		bid.setcDate(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
		bid.setNote("ÓÊ¼Äµ½Çàµº");
		dao.add(bid);
	}
	
	@Test
	public void testFindBuyer(){
		System.out.println(dao.findBuyer(4));
	}
	
	@Test
	public void testFindBid(){
		System.out.println(dao.find(4).getPrice());
	}
	
}







