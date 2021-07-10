package community.dao;

import java.util.List;
import java.util.Map;

import advertise.bean.AdvertiseDTO;
import community.bean.CommunityDTO;
import community.bean.ReplyDTO;

public interface CommunityDAO {

	public List<CommunityDTO> getCommunity(Map<String, Object> newMap);

	public void communityDelete(String seq);

	public int getTotalA(Map<String, String> map);

	public void noticeWrite(CommunityDTO communityDTO);

	public CommunityDTO getCommunityView(String seq);

	public List<CommunityDTO> getComSearch(Map<String, Object> map);

	public int getSearchTotalA(String comSearchText);

	public void viewModify(CommunityDTO communityDTO);

	public List<CommunityDTO> singoList(Map<String, Object> newMap);

	public int getSingoTotalA(Map<String, String> map);

	public List<ReplyDTO> singoReplyList(Map<String, Object> newMap);

	public int getReplyTotalA(Map<String, String> map);

	public void replyDelete(String seq);


}
