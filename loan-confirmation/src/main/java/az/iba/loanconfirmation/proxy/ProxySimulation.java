package az.iba.loanconfirmation.proxy;

import az.iba.loanconfirmation.api.internal.SimulateData;
import az.iba.loanconfirmation.api.internal.User;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@FeignClient(name="demo-simulation")
@RibbonClient(name ="demo-simulation")
public interface ProxySimulation {

    @PostMapping("/getAnswer")
     ResponseEntity<List<User>> getAnswer(@RequestBody SimulateData simulateData);
}
