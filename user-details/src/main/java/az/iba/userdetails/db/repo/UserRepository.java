package az.iba.userdetails.db.repo;

import az.iba.userdetails.db.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {
    Optional<UserDetails> findByIdUser(long idUser);

    Optional<UserDetails> findByUsername(String userName);
}
