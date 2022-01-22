package org.stockapp.web_services.resources;

import java.util.List;

import org.stockapp.web_services.model.Profile;
import org.stockapp.web_services.services.ProfileService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("profiles")
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	ProfileService profileService = new ProfileService();
	
	@GET
	@Path("/generate")
	public String generateProfile() {
		profileService.generateProfile();
		return "Profile generated, Check the request that get all profiles existed in the platform!";
	}
	
	@GET
	public List<Profile> getAllProfiles(){
		return profileService.getAllProfiles();
	}
	
	@GET
	@Path("/{username}")
	public Profile getProfile(@PathParam("username") String username) {
		return profileService.getProfile(username);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile profile) {
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("/{username}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Profile updateProfile(Profile profile,@PathParam("username") String username) {
		return profileService.updateProfile(profile, username);
	}
	
	@DELETE
	@Path("/{username}")
	public  List<Profile> removeProfile(@PathParam("username") String username){
		return profileService.removeProfile(username);
	}
	
}
