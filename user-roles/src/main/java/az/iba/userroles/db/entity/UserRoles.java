package az.iba.userroles.db.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Data
@Entity
@Table(name = "user_roles")
@AllArgsConstructor
@NoArgsConstructor
public class UserRoles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUserRoles", nullable = false, unique = true)
    private long idUserRoles;
    private String roleName;
    private String permissions;


}
