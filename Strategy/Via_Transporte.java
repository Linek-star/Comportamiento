package Strategy;

public interface Via_Transporte {

	//Distribuidor getDitribucion();

	/**
	 * 
	 * @param origen
	 * @param destino
	 */
	Ruta trazar_ruta(String origen, String destino);

}