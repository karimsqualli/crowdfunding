package org.mql.gc.test.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.mql.gc.models.Association;
import org.mql.gc.models.Cas;

public class CasTestDao {
	
	private static CaseDao dao;
	private static Cas cas;

	
	@BeforeAll
	public static void setUpSuite() {
		dao = new CaseDaoImpl();
		
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
	
	
	public void testFind
	
}
