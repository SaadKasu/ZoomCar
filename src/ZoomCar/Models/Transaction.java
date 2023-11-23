package ZoomCar.Models;

import java.util.Date;

public abstract class Transaction extends BaseClass{
    Date dateOfTransaction;
    TransactionStatus statusOfTransaction;
    PaymentType modeOfPayment;
    CarBooking bookedCar;
    int amount;
}
