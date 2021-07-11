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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import advertise.bean.AdvertiseDTO;
import advertise.bean.AdvertisePaging;
import community.bean.CommunityDTO;
import community.bean.CommunityPaging;
import community.bean.CommunitySearchPaging;
import community.bean.ReplyDTO;
import community.bean.ReplyPaging;
import community.service.CommunityService;

@Controller
@RequestMapping(value="/community")
public class CommunityController {
	@Autowired
	private CommunityService communityService; 
	
	
	@RequestMapping(value = "/community", method = RequestMethod.GET)
	@GetMapping("/community")
	public String community(@RequestParam(required=false, defaultValue="1") String pg,
							@RequestParam(required=false, defaultValue="[전체 게시글]팔레트") String comCategory1,
							Model model) { 
		model.addAttribute("pg", pg);
		model.addAttribute("comCategory1", comCategory1);
		model.addAttribute("display", "/community/community.jsp");
		return "/section/login";
	}// postModify()
	
//-----------------------------------------------------------------------------신고 댓글
	@RequestMapping(value = "/singoReply", method = RequestMethod.GET)
	public String singoReply(@RequestParam(required=false, defaultValue="1") String pg, Model model) { 
		
		model.addAttribute("pg",pg);
		model.addAttribute("display", "/community/singoReply.jsp");
		return "/section/login";
	}// 신고댓글
	
	@RequestMapping(value="/singoReplyList", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView singoReplyList(@RequestParam(required=false, defaultValue="1") String pg) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("pg", pg);
		
		List<ReplyDTO> list = communityService.singoReplyList(map);
		//페이징 처리
		ReplyPaging replyPaging = communityService.singoReplyPaging(map);

		ModelAndView mav = new ModelAndView();
		
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.addObject("replyPaging", replyPaging);
		mav.setViewName("jsonView");
		
		return mav;
	}
	
	@RequestMapping(value="/replyDelete")
	@ResponseBody
	public void replyDelete(@RequestParam String seq) {
		 communityService.replyDelete(seq);
	}
	
//---------------------------------------------------------------------------------end
	
//-----------------------------------------------------------------------------신고목록
	@RequestMapping(value = "/singoCommunity", method = RequestMethod.GET)
	public String singoCommunity(@RequestParam(required=false, defaultValue="1") String pg,
								 @RequestParam(required=false, defaultValue="[전체 게시글]팔레트") String comCategory1,
								 Model model) { 
		model.addAttribute("pg", pg);
		model.addAttribute("comCategory1", comCategory1);
		model.addAttribute("display", "/community/singoCommunity.jsp");
		return "/section/login";
	}// 신고목록
	
	@RequestMapping(value="/singoList", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView singoList(@RequestParam String comCategory,
			 					  @RequestParam(required=false, defaultValue="1") String pg) {
		
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("comCategory", comCategory);
		map.put("pg", pg);
		
		List<CommunityDTO> list = communityService.singoList(map);
		//페이징 처리
		CommunityPaging communityPaging = communityService.singoCommunityPaging(map);
		
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("comCategory", comCategory);
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.addObject("communityPaging", communityPaging);
		mav.setViewName("jsonView");
		
		return mav;
	}
//-----------------------------------------------------------------------------------end	
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
		
		//D:\Spring\FinalProject\git_Project\gitAdmin\adminPage\src\main\webapp\storage
		//C:\\git_home\\gitAdmin\\adminPage\\src\\main\\webapp\\storage
		String filePath = "D:\\Spring\\FinalProject\\git_Project\\gitAdmin\\adminPage\\src\\main\\webapp\\storage";
		String filePathSimri = "D:\\Spring\\FinalProject\\git_Project\\simriTest\\simri\\src\\main\\webapp\\storage";
		String fileName = img.getOriginalFilename();
		File file = new File(filePath, fileName);//파일 생성
		File fileSimri = new File(filePathSimri, fileName);//파일 생성
		
		if (fileName.equals("")) {
	         communityDTO.setImage("null.jpg");
	      } else {
	         // 파일 복사
	         try {
	            FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
	            FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(fileSimri));
	         } catch (IOException e) {
	            e.printStackTrace();
	         }
	         communityDTO.setImage(fileName);
	      }
		
		communityService.noticeWrite(communityDTO);
		
	

	}//공지사항 등록

	
	@RequestMapping(value = "/communityView", method = RequestMethod.GET)
	public String communityView(@RequestParam String seq, Model model) {
		CommunityDTO communityDTO = communityService.getCommunityView(seq);
		
		model.addAttribute("communityDTO", communityDTO);
		model.addAttribute("seq", Integer.parseInt(seq));
		model.addAttribute("display", "/community/communityView.jsp");
		return "/section/login"; 
	}// postModify() 
	
	@RequestMapping(value = "/noticeView", method = RequestMethod.GET)
	public String noticeView(@RequestParam String seq, Model model) {
		CommunityDTO communityDTO = communityService.getCommunityView(seq);
		
		model.addAttribute("communityDTO", communityDTO);
		model.addAttribute("seq", Integer.parseInt(seq));
		model.addAttribute("display", "/community/noticeView.jsp");
		return "/section/login"; 
	}// postModify() 
	
	@RequestMapping(value = "/comSearch", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView comSearch(@RequestParam String comSearchText,
								  @RequestParam String pg) {
		
		List<CommunityDTO> list = communityService.getComSearch(comSearchText, pg);
		
		CommunitySearchPaging communitySearchPaging = communityService.getcommunitySearchPaging(comSearchText, pg);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.addObject("communitySearchPaging", communitySearchPaging);
		mav.setViewName("jsonView");
		
		return mav;
	}//커뮤니ㅋ티 검색
	
	@RequestMapping(value="viewModify", method=RequestMethod.POST)
	@ResponseBody
	public void viewModify(@ModelAttribute CommunityDTO communityDTO,
			@RequestParam MultipartFile img) {
		
		//D:\Spring\FinalProject\git_Project\gitAdmin\adminPage\src\main\webapp\storage
		//C:\\git_home\\gitAdmin\\adminPage\\src\\main\\webapp\\storage
		String filePath = "D:\\Spring\\FinalProject\\git_Project\\gitAdmin\\adminPage\\src\\main\\webapp\\storage";
		String filePathSimri = "D:\\Spring\\FinalProject\\git_Project\\simriTest\\simri\\src\\main\\webapp\\storage";
		String fileName = img.getOriginalFilename();
		File file = new File(filePath, fileName);//파일 생성
		File fileSimri = new File(filePathSimri, fileName);//파일 생성
		
		if (fileName.equals("")) {
	         communityDTO.setImage("null.jpg");
	      } else {
	         // 파일 복사
	         try {
	        	 FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
		         FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(fileSimri));
	            
	         } catch (IOException e) {
	            e.printStackTrace();
	         }
	         communityDTO.setImage(fileName);
	      }
		
		communityService.viewModify(communityDTO);
		

	}//공지사항 수정등록
	
	
}















