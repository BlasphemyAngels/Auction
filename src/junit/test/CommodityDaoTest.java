package junit.test;

import java.sql.Date;

import org.junit.Test;

import com.wc.dao.impl.CommodityDaoImpl;
import com.wc.domain.Commodity;

public class CommodityDaoTest {
	
	@Test
	public void testAdd(){
		Commodity comm = new Commodity(0, "chock", 1, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()+7200), false, 3, 100, "timg.jpg");
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
		System.out.println(comm.getImage());
	}
	
	@Test
	public void testCount(){
		CommodityDaoImpl dao = new CommodityDaoImpl();
		System.out.println(dao.count());
	}
	
}
