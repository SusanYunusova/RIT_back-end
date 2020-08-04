package az.suzy.customerhistory.db.service.impl;

import az.suzy.customerhistory.db.entity.PaymentHistory;
import az.suzy.customerhistory.db.repo.PaymentRepository;
import az.suzy.customerhistory.db.service.DBService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PaymentServiceImpl implements DBService<PaymentHistory> {
    private final PaymentRepository repository;

    public PaymentServiceImpl(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<PaymentHistory> getById(long id) {
        return repository.findById(id);
    }

    public List<PaymentHistory> getAllByIdCustomer(long idCustomer){
        return repository.findAllByIdCustomer(idCustomer);
    }
}
