package chart.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import chart.bean.EtcDTO;

@Repository
@Transactional
public class ChartMybatis implements ChartDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<EtcDTO> getEtc(String seq) {
		List<EtcDTO> list = sqlSession.selectList("chartSQL.getEtc", seq);
		System.out.println(list);
		return list;
	}

	@Override
	public List<EtcDTO> getData(Map<String, Object> map) {
		System.out.println(map.get("startDate"));
		System.out.println(map.get("endDate"));
		List<EtcDTO> list = sqlSession.selectList("chartSQL.getData", map);
		System.out.println(list);
		return list;
	}
	
}
