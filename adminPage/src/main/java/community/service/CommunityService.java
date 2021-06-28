package community.service;

import java.util.List;
import java.util.Map;

import community.bean.CommunityDTO;
import community.bean.CommunityPaging;

public interface CommunityService {

	public List<CommunityDTO> getCommunity(Map<String, String> map);

	public void communityDelete(String seq);

	public CommunityPaging communityPaging(Map<String, String> map);

	public void noticeWrite(CommunityDTO communityDTO);

	public CommunityDTO getCommunityView(String seq, String image);

}
