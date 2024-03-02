package repository;

import service.ConsolePrintable;
import model.Customer;

public class CustomerRepository implements ConsolePrintable {

    private static int id = 1;

    private static int count = 0;

    Customer[] customers = new Customer[100];

    public void addCustomer(Customer customer) {
        if (count == 99) {
            System.out.println("Репозиторий заполнен");
        } else {
            Customer customerId = new Customer(id, customer);
            customers[count] = customerId;
            id++;
            count++;
        }
    }

    public int findCustomerRepo(String name) {
        for (Customer customer : customers) {
            String firstName = customer.getFirstName();
            if (firstName.toLowerCase().trim().equals(name.toLowerCase().trim())) {
                int id = customer.getId();
                return id;
            } else {
                System.out.println("Получаетель не был найден.");
                return 404;
            }
        }
        return 404;
    }

    @Override
    public void print() {
        for (Customer customer : customers) {
            if (customer == null) {
                break;
            } else {
                System.out.println(customer);
            }
        }
    }
}