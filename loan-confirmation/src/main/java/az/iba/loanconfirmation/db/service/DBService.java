package az.iba.loanconfirmation.db.service;

import az.iba.loanconfirmation.db.entity.Loaner;

import java.util.List;
import java.util.Optional;

public interface DBService {
    Optional<Loaner> saveOrUpdate(Loaner loaner);
    Optional<Loaner> getByIdLoaner(long idCustomer);

    List<Loaner> getActiveLoaners(int isActive);
}
