package member.service;

import java.util.List;
import java.util.Map;

import member.bean.MemberPaging;
import member.bean.MemberStopPaging;
import member.bean.MemberWarningPaging;
import member.bean.SimriMemberDTO;

public interface MemberService {

	public List<SimriMemberDTO> getMemberList(int pg);

	public SimriMemberDTO getSimriMember(String email);

	public void setPoint(String point,String email);

	public List<SimriMemberDTO> getMemberWarningList(int pg);

	public List<SimriMemberDTO> getMemberStopList(int pg);

	public void stopInsert(Map<String, String> map);

	public void stopPeriodInsert(Map<String, String> map);

	public void memberDelete(String email);

	public List<SimriMemberDTO> getMemberSearch(String category, String searchText, String pg);

	public MemberPaging memberPaging(int pg);

	public MemberWarningPaging warningMemberPaging(int pg);

	public MemberPaging memberPaging(Map<String, String> map);

	public List<SimriMemberDTO> getMemberWarningSearch(String category, String searchText, String pg);

	public MemberPaging memberWarningSearchPaging(Map<String, String> map);

	public MemberStopPaging stopMemberPaging(int pg);

	public MemberWarningPaging warningMemberPaging(Map<String, String> map);


}
