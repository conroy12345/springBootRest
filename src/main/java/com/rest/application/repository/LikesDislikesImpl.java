
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.liking.test.mode.DisLike;
import com.liking.test.mode.Likes;
import com.liking.test.mode.LikesDislikesModel;
@Repository
public class LikesDislikesImpl implements LikesDislikes {

	@Override
	public List<LikesDislikesModel> processLikesDislike() {	
		List<LikesDislikesModel>likeDislike= new ArrayList<>();
		LikesDislikesModel likeDislikeModel= new LikesDislikesModel(new Likes(200),new DisLike(10));
		likeDislike.add(likeDislikeModel);
		return likeDislike;
	}

}
