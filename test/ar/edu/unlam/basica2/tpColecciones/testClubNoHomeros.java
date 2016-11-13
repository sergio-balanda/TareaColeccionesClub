package ar.edu.unlam.basica2.tpColecciones;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.basica2.tpColecciones.BarHomero;
import ar.edu.unlam.basica2.tpColecciones.Cliente;
import ar.edu.unlam.basica2.tpColecciones.CompararPorEdad;
import junit.framework.Assert;

public class testClubNoHomeros {

	@Test
	public void testAbrirElBAR() {
		BarHomero elBar = new BarHomero();
		elBar.abierto();
		assertTrue(elBar.elBarSeEncuentra() == true);
	}
	
	@Test
	public void testAgragarClientesYnoIguales(){
		BarHomero elBar = new BarHomero();
		Cliente clienteUno = new Cliente("Homero",21);
		Cliente clienteDos = new Cliente("Homero",22);
		Cliente clienteTres = new Cliente("juan",120);
		Cliente clienteCuatro = new Cliente("romina",21);
		
		elBar.entraCliente(clienteUno);
		elBar.entraCliente(clienteDos);
		elBar.entraCliente(clienteTres);
		elBar.entraCliente(clienteCuatro);
	
		Assert.assertEquals(3, elBar.getClientes().size());
		
	}
	
	@Test
	public void testOrdenarPorNombre(){
		BarHomero elBar = new BarHomero();
		Cliente clienteUno = new Cliente("C",21);
		Cliente clienteDos = new Cliente("A",22);
		Cliente clienteTres = new Cliente("B",120);
		
		elBar.entraCliente(clienteUno);
		elBar.entraCliente(clienteDos);
		elBar.entraCliente(clienteTres);
		
		System.out.println(""+elBar.getClientes());
		String nombreEsperado="A";
		Assert.assertEquals(nombreEsperado, elBar.getClientes().first().getNombre());
	}
	
	@Test
	public void testOrdenarPorEdad(){
		CompararPorEdad comarar = new CompararPorEdad();
		BarHomero elBar = new BarHomero(comarar);
		Cliente clienteDos = new Cliente("Homero",50);
		Cliente clienteTres = new Cliente("Carlos",25);
		Cliente clienteUno = new Cliente("Carlos",22);
		
	
		elBar.entraCliente(clienteUno);
		elBar.entraCliente(clienteDos);
		elBar.entraCliente(clienteTres);
		Integer edadEsperadaAlComienzo= 22;
		Assert.assertEquals(edadEsperadaAlComienzo, elBar.getClientes().first().getEdad());
		Integer edadEsperadaAlFinal= 50;
		Assert.assertEquals(edadEsperadaAlFinal, elBar.getClientes().last().getEdad());
	}
	
	@Test
	public void testCompararClientes(){
		
		Cliente clienteUno = new Cliente("b",27);
		Cliente clienteDos = new Cliente("a",27);
		
		
		Boolean clienteUnoEsMayor = clienteUno.compareTo(clienteDos) > 0;
		assertEquals(true, clienteUnoEsMayor);
		Assert.assertFalse(clienteUno.equals(clienteDos));
		
	}
}
