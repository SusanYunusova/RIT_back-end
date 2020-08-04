package az.iba.userdetails.db.service.impl;

import az.iba.userdetails.db.entity.UserDetails;
import az.iba.userdetails.db.repo.UserRepository;
import az.iba.userdetails.db.service.DBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service(value = "DBService")
@Slf4j
public class DBServiceImpl implements DBService {
    private final UserRepository userRepository;

    public DBServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserDetails> getById(long id) {
        try {
            log.info("trying to get user by id from db");
            return userRepository.findByIdUser(id);
        } catch (Exception e) {
            log.error("error getting by id from Db{}", e, e);
            return Optional.empty();
        }
    }



    @Override
    public Optional<UserDetails> getByUserNameAndPassword(String userName) {
        try {
            log.info("trying to get user by username and password from db");
            return userRepository.findByUsername(userName);
        } catch (Exception e) {
            log.error("error getting by user by username and password from db{}", e, e);
            return Optional.empty();
        }
    }
}
