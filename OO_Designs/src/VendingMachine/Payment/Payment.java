package VendingMachine.Payment;

import VendingMachine.Hardware;

public interface Payment {

	boolean validatePaymentInput();

	boolean compltePaymentProcess();
}
