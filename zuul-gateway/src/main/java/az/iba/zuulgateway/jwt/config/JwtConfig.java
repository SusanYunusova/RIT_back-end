package az.iba.zuulgateway.jwt.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.http.HttpHeaders;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "app.jwt")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtConfig {

    private String secretKey;
    private String tokenPrefix;
    private Integer tokenExpirationDay;




    public String getAuthorizationHeader(){
        return HttpHeaders.AUTHORIZATION;
    }

}
