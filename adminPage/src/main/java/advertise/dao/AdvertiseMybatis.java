package advertise.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import advertise.bean.AdvertiseDTO;
import community.bean.CommunityDTO;

@Transactional
@Repository
public class AdvertiseMybatis implements AdvertiseDAO {
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private AdvertiseDTO advertiseDTO;

	@Override
	public String addAd(String seq) {
		int count=0;
		
		String newSeq1 = seq.replace("{\"seq\":\"", "");
		String newSeq2 = newSeq1.replace("\"}","");
		String newSeq3 = newSeq2.replace("[","");
		String newSeq4 = newSeq3.replace("]","");
		
		String[] arraySeq = newSeq4.split(",");
		
		for(int i=0; i<arraySeq.length; i++) {
			CommunityDTO communityDTO = sqlSession.selectOne("advertiseSQL.getcommunity",Integer.parseInt(arraySeq[i]));
			
			advertiseDTO.setSeq(communityDTO.getSeq());
			advertiseDTO.setCategory(communityDTO.getCategory());
			advertiseDTO.setSubject(communityDTO.getSubject());
			advertiseDTO.setImage(communityDTO.getImage());
			advertiseDTO.setPoint(communityDTO.getPoint());
			
			AdvertiseDTO advertiseDTO2 = sqlSession.selectOne("advertiseSQL.getAdvertiseDTO", advertiseDTO.getSeq());
			if(advertiseDTO2 != null) {
				count++;
			}
			
		}
		if(count != 0) {
			return "exist";
		}else {
			for(int i=0; i<arraySeq.length; i++) {
				CommunityDTO communityDTO = sqlSession.selectOne("advertiseSQL.getcommunity",Integer.parseInt(arraySeq[i]));
				
				advertiseDTO.setSeq(communityDTO.getSeq());
				advertiseDTO.setCategory(communityDTO.getCategory());
				advertiseDTO.setSubject(communityDTO.getSubject());
				advertiseDTO.setImage(communityDTO.getImage());
				advertiseDTO.setPoint(communityDTO.getPoint());
				
				sqlSession.insert("advertiseSQL.addAd", advertiseDTO);
			}
			return "non_exist";
		}
	}

	@Override
	public List<AdvertiseDTO> getAdList(Map<String, Object> map) {
		return sqlSession.selectList("advertiseSQL.getAdList", map);
	}

	@Override
	public void adDelete(String seq) {
		String newSeq1 = seq.replace("{\"seq\":\"", "");
		String newSeq2 = newSeq1.replace("\"}","");
		String newSeq3 = newSeq2.replace("[","");
		String newSeq4 = newSeq3.replace("]","");
		
		String[] arraySeq = newSeq4.split(",");
		
		for(int i=0; i<arraySeq.length; i++) {
			sqlSession.delete("advertiseSQL.adDelete", Integer.parseInt(arraySeq[i]));
		}
	}


	@Override
	public int getTotalA() {
		return sqlSession.selectOne("advertiseSQL.getTotalA");
	}

}
