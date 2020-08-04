package az.suzy.customerhistory.db.repo;

import az.suzy.customerhistory.db.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CustomerRepository  extends JpaRepository<Customers,Long> {
    Optional<Customers> findByIdCustomer(long idCustomer);


}
