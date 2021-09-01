// Joaquín Ortiz Castillo 2016100319
package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        startProgram();
    }
    public static double[] generarArray(int size) {

        double[] a = new double[size];

        for (int i = 0; i < size; i++) {
            a[i] =(Math.random() * 9.9);
            for (int j = 0; j < i; j++) {
                if (a[i] == a[j]) {
                    i--;
                    break;
                }
            }
        }
        for (double v : a) {
            System.out.print(String.format("%.2f",v)+" ");
        }
        return a;
    }
    public static String buscarMayorSismo(double[] a) {
        int i=0;

        double n=0;
        while ( i < a.length ) {
            if ( a[i] > n ) n = a[i];
            i++;
        }
        return String.format("%.2f",n);
    }
    public static void mostrarMayorSismo(double[] a){
        String mayorSismo = buscarMayorSismo(a);
        System.out.println(mayorSismo+"\n");
    }
    public static int contarSismos(double[] a){
        int i=0;

        int n=0;
        while ( i < a.length ) {
            if ( a[i] >= 5.0 ) n++;
            i++;
        }
        return n;
    }
    public static void mostrarContarSismos(double[] a){
        int cantidadSismo = contarSismos(a);
        System.out.println(+cantidadSismo+"\n");
    }
    public static void enviarSMS(double[] a){
        int i=0;
        while ( i < a.length ) {
            if ( a[i] >= 7.0 ) System.out.println("Alerta!!! se debe evacuar zona costera!");
            i++;
        }
    }
    public static void salir(){
        String respuesta = getInput("Desea salir del programa? S/N");
        if(respuesta.contains("s")){
            System.exit(0);
        }
        else if (respuesta.contains("S")){
            System.exit(0);
        }
        else if (respuesta.contains("n")){
            showMenu();
        }
        else if (respuesta.contains("N")){
            showMenu();
        }
    }
    public static String getInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.next();
    }
    public static void validateMenu(int option, double[] a) {
        switch (option) {
            case 1:
                generarArray(70);
                break;
            case 2:
                System.out.print("Mayor Sismo encontrado fue de intensidad: ");
                mostrarMayorSismo(a);
                break;
            case 3:
                System.out.print("Cantidad de sismos mayores o iguales a 5.0: ");
                mostrarContarSismos(a);
                break;
            case 4:
                System.out.println("Enviando SMS a zonas de riesgo.");
                enviarSMS(a);
                break;
            case 0:
                salir();
                break;
        }
    }
    public static int getMenuOption() {
        while (true) {
            String validacion = "01234";

            String input = getInput("Seleccione una opción:");
            if (validacion.indexOf(input) >= 0) {
                int option = Integer.parseInt(input);
                if (-1 < option && option < 5) {
                    return option;
                }
            }
            else {
                System.out.println("Opción inválida");
            }
        }
    }
    public static void showMenu() {
        System.out.println("-------------");
        System.out.println("[1] Ingresar datos");
        System.out.println("[2] Mostrar sismo de mayor magnitud");
        System.out.println("[3] Contar sismos mayores o iguales a 5.0");
        System.out.println("[4] Enviar SMS por cada sismo mayor o igual a 7.0");
        System.out.println("");
        System.out.println("[0] Salir (S/N)");
    }
    public static void executeMenu() {
        double[] a = generarArray(70);
        while (true) {
            showMenu();
            int option = getMenuOption();
            validateMenu(option, a);
        }
    }
    public static void startProgram(){
        System.out.println("Bienvenido, se ha simulado el ingreso de sismos.");
        executeMenu();
        showMenu();
    }
}