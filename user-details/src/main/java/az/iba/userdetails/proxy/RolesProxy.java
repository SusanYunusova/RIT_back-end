package az.iba.userdetails.proxy;

import az.iba.userroles.db.entity.UserRoles;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="user-roles")
@RibbonClient(name ="user-roles")
public interface RolesProxy {

    @GetMapping("/roles/{roleName}")
     ResponseEntity<List<UserRoles>> getByRoleName(@PathVariable String roleName);
}
