package microgram.impl.clt.soap;

import java.net.URI;

import microgram.api.Post;
import microgram.api.java.Posts;
import microgram.api.java.Result;
import microgram.api.soap.SoapPosts;

//TODO Make this class concrete
public abstract class _TODO_SoapPostsClient extends SoapClient implements Posts {

	SoapPosts impl;
	
	public _TODO_SoapPostsClient(URI serverUri) {
		super(serverUri);
	}

	@Override
	public Result<Post> getPost(String postId) {
		return super.tryCatchResult(() -> impl().getPost(postId));
	}
	
	
	private SoapPosts impl() {
		if( impl == null ) {
			//TODO
		}
		return impl;
	}
}
