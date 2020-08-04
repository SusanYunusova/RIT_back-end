package az.suzy.customerhistory.db.service;

import java.util.Optional;

public interface DBService<A>{
    Optional<A> getById(long id);
}
