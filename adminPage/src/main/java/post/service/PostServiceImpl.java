package post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import post.bean.PostDTO;
import post.bean.PostPaging;
import post.bean.PostPaging2;
import post.dao.PostDAO;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostDAO postDAO;
	@Autowired
	private PostPaging postPaging;
	@Autowired
	private PostPaging2 postPaging2;
	

	@Override
	public void postWrite(PostDTO postDTO) {
		postDAO.postWrite(postDTO);
	}

	@Override
	public List<PostDTO> getSimriPostList(String pg, String comCategory, String DHL) {
		//페이징 처리 ; 1페이지당
		int endNum = Integer.parseInt(pg)*5;
		int startNum = endNum-4;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum",startNum);
		map.put("endNum",endNum);
		map.put("comCategory", comCategory);
		map.put("pg", Integer.parseInt(pg));
		map.put("DHL", DHL);
		
		List<PostDTO> list = postDAO.getSimriPostList(map);
		
		return list;
	}

	@Override
	public PostPaging2 postPaging2(String pg, String comCategory, String DHL) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pg", Integer.parseInt(pg));
		map.put("comCategory", comCategory);
		map.put("DHL", DHL);
		
		
		
		int totalA = postDAO.getTotalA(map);
		
		postPaging2.setCurrentPage(Integer.parseInt(pg));
		postPaging2.setPageBlock(3);
		postPaging2.setPageSize(5);
		postPaging2.setTotalA(totalA);
		postPaging2.makePagingHTML(DHL);
		
		return postPaging2;
	}

	@Override
	public List<PostDTO> postSearch(Map<String, Object> map) {
		//페이징 처리 ; 1페이지당
		int endNum = (Integer) map.get("pg")*5;
		int startNum = endNum-4;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		
		return postDAO.postSearch(map);
	}

	@Override
	public PostPaging postSearchPaging(Map<String, Object> map) {
		int totalA = postDAO.getSearchTotalA(map);
		
		postPaging.setCurrentPage((Integer) map.get("pg"));
		postPaging.setPageBlock(3);
		postPaging.setPageSize(5);
		postPaging.setTotalA(totalA);
		postPaging.makePagingHTML();
		
		return postPaging;
	}

	@Override
	public void postDelete(String seq) {
		postDAO.postDelete(seq);
	}

	@Override
	public void viewModify(PostDTO postDTO) {
		postDAO.viewModify(postDTO);
	}

	@Override
	public PostDTO getPostView(String seq) {
		PostDTO postDTO = postDAO.getPostView(seq);
		return postDTO;
	}

	@Override
	public void loveWrite(PostDTO postDTO) {
		postDAO.loveWrite(postDTO);
		
	}

	@Override
	public List<PostDTO> getLovePostList(String pg, String comCategory, String DHL) {
		//페이징 처리 ; 1페이지당
		int endNum = Integer.parseInt(pg)*5;
		int startNum = endNum-4;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum",startNum);
		map.put("endNum",endNum);
		map.put("comCategory", comCategory);
		map.put("pg", Integer.parseInt(pg));
		map.put("DHL", DHL);
		
		List<PostDTO> list = postDAO.getLovePostList(map);
		
		return list;
	}

	@Override
	public PostDTO getLoveView(String seq) {
		
		PostDTO postDTO = postDAO.getLoveView(Integer.parseInt(seq));
		return postDTO;
	}

	






}
