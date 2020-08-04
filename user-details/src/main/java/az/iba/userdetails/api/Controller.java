package az.iba.userdetails.api;

import az.iba.userdetails.api.internal.Credentials;
import az.iba.userdetails.api.service.Service;
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

    @GetMapping("/byIdUser/{idUser}")
    public ResponseEntity<?> getById(@PathVariable long idUser) {
        log.info("getting by id:{}...", idUser);
        return service.getByID(idUser);
    }


    @PostMapping("/byUsername")
    public ResponseEntity<?> getByUsername(@RequestBody String username) {
        log.info("getting by username..");
        return service.getByCredentials(username);
    }

}
