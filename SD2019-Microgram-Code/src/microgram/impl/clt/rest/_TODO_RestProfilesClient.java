package microgram.impl.clt.rest;

import java.net.URI;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import microgram.api.Profile;
import microgram.api.java.Profiles;
import microgram.api.java.Result;
import microgram.api.rest.RestProfiles;

//TODO Make this class concrete
public abstract class _TODO_RestProfilesClient extends RestClient implements Profiles {

	public _TODO_RestProfilesClient(URI serverUri) {
		super(serverUri, RestProfiles.PATH);
	}

	@Override
	public Result<Profile> getProfile(String userId) {
		Response r = target.path(userId)
				.request()
				.accept(MediaType.APPLICATION_JSON)
				.get();
		
		return super.responseContents(r, Status.OK, new GenericType<Profile>() {});
	}
	
	
}
