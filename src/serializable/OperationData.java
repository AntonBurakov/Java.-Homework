package serializable;

import model.Customer;
import model.Operation;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;

public class OperationData implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Operation[] operations;
    private Customer[] customers;
    private int[][] statement;

    public OperationData(Operation[] operations, Customer[] customers, int[][] statement) {
        this.customers = customers;
        this.operations = operations;
        this.statement = statement;
    }


    public Operation[] getOperations() {
        return operations;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public int[][] getStatement() {
        return statement;
    }

    @Override
    public String toString() {
        return "Customer: " + Arrays.toString(customers) + '\n' +
                "Operations: " + Arrays.toString(operations) + '\n' +
                "Statement: " + Arrays.deepToString(statement);
    }
}