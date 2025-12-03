package ChainOfResponsibility;

public class GerenteTienda extends BaseManejador {

    private static final double LIMITE_APROBACION = 1000.0;

    @Override
    public boolean manejarSolicitud(SolicitudCambioProducto request) {
        if (request.getPrecio() > LIMITE_APROBACION) {
            System.out.println("Gerente de Tienda: Producto supera $1000, aprobando solicitud...");
            return true;
        }

        System.out.println("Gerente de Tienda: Aprobación no requerida.");
        return true;
    }
}