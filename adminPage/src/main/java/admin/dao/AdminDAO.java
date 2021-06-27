package admin.dao;

import java.util.Map;

import admin.bean.AdminDTO;

public interface AdminDAO {

	public AdminDTO sign(Map<String, String> map);

	public AdminDTO getAdmin(String adminId);

	public void changePwd(String changePwd);

}
