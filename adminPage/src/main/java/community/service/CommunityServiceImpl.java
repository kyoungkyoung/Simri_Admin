package community.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import community.bean.CommunityDTO;
import community.bean.CommunityPaging;
import community.dao.CommunityDAO;

@Service
public class CommunityServiceImpl implements CommunityService {
	@Autowired
	private CommunityDAO communityDAO;
	@Autowired
	private CommunityPaging communityPaging;
	
	
	@Override
	public List<CommunityDTO> getCommunity(Map<String, String> map) {
		//페이징 처리 ; 1페이지당
		int endNum = Integer.parseInt(map.get("pg"))*5;
		int startNum = endNum-4;
		
		Map<String, Object> newMap = new HashMap<String, Object>();
		newMap.put("startNum", startNum);
		newMap.put("endNum", endNum);
		newMap.put("comCategory", map.get("comCategory"));
		
		return communityDAO.getCommunity(newMap);
	}

	@Override
	public void communityDelete(String seq) {
		communityDAO.communityDelete(seq);
	}

	@Override
	public CommunityPaging communityPaging(Map<String, String> map) {
		int totalA = communityDAO.getTotalA(map);
		
		communityPaging.setCurrentPage(Integer.parseInt(map.get("pg")));
		communityPaging.setPageBlock(3);
		communityPaging.setPageSize(5);
		communityPaging.setTotalA(totalA);
		communityPaging.makePagingHTML(map.get("comCategory"));
		System.out.println(communityPaging);
		return communityPaging;
	}

	@Override
	public void noticeWrite(CommunityDTO communityDTO) {
		communityDAO.noticeWrite(communityDTO);
	} //공지사항 등록

	@Override
	public CommunityDTO getCommunityView(String seq, String image) {
		CommunityDTO communityDTO = communityDAO.getCommunityView(seq, image);
		
		return communityDTO;
	}

}
