package ChainOfResponsibility;

public class JefeInventario extends BaseManejador {

    @Override
    public boolean manejarSolicitud(SolicitudCambioProducto request) {
        System.out.println("Jefe de Inventario: Verificando stock disponible...");

        if (!request.isStockDisponible()) {
            System.out.println("Solicitud rechazada: No hay stock disponible.");
            return false;
        }

        return manejarSiguiente(request);
    }
}
