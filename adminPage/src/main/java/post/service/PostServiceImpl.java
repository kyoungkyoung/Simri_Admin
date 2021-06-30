package post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import post.bean.PostDTO;
import post.bean.PostPaging;
import post.dao.PostDAO;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostDAO postDAO;
	@Autowired
	private PostPaging postPaging;

	@Override
	public void postWrite(PostDTO postDTO) {
		postDAO.postWrite(postDTO);
	}

	@Override
	public List<PostDTO> getSimriPostList(String pg, String comCategory) {
		//페이징 처리 ; 1페이지당
		int endNum = Integer.parseInt(pg)*5;
		int startNum = endNum-4;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum",startNum);
		map.put("endNum",endNum);
		map.put("comCategory", comCategory);
		map.put("pg", Integer.parseInt(pg));
		
		List<PostDTO> list = postDAO.getSimriPostList(map);
		
		return list;
	}

	@Override
	public PostPaging postPaging(String pg, String comCategory) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pg", Integer.parseInt(pg));
		map.put("comCategory", comCategory);
		
		int totalA = postDAO.getTotalA(map);
		
		postPaging.setCurrentPage(Integer.parseInt(pg));
		postPaging.setPageBlock(3);
		postPaging.setPageSize(5);
		postPaging.setTotalA(totalA);
		postPaging.makePagingHTML();
		System.out.println(postPaging);
		
		return postPaging;
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
		System.out.println(postPaging);
		
		return postPaging;
	}

}
