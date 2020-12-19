import java.lang.IllegalArgumentException;
import java.util.GregorianCalendar;

public class Bisiesto{
	// @param a un n´umero entero positivo
	// @return true si a es un a~no bisiesto
	// false en caso contrario.
	// @throws IllegalArgumentException si a no es un par´ametro v´alido.

	public static boolean esBisiesto(int año) throws IllegalArgumentException {
		GregorianCalendar calendar = new GregorianCalendar();
		boolean bisiesto = false;
		if(año > 0) {
			if (calendar.isLeapYear(año)){
				bisiesto = true;
			}
		}else{
			throw new IllegalArgumentException("Año incorrecto");
		}
		return bisiesto;
	}
}