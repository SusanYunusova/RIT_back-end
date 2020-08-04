package az.iba.loanconfirmation.db.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
@Builder
@Data
@Entity
@Table(name = "loaner")
@NoArgsConstructor
@AllArgsConstructor
public class Loaner implements Serializable {
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLoaner", nullable = false, unique = true)
    private long idLoaner;
    private long idCustomer;
    private BigDecimal amount;
    private int isConfirm;
    private int isActive;
}
