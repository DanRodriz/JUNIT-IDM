import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class DescuentoBlackFridayTest {
	
	private double precioOriginal;
	private double porcentajeDescuento;
	private Calendar fecha;

	@Before  
	public void setUp(){
		precioOriginal = 0;
		porcentajeDescuento = 0;
		Calendar fecha = new GregorianCalendar(2020,11,29);
	}
	
	@After   
	public void tearDown(){
		precioOriginal = 0;
		porcentajeDescuento = 0;
		Calendar fecha = new GregorianCalendar(2020,11,29);
	}

	@Test
	public void TestDescuentoOk() {
		precioOriginal = 100;
		porcentajeDescuento = 25;
		Calendar fecha = new GregorianCalendar(2020,11,29);
		DescuentoBlackFriday.precioFinal(precioOriginal, porcentajeDescuento, fecha);
	}

	@Test
	public void TestNoEsBlackFriday() {
		precioOriginal = 100;
		porcentajeDescuento = 25;
		Calendar fecha = new GregorianCalendar(2020,10,29);
		DescuentoBlackFriday.precioFinal(precioOriginal, porcentajeDescuento, fecha);
	}

	@Test(expected=IllegalArgumentException.class)
	public void TestDescuentoNegativo() {
		precioOriginal = 100;
		porcentajeDescuento = -25;
		Calendar fecha = new GregorianCalendar(2020,11,29);
		DescuentoBlackFriday.precioFinal(precioOriginal, porcentajeDescuento, fecha);
	}

	@Test(expected=IllegalArgumentException.class)
	public void TestPrecioNegativo() {
		precioOriginal = -100;
		porcentajeDescuento = 25;
		Calendar fecha = new GregorianCalendar(2020,11,29);
		DescuentoBlackFriday.precioFinal(precioOriginal, porcentajeDescuento, fecha);
	}

	@Test(expected=IllegalArgumentException.class)
	public void TestDescuentoAlto() {
		precioOriginal = 100;
		porcentajeDescuento = 255;
		Calendar fecha = new GregorianCalendar(2020,11,29);
		DescuentoBlackFriday.precioFinal(precioOriginal, porcentajeDescuento, fecha);
	}

}