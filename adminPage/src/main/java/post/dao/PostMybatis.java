package post.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import post.bean.PostDTO;

@Repository
@Transactional
public class PostMybatis implements PostDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void postWrite(PostDTO postDTO) {
		sqlSession.insert("postSQL.postWrite", postDTO);
	}

	@Override
	public List<PostDTO> getSimriPostList(Map<String, Object> map) {
		if(map.get("DHL").equals("조회수")) {
			List<PostDTO> list = sqlSession.selectList("postSQL.DHitLList", map);
			return list;
		}else if(map.get("DHL").equals("좋아요")) {
			
			List<PostDTO> list = sqlSession.selectList("postSQL.DHLikeList", map);
			return list;
		}else{
			List<PostDTO> list = sqlSession.selectList("postSQL.getSimriPostList", map);
			return list;
		}
		
	}

	@Override
	public int getTotalA(Map<String, Object> map) {
		int totalA = sqlSession.selectOne("postSQL.getTotalA", map);
		return totalA;
	}

	@Override
	public int getSearchTotalA(Map<String, Object> map) {
		int totalA = sqlSession.selectOne("postSQL.getSearchTotalA", map);
		return totalA;
	}

	@Override
	public List<PostDTO> postSearch(Map<String, Object> map) {
		return sqlSession.selectList("postSQL.postSearch", map);
	}

	@Override
	public void postDelete(String seq) {
		String newSeq1 = seq.replace("{\"seq\":\"", "");
		String newSeq2 = newSeq1.replace("\"}","");
		String newSeq3 = newSeq2.replace("[","");
		String newSeq4 = newSeq3.replace("]","");
		
		String[] arraySeq = newSeq4.split(",");
		
		for(int i=0; i<arraySeq.length; i++) {
			sqlSession.delete("postSQL.postDelete", Integer.parseInt(arraySeq[i]));
		}
		
	}

	@Override
	public void viewModify(PostDTO postDTO) {
		if(postDTO.getImage() == null) {
			postDTO.setImage("null.jpg");
		}
		
		sqlSession.update("postSQL.viewModify", postDTO);
		
	}

	@Override
	public PostDTO getPostView(String seq) {
		PostDTO postDTO = sqlSession.selectOne("postSQL.getPostView", Integer.parseInt(seq));
		return postDTO;
	}

	@Override
	public void loveWrite(PostDTO postDTO) {
		
		if(postDTO.getImage().equals("null.jpg")) {
			int num = (int)(Math.random()*(7-1))+1;
			String nullImage = "null"+ Integer.toString(num)+".jpg";
			postDTO.setImage(nullImage);
		}
		
		sqlSession.insert("postSQL.loveWrite", postDTO);
		
	}

	@Override
	public List<PostDTO> getLovePostList(Map<String, Object> map) {
		if(map.get("DHL").equals("조회수")) {
			List<PostDTO> list = sqlSession.selectList("postSQL.DHitLList", map);
			return list;
		}else if(map.get("DHL").equals("좋아요")) {
			
			List<PostDTO> list = sqlSession.selectList("postSQL.DHLikeList", map);
			return list;
		}else{
			List<PostDTO> list = sqlSession.selectList("postSQL.getSimriPostList", map);
			return list;
		}
	}

	@Override
	public PostDTO getLoveView(int seq) {
		PostDTO postDTO = sqlSession.selectOne("postSQL.getLoveView", seq);
		return postDTO;
	}

	
}
