package team42.parse.classes;

import android.location.Location;

import com.parse.ParseClassName;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;

@ParseClassName("Event")
public class ParseEvent extends ParseObject {

	public static final EventArea MONT_KIARA = new EventArea("Mont Kiara");
	public static final EventArea KUALA_LUMPUR = new EventArea("Kuala Lumpur");
	public static final EventArea BANGSAR = new EventArea("Bangsar");
	public static final EventArea AMPANG = new EventArea("Ampang");
	public static final EventArea SUBANG = new EventArea("Subang");
	
	public static final EventType CELEBRATION = new EventType("Celebration");
	public static final EventType SPORTS = new EventType("Sports");
	public static final EventType GATHERING = new EventType("Gathering");
	
	public ParseEvent() {		
	}
	
//	public ParseEvent(String startDate, String startTime, String endDate,
//			String endTime, EventArea eventArea, Location geoLocation, EventType eventType, String title,
//			String description, String privacy) {
//		put("StartDate", startDate);
//		put("StartTime", startTime);
//		put("EndDate", endDate);
//		put("EndTime", endTime);
//		put("Area", eventArea.getArea());
//		
//		ParseGeoPoint parseGeoPoint = new ParseGeoPoint();
//		parseGeoPoint.setLatitude(geoLocation.getLatitude());
//		parseGeoPoint.setLongitude(geoLocation.getLongitude());
//		put("GeoLocation", parseGeoPoint);
//		
//		put("Type", eventType.getType());
//		put("Title", title);
//		put("Description", description);
//		put("Privacy", privacy);
//	}
	
	public ParseEvent(String startDate, String startTime, String endDate,
			String endTime, EventArea eventArea, String address, EventType eventType, String title,
			String description, String privacy) {
		put("StartDate", startDate);
		put("StartTime", startTime);
		put("EndDate", endDate);
		put("EndTime", endTime);
		put("Area", eventArea.getArea());
		put("Address", address);
		put("Type", eventType.getType());
		put("Title", title);
		put("Description", description);
		put("Privacy", privacy);
	}


	public String getStartDate() {
		return getString("StartDate");
	}

	public String getStartTime() {
		return getString("StartTime");

	}

	public String getEndDate() {
		return getString("EndDate");
	}

	public String getEndTime() {
		return getString("EndTime");
	}
	
	public String getEventArea() {
		return getString("Area");
	}
	
	public ParseGeoPoint getGeoPoint() {
		return getParseGeoPoint("EventLocation");
	}

	public Location getGeoLocation() {
		ParseGeoPoint parseGeoPoint = new ParseGeoPoint();
		parseGeoPoint = getGeoPoint();
		Location location = new Location("dummy");
		location.setLatitude(parseGeoPoint.getLatitude());
		location.setLongitude(parseGeoPoint.getLongitude());
		return location;
	}

	public String getTitle() {
		return getString("Title");
	}

	public String getDescription() {
		return getString("Description");
	}
	
	public String getPrivacy() {
		return getString("Privacy");
	}

	public String getID() {
		return getObjectId();
	}

}


