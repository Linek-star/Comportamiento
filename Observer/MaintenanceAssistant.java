package Observer;

class MaintenanceAssistant implements Observer {
        @Override
        public void update(String message) {
            if (message.contains("reparación")) {
                System.out.println("[MaintenanceAssistant] Nuevo equipo para reparar: " + message);
            }
        }
    }