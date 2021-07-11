package member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.bean.MemberPaging;
import member.bean.MemberStopPaging;
import member.bean.MemberWarningPaging;
import member.bean.SimriMemberDTO;
import member.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private MemberPaging memberPaging;
	@Autowired
	private MemberWarningPaging memberWarningPaging;
	@Autowired
	private MemberStopPaging memberStopPaging;
	@Override
	public List<SimriMemberDTO> getMemberList(int pg) {
		//페이징 처리
		//1페이지당 10개
		int endNum = pg*10;
		int startNum = endNum-9;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		List<SimriMemberDTO> list = memberDAO.getMemberList(map);
		return list;
	}
	
	@Override
	public MemberPaging memberPaging(int pg) {
		int totalA = memberDAO.getTotalA();
		
		memberPaging.setCurrentPage(pg);//현재 페이지
		memberPaging.setPageBlock(3);
		memberPaging.setPageSize(10);
		memberPaging.setTotalA(totalA);
		memberPaging.makePagingHTML();
		
		return memberPaging;
	}

	@Override
	public SimriMemberDTO getSimriMember(String email) {
		SimriMemberDTO simriMemberDTO = memberDAO.getSimriMember(email);
		return simriMemberDTO;
	}

	@Override
	public void setPoint(String point,String email) {
		memberDAO.setPoint(point,email);
	}

	@Override
	public List<SimriMemberDTO> getMemberWarningList(int pg) {
		//페이징 처리
		//1페이지당 10개
		int endNum = pg*10;
		int startNum = endNum-9;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		List<SimriMemberDTO> list = memberDAO.getMemberWarningList(map);
		return list;
	}

	@Override
	public MemberWarningPaging warningMemberPaging(int pg) {
		int totalA = memberDAO.getWarningTotalA();
		
		memberWarningPaging.setCurrentPage(pg);//현재 페이지
		memberWarningPaging.setPageBlock(3);
		memberWarningPaging.setPageSize(10);
		memberWarningPaging.setTotalA(totalA);
		memberWarningPaging.makePagingHTML();
		
		return memberWarningPaging;
	}
	
	@Override
	public MemberStopPaging stopMemberPaging(int pg) {
		int totalA = memberDAO.getStopTotalA();
		
		memberStopPaging.setCurrentPage(pg);//현재 페이지
		memberStopPaging.setPageBlock(3);
		memberStopPaging.setPageSize(10);
		memberStopPaging.setTotalA(totalA);
		memberStopPaging.makePagingHTML();
		
		return memberStopPaging;
	}
	 
	
	@Override
	public List<SimriMemberDTO> getMemberStopList(int pg) {
		//페이징 처리
		//1페이지당 10개
		int endNum = pg*10;
		int startNum = endNum-9;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		List<SimriMemberDTO> list = memberDAO.getMemberStopList(map);
		return list;
	}

	@Override
	public void stopInsert(Map<String, String> map) {
		memberDAO.stopInsert(map);
		
	}
	
	@Override
	public void stopPeriodInsert(Map<String, String> map) {
		memberDAO.stopPeriodInsert(map);
		
	}

	@Override
	public void memberDelete(String email) {
		memberDAO.memberDelete(email);
	}

	@Override
	public List<SimriMemberDTO> getMemberSearch(String category, String searchText, String pg) {
		//페이징 처리
		//1페이지당 10개
		int endNum = Integer.parseInt(pg)*10 ;
		int startNum = endNum-9;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum",startNum);
		map.put("endNum",endNum);
		map.put("category", category);
		map.put("searchText", searchText);
		map.put("pg", pg);
		
		List<SimriMemberDTO> list = memberDAO.getMemberSearch(map);
		return list;
	}

	@Override
	public MemberPaging memberPaging(Map<String, String> map) {
		int searchTotalA = memberDAO.searchTotalA(map);
		
		memberPaging.setCurrentPage(Integer.parseInt(map.get("pg")));//현재 페이지
		memberPaging.setPageBlock(3);
		memberPaging.setPageSize(10);
		memberPaging.setTotalA(searchTotalA);
		memberPaging.makePagingHTML();
		
		return memberPaging;
	}

	@Override
	public List<SimriMemberDTO> getMemberWarningSearch(String category, String searchText, String pg) {
		//페이징 처리
		//1페이지당 10개
		int endNum = Integer.parseInt(pg)*10 ;
		int startNum = endNum-9;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum",startNum);
		map.put("endNum",endNum);
		map.put("category", category);
		map.put("searchText", searchText);
		map.put("pg", pg);
		
		List<SimriMemberDTO> list = memberDAO.getMemberWarningSearch(map);
		return list;
	}

	@Override
	public MemberPaging memberWarningSearchPaging(Map<String, String> map) {
		int searchTotalA = memberDAO.warningSearchTotalA(map);
		
		memberPaging.setCurrentPage(Integer.parseInt(map.get("pg")));//현재 페이지
		memberPaging.setPageBlock(3);
		memberPaging.setPageSize(10);
		memberPaging.setTotalA(searchTotalA);
		memberPaging.makePagingHTML();
		
		return memberPaging;
	}

	@Override
	public MemberWarningPaging warningMemberPaging(Map<String, String> map) {
		int searchTotalA = memberDAO.warningSearchTotalA(map);
		
		memberWarningPaging.setCurrentPage(Integer.parseInt(map.get("pg")));//현재 페이지
		memberWarningPaging.setPageBlock(3);
		memberWarningPaging.setPageSize(10);
		memberWarningPaging.setTotalA(searchTotalA);
		memberWarningPaging.makePagingHTML();
		
		return memberWarningPaging;
	}




}
