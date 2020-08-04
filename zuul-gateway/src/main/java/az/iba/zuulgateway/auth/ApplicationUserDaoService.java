package az.iba.zuulgateway.auth;

import az.iba.zuulgateway.model.UserData;
import az.iba.zuulgateway.model.UserRoles;
import az.iba.zuulgateway.proxy.UserDetailsProxy;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Repository("userDetailsService")
public class ApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsProxy userDetailsProxy;

    @Autowired
    public ApplicationUserDaoService(PasswordEncoder passwordEncoder, UserDetailsProxy userDetailsProxy) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsProxy = userDetailsProxy;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return Optional.ofNullable(getApplicationUser(username));
    }


    private ApplicationUser getApplicationUser(String username){
        ResponseEntity<UserData> response = userDetailsProxy.getByUsername(username);
        if(response.getStatusCodeValue()==200){
            return createApplicationUser(response.getBody());
        }else{
            return null;
        }
    }

    private ApplicationUser createApplicationUser(UserData userData){
        return new ApplicationUser(
                userData.getUserDetails().getUsername(),
                passwordEncoder.encode(userData.getUserDetails().getPassword()),
                getGrantedAuthorities(userData.getUserDetails().getRoleName(),userData.getPermissions()),
                true,
                true,
                true,
                true
        );
    }

    private Set<SimpleGrantedAuthority> getGrantedAuthorities(String roleName, List<UserRoles> permissionsList){
            Set<SimpleGrantedAuthority> permissions = permissionsList.stream()
                    .map(permission -> new SimpleGrantedAuthority(permission.getPermissions()))
                    .collect(Collectors.toSet());
            permissions.add(new SimpleGrantedAuthority(roleName));
            return permissions;
    }

}
