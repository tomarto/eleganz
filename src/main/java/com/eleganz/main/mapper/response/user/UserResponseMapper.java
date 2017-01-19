package com.eleganz.main.mapper.response.user;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.eleganz.main.mapper.response.ResponseMapper;
import com.eleganz.main.model.domain.user.User;
import com.eleganz.main.model.response.user.EventResponse;
import com.eleganz.main.model.response.user.LocationResponse;
import com.eleganz.main.model.response.user.PersonResponse;
import com.eleganz.main.model.response.user.UserDetailResponse;
import com.eleganz.main.model.response.user.UserResponse;

/**
 * <p>
 * UserResponseMapper class. Mapper used to convert from {@link com.eleganz.main.model.domain.user.User}
 * to {@link com.eleganz.main.model.response.user.UserResponse}.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Component
public class UserResponseMapper implements ResponseMapper<User, UserResponse> {

	/** {@inheritDoc} */
	@Override
	public UserResponse convert(User from) {
		if(from == null) {
			return null;
		}
		final UserResponse result = new UserResponse();
		result.setId(from.getId());
		result.setUsername(from.getUsername());
		result.setRole(from.getRole());
		result.setEmail(from.getEmail());

		if(from.getUserDetail() != null) {
			final UserDetailResponse userDetail = new UserDetailResponse();
			userDetail.setType(from.getUserDetail().getType());

			if(from.getUserDetail().getPeople() != null) {
				final Set<PersonResponse> people = from.getUserDetail().getPeople().stream().map(p -> {
					final PersonResponse person = new PersonResponse();
					person.setFirstName(p.getFirstName());
					person.setLastName(p.getLastName());
					person.setType(p.getType());

					return person;
				}).collect(Collectors.toSet());
				userDetail.setPeople(people);
			}

			if(from.getUserDetail().getEvents() != null) {
				final Set<EventResponse> events = from.getUserDetail().getEvents().stream().map(e -> {
					final EventResponse event = new EventResponse();
					event.setDate(e.getDate());
					event.setTime(e.getTime());
					event.setType(e.getType());
					LocationResponse location = new LocationResponse();
					location.setName(e.getLocation().getName());
					location.setAddress(e.getLocation().getAddress());
					location.setCity(e.getLocation().getCity());
					location.setState(e.getLocation().getState());
					location.setCountry(e.getLocation().getCountry());
					location.setPostalCode(e.getLocation().getPostalCode());
					location.setType(e.getLocation().getType());
					event.setLocation(location);

					return event;
				}).collect(Collectors.toSet());
				userDetail.setEvents(events);
			}

			result.setUserDetail(userDetail);
		}

		return result;
	}
}
