package az.iba.loanconfirmation.api.internal;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RequestLoaner {
    private BigDecimal amount;
    private long idCustomer;
}
