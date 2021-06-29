package community.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import community.bean.CommunityDTO;
import community.bean.CommunityPaging;
import community.bean.CommunitySearchPaging;
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
	
	@RequestMapping(value="noticeWrite", method=RequestMethod.POST)
	@ResponseBody
	public void noticeWrite(@ModelAttribute CommunityDTO communityDTO,
			@RequestParam MultipartFile img) {
		//System.out.println(communityDTO.getImage());
		
		String filePath = "D:\\Spring\\FinalProject\\git_Project\\gitAdmin\\adminPage\\src\\main\\webapp\\storage";
		String fileName = img.getOriginalFilename();
		File file = new File(filePath, fileName);//파일 생성
		
		if (fileName.equals("")) {
	         communityDTO.setImage("null.jpg");
	      } else {
	         // 파일 복사
	         try {
	            FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
	         } catch (IOException e) {
	            e.printStackTrace();
	         }
	         communityDTO.setImage(fileName);
	      }
		
		communityService.noticeWrite(communityDTO);
		
	

	}//공지사항 등록

	
	@RequestMapping(value = "/communityView", method = RequestMethod.GET)
	public String communityView(@RequestParam String seq,
								@RequestParam String image, Model model) {
		System.out.println(seq);
		CommunityDTO communityDTO = communityService.getCommunityView(seq, image);
		System.out.println("Controller = " + communityDTO);
		
		model.addAttribute("communityDTO", communityDTO);
		model.addAttribute("seq", Integer.parseInt(seq));
		model.addAttribute("image", image);
		model.addAttribute("display", "/community/communityView.jsp");
		return "/section/login"; 
	}// postModify()
	
	
	@RequestMapping(value = "/comSearch", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView comSearch(@RequestParam String comSearchText,
								  @RequestParam String pg) {
		
		List<CommunityDTO> list = communityService.getComSearch(comSearchText, pg);
		
		CommunitySearchPaging commnunitySearchPaging = communityService.getcommunitySearchPaging(comSearchText, pg);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.addObject("commnunitySearchPaging", commnunitySearchPaging);
		mav.setViewName("jsonView");
		
		return mav;
	}
	
	
	
}















