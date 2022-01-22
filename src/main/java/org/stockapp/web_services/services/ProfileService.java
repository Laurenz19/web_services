package org.stockapp.web_services.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.stockapp.web_services.database.Database;
import org.stockapp.web_services.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = Database.getProfiles();
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String username) {
		return profiles.get(username);
	}
	
	public Profile addProfile(Profile profile) {
		
		profile.setId((long) (profiles.size() + 1));
		profile.setCreated(new Date());
		profiles.put(profile.getUsername(), profile);
		return profiles.get(profile.getUsername());
		
	}
	
	public Profile updateProfile(Profile profile, String username) {
		
		Profile old_profile = profiles.get(username);
		profile.setId(old_profile.getId());
		profile.setCreated(old_profile.getCreated());
		
		if(username.isEmpty()) {
			return null;
		}else if(username != profile.getUsername()) {

			profiles.remove(username);
			profiles.put(profile.getUsername(), profile);
		}
		
	
		profiles.replace(username, profile);
		return  profiles.get(profile.getUsername());
	}
	
	public List<Profile> removeProfile(String username){
		if(username.isEmpty()) {
			return null;
		}
		
		profiles.remove(username);
		return new ArrayList<Profile>(profiles.values());
	}
	
	public void generateProfile() {
		profiles.put("laurenz19", new Profile(1L, "laurenz19", "Sambany", "Michel Laurenzio"));
	}
	
	
}
