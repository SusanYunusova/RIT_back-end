package az.suzy.customerhistory.api.service;

import az.suzy.customerhistory.api.internal.CustomerData;
import az.suzy.customerhistory.db.entity.Customers;
import az.suzy.customerhistory.db.entity.PaymentHistory;
import az.suzy.customerhistory.db.service.impl.CustomerServiceImpl;
import az.suzy.customerhistory.db.service.impl.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@Slf4j
public class Service {
    private final CustomerServiceImpl customerService;
    private final PaymentServiceImpl paymentService;

    public Service(CustomerServiceImpl customerService, PaymentServiceImpl paymentService) {
        this.customerService = customerService;
        this.paymentService = paymentService;
    }

    Function<Optional<?>, ResponseEntity<?>> serviceFunction = data ->
            data.map(
                    result -> new ResponseEntity<>(result, HttpStatus.OK)
            ).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NO_CONTENT));

    public ResponseEntity<?> getCustomerById(long id) {
        log.info("trying to get customer  by  id");
        return serviceFunction.apply(customerService.getById(id));
    }

    public ResponseEntity<?> getCustomerData() {
        log.info("getting All..");
        return serviceFunction.apply(Optional.of(getCustomerDataList()));
    }

    public ResponseEntity<?> getCustomerDataList(BigDecimal amount, int monthlyTerm) {
       log.info("getting All by amount:{} and term:{}",amount,monthlyTerm);
        return serviceFunction.apply(Optional.ofNullable(checkCapacity(amount,monthlyTerm)));
    }

    private List<CustomerData> getCustomerDataList() {
        List<Customers> customersList = customerService.getAll();
        log.info("size:{}", customersList.size());
        List<CustomerData> dataList = new ArrayList<>();

        customersList.forEach(customer -> {
            CustomerData customerData = new CustomerData();
            customerData.setCustomers(customer);
            customerData.setPaymentHistory(getPaymentList(customer));
            dataList.add(customerData);
        });
        return dataList;
    }

    private List<PaymentHistory> getPaymentList(Customers customer) {
        return paymentService.getAllByIdCustomer(customer.getIdCustomer());
    }


    public List<CustomerData> checkCapacity(BigDecimal amount, int monthlyTerm) {//5000azn 10ay  500
        BigDecimal monthlyPayment = amount.divide(BigDecimal.valueOf(monthlyTerm));

        List<CustomerData> customerDataList = getCustomerDataList().stream().filter(customerData ->
                customerData.getCustomers().getMaxPayment().compareTo(monthlyPayment) > 0 ||
                        ( customerData.getCustomers().getMaxPayment().compareTo(monthlyPayment) == 0)
        ).sorted(Comparator.comparingInt(customerData-> getPaidTime(customerData.getPaymentHistory())))
                .collect(Collectors.toList());


        return customerDataList;
    }

    private int getPaidTime(List<PaymentHistory> paymentList) {
        log.info("getPaidTime...");
        return paymentList.stream().mapToInt(paymentHistory -> paymentHistory.getPaidDay()
                .compareTo(paymentHistory.getDeadline())).sum();

    }

}
