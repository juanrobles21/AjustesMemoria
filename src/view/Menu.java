package view;

import controller.MemorySizeController;

import java.util.Scanner;

public class Menu {
    public static Scanner Keyboard = new Scanner(System.in);
    private MemorySizeController memorySizeController;

    public Menu() {
        memorySizeController = new MemorySizeController();
        memorySizeController.insertDates();
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        String jobSize = "";
        int opt = 0;
        do {
            System.out.println("Ingrese tamaño del archivo Kb");
            jobSize = Keyboard.next();
            System.out.println("Seleccione El tipo de asignacion de memoria\n" +
                    "(1) Primer Ajuste\n" +
                    "(2) Mejor Ajuste\n" +
                    "(3) Peor Ajuste\n" +
                    "(0) Salir");
            opt = Keyboard.nextInt();
            switch (opt) {
                case 1:
                    menu.primerAjuste(jobSize);
                    break;
                case 2:
                    menu.mejorAjuste(jobSize);
                    break;
                case 3:
                    menu.peorAjuste(jobSize);
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.err.println("Opcion no encontrada");
                    break;
            }

        } while (opt != 0);


    }

    public void primerAjuste(String jobSize) {
        String returnValue = "";
        returnValue = memorySizeController.values();
        System.out.println(returnValue);
        returnValue = memorySizeController.primerAjuste(jobSize);
        System.out.println(returnValue);

    }

    public void mejorAjuste(String jobSize) {
        String returnValue = "";
        returnValue = memorySizeController.values();
        System.out.println(returnValue);
        returnValue = memorySizeController.mejorAjuste(jobSize);
        System.out.println(returnValue);
    }

    public void peorAjuste(String jobSize) {
        String returnValue = "";
        returnValue = memorySizeController.values();
        System.out.println(returnValue);
        returnValue = memorySizeController.peorAjuste(jobSize);
        System.out.println(returnValue);
    }
}
