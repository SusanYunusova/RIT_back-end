package az.iba.userroles.db.service.impl;

import az.iba.userroles.db.entity.UserRoles;
import az.iba.userroles.db.repo.RolesRepository;
import az.iba.userroles.db.service.DBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
public class DBServiceImpl  implements DBService<UserRoles> {
    private  final RolesRepository rolesRepository;

    public DBServiceImpl(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public List<UserRoles> getAllByRoleName(String roleName) {

        try {
            log.info("trying to get  by roleName from db");
            return rolesRepository.findAllByRoleName(roleName);
        } catch (Exception e) {
            log.error("error getting by roleName from Db{}", e, e);
            return new ArrayList<>();
        }
    }
}
