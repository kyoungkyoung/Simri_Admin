package community.service;

import java.util.List;
import java.util.Map;

import advertise.bean.AdvertiseDTO;
import community.bean.CommunityDTO;
import community.bean.CommunityPaging;
import community.bean.CommunitySearchPaging;
import community.bean.ReplyDTO;
import community.bean.ReplyPaging;

public interface CommunityService {

	public List<CommunityDTO> getCommunity(Map<String, String> map);

	public void communityDelete(String seq);

	public CommunityPaging communityPaging(Map<String, String> map);

	public void noticeWrite(CommunityDTO communityDTO);

	public CommunityDTO getCommunityView(String seq);

	public List<CommunityDTO> getComSearch(String comSearchText, String pg);

	public CommunitySearchPaging getcommunitySearchPaging(String comSearchText, String pg);

	public void viewModify(CommunityDTO communityDTO);

	public List<CommunityDTO> singoList(Map<String, String> map);

	public CommunityPaging singoCommunityPaging(Map<String, String> map);

	public List<ReplyDTO> singoReplyList(Map<String, String> map);

	public ReplyPaging singoReplyPaging(Map<String, String> map);

	public void replyDelete(String seq);


}
