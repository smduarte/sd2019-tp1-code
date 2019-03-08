package microgram.impl.srv.java;

import static microgram.api.java.Result.error;
import static microgram.api.java.Result.ok;
import static microgram.api.java.Result.ErrorCode.INTERNAL_ERROR;
import static microgram.api.java.Result.ErrorCode.NOT_FOUND;

import java.io.File;
import java.nio.file.Files;

import microgram.api.java.Media;
import microgram.api.java.Result;
import utils.Base58;
import utils.MD5;

public class JavaMedia implements Media {

	private static final String MEDIA_EXTENSION = ".jpg";
	private static final String ROOT_DIR = "/tmp/microgram/";
	
	final String baseUri;
	
	public JavaMedia(String baseUri ) {
		this.baseUri = baseUri;
		new File( ROOT_DIR ).mkdirs();
	}
	
	@Override
	public Result<String> upload(byte[] bytes) {
		try {
			String id = Base58.encode(MD5.digest(bytes));
			File filename = new File(ROOT_DIR + id + MEDIA_EXTENSION);
			Files.write(filename.toPath(), bytes);
			return ok(baseUri + "/" + id);
		} catch( Exception x  ) { 
			x.printStackTrace();
			return error(INTERNAL_ERROR);
		}
	}

	@Override
	public Result<byte[]> download(String id) {
		try {
			File filename = new File(ROOT_DIR + id + MEDIA_EXTENSION);
			if( filename.exists())
				return ok(Files.readAllBytes( filename.toPath() ));
			else
				return error(NOT_FOUND);
		} catch( Exception x ) {
			x.printStackTrace();
			return error(INTERNAL_ERROR);
		}
 	}
}
