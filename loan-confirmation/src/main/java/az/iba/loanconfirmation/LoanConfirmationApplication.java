package az.iba.loanconfirmation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("az.iba.loanconfirmation.proxy")
public class LoanConfirmationApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoanConfirmationApplication.class, args);
    }

}
