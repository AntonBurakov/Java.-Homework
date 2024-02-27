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



        // ДЗ 3
        Scanner scanner2 = new Scanner(System.in);

        String name = "";
        int age = 0;
        long accountNumber = 0;
        int currencyCode = 0;
        double amount = 0;
        int j = 0;
        while (true) {
            j++;
            switch (j) {
                case 1:
                    System.out.println("Введите ФИО получателя:");
                    name = scanner2.nextLine();
                    break;
                case 2:
                    System.out.println("Введите возраст получателя:");
                    age = scanner2.nextInt();
                    break;
                case 3:
                    System.out.println("Введите номер счета получателя:");
                    accountNumber = scanner2.nextLong();
                    break;
                case 4:
                    System.out.println("Введите код валюты:");
                    currencyCode = scanner2.nextInt();
                    break;
                case 5:
                    System.out.println("Введите размер перевода:");
                    amount = scanner2.nextDouble();
                    break;
            }
            if (j == 6){
                break;
            }
        }
        System.out.println("ФИО получателя: " + name);
        System.out.println("Возраст получателя: " + age);
        System.out.println("Номер счета получателя: " + accountNumber);
        System.out.println("Код валюты: " + currencyCode);
        System.out.println("Размер перевода: " + amount);
    }
}