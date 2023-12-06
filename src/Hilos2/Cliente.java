package Hilos2;

class Cliente extends Thread {
    private Banco banco;
    private int id;
    
    public Cliente(Banco banco, int id) {
        this.banco = banco;
        this.id = id;
    }
    
    public void run() {
        banco.ingresarBanco(id);
        
        // Aqui se simula la espera en la fila del banco
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        banco.salirBanco(id);
    }
}
