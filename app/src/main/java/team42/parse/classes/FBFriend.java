package team42.parse.classes;

import com.parse.ParseObject;

public class FBFriend extends ParseObject {

	private String id;
	private String name;
	private boolean isBestFriend;
	private boolean isBestFriendToggled = false;

	public FBFriend() {

	}

	public FBFriend(String id, String name) {
		this.id = id;
		this.name = name;
		this.isBestFriend = false;
	}

	public String getId() {
		return this.getString("userid");
	}

	public String getName() {
		return this.getString("name");
	}

	public String getProfilePicUrl() {
		return "https://graph.facebook.com/" + this.getId() + "/picture";
	}

	public boolean getIsBestFriend() {
		if (isBestFriendToggled) {
			return !(this.getBoolean("bestfriend"));
		} else {
			return this.getBoolean("bestfriend");
		}
	}

	public void toggleIsBestFriend() {
		isBestFriendToggled = !isBestFriendToggled;
	}

}
