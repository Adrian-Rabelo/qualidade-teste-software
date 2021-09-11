package qts.locadora.service;

import org.junit.Assert;
import org.junit.Test;

import qts.locadora.model.Cliente;

public class AssertivaTest {
	
	@Test
	public void teste() {
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		// Delta ou epsilon -> margem entre valores
		Assert.assertEquals(5.24543, 5.24542, 0.00001);
		
		// Comparar tipos primitivos com classes
		int a = 3;
		Integer d = 3;
		Assert.assertEquals(Integer.valueOf(a), d);
		Assert.assertEquals(a, d.intValue());
		
		// Comparação entre strings
		Assert.assertEquals("teste", "teste");
		Assert.assertTrue("Teste".equalsIgnoreCase("teste"));
		
		// Comparação entre classes
		Cliente cli1 = new Cliente("ádrian");
		Cliente cli2 = new Cliente("ádrian");
		
		// O .equals() interno da classe "Cliente" teve uma sobrecaraga para poder fazer a comparação certa entre classes 
		Assert.assertEquals(cli1, cli2);
		
		System.out.println(cli1);
		
		// Comparar as instâncias
		Assert.assertSame(cli1, cli2);
		
		Assert.assertNotNull(cli1);
	}
	
}
