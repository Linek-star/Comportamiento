package Observer;

class StoreSeller implements Observer {
        private String storeId;

        public StoreSeller(String storeId) {
            this.storeId = storeId;
        }

        @Override
        public void update(String message) {
            System.out.println("[StoreSeller - Tienda " + storeId + "] Nuevas unidades en tu tienda: " + message);
        }
    }
