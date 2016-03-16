package be.vdab.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import be.vdab.entities.Filiaal;
import be.vdab.services.FiliaalService;
import be.vdab.valueobjects.Adres;

public class FiliaalControllerTest {

	private Filiaal filiaal;
	private FiliaalController filiaalController;
	private List<Filiaal> filialen;
	private FiliaalService filiaalService;

	@Before
	public void before() {
		filiaalService = Mockito.mock(FiliaalService.class);
		
		filiaal = new Filiaal("naam1", true, BigDecimal.ONE, new Date(),
				new Adres("straat1", "huisnr1", 1, "gemeente1"), 0L);
		Mockito.when(filiaalService.read(1)).thenReturn(filiaal);
		
		filialen = Collections.emptyList();
		Mockito.when(filiaalService.findAll()).thenReturn(filialen);
		filiaalController = new FiliaalController(filiaalService);
	}
	


	@Test
	public void findAllActiveertJuistView() {
		assertEquals("filialen/filialen", filiaalController.findAll().getViewName());
	}

	@Test
	public void findAllMaaktRequestAttribuutFilialen() {
		assertSame(filialen, filiaalController.findAll().getModelMap().get("filialen"));
	}

	@Test
	public void readActiveertJuisteView() {
		assertEquals("filialen/filiaal", filiaalController.read(filiaal).getViewName());
	}

	@Test
	public void readMetBestaandeIDGeeftFiliaalTerug() {
		assertSame(filiaal, filiaalController.read(filiaal).getModelMap().get("filiaal"));
	}

}
