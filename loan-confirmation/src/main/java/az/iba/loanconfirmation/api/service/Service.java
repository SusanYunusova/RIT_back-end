package az.iba.loanconfirmation.api.service;

import az.iba.loanconfirmation.api.internal.*;
import az.iba.loanconfirmation.db.entity.Loaner;
import az.iba.loanconfirmation.db.service.impl.DBServiceImpl;
import az.iba.loanconfirmation.proxy.ProxyCustomerHistory;
import az.iba.loanconfirmation.proxy.ProxySimulation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@Slf4j
public class Service {
    private final DBServiceImpl dbService;
    private final ProxyCustomerHistory proxyCustomerHistory;
    private final ProxySimulation proxySimulation;

    public Service(DBServiceImpl dbService, ProxyCustomerHistory proxyCustomerHistory, ProxySimulation proxySimulation) {
        this.dbService = dbService;
        this.proxyCustomerHistory = proxyCustomerHistory;
        this.proxySimulation = proxySimulation;
    }

    Function<Optional<?>, ResponseEntity<?>> serviceFunction = data ->
            data.map(
                    result -> new ResponseEntity<>(result, HttpStatus.OK)
            ).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NO_CONTENT));

    public ResponseEntity<?> getCustomersForNewLoan(CreditParameters parameters) {
        log.info("getting getCustomersForNewLoan by parameters");
        return serviceFunction.apply(getCustomersFromProxy(parameters));
    }

    public ResponseEntity<?> createLoaner(RequestLoaner requestLoaner) {
        log.info(" createNewLoaner by requestLoaner");
        return serviceFunction.apply(createNewLoaner(requestLoaner.getAmount(), requestLoaner.getIdCustomer()));
    }


    public ResponseEntity<?> sendConfirmedData(SimulateData simulateData) {
        log.info("sendConfirmedData...");
        return serviceFunction.apply(startSimulation(simulateData));
    }


    public ResponseEntity<?> confirm(long idLoaner) {
        log.info("confirm loaners ...");
        return serviceFunction.apply(confirmLoaner(idLoaner));
    }

    public ResponseEntity<?> getActiveLoaners() {
        log.info("getting all active confirmed or unConfirmed loaners...");
        return serviceFunction.apply(getLoaners());
    }

    public Optional<List<Loaner>> getLoaners() {
        List<Loaner> activeLoaners = dbService.getActiveLoaners(1);
     return Optional.of(activeLoaners);
    }
    private Optional<List<CustomerData>> getCustomersFromProxy(CreditParameters parameters) {
        ResponseEntity<List<CustomerData>> allData = proxyCustomerHistory.getAllData(parameters);
        if (allData.getStatusCodeValue() == 200) {
            log.info("get customer is ok");
            List<CustomerData> customerDataList = allData.getBody();
            return Optional.ofNullable(customerDataList);
        } else {
            return Optional.empty();
        }
    }

    private Optional<Loaner> createNewLoaner(BigDecimal amount, long idCustomer) {
        return dbService.saveOrUpdate(Loaner.builder()
                .amount(amount)
                .idCustomer(idCustomer)
                .isActive(1)
                .isConfirm(0)
                .build());
    }


    public Optional<Loaner> confirmLoaner(long idLoaner) {
        Optional<Loaner> byIdLoaner = dbService.getByIdLoaner(idLoaner);
        if (byIdLoaner.isPresent()) {
            byIdLoaner.get().setIsConfirm(1);
            return dbService.saveOrUpdate(byIdLoaner.get());
        } else {
            return Optional.empty();
        }
    }


    private Customers getCustomerDetails(long idCustomer) {
        ResponseEntity<Customers> response = proxyCustomerHistory.getById(idCustomer);
        if (response.getStatusCodeValue() == 200) {
            return response.getBody();
        }
        return null;
    }

    private Optional<List<SimulationResult>> startSimulation(SimulateData simulateData) {
        ResponseEntity<List<User>> response = proxySimulation.getAnswer(simulateData);
        if (response.getStatusCodeValue() == 200 && response.getBody() != null) {
            List<SimulationResult> list = response.getBody().stream().map(
                    this::createResult
            ).collect(Collectors.toList());
            return Optional.of(list);
        }
        return Optional.empty();
    }

    private SimulationResult createResult(User user) {

        return SimulationResult.builder()
                .fullName(getCustomerDetails(user.getId()).getFullName())
                .result(user.getIsAccept() == 1 ? "Message sent" : "Couldnt send")
                .build();
    }
}
