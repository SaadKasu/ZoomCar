package ZoomCar.Models;

import java.util.Date;

public class PhonePeTransaction extends Transaction implements OnlinePayment {

    public PhonePeTransaction(Date dateOfTransaction, int amount, CarBooking  bookedCar){
        this.modeOfPayment = PaymentType.ONLINE;
        this.amount = amount;
        this.bookedCar = bookedCar;
        makePayment();
    }

    public void makePayment(){
        this.dateOfTransaction = new Date();
        this.statusOfTransaction = TransactionStatus.SUCCESSFUL;
        // WIll use 3rd Party API here
    }
}
