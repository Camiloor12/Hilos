package Hilos2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
    Scanner S1 = new Scanner(System.in);
     System.out.println("Cuantos clientes hay en la cola al  banco ");
    int a= S1.nextInt();
        for (int i = 1; i <= a; i++) {
            Cliente cliente = new Cliente(banco, i);
            cliente.start();
        }
    }
}