package az.suzy.customerhistory.db.repo;

import az.suzy.customerhistory.db.entity.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PaymentRepository  extends JpaRepository<PaymentHistory,Long> {
    Optional<PaymentHistory> findById(long id);
    List<PaymentHistory> findAllByIdCustomer(long idCustomer);
}
