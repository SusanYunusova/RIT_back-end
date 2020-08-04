package az.suzy.customerhistory.api.internal;

import az.suzy.customerhistory.db.entity.Customers;
import az.suzy.customerhistory.db.entity.PaymentHistory;
import lombok.Data;

import java.util.List;

@Data
public class CustomerData {
    private Customers customers;
    private List<PaymentHistory> paymentHistory;
}
