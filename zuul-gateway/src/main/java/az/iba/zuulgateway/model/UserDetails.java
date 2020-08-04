package az.iba.zuulgateway.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data

@NoArgsConstructor
public class UserDetails implements Serializable {
    private long idUser;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String roleName;
}
