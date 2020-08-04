package az.iba.zuulgateway.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRoles implements Serializable {
    private static final long serialVersionUID = 1L;
    private long idUserRoles;
    private String roleName;
    private String permissions;


}
