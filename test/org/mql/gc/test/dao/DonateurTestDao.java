package org.mql.gc.test.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mql.gc.dao.AssociationDao;
import org.mql.gc.dao.AssociationDaoImp;
import org.mql.gc.dao.DonorDao;
import org.mql.gc.dao.DonorDaoImp;
import org.mql.gc.models.Association;
import org.mql.gc.models.Donor;

public class DonateurTestDao {
	
	private static DonorDao dao;
	private static DonorDaoImp donnateur;
	
	@BeforeAll
	public static void setUpSuite() {
		dao = new DonorDaoImp();
	}
	
	@Test
	public void testCreateDonnateur() {
		DonorDaoImp d = new DonorDaoImp();

		d.setfName("karim");
		dao.create(d);

		assertNotNull(d.getId());
		assertEquals(d.getfName(), "karim");
	}
	
	@Test
	public void testUpdateDonnateur() {
		DonorDaoImp d = new DonorDaoImp();

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
		DonorDaoImp d = new DonorDaoImp();

		d.setfName("karim");
		dao.create(d);

		
		assertNotNull(d.getId());
		
		dao.delete(d.getId());
		
		d = dao.findById(d.getId());
		assertNull(d);
	}
	
	@Test
	public void testFindById() {
		DonorDaoImp d = new DonorDaoImp();
		dao.create(d);

		DonorDaoImp b = dao.findById(d.getId());
		
		assertEquals(b.getId(), d.getId());
	}
	
	@Test
	public void testFindByEmail() {
		DonorDaoImp d = new DonorDaoImp();

	}

	
}
