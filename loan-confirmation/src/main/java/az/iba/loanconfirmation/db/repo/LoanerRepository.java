package az.iba.loanconfirmation.db.repo;

import az.iba.loanconfirmation.db.entity.Loaner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoanerRepository extends JpaRepository<Loaner,Long> {
    List<Loaner> findAllByIsActive(int isActive);
    Optional<Loaner> findByIdLoaner(long idCustomer);
}
