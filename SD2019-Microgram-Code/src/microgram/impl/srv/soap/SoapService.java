package microgram.impl.srv.soap;

import microgram.api.java.Result;
import microgram.api.soap.MicrogramException;

public class SoapService {

	/**
	 * Given a Result<T>, either returns the value, or throws the Jersey Exception matching the error code...
	 * @param r
	 * @return
	 */
	protected <T> T resultOrThrow( Result<T> result ) throws MicrogramException {
		if( result.isOK() )
			return result.value();
		else
			throw new MicrogramException( result.error().name() );
	}

}
