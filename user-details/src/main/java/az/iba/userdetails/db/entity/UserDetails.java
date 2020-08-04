package az.iba.userdetails.db.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Builder
@Data
@Entity
@Table(name = "user_details")
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser", nullable = false, unique = true)
    private long idUser;
    private String name;
    private String surname;
    @Column(unique = true)
    private String username;
    private String password;
    private String roleName;

}
