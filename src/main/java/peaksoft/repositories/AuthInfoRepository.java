package peaksoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entity.AuthInfo;

import java.util.Optional;

/**
 * @author kurstan
 * @created at 13.03.2023 18:01
 */
@Repository
public interface AuthInfoRepository extends JpaRepository<AuthInfo, Long> {
    Optional<AuthInfo> findByEmail(String email);
}
