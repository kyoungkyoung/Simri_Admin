package admin.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import admin.bean.AdminDTO;

public interface AdminService {

	public String sign(Map<String, String> map, HttpSession session);

	public AdminDTO getAdmin(HttpSession session);

	public void changePwd(String changePwd);

}
