package az.iba.zuulgateway.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class UserData {
    private UserDetails userDetails;
    private List<UserRoles> permissions;
}
