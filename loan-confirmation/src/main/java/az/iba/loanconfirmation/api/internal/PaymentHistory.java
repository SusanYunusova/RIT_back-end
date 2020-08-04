package az.iba.loanconfirmation.api.internal;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data

public class PaymentHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    private  long id;
    private  long idCustomer;
    private LocalDate deadline;
    private LocalDate paidDay;
    private BigDecimal minPaymentAmount;
    private BigDecimal paymentAmount;


}
