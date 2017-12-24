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
import org.mql.gc.dao.AssociationDaoImpl;
import org.mql.gc.dao.CaseDao;
import org.mql.gc.dao.CaseDaoImpl;
import org.mql.gc.dao.DonateurDao;
import org.mql.gc.dao.DonateurDaoImpl;
import org.mql.gc.models.Association;
import org.mql.gc.models.Cas;
import org.mql.gc.models.Donnateur;

public class CasTestDao {
	
	private static CaseDao dao;
	private static DonateurDao donDao;
	private static Cas cas;

	
	@BeforeAll
	public static void setUpSuite() {
		dao = new CaseDaoImpl();
		donDao = new DonateurDaoImpl();
		
		cas = new Cas();
		cas.setDescription("test description");
		dao.create(cas);
	}
	
	
	@Test
	public void testCreateCase() {
		Cas a = new Cas();

		a.setDescription("karim");
		dao.create(a);

		assertNotNull(a.getId());
		assertEquals(a.getDescription(), "karim");
	}
	
	@Test
	public void testFindAll() {
		Cas a = new Cas();
		dao.create(a);

		List<Cas> cas_list = dao.findAll();
		
		assertTrue(cas_list.contains(a));
	}
	
	@Test
	public void testFindByNameAndCategory() {
		Cas a = new Cas();
		Cas b = new Cas();
		
		a.setCategorie("1");
		dao.create(a);
		
		b.setCategorie("0");
		dao.create(a);
		
		List<Cas> cas_list = dao.findByTitleAndCategory("", "1");
		
		assertTrue(cas_list.contains(a));
		assertFalse(cas_list.contains(b));
	}
	
	@Test
	public void testFindByNameAndCategoryVoid() {
		List<Cas> cas_list = dao.findByTitleAndCategory("", "55555");
		
		assertEquals(cas_list.size(), 0);
	}
	
	
//	@Test
//	public void testFindByIdDonator() {
//		Cas a = new Cas();
//		Cas b = new Cas();
//		
//		Donnateur d1 = new Donnateur();
//		Donnateur d2 = new Donnateur();
//		
//		donDao.create(d1);
//		donDao.create(d2);
//		
//		dao.create(a);
//		
//		b.setCategorie("0");
//		dao.create(a);
//	}
	
}
