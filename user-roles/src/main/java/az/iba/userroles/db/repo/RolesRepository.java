package az.iba.userroles.db.repo;

import az.iba.userroles.db.entity.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesRepository extends JpaRepository<UserRoles, Long> {
    List<UserRoles> findAllByRoleName(String roleName);
}
