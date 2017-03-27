package com.eleganz.main.mapper.request.user;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.eleganz.main.mapper.response.Mapper;
import com.eleganz.main.model.domain.user.Event;
import com.eleganz.main.model.domain.user.Location;
import com.eleganz.main.model.domain.user.Person;
import com.eleganz.main.model.domain.user.User;
import com.eleganz.main.model.domain.user.UserDetail;
import com.eleganz.main.model.request.user.UserCreateRequest;

/**
 * <p>
 * UserRequestMapper class. Mapper used to convert from {@link com.eleganz.main.model.request.user.UserCreateRequest}
 * to {@link com.eleganz.main.model.domain.user.User}.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Component
public class UserRequestMapper implements Mapper<UserCreateRequest, User> {

	/** {@inheritDoc} */
	@Override
	public User convert(UserCreateRequest from) {
		final User user = new User();
		user.setUsername(from.getUsername());
		user.setRole(from.getRoleEnum());
		user.setEmail(from.getEmail());

		final UserDetail userDetail = new UserDetail();
		userDetail.setType(from.getDetail().getType());
		
		final StringBuilder username = new StringBuilder();
		final StringBuilder password = new StringBuilder();
		if(from.getDetail().getPeople() != null && !from.getDetail().getPeople().isEmpty()) {
			final Set<Person> people = from.getDetail().getPeople().stream().map(p -> {
				final Person person = new Person();
				person.setFirstName(p.getFirstName());
				person.setLastName(p.getLastName());
				person.setType(p.getType());
				username.append(p.getFirstName().toLowerCase() + "-");
				password.append(p.getFirstName().substring(0, 3).toLowerCase());
				person.setUserDetail(userDetail);

				return person;
			}).collect(Collectors.toSet());
			userDetail.setPeople(people);
		}

		if(password.length() == 0) {
			password.append("SinPassword");
		}

		user.setUsername(username.substring(0, username.length() - 1));
		user.setPasswordHash(new BCryptPasswordEncoder().encode(password.toString()));

		if(from.getDetail().getEvents() != null && !from.getDetail().getEvents().isEmpty()) {
			final Set<Event> events = from.getDetail().getEvents().stream().map(e -> {
				final Event event = new Event();
				event.setType(e.getType());
				event.setDate(e.getDate());
				final Location location = new Location();
				location.setId(e.getId());
				event.setLocation(location);
				event.setUserDetail(userDetail);

				return event;
			}).collect(Collectors.toSet());
			userDetail.setEvents(events);
		}

		user.setUserDetail(userDetail);

		return user;
	}
}
