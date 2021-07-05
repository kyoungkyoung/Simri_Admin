package chart.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import chart.bean.EtcDTO;
import chart.bean.MemChartDTO;
import community.bean.CommunityDTO;

@Repository
@Transactional
public class ChartMybatis implements ChartDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<EtcDTO> getEtc(String seq) {
		List<EtcDTO> list = sqlSession.selectList("chartSQL.getEtc", seq);
		//System.out.println(list);
		return list;
	}

	@Override
	public List<EtcDTO> getData(Map<String, Object> map) {
		//System.out.println(map.get("startDate"));
		//System.out.println(map.get("endDate"));
		List<EtcDTO> list = sqlSession.selectList("chartSQL.getData", map);
		//System.out.println(list);
		return list;
	}

	@Override
	public CommunityDTO getCommunityDTO(int seq) {
		CommunityDTO communityDTO = sqlSession.selectOne("chartSQL.getCommunityDTO", seq);
		System.out.println(communityDTO);
		return communityDTO;
	}

	@Override
	public List<MemChartDTO> getMemData(String date) {		
		if(date.equals("day")) {
			List<MemChartDTO> list = sqlSession.selectList("chartSQL.getMemDataDay");
			System.out.println(list);
			return list;
		}else {
			List<MemChartDTO> list = sqlSession.selectList("chartSQL.getMemDataMonth");
			System.out.println(list);
			return list;
		}
	}

	@Override
	public List<CommunityDTO> getTestHit() {
		List<CommunityDTO> list = sqlSession.selectList("chartSQL.getTestHit");
		System.out.println(list);
		return list;
	}

	@Override
	public List<CommunityDTO> getloveHit() {
		List<CommunityDTO> list = sqlSession.selectList("chartSQL.getloveHit");
		System.out.println(list);
		return list;
	}

	@Override
	public List<CommunityDTO> getHitInfoDay(Map<String, String> map) {
		List<CommunityDTO> list = new ArrayList<CommunityDTO>();
	
		System.out.println(map.get("comCategory"));
		System.out.println(map.get("condition"));
		System.out.println(map.get("date"));
			
		if(map.get("comCategory").equals("comCategoryAll")) {
			if(map.get("date").equals("day")) {
				list = sqlSession.selectList("chartSQL.getHitInfoAll", map);
				System.out.println(list);
				return list;
			}else if(map.get("date").equals("week")) {
				list = sqlSession.selectList("chartSQL.getHitInfoAllWeek", map);
				System.out.println(list);
				return list;
			}else {
				list = sqlSession.selectList("chartSQL.getHitInfoAllMonth", map);
				System.out.println(list);
				return list;
			}
		}
		else if(map.get("comCategory").equals("심리테스트")) {
			map.put("comCategory", "심리 테스트");
			if(map.get("date").equals("day")) {
				list = sqlSession.selectList("chartSQL.getHitInfo", map);
				return list;
			}else if(map.get("date").equals("week")) {
				list = sqlSession.selectList("chartSQL.getHitInfoWeek", map);
				return list;
			}else {
				list = sqlSession.selectList("chartSQL.getHitInfoMonth", map);
				return list;
			}
		}else {
			map.put("comCategory", "연애 심리글");
			if(map.get("date").equals("day")) {
				list = sqlSession.selectList("chartSQL.getHitInfo", map);
				return list;
			}else if(map.get("date").equals("week")) {
				list = sqlSession.selectList("chartSQL.getHitInfoWeek", map);
				return list;
			}else {
				list = sqlSession.selectList("chartSQL.getHitInfoMonth", map);
				return list;
			}
		}
	}
	
}
