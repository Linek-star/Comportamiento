package Observer;

class WebBuyer implements Observer {
        @Override
        public void update(String message) {
            System.out.println("[WebBuyer] Productos disponibles actualizados: " + message);
        }
    }