package advertise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import advertise.bean.AdvertiseDTO;
import advertise.bean.AdvertisePaging;
import advertise.service.AdvertiseService;
import post.bean.PostPaging2;

@Controller
@RequestMapping(value="/advertise")
public class AdvertiseController {
	@Autowired
	private AdvertiseService advertiseService;

	//광고목록
	@RequestMapping(value = "/advertiseList", method = RequestMethod.GET)
	public String advertiseList(@RequestParam(required = false, defaultValue="1") String pg, Model model) { 
		model.addAttribute("pg", pg);
		model.addAttribute("display", "/advertise/advertiseList.jsp");
		return "/section/login";
	}// postModify()
	
	@RequestMapping(value="/addAd", method = RequestMethod.POST)
	@ResponseBody
	public String addAd(@RequestParam String seq) {
		return advertiseService.addAd(seq);
	}
	
	@RequestMapping(value="/getAdList", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getAdList(@RequestParam String pg) {
		
		List<AdvertiseDTO> list = advertiseService.getAdList(pg);
		
		//페이징 처리
		AdvertisePaging advertisePaging = advertiseService.advertisePaging(pg);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.addObject("advertisePaging", advertisePaging);
		mav.setViewName("jsonView");
		
		return mav;
	}
	
	@RequestMapping(value="/adDelete", method = RequestMethod.POST)
	@ResponseBody
	public void adDelete(@RequestParam String seq) {
		advertiseService.adDelete(seq);
	}	
	
}
