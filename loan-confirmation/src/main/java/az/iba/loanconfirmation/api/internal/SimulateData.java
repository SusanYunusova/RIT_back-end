package az.iba.loanconfirmation.api.internal;

import lombok.Data;

import java.util.List;

@Data
public class SimulateData {
    private List<User> users;
    private String message;
    private int sendWay;//1 sms 2 mail
}
