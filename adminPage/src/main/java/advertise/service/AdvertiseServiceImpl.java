package advertise.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import advertise.bean.AdvertiseDTO;
import advertise.bean.AdvertisePaging;
import advertise.dao.AdvertiseDAO;
import post.bean.PostPaging;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {
	@Autowired
	private AdvertiseDAO advertiseDAO;
	@Autowired
	private AdvertisePaging advertisePaging;

	@Override
	public String addAd(String seq) {
		return advertiseDAO.addAd(seq);
	}

	@Override
	public List<AdvertiseDTO> getAdList(String pg) {
		//페이징 처리 ; 1페이지당
		int endNum = Integer.parseInt(pg)*5;
		int startNum = endNum-4;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum",startNum);
		map.put("endNum",endNum);
		map.put("pg", Integer.parseInt(pg));
		
		return advertiseDAO.getAdList(map);
	}

	@Override
	public void adDelete(String seq) {
		advertiseDAO.adDelete(seq);
	}

	@Override
	public AdvertisePaging advertisePaging(String pg) {
		int totalA = advertiseDAO.getTotalA();
		
		advertisePaging.setCurrentPage(Integer.parseInt(pg));
		advertisePaging.setPageBlock(3);
		advertisePaging.setPageSize(5);
		advertisePaging.setTotalA(totalA);
		advertisePaging.makePagingHTML();
		
		return advertisePaging;
	}

}
