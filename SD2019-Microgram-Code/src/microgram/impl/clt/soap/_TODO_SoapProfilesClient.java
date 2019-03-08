package microgram.impl.clt.soap;

import java.net.URI;

import microgram.api.Profile;
import microgram.api.java.Profiles;
import microgram.api.java.Result;

//TODO Make this class concrete
public abstract class _TODO_SoapProfilesClient extends SoapClient implements Profiles {


	public _TODO_SoapProfilesClient(URI serverUri) {
		super(serverUri);
	}

	@Override
	public Result<Profile> getProfile(String userId) {
		return null;
	}

}
