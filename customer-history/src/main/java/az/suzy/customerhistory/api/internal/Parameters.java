package az.suzy.customerhistory.api.internal;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Parameters {
    private BigDecimal amount;
    private int monthlyTerm;
}
