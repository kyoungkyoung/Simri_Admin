package post.service;

import java.util.List;
import java.util.Map;

import post.bean.PostDTO;
import post.bean.PostPaging;
import post.bean.PostPaging2;

public interface PostService {

	public void postWrite(PostDTO postDTO);

	public List<PostDTO> getSimriPostList(String pg, String comCategory,String DHL);

	public PostPaging2 postPaging2(String pg, String comCategory, String DHL);

	public List<PostDTO> postSearch(Map<String, Object> map);

	public PostPaging postSearchPaging(Map<String, Object> map);

	public void postDelete(String seq);

	public void viewModify(PostDTO postDTO);

	public PostDTO getPostView(String seq);

	public void loveWrite(PostDTO postDTO);

	public List<PostDTO> getLovePostList(String pg, String comCategory, String DHL);

	public PostDTO getLoveView(String seq);




}
