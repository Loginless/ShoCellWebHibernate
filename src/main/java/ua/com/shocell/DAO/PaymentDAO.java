package ua.com.shocell.DAO;

import ua.com.shocell.models.Payment;

import java.util.Date;
import java.util.List;

public interface PaymentDAO {

    public List<Payment> findByPaymentDate(Date paymentDate);

    public List<Payment> findByPaymentDateRange(Date fromDate, Date toDate);

    public List<Payment> findByPaymentAmount(int fromAmount, int toAmount);

    public List<Payment> findByPaymentChannel(String paymentChannel);

}
