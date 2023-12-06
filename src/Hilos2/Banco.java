package Hilos2;

public class Banco extends Thread {
    private int clientes_act = 0;
    
    public synchronized void ingresarBanco(int cl) {
    	//Aqui se llama y se verifica cuantos clientes existen en el momento si hay menos de dos el cliente 
    	//puede entrar sino se va a espera
        while (clientes_act >= 2) {
            try {
                System.out.println("El Cliente " + cl + " está esperando para ingresar al banco.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        clientes_act++;
        System.out.println("El cliente " + cl + " ha ingresado al banco.");
    }
    public synchronized void salirBanco(int idCliente) {
        clientes_act--;
        System.out.println("Cliente " + idCliente + " ha salido del banco.");
        notifyAll();
    }    
}