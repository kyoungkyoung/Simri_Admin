package admin.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admin.bean.AdminDTO;
import admin.dao.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService {
   @Autowired
   private AdminDAO adminDAO;

   @Override
   public String sign(Map<String, String> map, HttpSession session) {
      AdminDTO adminDTO = adminDAO.sign(map);
      
      if(adminDTO == null) {
         return "fail";
      }else {
         session.setAttribute("memId", adminDTO.getAdminId());
         return "success";
      }
      
   }

	@Override
	public AdminDTO getAdmin(HttpSession session) {
		String adminId = (String)session.getAttribute("memId");
		AdminDTO adminDTO = adminDAO.getAdmin(adminId);
		return adminDTO;
	}

	@Override
	public void changePwd(String changePwd) {
		adminDAO.changePwd(changePwd);
	}

}