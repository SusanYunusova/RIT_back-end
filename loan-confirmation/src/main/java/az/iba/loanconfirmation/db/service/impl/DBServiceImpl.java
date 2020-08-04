package az.iba.loanconfirmation.db.service.impl;

import az.iba.loanconfirmation.db.entity.Loaner;
import az.iba.loanconfirmation.db.repo.LoanerRepository;
import az.iba.loanconfirmation.db.service.DBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class DBServiceImpl  implements DBService {
    private final LoanerRepository repository;

    public DBServiceImpl(LoanerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Loaner> saveOrUpdate(Loaner loaner) {
        log.info("save or update db");
        return Optional.of(repository.save(loaner));
    }

    @Override
    public Optional<Loaner> getByIdLoaner(long idLoaner) {
        log.info("get by id:{}",idLoaner);
        return repository.findByIdLoaner(idLoaner);
    }

    @Override
    public List<Loaner> getActiveLoaners(int isActive) {
        log.info("get All active loaners");
        return repository.findAllByIsActive(isActive);
    }
}
