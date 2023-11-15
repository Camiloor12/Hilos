import java.util.Scanner;

public class CFilPrincipal {
    private static Scanner S1 = new Scanner(System.in);

    public static void main(String[] args) {
        int con = 0;
        do {
            // Menú de opciones
            System.out.println("Introduce una opcion 1 ( 1.1) / 2 (1.2) / 3 (1.4) / 4 Salir");
            con = S1.nextInt();
            switch (con) {
                case 1:
                    parte1();  
                    break;
                case 2:
                    parte2();  
                    break;
                case 3:
                    parte3();  
                    break;
                case 4:
                    System.out.println("Cerrando Programa...");  
                    break;
            }
        } while (con != 4);  
    }

    public static void parte1() {
        System.out.println("ej 1.1\n");
        CFil h1 = new CFil("Hijo1");
        System.out.println("Proceso padre iniciado");
        h1.setTemp(0);
        h1.start();
        try {
            h1.join();  // Espera a que el hilo h1 termine antes de continuar
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println("Proceso padre terminado\n");
    }

 
    public static void parte2() {
        System.out.println("ej 1.2\n");
        CFil h2 = new CFil("Hijo2");
        System.out.println("Proceso padre iniciado ");
        h2.setTemp(7000);
        h2.start();
        System.out.println("Proceso padre terminado ");
        while (h2.isAlive()) {
            // Espera hasta que el hilo h2 termine
        }
    }
    
    public static void parte3() {
        CFil c;
        System.out.println("Cuantos procesos quieres hacer: ");
        int numProcesos = S1.nextInt();
        while (numProcesos > 10) {
            System.out.println("El numero de procesos es demasiado grande, Introduce otro numero ");
            numProcesos = S1.nextInt();
        }
        System.out.println("Proceso padre iniciado");

        // Crear y ejecutar hilos
        for (int i = 0; i < numProcesos; i++) {
            c = new CFil("Hijo " + i);
            c.setTemp(3000 * i);
            c.start();
            try {
                c.join();  // Espera a que el hilo c termine antes de continuar
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Proceso padre finalizado");
    }
}
