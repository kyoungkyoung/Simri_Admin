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
		List<PostDTO> list = sqlSession.selectList("postSQL.getSimriPostList", map);
		System.out.println(list);
		return list;
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

	
}
