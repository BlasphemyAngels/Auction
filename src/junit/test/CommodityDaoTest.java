package junit.test;

import java.sql.Date;
import java.sql.Timestamp;

import org.junit.Test;

import com.wc.dao.impl.CommodityDaoImpl;
import com.wc.domain.Commodity;
import com.wc.utils.WebUtils;

public class CommodityDaoTest {
	
	@Test
	public void testAdd(){
		Commodity comm = new Commodity(0, "chock2", 1, new Timestamp(new Date(System.currentTimeMillis()).getTime()), new Timestamp(new Date(System.currentTimeMillis()+7200000).getTime()), false, 3, 1000, "timg.jpg");
		CommodityDaoImpl dao = new CommodityDaoImpl();
		dao.add(comm);
	}
	
	@Test
	public void testFind(){
		CommodityDaoImpl dao = new CommodityDaoImpl();
		Commodity comm = dao.find(1);
		System.out.println(comm.getComm_id());
	}
	@Test
	public void testFindOne(){
		CommodityDaoImpl dao = new CommodityDaoImpl();
		Commodity comm = dao.find();
		System.out.println(WebUtils.formatDate(comm.getPub_date()));
	}
	
	@Test
	public void testCount(){
		CommodityDaoImpl dao = new CommodityDaoImpl();
		System.out.println(dao.count());
	}
	
}
