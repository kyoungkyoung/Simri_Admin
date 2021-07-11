package member.controller;

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

import member.bean.MemberPaging;
import member.bean.MemberStopPaging;
import member.bean.MemberWarningPaging;
import member.bean.SimriMemberDTO;
import member.service.MemberService;

@Controller
@RequestMapping("/member")
public class memberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/memberList", method = RequestMethod.GET)
	public String memberList(@RequestParam(required=false, defaultValue="1") String pg, 
								@RequestParam(required=false, defaultValue="1") String btnId, Model model) {
		model.addAttribute("pg", pg);
		model.addAttribute("btnId", btnId);

		model.addAttribute("display", "/member/memberList.jsp");
		
		return "/section/login";
	}// memberList()
	
	@RequestMapping(value = "/memberView", method=RequestMethod.GET)
	public String memberView(@RequestParam String email, Model model) { 
		SimriMemberDTO simriMemberDTO = memberService.getSimriMember(email);
		
		model.addAttribute("SimriMemberDTO",simriMemberDTO);
		//model.addAttribute("email", email);
		
		return "/member/memberView";
	}// checkPost()
	
	@RequestMapping(value="/setPoint", method=RequestMethod.POST)
	@ResponseBody
	public void setPoint(@RequestParam String point, @RequestParam String email) {
		memberService.setPoint(point,email);
	}
	
	@RequestMapping(value = "/getMemberList", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getMemberList(@RequestParam(required=false, defaultValue="1") String pg) {
		
		List<SimriMemberDTO> list = memberService.getMemberList(Integer.parseInt(pg));
		
		//페이징 처리
		MemberPaging memberPaging = memberService.memberPaging(Integer.parseInt(pg));
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.addObject("list",list);
		mav.addObject("memberPaging",memberPaging);
		
		mav.setViewName("jsonView");

		return mav;
	}
	
	@RequestMapping(value = "/getMemberWarningList", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getMemberWarningList(@RequestParam(required=false, defaultValue="1") String pg, Model model) {
		
		List<SimriMemberDTO> list = memberService.getMemberWarningList(Integer.parseInt(pg));
		
		//페이징 처리
		MemberWarningPaging memberWarningPaging = memberService.warningMemberPaging(Integer.parseInt(pg));
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.addObject("list",list);
		mav.addObject("memberWarningPaging",memberWarningPaging);
		mav.setViewName("jsonView");

		return mav;
	}
	
	@RequestMapping(value = "/getMemberStopList", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getMemberStopList(@RequestParam(required=false, defaultValue="1") String pg, Model model) {
		
		List<SimriMemberDTO> list = memberService.getMemberStopList(Integer.parseInt(pg));
		
		//페이징 처리
		MemberStopPaging memberStopPaging = memberService.stopMemberPaging(Integer.parseInt(pg));
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg",pg);
		mav.addObject("list",list);
		mav.addObject("memberStopPaging",memberStopPaging);
		mav.setViewName("jsonView");

		return mav;
	}
	
	@RequestMapping(value = "/stopInsert", method=RequestMethod.POST)
	@ResponseBody
	public void stopInsert(@RequestParam String num, @RequestParam String email,
						   @RequestParam String stopReason, @RequestParam String period) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("num",num);
		map.put("email",email);
		map.put("stopReason",stopReason);
		map.put("period",period);
		
		memberService.stopInsert(map);
	}
	
	@RequestMapping(value = "/stopPeriodInsert", method=RequestMethod.POST)
	@ResponseBody
	public void stopPeriodInsert(@RequestParam String num, @RequestParam String email,
						          @RequestParam String period) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("num",num);
		map.put("email",email);
		map.put("period",period);
		
		memberService.stopPeriodInsert(map);
	}
	
	@RequestMapping(value="/memberDelete", method=RequestMethod.POST)
	@ResponseBody
	public void memberDelete(@RequestParam String email) {
		memberService.memberDelete(email);
	}
	
	@RequestMapping(value="/getMemberSearch", method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView getMemberSearch(@RequestParam String category,
										@RequestParam String searchText,
										@RequestParam String pg) {
		
		if(category.equals("이름")) {
			category="name";
		}else if(category.equals("이메일")) {
			category="email";
		}
		
		List<SimriMemberDTO> list = memberService.getMemberSearch(category, searchText, pg);
		
		//페이징 처리
		Map<String, String> map = new HashMap<String, String>();
		map.put("category", category);
		map.put("searchText", searchText);
		map.put("pg", pg);
		
		
		MemberPaging memberPaging = memberService.memberPaging(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",list);
		mav.addObject("searchText", searchText);
		mav.addObject("category", category);
		mav.addObject("pg", map.get(pg));
		mav.addObject("memberPaging", memberPaging);
		mav.setViewName("jsonView");

		return mav;
	}
	
	@RequestMapping(value="/getMemberWarningSearch", method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView getMemberWarningSearch(@RequestParam String category,
										@RequestParam String searchText,
										@RequestParam String pg) {
		
		if(category.equals("이름")) {
			category="name";
		}else if(category.equals("이메일")) {
			category="email";
		}
		
		List<SimriMemberDTO> list = memberService.getMemberWarningSearch(category, searchText, pg);
		
		//페이징 처리
		Map<String, String> map = new HashMap<String, String>();
		map.put("category", category);
		map.put("searchText", searchText);
		map.put("pg", pg);
		
		MemberWarningPaging memberWarningPaging = memberService.warningMemberPaging(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",list);
		mav.addObject("searchText", searchText);
		mav.addObject("category", category);
		mav.addObject("pg", map.get(pg));
		mav.addObject("memberWarningPaging", memberWarningPaging);
		mav.setViewName("jsonView");

		return mav;
	}
	
	
}