package team42.parse.classes;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Member")
public class ParseMember extends ParseObject {
	
	public ParseMember() {
	}

	public ParseMember(String fbId, String name, String profilePhotoUrl) {
		put("FBID", fbId);
		put("Name", name);
		put("ProfilePhotoUrl", profilePhotoUrl);
	}

	public String getFbId() {
		return getString("FBID");

	}

	public String getName() {
		return getString("Name");
	}

	public String getProfilePhotoUrl() {
		return getString("ProfilePhotoUrl");
	}

}
