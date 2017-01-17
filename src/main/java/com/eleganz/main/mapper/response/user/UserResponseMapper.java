package com.eleganz.main.mapper.response.user;

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

		final UserDetailResponse userDetail = new UserDetailResponse();
		userDetail.setType(from.getUserDetail().getType());
		result.setUserDetail(userDetail);

		final PersonResponse bride = new PersonResponse();
		bride.setFirstName(from.getUserDetail().getBride().getFirstName());
		bride.setLastName(from.getUserDetail().getBride().getLastName());
		userDetail.setBride(bride);

		final PersonResponse groom = new PersonResponse();
		groom.setFirstName(from.getUserDetail().getGroom().getFirstName());
		groom.setLastName(from.getUserDetail().getGroom().getLastName());
		userDetail.setGroom(groom);

		final EventResponse churchEvent = new EventResponse();
		churchEvent.setDate(from.getUserDetail().getChurchEvent().getDate());
		churchEvent.setTime(from.getUserDetail().getChurchEvent().getTime());
		userDetail.setChurchEvent(churchEvent);

		final LocationResponse churchLocation = new LocationResponse();
		churchLocation.setName(from.getUserDetail().getChurchEvent().getLocation().getName());
		churchLocation.setAddress(from.getUserDetail().getChurchEvent().getLocation().getAddress());
		churchLocation.setCity(from.getUserDetail().getChurchEvent().getLocation().getCity());
		churchLocation.setState(from.getUserDetail().getChurchEvent().getLocation().getState());
		churchLocation.setCountry(from.getUserDetail().getChurchEvent().getLocation().getCountry());
		churchLocation.setPostalCode(from.getUserDetail().getChurchEvent().getLocation().getPostalCode());
		churchLocation.setType(from.getUserDetail().getChurchEvent().getLocation().getType());
		churchEvent.setLocation(churchLocation);

		final EventResponse weddingEvent = new EventResponse();
		weddingEvent.setDate(from.getUserDetail().getWeddingEvent().getDate());
		weddingEvent.setTime(from.getUserDetail().getWeddingEvent().getTime());
		userDetail.setWeddingEvent(weddingEvent);

		final LocationResponse weddingLocation = new LocationResponse();
		weddingLocation.setName(from.getUserDetail().getWeddingEvent().getLocation().getName());
		weddingLocation.setAddress(from.getUserDetail().getWeddingEvent().getLocation().getAddress());
		weddingLocation.setCity(from.getUserDetail().getWeddingEvent().getLocation().getCity());
		weddingLocation.setState(from.getUserDetail().getWeddingEvent().getLocation().getState());
		weddingLocation.setCountry(from.getUserDetail().getWeddingEvent().getLocation().getCountry());
		weddingLocation.setPostalCode(from.getUserDetail().getWeddingEvent().getLocation().getPostalCode());
		weddingLocation.setType(from.getUserDetail().getWeddingEvent().getLocation().getType());
		weddingEvent.setLocation(weddingLocation);

		return result;
	}
}
