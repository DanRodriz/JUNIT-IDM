import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class BisiestoTest {
	
	private int año;  

	@Before
	public void setUp()
	{
	   año = 0;
	}
	
	@After
	public void tearDown()
	{
	   año = 0;  
	}

	@Test
	public void TestAñoBisiesto()
	{
		año = 2012;
		Bisiesto.esBisiesto(año);
		assertEquals("Año bisiesto", true, Bisiesto.esBisiesto(año));
	}

	@Test
	public void TestAñoNoBisiesto()
	{
		año = 2019;
		Bisiesto.esBisiesto(año);
		assertEquals("Año bisiesto", false, Bisiesto.esBisiesto(año));
	}

	@Test(expected=IllegalArgumentException.class)
	public void TestAñoCero()
	{
		año = 0;
		Bisiesto.esBisiesto(año);	
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestAñoNegativo()
	{
		año = -2;
		Bisiesto.esBisiesto(año);	
	}

}