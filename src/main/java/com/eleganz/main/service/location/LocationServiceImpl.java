package com.eleganz.main.service.location;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.eleganz.main.mapper.response.Mapper;
import com.eleganz.main.model.domain.user.Location;
import com.eleganz.main.model.response.user.LocationResponse;
import com.eleganz.main.repository.location.LocationRepository;

/**
 * <p>
 * LocationServiceImpl class. LocationService implementation.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Service
public class LocationServiceImpl implements LocationService {

	private final LocationRepository locationRepository;
	private final Mapper<Location, LocationResponse> locationResponseMapper;

	/**
	 * <p>
	 * Constructor for LocationServiceImpl.
	 * </p>
	 * 
	 * @param locationRepository
	 *            a {@link com.eleganz.main.repository.location.LocationRepository} object.
	 * @param locationResponseMapper
	 *            a {@link com.eleganz.main.mapper.response.Mapper<Location, LocationResponse>} object.
	 */
	@Autowired
    public LocationServiceImpl(LocationRepository locationRepository,
    		Mapper<Location, LocationResponse> locationResponseMapper) {
        this.locationRepository = locationRepository;
        this.locationResponseMapper = locationResponseMapper;
    }

	/** {@inheritDoc} */
	@Override
	public Collection<LocationResponse> getAllLocations() {
		return locationRepository.findAll(new Sort("name")).stream()
				.map(location -> locationResponseMapper.convert(location))
				.collect(Collectors.toList());
	}

	/** {@inheritDoc} */
	@Override
	public Optional<LocationResponse> getLocationById(long id) {
		return Optional.ofNullable(locationResponseMapper.convert(locationRepository.findOne(id)));
	}
}
