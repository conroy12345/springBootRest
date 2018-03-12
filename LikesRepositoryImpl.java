package com.liking.test.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.liking.test.mode.DisLike;
import com.liking.test.mode.Likes;
@Repository
public class LikesRepositoryImpl implements LikeRepository {


	@Override
	public List<Likes> retrieveLikes() {
		Likes like=new Likes(200);
		List<Likes> likes=new ArrayList<>();
		likes.add(like);
		return likes;
	}

}
