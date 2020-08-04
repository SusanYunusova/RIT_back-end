package az.iba.loanconfirmation.proxy;

import az.iba.loanconfirmation.api.internal.CreditParameters;
import az.iba.loanconfirmation.api.internal.CustomerData;
import az.iba.loanconfirmation.api.internal.Customers;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="customer-history")
@RibbonClient(name ="customer-history")
public interface ProxyCustomerHistory {

    @PostMapping("/getAllData")
     ResponseEntity<List<CustomerData>> getAllData(@RequestBody CreditParameters parameters);

    @GetMapping("/byIdCustomer/{id}")
     ResponseEntity<Customers> getById(@PathVariable long id);

}
