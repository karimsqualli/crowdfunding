package org.mql.gc.test.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mql.gc.dao.AssociationDao;
import org.mql.gc.dao.AssociationDaoImpl;
import org.mql.gc.dao.DonateurDao;
import org.mql.gc.dao.DonateurDaoImpl;
import org.mql.gc.models.Association;
import org.mql.gc.models.Donnateur;

public class DonateurTestDao {
	
	private static DonateurDao dao;
	private static Donnateur donnateur;
	
	@BeforeAll
	public static void setUpSuite() {
		dao = new DonateurDaoImpl();
	}
	
	@Test
	public void testCreateDonnateur() {
		Donnateur d = new Donnateur();

		d.setfName("karim");
		dao.create(d);

		assertNotNull(d.getId());
		assertEquals(d.getfName(), "karim");
	}
	
	@Test
	public void testUpdateDonnateur() {
		Donnateur d = new Donnateur();

		d.setfName("karim");
		dao.create(d);


		d.setEmail("karim@live.fr");
		d.setfName("testname");
		
		dao.update(d);
		
		d = dao.findById(d.getId());

		assertEquals(d.getfName(), "testname");
		assertEquals(d.getEmail(), "karim@live.fr");
	}
	
	@Test
	public void testDeleteDonnateur() {
		Donnateur d = new Donnateur();

		d.setfName("karim");
		dao.create(d);

		
		assertNotNull(d.getId());
		
		dao.delete(d.getId());
		
		d = dao.findById(d.getId());
		assertNull(d);
	}
	
	@Test
	public void testFindById() {
		Donnateur d = new Donnateur();
		dao.create(d);

		Donnateur b = dao.findById(d.getId());
		
		assertEquals(b.getId(), d.getId());
	}
	
}
