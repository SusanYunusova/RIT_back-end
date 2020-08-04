package az.iba.userroles.api;

import az.iba.userroles.api.service.Service;
import az.iba.userroles.db.entity.UserRoles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/roles")
public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/{roleName}")
    public ResponseEntity<List<UserRoles>> getByRoleName(@PathVariable String roleName){
        log.info("getting All roles and permissions by roleName:{}...",roleName);
        return service.getByRoleName(roleName);
    }


}
