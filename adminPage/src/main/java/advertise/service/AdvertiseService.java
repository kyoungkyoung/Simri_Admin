package advertise.service;

import java.util.List;

import advertise.bean.AdvertiseDTO;
import advertise.bean.AdvertisePaging;

public interface AdvertiseService {

	public String addAd(String seq);

	public List<AdvertiseDTO> getAdList(String pg);

	public void adDelete(String seq);

	public AdvertisePaging advertisePaging(String pg);

}
