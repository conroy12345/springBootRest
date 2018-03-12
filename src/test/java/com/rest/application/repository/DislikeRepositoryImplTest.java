package com.rest.application.repository;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rest.application.model.DisLike;
import com.rest.application.model.Likes;

public class DislikeRepositoryImplTest {

	@Test
	public void testDislike() {
		DisLike dislike= new DisLike();
		DislikeRepositoryImpl p= new DislikeRepositoryImpl();
		dislike.setDislike(10);
		assertEquals(dislike.getDislike(),p.processDislike().size()+9);
	}
	
	@Test
	public void testLike() {		
		Likes like= new Likes(200);
		LikeRepository p= new LikesRepositoryImpl();
		p.retrieveLikes();
		assertEquals(like.getLikes(),p.retrieveLikes().size()+199);
	}

}
