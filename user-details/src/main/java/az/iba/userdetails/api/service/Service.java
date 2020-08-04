package az.iba.userdetails.api.service;

import az.iba.userdetails.api.internal.UserData;
import az.iba.userdetails.db.entity.UserDetails;
import az.iba.userdetails.db.service.DBService;
import az.iba.userdetails.db.service.impl.DBServiceImpl;
import az.iba.userdetails.proxy.RolesProxy;
import az.iba.userroles.db.entity.UserRoles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Component
@Slf4j
public class Service {
    private final DBService dbService;
    private final RolesProxy rolesProxy;

    public Service(@Qualifier("DBService") DBService dbService, RolesProxy rolesProxy) {
        this.dbService = dbService;
        this.rolesProxy = rolesProxy;
    }

    Function<Optional<?>, ResponseEntity<?>> serviceFunction = data ->
            data.map(
                    result -> new ResponseEntity<>(result, HttpStatus.OK)
            ).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NO_CONTENT));


    public ResponseEntity<?> getByID(long id) {
        log.info("trying to get  user by  id");
        return serviceFunction.apply(getUserDetails(id));
    }

    public ResponseEntity<?> getByCredentials(String username) {
        log.info("trying to get  user by  credentials");
        Optional<UserDetails> userDetails = dbService.getByUserNameAndPassword(username);
        Optional<UserData> userData = userDetails.flatMap(data -> createUserData(data, getPermissionsList(data.getRoleName())));
        return serviceFunction.apply(userData);
    }

    private List<UserRoles> getPermissionsList(String roleName) {
        log.info("trying to get permissionsList from role proxy");
        ResponseEntity<List<UserRoles>> byRoleName = rolesProxy.getByRoleName(roleName);
        if (byRoleName.getStatusCodeValue() == 200) {
            return byRoleName.getBody();
        } else {
            return new ArrayList<>();
        }
    }

    private Optional<UserDetails> getUserDetails(long idUser) {
        log.info("getting userDetails by id:{}", idUser);
        return dbService.getById(idUser);
    }

    private Optional<UserData> createUserData(UserDetails userDetails, List<UserRoles> permissions) {
        return Optional.of(UserData.builder()
                .permissions(permissions)
                .userDetails(userDetails)
                .build());
    }


}
