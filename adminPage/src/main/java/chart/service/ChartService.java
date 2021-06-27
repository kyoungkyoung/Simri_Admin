package chart.service;

import java.util.List;

import chart.bean.EtcDTO;

public interface ChartService {

	//public List<HitDTO> getHit(String seq);

	public List<EtcDTO> getEtc(String seq);

	public List<EtcDTO> getDate(String seq, String date);
}
