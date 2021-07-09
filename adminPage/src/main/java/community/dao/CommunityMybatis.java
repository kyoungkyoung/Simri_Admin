package community.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import advertise.bean.AdvertiseDTO;
import community.bean.CommunityDTO;

@Repository
@Transactional
public class CommunityMybatis implements CommunityDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<CommunityDTO> getCommunity(Map<String, Object> newMap) {
		if(newMap.get("comCategory").equals("[전체 게시글]팔레트")){
			List<CommunityDTO> list = sqlSession.selectList("communitySQL.getComPalette", newMap);
			return list;
		}else {
			List<CommunityDTO> list = sqlSession.selectList("communitySQL.getCommunity",newMap);
			System.out.println(list);
			return list;
		}
	}
	
	@Override
	public List<CommunityDTO> singoList(Map<String, Object> newMap) {
		if(newMap.get("comCategory").equals("[전체 게시글]팔레트")){
			List<CommunityDTO> list = sqlSession.selectList("communitySQL.singoComPalette", newMap);
			return list;
		}else {
			List<CommunityDTO> list = sqlSession.selectList("communitySQL.singoList",newMap);
			return list;
		}
	}


	@Override
	public void communityDelete(String seq) {
		String newSeq1 = seq.replace("{\"seq\":\"", "");
		String newSeq2 = newSeq1.replace("\"}","");
		String newSeq3 = newSeq2.replace("[","");
		String newSeq4 = newSeq3.replace("]","");
		
		String[] arraySeq = newSeq4.split(",");
		
		for(int i=0; i<arraySeq.length; i++) {
			sqlSession.delete("communitySQL.communityDelete", Integer.parseInt(arraySeq[i]));
		}
	}
	
	@Override
	public int getTotalA(Map<String, String> map) {
		if(map.get("comCategory").equals("[전체 게시글]팔레트")){
			int totalA = sqlSession.selectOne("communitySQL.getTotalB", map);
			return totalA;
		}else {
			int totalA = sqlSession.selectOne("communitySQL.getTotalA", map);
			return totalA;
		}
	}
	
	@Override
	public int getSingoTotalA(Map<String, String> map) {
		if(map.get("comCategory").equals("[전체 게시글]팔레트")){
			int totalA = sqlSession.selectOne("communitySQL.getSingoTotalB", map);
			return totalA;
		}else {
			int totalA = sqlSession.selectOne("communitySQL.getSingoTotalA", map);
			return totalA;
		}
	}

	@Override
	public void noticeWrite(CommunityDTO communityDTO) {
		if(communityDTO.getImage() == null) {
			communityDTO.setImage("null.jpg");
		}
		
		sqlSession.insert("communitySQL.noticeWrite", communityDTO);
	}//공지사항 등록

	@Override
	public CommunityDTO getCommunityView(String seq) {
		CommunityDTO communityDTO = sqlSession.selectOne("communitySQL.getCommunityView", Integer.parseInt(seq));
		System.out.println(communityDTO);
		return communityDTO;
	}

	@Override
	public List<CommunityDTO> getComSearch(Map<String, Object> map) {
		return sqlSession.selectList("communitySQL.getComSearch", map);
	}

	@Override
	public int getSearchTotalA(String comSearchText) {
		int totalA = sqlSession.selectOne("communitySQL.getSearchTotalA", comSearchText);
		return totalA;
	}

	@Override
	public void viewModify(CommunityDTO communityDTO) {
		if(communityDTO.getImage() == null) {
			communityDTO.setImage("null.jpg");
		}
		
		sqlSession.update("communitySQL.viewModify", communityDTO);
	}//공지사항 수정등록









}
