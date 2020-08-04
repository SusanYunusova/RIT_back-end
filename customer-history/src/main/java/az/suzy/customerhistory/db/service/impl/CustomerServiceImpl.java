package az.suzy.customerhistory.db.service.impl;

import az.suzy.customerhistory.db.entity.Customers;
import az.suzy.customerhistory.db.repo.CustomerRepository;
import az.suzy.customerhistory.db.service.DBService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerServiceImpl implements DBService<Customers> {
    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Customers> getById(long id) {
        return repository.findByIdCustomer(id);
    }

    public List<Customers> getAll(){
        return repository.findAll();
    }
}
