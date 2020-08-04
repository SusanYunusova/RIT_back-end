package az.iba.loanconfirmation.api;

import az.iba.loanconfirmation.api.internal.CreditParameters;
import az.iba.loanconfirmation.api.internal.RequestLoaner;
import az.iba.loanconfirmation.api.internal.SimulateData;
import az.iba.loanconfirmation.api.service.Service;
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

    @PostMapping("/getForLoaner")
    public ResponseEntity<?> createLoaner(@RequestBody CreditParameters parameters) {
        log.info("getting new Loaners...");
        return service.getCustomersForNewLoan(parameters);
    }

    @PostMapping("/createLoaner")
    public ResponseEntity<?> createLoaner(@RequestBody RequestLoaner requestLoaner) {
        log.info("creating new Loaners...");
        return service.createLoaner(requestLoaner);
    }

    @GetMapping("/getActiveLoaners")
    public ResponseEntity<?> getActiveLoaners() {
        log.info("getActiveLoaners...");
        return service.getActiveLoaners();
    }

    @GetMapping("/confirmLoaner/{idLoaner}")
    public ResponseEntity<?> confirmLoaner(@PathVariable long idLoaner) {
        log.info("confirmLoaner id{}...", idLoaner);
        return service.confirm(idLoaner);
    }

    @PostMapping("/sendConfirmedData")
    public ResponseEntity<?> sendConfirmedData(@RequestBody SimulateData simulateData) {
        return service.sendConfirmedData(simulateData);

    }
}
