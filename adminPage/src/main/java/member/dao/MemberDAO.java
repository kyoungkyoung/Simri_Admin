package member.dao;

import java.util.List;
import java.util.Map;

import member.bean.SimriMemberDTO;

public interface MemberDAO {

	public List<SimriMemberDTO> getMemberList(Map<String, Integer> map);

	public SimriMemberDTO getSimriMember(String email);

	public void setPoint(String point, String email);

	public List<SimriMemberDTO> getMemberWarningList(Map<String, Integer> map);

	public List<SimriMemberDTO> getMemberStopList(Map<String, Integer> map);

	public void stopInsert(Map<String, String> map);

	public void stopPeriodInsert(Map<String, String> map);

	public void memberDelete(String email);

	public List<SimriMemberDTO> getMemberSearch(Map<String, Object> map);

	public int getTotalA();

	public int getWarningTotalA();

	public int searchTotalA(Map<String, String> map);

	public List<SimriMemberDTO> getMemberWarningSearch(Map<String, Object> map);

	public int warningSearchTotalA(Map<String, String> map);

	public int getStopTotalA();


}
