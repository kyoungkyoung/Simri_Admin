package chart.controller;

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

import chart.bean.EtcDTO;
import chart.service.ChartService;

@Controller
@RequestMapping("/chart")
public class ChartController {
	@Autowired
	private ChartService chartService;
	
	@RequestMapping(value = "/postGraphDetail", method = RequestMethod.GET)
	public String postGraphDetail(@RequestParam String seq, Model model) { 
		System.out.println(seq);
		model.addAttribute("seq", seq);
		model.addAttribute("display", "/chart/postGraphDetail.jsp");
		return "/section/login";
	}// postGraphDetail()
	
//	@RequestMapping(value = "/getHit", method = RequestMethod.POST)
//	@ResponseBody
//	public ModelAndView getHit(@RequestParam String seq) {
//		System.out.println("seq="+seq);
//		List<HitDTO> list = chartService.getHit(seq);
//		
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("list", list);
//		mav.setViewName("jsonView");
//		
//		return mav;
//	}
	
	@RequestMapping(value = "/getEtc", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getEtc(@RequestParam String seq) {
		System.out.println("seq="+seq);
		
		List<EtcDTO> list = chartService.getEtc(seq);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		
		return mav;
	}
	
	@RequestMapping(value = "/getDate", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getDate(@RequestParam String seq, @RequestParam String date) {
		System.out.println("찍히나"+seq);
		System.out.println("찍히나"+date);
		
		List<EtcDTO> list = chartService.getDate(seq, date);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		
		return mav;
	}
	
	
	
}
