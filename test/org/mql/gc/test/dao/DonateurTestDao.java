package org.mql.gc.test.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mql.gc.dao.AssociationDao;
import org.mql.gc.dao.AssociationDaoImp;
import org.mql.gc.dao.DonorDao;
import org.mql.gc.dao.DonorDaoImp;
import org.mql.gc.models.Association;
import org.mql.gc.models.Donor;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DonateurTestDao {
	private static DonorDao dao;
	private static DonorDaoImp donnateur;
	private static WebDriver driver;
	private static String baseUrl;
	
	@BeforeAll
	public static void setUpSuite() {
		dao = new DonorDaoImp();
		System.setProperty("webdriver.chrome.driver", "C:/Users/SALAM/Desktop/Selenium/chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://localhost:8083/Projet_KAISAHHH/loginAdmin.xhtml";
		driver.manage().timeouts().implicitlyWait(30 , TimeUnit.SECONDS);
	}
	
	@Test
	public void testLogin() {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//input[@ id='bb:email1']")).clear();
		driver.findElement(By.xpath("//input[@ id='bb:email1']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@ id='bb:passw']")).clear();
		driver.findElement(By.xpath("//input[@ id='bb:passw']")).sendKeys("admin");
		driver.findElement(By.id("bb:j_idt48")).click();
		assertTrue(driver.findElement(By.id("upd")).isDisplayed());
	}
	
	@Test
	public void testLogout() {
		driver.findElement(By.id("j_idt6:j_idt7")).click();
		driver.navigate().back();
		assertEquals(baseUrl, driver.getCurrentUrl());
	}
	
//	@Test
//	public void testLogin() {
//		driver.get("http://localhost:8083/Projet_KAISAHHH/index.xhtml");
//		driver.findElement(By.xpath("a.btn.btn-default")).click();
//		driver.findElement(By.xpath("//input[@ id='AAA:username']")).clear();
//		driver.findElement(By.xpath("//input[@ id='AAA:username']")).sendKeys("plasmahamza@hotmail.com");
//		driver.findElement(By.id("//input[@ id='AAA:password1']")).clear();
//		driver.findElement(By.id("//input[@ id='AAA:password1']")).sendKeys("aaaaaa");
//		driver.findElement(By.id("//button[@id='AAA:j_idt58']/spa")).click();
//		assertTrue(driver.findElement(By.xpath("http://localhost:8083/Projet_KAISAHHH/index.xhtml")).isDisplayed());
//	}
	
	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	
//	@Test
//	public void testCreateDonnateur() {
//		DonorDaoImp d = new DonorDaoImp();
//
//		d.setfName("karim");
//		dao.create(d);
//
//		assertNotNull(d.getId());
//		assertEquals(d.getfName(), "karim");
//	}
//	
//	@Test
//	public void testUpdateDonnateur() {
//		DonorDaoImp d = new DonorDaoImp();
//
//		d.setfName("karim");
//		dao.create(d);
//
//
//		d.setEmail("karim@live.fr");
//		d.setfName("testname");
//		
//		dao.update(d);
//		
//		d = dao.findById(d.getId());
//
//		assertEquals(d.getfName(), "testname");
//		assertEquals(d.getEmail(), "karim@live.fr");
//	}
//	
//	@Test
//	public void testDeleteDonnateur() {
//		DonorDaoImp d = new DonorDaoImp();
//
//		d.setfName("karim");
//		dao.create(d);
//
//		
//		assertNotNull(d.getId());
//		
//		dao.delete(d.getId());
//		
//		d = dao.findById(d.getId());
//		assertNull(d);
//	}
//	
//	@Test
//	public void testFindById() {
//		DonorDaoImp d = new DonorDaoImp();
//		dao.create(d);
//
//		DonorDaoImp b = dao.findById(d.getId());
//		
//		assertEquals(b.getId(), d.getId());
//	}
//	
//	@Test
//	public void testFindByEmail() {
//		DonorDaoImp d = new DonorDaoImp();
//
//	}

	
}
