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
		return list;
	}

	@Override
	public List<EtcDTO> getData(Map<String, Object> map) {
		List<EtcDTO> list = sqlSession.selectList("chartSQL.getData", map);
		return list;
	}

	@Override
	public CommunityDTO getCommunityDTO(int seq) {
		CommunityDTO communityDTO = sqlSession.selectOne("chartSQL.getCommunityDTO", seq);
		return communityDTO;
	}

	@Override
	public List<MemChartDTO> getMemData(String date) {		
		if(date.equals("day")) {
			List<MemChartDTO> list = sqlSession.selectList("chartSQL.getMemDataDay");
			return list;
		}else {
			List<MemChartDTO> list = sqlSession.selectList("chartSQL.getMemDataMonth");
			return list;
		}
	}

	@Override
	public List<CommunityDTO> getTestHit() {
		List<CommunityDTO> list = sqlSession.selectList("chartSQL.getTestHit");
		return list;
	}

	@Override
	public List<CommunityDTO> getloveHit() {
		List<CommunityDTO> list = sqlSession.selectList("chartSQL.getloveHit");
		return list;
	}

	@Override
	public List<CommunityDTO> getHitInfoDay(Map<String, Object> newMap) {
		List<CommunityDTO> list = new ArrayList<CommunityDTO>();
////////////////////////////////////////////////////////////////////////////////////////////////////////최신순
		
		if(newMap.get("condition").equals("seq")) {
			//최신순
			if(newMap.get("comCategory").equals("comCategoryAll")) {
				if(newMap.get("date").equals("day")) {
					list = sqlSession.selectList("chartSQL.getHitInfoAllL", newMap);
					return list;
				}else if(newMap.get("date").equals("week")) {
					list = sqlSession.selectList("chartSQL.getHitInfoAllWeekL", newMap);
					return list;
				}else {
					list = sqlSession.selectList("chartSQL.getHitInfoAllMonthL", newMap);
					return list;
				}
			}
			else if(newMap.get("comCategory").equals("심리테스트")) {
				newMap.put("comCategory", "심리 테스트");
				if(newMap.get("date").equals("day")) {
					list = sqlSession.selectList("chartSQL.getHitInfoL", newMap);
					return list;
				}else if(newMap.get("date").equals("week")) {
					list = sqlSession.selectList("chartSQL.getHitInfoWeekL", newMap);
					return list;
				}else {
					list = sqlSession.selectList("chartSQL.getHitInfoMonthL", newMap);
					return list;
				}
			}else {
				newMap.put("comCategory", "연애 심리글");
				if(newMap.get("date").equals("day")) {
					list = sqlSession.selectList("chartSQL.getHitInfoL", newMap);
					return list;
				}else if(newMap.get("date").equals("week")) {
					list = sqlSession.selectList("chartSQL.getHitInfoWeekL", newMap);
					return list;
				}else {
					list = sqlSession.selectList("chartSQL.getHitInfoMonthL", newMap);
					return list;
				}
			}
		}//if 최신순
		
////////////////////////////////////////////////////////////////////////////////////////////////////////조회수, 좋아요		
		
		else {
			//조회수, 좋아요
			if(newMap.get("comCategory").equals("comCategoryAll")) {
				if(newMap.get("date").equals("day")) {
					list = sqlSession.selectList("chartSQL.getHitInfoAll", newMap);
					return list;
				}else if(newMap.get("date").equals("week")) {
					list = sqlSession.selectList("chartSQL.getHitInfoAllWeek", newMap);
					return list;
				}else {
					list = sqlSession.selectList("chartSQL.getHitInfoAllMonth", newMap);
					return list;
				}
			}
			else if(newMap.get("comCategory").equals("심리테스트")) {
				newMap.put("comCategory", "심리 테스트");
				if(newMap.get("date").equals("day")) {
					list = sqlSession.selectList("chartSQL.getHitInfo", newMap);
					return list;
				}else if(newMap.get("date").equals("week")) {
					list = sqlSession.selectList("chartSQL.getHitInfoWeek", newMap);
					return list;
				}else {
					list = sqlSession.selectList("chartSQL.getHitInfoMonth", newMap);
					return list;
				}
			}else {
				newMap.put("comCategory", "연애 심리글");
				if(newMap.get("date").equals("day")) {
					list = sqlSession.selectList("chartSQL.getHitInfo", newMap);
					return list;
				}else if(newMap.get("date").equals("week")) {
					list = sqlSession.selectList("chartSQL.getHitInfoWeek", newMap);
					return list;
				}else {
					list = sqlSession.selectList("chartSQL.getHitInfoMonth", newMap);
					return list;
				}
			}
			
		}//else 조회수, 좋아요
		
////////////////////////////////////////////////////////////////////////////////////////////////////////조회수, 좋아요		
		
	}

	@Override
	public int getTotalA(Map<String, String> map) {
		
		if(map.get("condition").equals("seq")) {
			//최신순
			if(map.get("comCategory").equals("comCategoryAll")) {
				if(map.get("date").equals("day")) {
					return sqlSession.selectOne("chartSQL.getTotalHitInfoAllL", map);
				}else if(map.get("date").equals("week")) {
					return sqlSession.selectOne("chartSQL.getTotalHitInfoAllWeekL", map);
				}else {
					return sqlSession.selectOne("chartSQL.getTotalHitInfoAllMonthL", map);
				}
			}
			else if(map.get("comCategory").equals("심리테스트")) {
				map.put("comCategory", "심리 테스트");
				if(map.get("date").equals("day")) {
					return sqlSession.selectOne("chartSQL.getTotalHitInfoL", map);
				}else if(map.get("date").equals("week")) {
					return sqlSession.selectOne("chartSQL.getTotalHitInfoWeekL", map);
				}else {
					return sqlSession.selectOne("chartSQL.getTotalHitInfoMonthL", map);
				}
			}else {
				map.put("comCategory", "연애 심리글");
				if(map.get("date").equals("day")) {
					return sqlSession.selectOne("chartSQL.getTotalHitInfoL", map);
				}else if(map.get("date").equals("week")) {
					return sqlSession.selectOne("chartSQL.getTotalHitInfoWeekL", map);
				}else {
					return sqlSession.selectOne("chartSQL.getTotalHitInfoMonthL", map);
				}
			}
			
		}else {
			//조회수, 좋아요
			if(map.get("comCategory").equals("comCategoryAll")) {
				if(map.get("date").equals("day")) {
					return sqlSession.selectOne("chartSQL.getTotalHitInfoAll", map);
				}else if(map.get("date").equals("week")) {
					return sqlSession.selectOne("chartSQL.getTotalHitInfoAllWeek", map);
				}else {
					return sqlSession.selectOne("chartSQL.getTotalHitInfoAllMonth", map);
				}
			}
			else if(map.get("comCategory").equals("심리테스트")) {
				map.put("comCategory", "심리 테스트");
				if(map.get("date").equals("day")) {
					return sqlSession.selectOne("chartSQL.getTotalHitInfo", map);
				}else if(map.get("date").equals("week")) {
					return sqlSession.selectOne("chartSQL.getTotalHitInfoWeek", map);
				}else {
					return sqlSession.selectOne("chartSQL.getTotalHitInfoMonth", map);
				}
			}else {
				map.put("comCategory", "연애 심리글");
				if(map.get("date").equals("day")) {
					return sqlSession.selectOne("chartSQL.getTotalHitInfo", map);
				}else if(map.get("date").equals("week")) {
					return sqlSession.selectOne("chartSQL.getTotalHitInfoWeek", map);
				}else {
					return sqlSession.selectOne("chartSQL.getTotalHitInfoMonth", map);
				}
			}
		}
		
	}
	
}
