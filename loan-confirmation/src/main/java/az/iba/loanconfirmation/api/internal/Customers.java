package az.iba.loanconfirmation.api.internal;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
public class Customers implements Serializable {
    private static final long serialVersionUID = 1L;
    private  long idCustomer;
    private String name;
    private String surname;
    private String paternalName;
    private String code;
    private BigDecimal maxPayment;

    public String getFullName(){
        return name.concat(" ").concat(surname);
    }
}
