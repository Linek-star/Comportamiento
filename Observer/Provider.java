package Observer;

class Provider implements Observer {
        @Override
        public void update(String message) {
            if (message.contains("falla") || message.contains("garantía")) {
                System.out.println("[Provider] Productos con fallas detectados: " + message);
            }
        }
    }