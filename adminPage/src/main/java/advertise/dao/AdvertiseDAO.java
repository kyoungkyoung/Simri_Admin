package advertise.dao;

import java.util.List;
import java.util.Map;

import advertise.bean.AdvertiseDTO;

public interface AdvertiseDAO {

	public String addAd(String seq);

	public List<AdvertiseDTO> getAdList(Map<String, Object> map);

	public void adDelete(String seq);

	public int getTotalA();

}
