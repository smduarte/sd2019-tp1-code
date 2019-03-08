package microgram.impl.srv.soap;

import java.util.logging.Logger;


public class PostsSoapServer {
	private static Logger Log = Logger.getLogger(PostsSoapServer.class.getName());

	static {
		System.setProperty("java.net.preferIPv4Stack", "true");
		System.setProperty("java.util.logging.SimpleFormatter.format", "%4$s: %5$s");
	}
	
	public static final int PORT = 7777;
	public static final String SERVICE = "Microgram-Posts";
	public static String SERVER_BASE_URI = "http://%s:%s/soap";
	
	public static void main(String[] args) throws Exception {


	}
}
