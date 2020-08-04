package az.iba.loanconfirmation.api.internal;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreditParameters {
    private BigDecimal amount;
    private int monthlyTerm;
}
