package az.suzy.customerhistory.db.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
@Entity
@Table(name = "payment_history")
@AllArgsConstructor
@NoArgsConstructor
public class PaymentHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private  long id;
    private  long idCustomer;
    private LocalDate deadline;
    private LocalDate paidDay;
    private BigDecimal minPaymentAmount;
    private BigDecimal paymentAmount;


}
