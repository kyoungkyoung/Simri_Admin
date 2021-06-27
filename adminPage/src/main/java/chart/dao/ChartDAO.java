package chart.dao;

import java.util.List;
import java.util.Map;

import chart.bean.EtcDTO;
//import chart.bean.HitDTO;

public interface ChartDAO {

	//public List<HitDTO> getHit(String seq);
	
	public List<EtcDTO> getEtc(String seq);

	public List<EtcDTO> getData(Map<String, Object> map);

}
