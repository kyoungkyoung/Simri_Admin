package post.service;

import java.util.List;
import java.util.Map;

import post.bean.PostDTO;
import post.bean.PostPaging;

public interface PostService {

	public void postWrite(PostDTO postDTO);

	public List<PostDTO> getSimriPostList(String pg, String comCategory);

	public PostPaging postPaging(String pg, String comCategory);

	public List<PostDTO> postSearch(Map<String, Object> map);

	public PostPaging postSearchPaging(Map<String, Object> map);

}
