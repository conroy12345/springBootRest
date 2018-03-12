package com.rest.application.controller;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.liking.test.mode.DisLike;
import com.liking.test.mode.Likes;
import com.liking.test.mode.LikesDislikesModel;
import com.liking.test.repository.DislikeRepository;
import com.liking.test.repository.LikeRepository;
import com.liking.test.repository.LikesDislikes;

@RestController
@RequestMapping("/product")
public class ProductResource {
	//announcements/{announcementId}/like.
	
	@Autowired
	LikeRepository likeRepos;
	
	@Autowired
	DislikeRepository dislikeRepos;
	//announcements/{id}/like
	@Autowired
	LikesDislikes likesDislikes;
	@RequestMapping(value="likes",method=RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<Likes>> getAllLikeslikes(){
		
		List<Likes> likes=likeRepos.retrieveLikes();		
		
		return new ResponseEntity<List<Likes>>(likes,HttpStatus.OK);
	}
	
	@RequestMapping(value="dislikes",method=RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<DisLike>> getAllLikesDislikes(){
		
		List<DisLike> dislikes=dislikeRepos.processDislike();		
		
		return new ResponseEntity<List<DisLike>>(dislikes,HttpStatus.OK);
	}

	@RequestMapping(value="announcements/{announcementId}/like",method=RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<LikesDislikesModel>> getAllLikesDislikesandLikes(){
		
		List<LikesDislikesModel> obj=likesDislikes.processLikesDislike();
		
		
		return new ResponseEntity<List<LikesDislikesModel>>(obj,HttpStatus.OK);
	}
 
}
