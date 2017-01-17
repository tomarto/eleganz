package com.eleganz.main.repository.location;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eleganz.main.model.domain.user.Location;

/**
 * <p>
 * LocationRepository interface. JPARepository used to interact with database queries.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public interface LocationRepository extends JpaRepository<Location, Long> {

}
