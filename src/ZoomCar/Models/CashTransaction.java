package ZoomCar.Models;

import java.util.Date;

public class CashTransaction extends Transaction {
    public CashTransaction(Date dateOfTransaction, int amount, CarBooking  bookedCar){
        this.dateOfTransaction = dateOfTransaction;
        this.modeOfPayment = PaymentType.CASH;
        this.amount = amount;
        this.bookedCar = bookedCar;
        this.statusOfTransaction = TransactionStatus.SUCCESSFUL;
    }
}
