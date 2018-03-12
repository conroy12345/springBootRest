package com.liking.test.mode;

public class Likes {
private int likes;

public Likes(int likes) {
	
	this.likes = likes;
}

public int getLikes() {
	return likes;
}

public void setLikes(int likes) {
	this.likes = likes;
}




@Override
public String toString() {
	return "Likes [likes=" + likes + "]";
}


}
