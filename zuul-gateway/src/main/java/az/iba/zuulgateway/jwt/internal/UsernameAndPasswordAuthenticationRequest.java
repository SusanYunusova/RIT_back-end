package az.iba.zuulgateway.jwt.internal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsernameAndPasswordAuthenticationRequest {

    private String username;
    private String password;


}
