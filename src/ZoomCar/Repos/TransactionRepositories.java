package ZoomCar.Repos;

import ZoomCar.Models.Transaction;

import java.util.ArrayList;

public class TransactionRepositories {
    public static ArrayList<Transaction> transactions = new ArrayList<>();
    public static void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }
}
