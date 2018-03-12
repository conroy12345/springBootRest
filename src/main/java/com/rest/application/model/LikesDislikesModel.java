package com.liking.test.mode;

public class LikesDislikesModel {
	private Likes likes;
	private DisLike dislikes;
	
	
	public LikesDislikesModel(Likes likes, DisLike dislikes) {		
		this.likes = likes;
		this.dislikes = dislikes;
	}
	
	public LikesDislikesModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Likes getLikes() {
		return likes;
	}
	public void setLikes(Likes likes) {
		this.likes = likes;
	}
	public DisLike getDislikes() {
		return dislikes;
	}
	public void setDislikes(DisLike dislikes) {
		this.dislikes = dislikes;
	}
	@Override
	public String toString() {
		return "LikesDislikes [likes=" + likes + ", dislikes=" + dislikes + "]";
	}
	
	
	
}
