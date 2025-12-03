package ChainOfResponsibility;

public class Cliente {

    private Handler handlerInicial;

    public Cliente() {
        configurarCadena();
    }

    private void configurarCadena() {
        Handler asistente = new AsistenteAtencion();
        Handler tecnico = new Tecnico();
        Handler jefeInventario = new JefeInventario();
        Handler gerente = new GerenteTienda();

        asistente
                .setSiguiente(tecnico)
                .setSiguiente(jefeInventario)
                .setSiguiente(gerente);

        this.handlerInicial = asistente;
    }

    public void solicitarCambio(SolicitudCambioProducto request) {
        boolean aprobado = handlerInicial.manejarSolicitud(request);

        if (aprobado) {
            System.out.println("✅ Cambio aprobado exitosamente.");
        } else {
            System.out.println("❌ Cambio rechazado.");
        }
    }

    public static void main(String[] args) {
        Cliente cliente = new Cliente();

        SolicitudCambioProducto solicitud = new SolicitudCambioProducto(
                true,   // en garantía
                true,   // tipo de falla cubierta
                true,   // stock disponible
                1200.0  // precio
        );

        cliente.solicitarCambio(solicitud);
    }
}
