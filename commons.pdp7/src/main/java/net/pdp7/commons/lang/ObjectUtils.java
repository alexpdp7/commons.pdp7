package net.pdp7.commons.lang;

public class ObjectUtils {
	
	protected ObjectUtils() {}
	
	@SuppressWarnings("unchecked")
	public static <T> T uncheckedCast(Object object) {
		return (T) object;
	}

}
