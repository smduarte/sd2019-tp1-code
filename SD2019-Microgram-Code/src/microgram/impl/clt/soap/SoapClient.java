package microgram.impl.clt.soap;


import static microgram.api.java.Result.error;
import static microgram.api.java.Result.ok;

import java.net.URI;

import microgram.api.java.Result;
import microgram.api.java.Result.ErrorCode;
import microgram.api.soap.MicrogramException;

abstract class SoapClient {

	protected final URI uri;
	
	public SoapClient(URI uri) {
		this.uri = uri;
	}
	
	@Override
	public String toString() {
		return uri.toString();
	}

	static interface MicrogramResultSupplier<T> {
		T get() throws MicrogramException;
	}
	
	static interface MicroagramVoidSupplier {
		void run() throws MicrogramException;
	}
	
	protected <T> Result<T> tryCatchResult( MicrogramResultSupplier<T> sup ) {
		try {
			T result = sup.get();
			return ok( result );
		} catch( MicrogramException e ) {
			return error(errorCode(e));
		}
	}
	
	protected <T> Result<T> tryCatchVoid( MicroagramVoidSupplier r ) {
		try {
			r.run();
			return ok();
		} catch( MicrogramException e ) {
			return error(errorCode(e));
		}
	}
	
	//Translates the MicrogramException into an ErrorCode
	static private ErrorCode errorCode(MicrogramException me) {
		switch (me.getMessage()) {
			case "OK": return ErrorCode.OK;
			case "CONFLICT" : return ErrorCode.CONFLICT;
			case "NOT_FOUND": return ErrorCode.NOT_FOUND;
			case "INTERNAL_ERROR": return ErrorCode.INTERNAL_ERROR;
			case "NOT_IMPLEMENTED": return ErrorCode.NOT_IMPLEMENTED;
			default:
			return ErrorCode.INTERNAL_ERROR;
		}
	}
}
