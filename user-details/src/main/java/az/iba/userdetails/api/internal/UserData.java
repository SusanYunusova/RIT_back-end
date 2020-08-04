package az.iba.userdetails.api.internal;

import az.iba.userdetails.db.entity.UserDetails;
import az.iba.userroles.db.entity.UserRoles;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class UserData {
    private UserDetails userDetails;
    private List<UserRoles> permissions;
}
