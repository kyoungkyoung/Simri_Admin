package community.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import community.bean.CommunityDTO;
import community.bean.CommunityPaging;
import community.service.CommunityService;

@Controller
@RequestMapping(value="/community")
public class CommunityController {
	@Autowired
	private CommunityService communityService; 
	
	@RequestMapping(value = "/community", method = RequestMethod.GET)
	public String community(@RequestParam(required=false, defaultValue="1") String pg,
							@RequestParam(required=false, defaultValue="[전체 게시글]팔레트") String comCategory1,
							Model model) { 
		model.addAttribute("pg", pg);
		model.addAttribute("comCategory1", comCategory1);
		model.addAttribute("display", "/community/community.jsp");
		return "/section/login";
	}// postModify()
	
	@RequestMapping(value = "/communityModify", method = RequestMethod.GET)
	public String postModify(Model model) { 
		model.addAttribute("display", "/community/communityModify.jsp");
		return "/section/login";
	}// postModify()
	
	@RequestMapping(value = "/writeForm", method = RequestMethod.GET)
	public String writeForm(Model model) { 
		model.addAttribute("display", "/community/writeForm.jsp");
		return "/section/login";
	}// memberView()

	@RequestMapping(value = "/communityWriteForm", method = RequestMethod.GET)
	public String communityWriteForm(Model model) { 
		model.addAttribute("display", "/community/communityWriteForm.jsp");
		return "/section/login";
	}// postModify()
	
	@RequestMapping(value="/getCommunity")
	@ResponseBody
	public ModelAndView getCommunity(@RequestParam String comCategory,
									 @RequestParam(required=false, defaultValue="1") String pg) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("comCategory", comCategory);
		map.put("pg", pg);
		
		List<CommunityDTO> list = communityService.getCommunity(map);
		
		//페이징 처리
		CommunityPaging communityPaging = communityService.communityPaging(map);
		
		System.out.println(communityPaging.getPageSize());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("comCategory", comCategory);
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.addObject("communityPaging", communityPaging);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="/communityDelete")
	@ResponseBody
	public void communityDelete(@RequestParam String seq) {
		 communityService.communityDelete(seq);
	}
	
}















