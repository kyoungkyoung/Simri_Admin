package community.dao;

import java.util.List;
import java.util.Map;

import community.bean.CommunityDTO;

public interface CommunityDAO {

	public List<CommunityDTO> getCommunity(Map<String, Object> newMap);

	public void communityDelete(String seq);

	public int getTotalA(Map<String, String> map);

	public void noticeWrite(CommunityDTO communityDTO);

	public CommunityDTO getCommunityView(String seq);

	public List<CommunityDTO> getComSearch(Map<String, Object> map);

	public int getSearchTotalA(String comSearchText);

	public void viewModify(CommunityDTO communityDTO);

}
