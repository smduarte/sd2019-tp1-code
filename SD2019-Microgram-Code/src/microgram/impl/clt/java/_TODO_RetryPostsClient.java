package microgram.impl.clt.java;

import microgram.api.Post;
import microgram.api.java.Posts;
import microgram.api.java.Result;

public abstract class _TODO_RetryPostsClient extends RetryClient implements Posts {

	final Posts impl;
	
	public _TODO_RetryPostsClient( Posts impl ) {
		this.impl = impl;
	}

	@Override
	public Result<Post> getPost(String postId) {
		return reTry( () -> impl.getPost(postId));
	}

}
