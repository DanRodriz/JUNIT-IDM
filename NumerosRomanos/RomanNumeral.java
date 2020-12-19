import java.util.Hashtable;
import java.lang.IllegalArgumentException;

public class RomanNumeral 
{
	static Hashtable <String, Integer> numerosRomanos = new Hashtable <String, Integer>();

	public static void llenarHashtable(){
		numerosRomanos.put("I", 1);
		numerosRomanos.put("V", 5);
		numerosRomanos.put("X", 10);
		numerosRomanos.put("L", 50);
		numerosRomanos.put("C", 100);
		numerosRomanos.put("D", 500);
		numerosRomanos.put("M", 1000);
	}

	public static int restarTerminos(String romano, int suma){
	    if (romano.contains("IV"))
	        suma-=2;
	    if (romano.contains("IX"))
	        suma-=2;
	    if (romano.contains("XL"))
	    	suma-=20;
	    if (romano.contains("XC"))
	    	suma-=20;
	    if (romano.contains("CD"))
	    	suma-=200;
	    if (romano.contains("CM"))
	    	suma-=200;
	    return suma;
	}

	public static boolean esRomano(String romano){

	    return !romano.contains("IIII") && !romano.contains("XXX") && !romano.contains("CCC")
	    		&& !romano.contains("MMM") && !romano.contains("VV") && !romano.contains("LL")
	    		&& !romano.contains("DD") && !romano.contains("VL") && !romano.contains("VIV")
	    		&& !romano.contains("XXM") && !romano.contains("CXM") && !romano.contains("XID");
	}
	
	public static int convertir(String entrada) throws IllegalArgumentException{
		String romano = entrada.replaceAll(" ","");	
		if (!esRomano(romano))
			throw new IllegalArgumentException();
		
		llenarHashtable();
		
		int decimal = 0;	
		int valor = 0;	
			
		
		for(int i = 0; i < entrada.length(); i++)	
		{
			String letra = Character.toString(romano.charAt(i)).toUpperCase();
			
			if(numerosRomanos.containsKey(letra)){
				decimal = decimal + numerosRomanos.get(letra);
			}else {
				throw new IllegalArgumentException();
			}
		}
		if (decimal == 0)
			throw new IllegalArgumentException();
		decimal = restarTerminos(romano, decimal);
		return decimal;
	}
}