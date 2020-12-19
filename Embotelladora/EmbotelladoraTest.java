import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class EmbotelladoraTest {
	
	private int litros;  
	private int pequenas;
	private int grandes;

	@Before  
	public void setUp()
	{
	   litros = 0;
	   pequenas = 0;
	   grandes = 0;
	}
	
	@After    
	public void tearDown()
	{
	   litros = 0;
	   pequenas = 0;
	   grandes = 0; 
	}
	
	@Test(expected=NoSolution.class)
	public void TestSinBotellas() throws NoSolution
	{
		pequenas = 0;
		grandes = 0;
		litros= 5;
		Embotelladora.calculaBotellasPequenas(pequenas, grandes, litros);
	}
	
	@Test
	public void TestBotellaGrande() throws NoSolution
	{
		pequenas = 0;
		grandes = 1;
		litros= 5;
		assertEquals(0,Embotelladora.calculaBotellasPequenas(pequenas, grandes, litros));
	}

	@Test()
	public void TestDosBotellas() throws NoSolution
	{
		pequenas = 1;
		grandes = 1;
		litros= 1;
		Embotelladora.calculaBotellasPequenas(pequenas, grandes, litros);
	}
	
	@Test
	public void TestDosPequeñas() throws NoSolution
	{
		pequenas = 2;
		grandes = 0;
		litros= 2;
		assertEquals(2,Embotelladora.calculaBotellasPequenas(pequenas, grandes, litros));
	}
	
	@Test
	public void TestDosPequeñasUnaGrande() throws NoSolution
	{
		pequenas = 2;
		grandes = 1;
		litros= 7;
		assertEquals(2,Embotelladora.calculaBotellasPequenas(pequenas, grandes, litros));
	}
	
	@Test(expected=NoSolution.class)
	public void TestDosPequeñasMal() throws NoSolution
	{
		pequenas = 2;
		grandes = 0;
		litros= 5;
		Embotelladora.calculaBotellasPequenas(pequenas, grandes, litros);
	}
	
	@Test(expected=NoSolution.class)
	public void TestCuatroPequeñasMal() throws NoSolution
	{
		pequenas = 4;
		grandes = 0;
		litros= 9;
		assertEquals(0,Embotelladora.calculaBotellasPequenas(pequenas, grandes, litros));
	}
	
	@Test(expected=NoSolution.class)
	public void sieteLitrosUnaGrandes() throws NoSolution
	{
		pequenas = 0;
		grandes = 1;
		litros= 7;
		Embotelladora.calculaBotellasPequenas(pequenas, grandes, litros);
	}

	@Test
	public void sieteLitrosDosGrandes() throws NoSolution
	{
		pequenas = 0;
		grandes = 2;
		litros= 7;
		Embotelladora.calculaBotellasPequenas(pequenas, grandes, litros);
	}

}