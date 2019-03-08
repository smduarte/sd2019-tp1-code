package microgram.impl.srv.rest;

import java.net.URI;

import microgram.api.Post;
import microgram.api.java.Posts;
import microgram.api.rest.RestPosts;
import microgram.impl.srv.java.JavaPosts;

// Make this class concrete.
public abstract class _TODO_RestPostsResources extends RestResource implements RestPosts {

	final Posts impl;
		
	public _TODO_RestPostsResources(URI serverUri) {
		this.impl = new JavaPosts();
	}
	
	@Override
	public Post getPost(String postId) {
		return super.resultOrThrow(impl.getPost(postId));
	}
 
}
