package com.rest.application.repository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.liking.test.mode.DisLike;
@Repository
public class DislikeRepositoryImpl implements DislikeRepository {
	
	

	@Override
	public List<DisLike> processDislike() {
		DisLike dislike= new DisLike(10);
		List<DisLike>dislikes= new ArrayList<>();
		dislikes.add(dislike);
		return dislikes;
	}

}
