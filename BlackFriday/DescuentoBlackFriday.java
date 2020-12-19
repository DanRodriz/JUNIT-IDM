import java.util.Calendar;

public class DescuentoBlackFriday {

	public static double precioFinal(double precioOriginal, double porcentajeDescuento, Calendar fecha) throws IllegalArgumentException {

		int mes = fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		if (precioOriginal <= 0) {
			throw new IllegalArgumentException("Precio no válido");
		}
		
		if(porcentajeDescuento < 0 || porcentajeDescuento > 100) {
			throw new IllegalArgumentException("Descuento no válido");
		}

		if (dia == 29 && mes == 11) {
			return precioOriginal * ((100 - porcentajeDescuento)/100);
		}
		return precioOriginal;
	}
}