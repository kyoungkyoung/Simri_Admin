package member.dao;

import java.awt.font.TransformAttribute;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import member.bean.SimriMemberDTO;

@Repository
@Transactional
public class MemberMybatis implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
	private SimpleDateFormat sdf2 = new SimpleDateFormat("yy/MM/dd");
	
	
	@Override
	public List<SimriMemberDTO> getMemberList(Map<String, Integer> map) {
		List<SimriMemberDTO> list = sqlSession.selectList("memberSQL.getMemberList", map);
		for(SimriMemberDTO dto : list) {
			if(dto.getStopPeriod()!=0) {
				try {
					Calendar cal = Calendar.getInstance();
					String date = sdf.format(cal.getTime());
					
					Date date1 = sdf.parse(dto.getSingologtime());
					Date today = sdf.parse(date);
					
					cal.setTime(date1);
					cal.add(Calendar.DATE, dto.getStopPeriod());
					
					if(cal.getTime().after(today)) {
						//System.out.println("정지 안풀림");
					}else {
						//System.out.println("정지 풀림");
						sqlSession.update("memberSQL.updateStop", dto);
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}//if dto.getStopPeriod()!=0
		}//for list
		
		List<SimriMemberDTO> list2 = sqlSession.selectList("memberSQL.getMemberList", map);
		return list2;
	}
	
	@Override
	public int getTotalA() {
		//총글수
		return sqlSession.selectOne("memberSQL.getTotalA");
	}

	@Override
	public SimriMemberDTO getSimriMember(String email) {
		SimriMemberDTO simriMemberDTO = sqlSession.selectOne("memberSQL.getSimriMember", email);
		return simriMemberDTO;
	}

	@Override
	public void setPoint(String point, String email) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("point",Integer.parseInt(point));
		map.put("email", email);
 		
		sqlSession.update("memberSQL.setPoint", map);
	}

	@Override
	public List<SimriMemberDTO> getMemberWarningList(Map<String, Integer> map) {
		List<SimriMemberDTO> list = sqlSession.selectList("memberSQL.getMemberWarningList", map);
		return list;
	}

	@Override
	public int getWarningTotalA() {
		//총글수
		return sqlSession.selectOne("memberSQL.getWarningTotalA");
	}

	@Override
	public List<SimriMemberDTO> getMemberStopList(Map<String, Integer> map) {
		List<SimriMemberDTO> list = sqlSession.selectList("memberSQL.getMemberStopList", map);
		
		for(SimriMemberDTO dto : list) {
			if(dto.getStopPeriod()!=0) {
				try {
					Calendar cal = Calendar.getInstance();
					String date = sdf.format(cal.getTime());

					Date date1 = sdf.parse(dto.getSingologtime());
					Date today = sdf.parse(date);
					
					cal.setTime(date1);
					cal.add(Calendar.DATE, dto.getStopPeriod());
					
					if(cal.getTime().after(today)) {
						//System.out.println("정지 안풀림");
					}else {
						//System.out.println("정지 풀림");
						sqlSession.update("memberSQL.updateStop", dto);
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}//if dto.getStopPeriod()!=0
		}//for list
		return list;
	}

	@Override
	public void stopInsert(Map<String, String> map) {
		
		String newEmail1 = map.get("email").replace("{\"email\":\"", "");
		String newEmail2 = newEmail1.replace("\"}","");
		String newEmail3 = newEmail2.replace("[","");
		String newEmail4 = newEmail3.replace("]","");
		
		String[] arrayEmail = newEmail4.split(",");
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
		String sysdate = sdf.format(date);
		
		for(int i=0; i<arrayEmail.length; i++) {
			Map<String, String> newMap = new HashMap<String, String>();
			newMap.put("singologtime", sysdate);
			newMap.put("stopReason", map.get("stopReason"));
			newMap.put("stopPeriod", (String) map.get("period"));
			newMap.put("email", arrayEmail[i]);
			sqlSession.update("memberSQL.stopInsert", newMap);
		}

	}

	@Override
	public void stopPeriodInsert(Map<String, String> map) {
		
		String newEmail1 = map.get("email").replace("{\"email\":\"", "");
		String newEmail2 = newEmail1.replace("\"}","");
		String newEmail3 = newEmail2.replace("[","");
		String newEmail4 = newEmail3.replace("]","");
		
		String[] arrayEmail = newEmail4.split(",");
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
		String sysdate = sdf.format(date);
		
		for(int i=0; i<arrayEmail.length; i++) {
			
			Map<String, String> newMap = new HashMap<String, String>();
			newMap.put("singologtime", sysdate);
			newMap.put("stopPeriod", map.get("period"));
			newMap.put("email", arrayEmail[i]);
			sqlSession.update("memberSQL.stopPeriodInsert", newMap);
		}

	}
	
	@Override
	public void memberDelete(String email) {
		String newEmail1 = email.replace("{\"email\":\"", "");
		String newEmail2 = newEmail1.replace("\"}","");
		String newEmail3 = newEmail2.replace("[","");
		String newEmail4 = newEmail3.replace("]","");
		
		String[] arrayEmail = newEmail4.split(",");
		
		for(int i=0; i<arrayEmail.length; i++) {
			sqlSession.delete("memberSQL.memberDelete", arrayEmail[i]);
		}
	}

	@Override
	public List<SimriMemberDTO> getMemberSearch(Map<String, Object> map) {
		List<SimriMemberDTO> list = sqlSession.selectList("memberSQL.getMemberSearch", map);
		return list;
	}

	@Override
	public int searchTotalA(Map<String, String> map) {
		return sqlSession.selectOne("memberSQL.searchTotalA", map);
	}

	@Override
	public List<SimriMemberDTO> getMemberWarningSearch(Map<String, Object> map) {
		List<SimriMemberDTO> list = sqlSession.selectList("memberSQL.getMemberWarningSearch", map);
		return list;
	}

	@Override
	public int warningSearchTotalA(Map<String, String> map) {
		return sqlSession.selectOne("memberSQL.warningSearchTotalA", map);
	}

	@Override
	public int getStopTotalA() {
		//총글수
		return sqlSession.selectOne("memberSQL.getStopTotalA");
	}


}
