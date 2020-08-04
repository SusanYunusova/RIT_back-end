package az.iba.zuulgateway.proxy;

import az.iba.zuulgateway.model.Credentials;
import az.iba.zuulgateway.model.UserData;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="user-details")
@RibbonClient(name ="user-details")
public interface UserDetailsProxy {

    @PostMapping("/byUsername")
     ResponseEntity<UserData> getByUsername(@RequestBody String username);
}
