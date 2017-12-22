package org.mql.gc.test.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.mql.gc.dao.AssociationDao;
import org.mql.gc.dao.AssociationDaoImpl;
import org.mql.gc.models.Association;
import org.junit.jupiter.api.BeforeAll;

class AssociationTestDao  {

	private static AssociationDao dao;
	private static Association association;

	@BeforeAll
	public static void setUpSuite() {
		dao = new AssociationDaoImpl();
		
		Association association = new Association();

		association.setName("testName");
		dao.create(association);
	}
	

	@Test
	public void testCreateAssociation() {
		Association a = new Association();

		a.setName("karim");
		dao.create(a);

		assertNotNull(a.getId());
		assertEquals(a.getName(), "karim");
	}
	
	@Test
	public void testUpdateAssociation() {
		Association a = new Association();
		dao.create(a);

		a.setEmail("karim@live.fr");
		a.setName("testname");
		
		dao.update(a);
		
		a = dao.findById(a.getId());

		assertEquals(a.getName(), "testname");
		assertEquals(a.getEmail(), "karim@live.fr");
	}
	
	@Test
	public void testDeleteAssociation() {
		Association a = new Association();
		a.setName("test-name-lol");
		dao.create(a);
		
		assertNotNull(a.getId());
		
		dao.delete(a.getId());
		
		a = dao.findById(a.getId());
		assertNull(a);
	}
	
	@Test
	public void testFindById() {
		Association a = new Association();
		dao.create(a);

		Association b = dao.findById(a.getId());
		
		assertEquals(b.getId(), a.getId());
	}
	
	
	@Test
	public void testFindByEmail() {
		Association a = new Association();
		a.setEmail("uniqueMail@live.fr");
		dao.create(a);

		Association b = dao.findByEmail(a.getEmail());
		
		assertEquals(b.getId(), a.getId());
		assertEquals(b.getEmail(), a.getEmail());
	}
	


}
