package chart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chart.bean.EtcDTO;
import chart.dao.ChartDAO;

@Service
public class ChartServiceImpl implements ChartService {
	@Autowired
	private ChartDAO chartDAO;

	@Override
	public List<EtcDTO> getEtc(String seq) {
		List<EtcDTO> list = chartDAO.getEtc(seq);
		return list;
	}

	@Override
	public List<EtcDTO> getDate(String seq, String date) {
		String startDate = date.substring(0,8);
		String endDate = date.substring(11,19);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", Integer.parseInt(seq));
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		
		List<EtcDTO> list = chartDAO.getData(map);
		
		return list;
	}
}           