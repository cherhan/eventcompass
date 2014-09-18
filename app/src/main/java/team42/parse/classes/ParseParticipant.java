package team42.parse.classes;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Participant")
public class ParseParticipant extends ParseObject {

	public ParseParticipant() {
	}

	public ParseParticipant(String eventId, String fbId) {
		put("EventID", eventId);
		put("FBID", fbId);
	}

	public String getEventId() {
		return getString("EventID");
	}

	public String getFbId() {
		return getString("FBID");

	}

}
