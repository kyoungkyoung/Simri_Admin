package chart.dao;

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
	
}
