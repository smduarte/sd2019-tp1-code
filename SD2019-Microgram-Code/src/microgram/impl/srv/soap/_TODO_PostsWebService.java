package microgram.impl.srv.soap;

import microgram.api.Post;
import microgram.api.java.Posts;
import microgram.api.soap.MicrogramException;
import microgram.api.soap.SoapPosts;
import microgram.impl.srv.java.JavaPosts;

//Make this class concrete.
public abstract class _TODO_PostsWebService extends SoapService implements SoapPosts {

	final Posts impl;
	
	protected _TODO_PostsWebService() {
		this.impl = new JavaPosts();
	}

	@Override
	public Post getPost( String postId ) throws MicrogramException {
		return super.resultOrThrow( impl.getPost(postId));
	}
	
}
