package microgram.impl.srv.rest;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import discovery.Discovery;
import utils.IP;


public class ProfilesRestServer {
	private static Logger Log = Logger.getLogger(ProfilesRestServer.class.getName());

	static {
		System.setProperty("java.net.preferIPv4Stack", "true");
		System.setProperty("java.util.logging.SimpleFormatter.format", "%4$s: %5$s");
	}
	
	public static final int PORT = 7777;
	public static final String SERVICE = "Microgram-Profiles";
	public static String SERVER_BASE_URI = "http://%s:%s/rest";
	
	public static void main(String[] args) throws Exception {

		Log.setLevel( Level.FINER );

		String ip = IP.hostAddress();
		String serverURI = String.format(SERVER_BASE_URI, ip, PORT);
		
		ResourceConfig config = new ResourceConfig();

//		config.register(new _TODO_RestProfilesResources(serverURI)); TODO
		
		JdkHttpServerFactory.createHttpServer( URI.create(serverURI.replace(ip, "0.0.0.0")), config);

		Log.info(String.format("%s Server ready @ %s\n",  SERVICE, serverURI));
		
		Discovery.announce(SERVICE, serverURI);
	}
}
