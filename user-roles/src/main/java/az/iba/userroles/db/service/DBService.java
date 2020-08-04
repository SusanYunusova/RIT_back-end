package az.iba.userroles.db.service;

import java.util.List;

public interface DBService<A> {
    List<A> getAllByRoleName(String roleName);

}
