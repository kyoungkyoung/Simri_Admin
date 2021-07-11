package admin.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import admin.bean.AdminDTO;
import admin.service.AdminService;

@Controller
@RequestMapping("/section")
public class adminController {
	@Autowired
	private AdminService adminService;
	
	//팝업창
	@RequestMapping(value = "/memberView", method = RequestMethod.GET)
	public String memberView() { 
		return "/section/memberView";
	}// checkPost()
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() { 
		return "/section/login";
	}// checkPost()
	
//modify(비번 변경)
	//팝업창
	@RequestMapping(value = "/adminModify", method = RequestMethod.GET)
	public String adminModify(Model model, HttpSession session) { 
		AdminDTO adminDTO = adminService.getAdmin(session);
		model.addAttribute("adminDTO", adminDTO);
		return "/section/adminModify";
	}// checkPost()
	
	@RequestMapping(value="/changePwd", method=RequestMethod.POST)
	@ResponseBody
	public void changePwd(@RequestParam String changePwd) {
		adminService.changePwd(changePwd);
	}
//modify	
	

	@RequestMapping(value = "/postGraphDetail", method = RequestMethod.GET)
	public String postGraphDetail(Model model) { 
		model.addAttribute("display", "/chart/postGraphDetail.jsp");
		return "/section/login";
	}// postGraphDetail()
	

	
	
	


	
//로그인
    @RequestMapping(value = "sign", method = RequestMethod.POST)
    @ResponseBody
    public String sign(@RequestParam Map<String, String> map, HttpSession session) {
       return adminService.sign(map,session);
    }//로그인
	
//로그아웃
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
       session.invalidate(); //무효화
       return "/index";
    }
	
}

