package org.mql.gc.test.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mql.gc.dao.AssociationDao;
import org.mql.gc.dao.AssociationDaoImp;
import org.mql.gc.models.Association;
import org.junit.jupiter.api.BeforeAll;

class AssociationTestDao  {

	private static AssociationDao dao;
	private static Association association;

	@BeforeAll
	public static void setUpSuite() {
		dao = new AssociationDaoImp();
		
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


	}
	
	@Test
	public void testDeleteAssociation() {
		Association a = new Association();
		a.setName("test-name-lol");
		dao.create(a);
	}
	
	@Test
	public void testFindById() {
		Association a = new Association();
		dao.create(a);
		
	}
	
	
	@Test
	public void testFindByEmail() {
		Association a = new Association();
		a.setEmail("uniqueMail@live.fr");

	}
	

}
