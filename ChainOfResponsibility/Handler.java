package ChainOfResponsibility;

public interface Handler {
    Handler setSiguiente(Handler handler);
    boolean manejarSolicitud(SolicitudCambioProducto request);
}