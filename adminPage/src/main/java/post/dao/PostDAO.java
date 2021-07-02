package post.dao;

import java.util.List;
import java.util.Map;

import post.bean.PostDTO;

public interface PostDAO {

	public void postWrite(PostDTO postDTO);

	public List<PostDTO> getSimriPostList(Map<String, Object> map);

	public int getTotalA(Map<String, Object> map);

	public int getSearchTotalA(Map<String, Object> map);

	public List<PostDTO> postSearch(Map<String, Object> map);

	public void postDelete(String seq);

	public void viewModify(PostDTO postDTO);

	public PostDTO getPostView(String seq);

	public void loveWrite(PostDTO postDTO);

	public List<PostDTO> getLovePostList(Map<String, Object> map);

	public PostDTO getLoveView(int seq);


}
