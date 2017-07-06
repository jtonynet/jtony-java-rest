package test;

import java.util.List;

import br.com.livro.domain.Carro;
import br.com.livro.domain.CarroService;

import junit.framework.TestCase;


public class CarroTest extends TestCase {
	private CarroService carroService = new CarroService();
	
	public void testaListaCarros() {
		
		List<Carro> carros = carroService.getCarros();
		
		assertNotNull(carros);
		
		assertTrue(carros.size() > 0);
		
		Carro tucker = carroService.findByName("Tucker 1948").get(0);
		assertEquals("Tucker 1948", tucker.getNome());
		
		Carro ferrari = carroService.findByName("Ferrari FF").get(0);
		assertEquals("Ferrari FF", ferrari.getNome());
		
		Carro bugatti = carroService.findByName("Bugatti Veyron").get(0);
		assertEquals("Bugatti Veyron", bugatti.getNome());
	}
	
	public void testSalvarDeletarCarro () {
		
		Carro c = new Carro();
		c.setNome("Teste");
		c.setDesc("Teste desc");
		c.setUrlFoto("url foto aqui");
		c.setUrlVideo("urlVideo aqui");
		c.setLatitude("lat");
		c.setLongitude("long");
		c.setTipo("tipo");
		carroService.save(c);
		
		Long id = c.getId();
		
		c = carroService.getCarro(id);
		assertEquals(c.getNome(), "Teste");
		assertEquals(c.getDesc(), "Teste desc");
		assertEquals(c.getUrlFoto(), "url foto aqui");
		assertEquals(c.getUrlVideo(), "urlVideo aqui");
		assertEquals(c.getLatitude(), "lat");
		assertEquals(c.getLongitude(), "long");
		assertEquals(c.getTipo(), "tipo");
		
		c.setNome("Teste UPDATE");
		carroService.save(c);
		c = carroService.getCarro(id);
		assertEquals("Teste UPDATE", c.getNome());
		
		carroService.delete(id);
		c = carroService.getCarro(id);
		assertNull(c);
	}
}
