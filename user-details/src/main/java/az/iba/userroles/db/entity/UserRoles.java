package az.iba.userroles.db.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
public class UserRoles implements Serializable {
    private static final long serialVersionUID = 1L;
    private long idUserRoles;
    private String roleName;
    private String permissions;


}
