package az.suzy.simulation.api;

import az.suzy.simulation.api.internal.SimulateData;
import az.suzy.simulation.api.internal.User;
import az.suzy.simulation.api.service.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class Controller {

    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping("/getAnswer")
    public ResponseEntity<List<User>> getAnswer(@RequestBody SimulateData simulateData) {
        log.info("trying to get result list...");
        return service.getAnswer(simulateData);
    }

}
