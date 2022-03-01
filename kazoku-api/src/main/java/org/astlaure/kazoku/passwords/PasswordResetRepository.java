package org.astlaure.kazoku.passwords;

import org.astlaure.kazoku.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PasswordResetRepository extends JpaRepository<PasswordResetToken, Long> {
    Optional<PasswordResetToken> findByUser(User user);
    Optional<PasswordResetToken> findByTokenAndExpirationAfter(String token, LocalDateTime time);
}
