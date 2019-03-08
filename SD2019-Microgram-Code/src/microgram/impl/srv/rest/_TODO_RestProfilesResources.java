package microgram.impl.srv.rest;


import java.net.URI;

import microgram.api.Profile;
import microgram.api.java.Profiles;
import microgram.api.rest.RestProfiles;
import microgram.impl.srv.java.JavaProfiles;

//Make this class concrete.
public abstract class _TODO_RestProfilesResources extends RestResource implements RestProfiles {

	final Profiles impl;
	
	public _TODO_RestProfilesResources(URI serverUri) {
		this.impl = new JavaProfiles();
	}
	
	@Override
	public Profile getProfile(String userId) {
		return super.resultOrThrow( impl.getProfile(userId));
	}	
}
