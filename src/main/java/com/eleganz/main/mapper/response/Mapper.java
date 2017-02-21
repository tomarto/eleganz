package com.eleganz.main.mapper.response;

/**
 * <p>
 * Mapper interface.  Mapper used to convert from {@link T} to {@link Y}.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public interface Mapper<T, Y> {

	/**
	 * <p>
	 * Converts from {@link T} to {@link Y}.
	 * </p>
	 * 
	 * @param from
	 *            {@link T}
	 * @return a {@link Y} object.
	 */
	Y convert(T from);
}
