public class Embotelladora {

	// @param pequenas: número de botellas en almacén de 1L
	//		  grandes : número de botellas en almacén de 5L
	//		  total : número total de litros que hay que embotellar
	// @return número de botellas pequeñas necesarias para embotellar el total de lı́quido, teniendo
	// en cuenta que hay que minimizar el número de botellas pequeñas: primero
	// se rellenan las grandes
	// @throws NoSolution si no es posible embotellar todo el lı́quido

	public static int calculaBotellasPequenas(int pequenas, int grandes, int total) throws NoSolution {

		int botellasGrandes = 0;
		if (pequenas < 0 || grandes < 0 || total <= 0){
			throw new NoSolution("Invalid Parameter");
		}
		if (grandes != 0 && total >= 5){
			botellasGrandes = Math.min((int)Math.floor(total / grandes), grandes);
		}
		int restante = total - botellasGrandes * 5;
		int botellasPequeñas = Math.min(restante, pequenas);
		restante = restante - botellasPequeñas;

		if (restante != 0){
			throw new NoSolution("Cantidad sobrante");
		}
		return botellasPequeñas;
	}
}