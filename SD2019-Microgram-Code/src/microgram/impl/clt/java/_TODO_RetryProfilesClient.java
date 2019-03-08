package microgram.impl.clt.java;

import microgram.api.Profile;
import microgram.api.java.Profiles;
import microgram.api.java.Result;

public abstract class _TODO_RetryProfilesClient extends RetryClient implements Profiles {

	final Profiles impl;

	public _TODO_RetryProfilesClient( Profiles impl ) {
		this.impl = impl;	
	}
	
	@Override
	public Result<Profile> getProfile(String userId) {
		return reTry( () -> impl.getProfile(userId));
	}
}
