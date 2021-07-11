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

import chart.bean.ChartPaging;
import chart.bean.EtcDTO;
import chart.bean.MemChartDTO;
import chart.service.ChartService;
import community.bean.CommunityDTO;

@Controller
@RequestMapping("/chart")
public class ChartController {
	@Autowired
	private ChartService chartService;
	
	@RequestMapping(value = "/postGraphDetail", method = RequestMethod.GET)
	public String postGraphDetail(@RequestParam String seq, Model model) { 
		
		CommunityDTO communityDTO = chartService.getCommunityDTO(Integer.parseInt(seq));
		
		model.addAttribute("communityDTO", communityDTO);
		model.addAttribute("seq", seq);
		model.addAttribute("display", "/chart/postGraphDetail.jsp");
		return "/section/login";
	}// postGraphDetail()
	

	@RequestMapping(value = "/getEtc", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getEtc(@RequestParam String seq) {
		List<EtcDTO> list = chartService.getEtc(seq);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		
		return mav;
	}
	
	@RequestMapping(value = "/getDate", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getDate(@RequestParam String seq, @RequestParam String date) {
		
		List<EtcDTO> list = chartService.getDate(seq, date);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		
		return mav;
	}
	
	@RequestMapping(value = "/graph", method = RequestMethod.GET)
	public String graph(Model model) { 
		model.addAttribute("display", "/chart/graph.jsp");
		return "/section/login";
	}
	
	@RequestMapping(value = "/hitInfo", method = RequestMethod.GET)
	public String hitInfo(@RequestParam(required=false, defaultValue="1") String pg,
						  @RequestParam(required=false, defaultValue="comCategoryAll") String comCategory1,
						  @RequestParam(required=false, defaultValue="seq") String condition1,
						//  @RequestParam(required=false, defaultValue="day") String date,
										Model model) { 
		model.addAttribute("comCategory1", comCategory1);
		model.addAttribute("condition1", condition1);
		//model.addAttribute("date", date);
		model.addAttribute("pg", pg);
		model.addAttribute("display", "/chart/hitInfo.jsp");
		return "/section/login";
	}// memberView()
	
	@RequestMapping(value="/getMemData", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getMemData(@RequestParam String date) {
		
		List<MemChartDTO> list = chartService.getMemData(date);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="/getTestHit", method = RequestMethod.POST)
	   @ResponseBody
	   public ModelAndView getTestHit() {
	      List<CommunityDTO> list = chartService.getTestHit();
	      
	      ModelAndView mav = new ModelAndView();
	      mav.addObject("list", list);
	      mav.setViewName("jsonView");
	      return mav;
	   }
	   
	   @RequestMapping(value="/getloveHit", method = RequestMethod.POST)
	   @ResponseBody
	   public ModelAndView getloveHit() {
	      List<CommunityDTO> list = chartService.getloveHit();
	      
	      
	      ModelAndView mav = new ModelAndView();
	      mav.addObject("list", list);
	      mav.setViewName("jsonView");
	      return mav;
	   }
	
	@RequestMapping(value="/getHitInfoDay", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getHitInfoDay(@RequestParam String comCategory, @RequestParam String condition, @RequestParam String date, @RequestParam String pg) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("comCategory", comCategory);
		map.put("condition", condition);
		map.put("date", date);
		map.put("pg", pg);
		
		List<CommunityDTO> list = chartService.getHitInfoDay(map);
		
		ChartPaging chartPaging = chartService.chartPaging(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.addObject("chartPaging", chartPaging);
		mav.setViewName("jsonView");
		
		return mav;
	}
	
}
