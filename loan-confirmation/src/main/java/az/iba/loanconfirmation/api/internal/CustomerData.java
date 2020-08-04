package az.iba.loanconfirmation.api.internal;

import lombok.Data;

import java.util.List;

@Data
public class CustomerData {
    private Customers customers;
    private List<PaymentHistory> paymentHistory;
}
