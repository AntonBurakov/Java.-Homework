package ru.netology.burakov;

import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

import model.Customer;
import model.Operation;
import repository.CustomerRepository;
import repository.OperationRepository;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        /*
        // ДЗ 1
        System.out.println("Hello and welcome!");


        // ДЗ 2
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


        Scanner scanner3 = new Scanner(System.in);
        double[] transactions = new double[5];
        String[] names = new String[5];
        int[] currencyCodes = new int[5];
        System.out.println("Введите размер транзакций");
        for (int i = 0; i < transactions.length; i++) {
            transactions[i] = scanner3.nextDouble();
        }

        for (double transaction : transactions) {
            System.out.println(transaction);
        }

        Scanner scanner4 = new Scanner(System.in);
        Date[] dates = new Date[5];
        System.out.println("Введите даты транзакций в формате dd/MM/yyyy");
        for (int i = 0; i < dates.length; i++) {
            String s = scanner4.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dates[i] = sdf.parse(s);
        }

        for (Date date : dates) {
            System.out.println(date);
        }

        System.out.println("Введите начальную дату периода за который вы хотите посмотреть транзакции");
        String s = scanner4.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dateStart = sdf.parse(s);

        System.out.println("Введите конечную дату периода за который вы хотите посмотреть транзакции");
        s = scanner4.nextLine();
        Date dateEnd = sdf.parse(s);

        System.out.println("Следующие транзакции были произведены за период с " + dateStart + " по " + dateEnd);
        Main.transactionForPeriod(transactions, dates, dateStart, dateEnd);

    }

    public static void transactionForPeriod (double[] transactions, Date[] dates, Date dateStart, Date dateEnd) {
        for (int i = 0; i < transactions.length; i++) {
            if ((dates[i].after(dateStart)) && (dates[i].before(dateEnd))) {
                System.out.println(transactions[i] + " за дату " + dates[i]);
            }
        }
    }
    */
        // ДЗ5
        CustomerRepository customerRepository = new CustomerRepository();
        OperationRepository operationRepository = new OperationRepository();
        Customer customer;
        Operation operation;


        Scanner scanner = new Scanner(System.in);

        boolean b = true;

        while (b) {

            System.out.println("""
                Добрый день, какую из нижеперечисленных операций желаете выполнить?
                1. Добавить получателя
                2. Выполнить перевод
                3. Вывести список операций по получателю
                4. Вывести полный список получателей
                5. Вывести полный список операций
                6. Заверщение работы
                """);

            int command = scanner.nextInt();

            switch (command) {
                case 1:
                    System.out.println("Введите Имя получателя: ");
                    String firstName = scanner.next();
                    System.out.println("Введите Фамилию получателя: ");
                    String secondName = scanner.next();
                    System.out.println("Введите возраст получателя: ");
                    int age = scanner.nextInt();
                    customer = new Customer(firstName,secondName,age);
                    customerRepository.addCustomer(customer);
                    break;
                case 2:
                    System.out.println("Введите сумму: ");
                    double amount = scanner.nextDouble();
                    System.out.println("Введите дату: ");
                    int date = scanner.nextInt();
                    System.out.println("Введите имя получателя");
                    String name = scanner.next();
                    int customerId = customerRepository.findCustomerRepo(name);
                    if(customerId == 404){
                        System.out.println("Повторите попытку.");
                    } else {
                        operation = new Operation(amount, date);
                        operationRepository.addOperation(operation, customerId);
                    }
                    break;
                case 3:
                    System.out.println("Введите имя получателя: ");
                    String nameCustomer = scanner.next();
                    int nameId = customerRepository.findCustomerRepo(nameCustomer);
                    Operation[] operationsCustomer = OperationRepository.getOperations(nameId);
                    operationRepository.printOperation(operationsCustomer);
                    break;
                case 4:
                    System.out.println("Полный список получателей: ");
                    customerRepository.print();
                    break;
                case 5:
                    System.out.println("Полный список операций ");
                    operationRepository.print();
                    break;
                case 6:
                    System.out.println("Это было супер!");
                    b = false;
                    break;
                default:
                    System.out.println("Такой команды не существует");
                    break;
            }
        }
    }
}