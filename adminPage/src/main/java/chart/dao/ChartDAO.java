package chart.dao;

import java.util.List;
import java.util.Map;

import chart.bean.EtcDTO;
import chart.bean.MemChartDTO;
//import chart.bean.HitDTO;
import community.bean.CommunityDTO;

public interface ChartDAO {

	//public List<HitDTO> getHit(String seq);
	
	public List<EtcDTO> getEtc(String seq);

	public List<EtcDTO> getData(Map<String, Object> map);

	public CommunityDTO getCommunityDTO(int seq);

	public List<MemChartDTO> getMemData(String date);

	public List<CommunityDTO> getTestHit();

	public List<CommunityDTO> getloveHit();

	public List<CommunityDTO> getHitInfoDay(Map<String, Object> newMap);

	public int getTotalA(Map<String, String> map);

}
