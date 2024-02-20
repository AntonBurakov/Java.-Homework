package ru.netology.burakov;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ФИО: ");
        String s = scanner.nextLine();

        System.out.print("Введите код валюты: ");
        int i = scanner.nextInt();

        System.out.print("Введите количесвто рублей: ");
        double d = scanner.nextDouble();

        System.out.println("ФИО: " + s);
        System.out.println("Код валюты: " + i);
        System.out.println("Количесвто рублей: " + d);
    }
}