package org.mql.gc.test.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mql.gc.dao.AssociationDao;
import org.mql.gc.dao.AssociationDaoImp;
import org.mql.gc.dao.CaseDao;
import org.mql.gc.dao.CaseDaoImp;
import org.mql.gc.dao.DonorDao;
import org.mql.gc.dao.DonorDaoImp;
import org.mql.gc.models.Association;
import org.mql.gc.models.Case;
import org.mql.gc.models.Donor;

public class CasTestDao {
	
	private static CaseDao dao;
	private static DonorDao donDao;
	private static Case cas;

	
	@BeforeAll
	public static void setUpSuite() {
		dao = new CaseDaoImp();
		donDao = new DonorDaoImp();
		
		cas = new Case();
		cas.setDescription("test description");
		dao.create(cas);
	}
	
	
	@Test
	public void testCreateCase() {
		Case a = new Case();

		a.setDescription("karim");
		dao.create(a);

		assertNotNull(a.getId());
		assertEquals(a.getDescription(), "karim");
	}
	
//	@Test
//	public void testFindAll() {
//		Case a = new Case();
//		dao.create(a);
//
//		List<Case> cas_list = dao.findAll();
//		
//		assertTrue(cas_list.contains(a));
//	}
//	
//	@Test
//	public void testFindByNameAndCategory() {
//		Case a = new Case();
//		Case b = new Case();
//		
//		a.setCategory("1");
//		dao.create(a);
//		
//		b.setCategory("0");
//		dao.create(a);
//		
//		List<Case> cas_list = dao.findByTitleAndCategory("", "1");
//		
//		assertTrue(cas_list.contains(a));
//		assertFalse(cas_list.contains(b));
//	}
//	
//	@Test
//	public void testFindByNameAndCategoryVoid() {
//		List<Case> cas_list = dao.findByTitleAndCategory("", "55555");
//		
//		assertEquals(cas_list.size(), 0);
//	}
//	
//	
////	@Test
////	public void testFindByIdDonator() {
////		Cas a = new Cas();
////		Cas b = new Cas();
////		
////		Donnateur d1 = new Donnateur();
////		Donnateur d2 = new Donnateur();
////		
////		donDao.create(d1);
////		donDao.create(d2);
////		
////		dao.create(a);
////		
////		b.setCategorie("0");
////		dao.create(a);
////	}
	
}
