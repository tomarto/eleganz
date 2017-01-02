package com.eleganz.main.repository.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eleganz.main.model.domain.user.User;

/**
 * <p>
 * UserRepository interface. JPARepository used to interact with database queries.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * <p>
	 * Retrieves a single {@link com.eleganz.main.model.domain.user.User} from its username.
	 * </p>
	 * 
	 * @param username
	 *            {@link java.lang.String}
	 * @return a {@link java.util.Optional<User>} object.
	 */
	Optional<User> findOneByUsername(String username);
}
