package az.iba.userroles.api.service;

import az.iba.userroles.db.entity.UserRoles;
import az.iba.userroles.db.service.impl.DBServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class Service {
    private final DBServiceImpl dbService;

    public Service(DBServiceImpl dbService) {
        this.dbService = dbService;
    }


    public ResponseEntity<List<UserRoles>> getByRoleName(String roleName) {
        log.info("trying to get   by  roleName:{}", roleName);
        List<UserRoles> userRolesList = dbService.getAllByRoleName(roleName);
        if (!userRolesList.isEmpty()) {
            log.info("userRolesList has found by rolename");
            return new ResponseEntity<>(userRolesList, HttpStatus.OK);
        } else {
            log.info("couldn't find by rolename:{}", roleName);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }


    }
}
