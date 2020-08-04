package az.iba.userdetails.db.service;

import az.iba.userdetails.db.entity.UserDetails;

import java.util.List;
import java.util.Optional;

public interface DBService {
    Optional<UserDetails> getById(long id);
    Optional<UserDetails> getByUserNameAndPassword(String userName);
}
