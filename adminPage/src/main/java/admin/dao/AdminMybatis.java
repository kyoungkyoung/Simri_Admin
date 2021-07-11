package admin.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import admin.bean.AdminDTO;

@Transactional
@Repository
public class AdminMybatis implements AdminDAO {
   @Autowired
   private SqlSession sqlSession;
   
   @Override
   public AdminDTO sign(Map<String, String> map) {
      AdminDTO adminDTO = sqlSession.selectOne("adminSQL.sign", map);
      return adminDTO;
   }

	@Override
	public AdminDTO getAdmin(String adminId) {
		AdminDTO adminDTO = sqlSession.selectOne("adminSQL.getAdmin", adminId);
		return adminDTO;
	}

	@Override
	public void changePwd(String changePwd) {
		sqlSession.update("adminSQL.changePwd", changePwd);
	}

}