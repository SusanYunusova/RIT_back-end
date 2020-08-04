package az.suzy.customerhistory.api;

import az.suzy.customerhistory.api.internal.Parameters;
import az.suzy.customerhistory.api.service.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/byIdCustomer/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        log.info("getting by id:{}...", id);
        return service.getCustomerById(id);
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllCustomers() {
        log.info("getting All data...");
        return service.getCustomerData();
    }
    @PostMapping("/getAllData")
    public ResponseEntity<?> getAllData(@RequestBody Parameters parameters) {
        log.info("getting All data by amount and term...");
        return service.getCustomerDataList(parameters.getAmount(),parameters.getMonthlyTerm());
    }
}
