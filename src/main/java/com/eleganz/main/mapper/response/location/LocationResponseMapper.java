package com.eleganz.main.mapper.response.location;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.eleganz.main.mapper.response.ResponseMapper;
import com.eleganz.main.model.domain.user.Location;
import com.eleganz.main.model.response.user.EventResponse;
import com.eleganz.main.model.response.user.LocationResponse;
import com.eleganz.main.model.response.user.PersonResponse;
import com.eleganz.main.model.response.user.UserDetailResponse;
import com.eleganz.main.model.response.user.UserResponse;

/**
 * <p>
 * LocationResponseMapper class. Mapper used to convert from {@link com.eleganz.main.model.domain.location.Location}
 * to {@link com.eleganz.main.model.response.location.LocationResponse}.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Component
public class LocationResponseMapper implements ResponseMapper<Location, LocationResponse> {

	/** {@inheritDoc} */
	@Override
	public LocationResponse convert(Location from) {
		if(from == null) {
			return null;
		}
		final LocationResponse result = new LocationResponse();
		result.setId(from.getId());
		result.setName(from.getName());
		result.setAddress(from.getAddress());
		result.setCity(from.getCity());
		result.setState(from.getState());
		result.setCountry(from.getCountry());
		result.setPostalCode(from.getPostalCode());
		result.setType(from.getType());

		if(from.getEvents() != null) {
			final Set<EventResponse> events = from.getEvents().stream().map(e -> {
				final EventResponse event = new EventResponse();
				event.setDate(e.getDate());
				event.setTime(e.getTime());
				event.setType(e.getType());

				if(e.getUserDetail() != null) {
					final UserDetailResponse userDetail = new UserDetailResponse();
					userDetail.setType(e.getUserDetail().getType());

					if(e.getUserDetail().getPeople() != null) {
						final Set<PersonResponse> people = e.getUserDetail().getPeople().stream().map(p -> {
							final PersonResponse person = new PersonResponse();
							person.setFirstName(p.getFirstName());
							person.setLastName(p.getLastName());
							person.setType(p.getType());

							return person;
						}).collect(Collectors.toSet());
						userDetail.setPeople(people);
					}

					if(e.getUserDetail().getUser() != null) {
						final UserResponse user = new UserResponse();
						user.setId(e.getUserDetail().getUser().getId());
						user.setUsername(e.getUserDetail().getUser().getUsername());
						user.setEmail(e.getUserDetail().getUser().getEmail());
						user.setRole(e.getUserDetail().getUser().getRole());
						userDetail.setUser(user);
					}

					event.setUserDetail(userDetail);
				}

				return event;
			}).collect(Collectors.toSet());
			result.setEvents(events);
		}

		return result;
	}
}
