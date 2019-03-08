package microgram.impl.clt.rest;

import java.net.URI;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import microgram.api.Post;
import microgram.api.java.Posts;
import microgram.api.java.Result;
import microgram.api.rest.RestPosts;

//TODO Make this class concrete
public abstract class _TODO_RestPostsClient extends RestClient implements Posts {

	public _TODO_RestPostsClient(URI serverUri) {
		super(serverUri, RestPosts.PATH);
	}

	
	public Result<String> createPost(Post post) {
		Response r = target
				.request()
				.post( Entity.entity( post, MediaType.APPLICATION_JSON));
		
		return super.responseContents(r, Status.OK, new GenericType<String>(){});	
	}
}
