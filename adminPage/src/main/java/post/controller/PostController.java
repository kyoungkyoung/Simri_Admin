package post.controller;

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
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import community.bean.CommunityDTO;
import community.bean.CommunityPaging;
import community.bean.CommunitySearchPaging;
import post.bean.PostDTO;
import post.bean.PostPaging;
import post.bean.PostPaging2;
import post.service.PostService;

@Controller
@RequestMapping(value="/post")
public class PostController {
	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "/writeManage", method = RequestMethod.GET)
	public String writeManage(@RequestParam(required=false, defaultValue="1") String pg,
							  @RequestParam(required=false, defaultValue="최신순") String DHL1, Model model) { 
		model.addAttribute("pg", pg);
		model.addAttribute("DHL1", DHL1);
		model.addAttribute("display", "/post/writeManage.jsp");
		return "/section/login";
	}// writeForm()
	
//	@RequestMapping(value = "/postModify", method = RequestMethod.GET)
//	public String postModify(Model model) { 
//		model.addAttribute("display", "/post/postModify.jsp");
//		return "/section/login";
//	}// postModify()
	
	@RequestMapping(value = "/writeForm", method = RequestMethod.GET)
	public String writeForm(Model model) { 
		model.addAttribute("display", "/post/writeForm.jsp");
		return "/section/login";
	}// memberView()
	
	@RequestMapping(value="/postWrite", method=RequestMethod.POST)
	@ResponseBody
	public void postWrite(@ModelAttribute PostDTO postDTO, 
						  @RequestParam MultipartFile img) {
		
		//D:\Spring\FinalProject\git_Project\gitAdmin\adminPage\src\main\webapp\storage
		//C:\\git_home\\gitAdmin\\adminPage\\src\\main\\webapp\\storage
		String filePath = "C:\\programming\\Spring\\git\\gitAdmin\\adminPage\\src\\main\\webapp\\storage";
		String filePathSimri = "C:\\programming\\Spring\\git\\simriTest\\simri\\src\\main\\webapp\\storage";
		String fileName = img.getOriginalFilename();
		File file = new File(filePath, fileName);//파일 생성
		File fileSimri = new File(filePathSimri, fileName);//파일 생성
		
		if (fileName.equals("")) {
	         postDTO.setImage("null.jpg");
	      } else {
	         // 파일 복사
	         try {
	            FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
	            FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(fileSimri));
	         } catch (IOException e) {
	            e.printStackTrace();
	         }
	         postDTO.setImage(fileName);
	      }
		postDTO.setEmail("admin@gamil.com");
		postDTO.setNickname("admin");
		postDTO.setPalette("관리자");
		
		postService.postWrite(postDTO);
		
	}
	
	@RequestMapping(value="/getSimriPostList", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getSimriPostList(@RequestParam String comCategory, @RequestParam String DHL,
										 @RequestParam(required=false, defaultValue="1") String pg) {
		
		List<PostDTO> list = postService.getSimriPostList(pg, comCategory, DHL);
		
		//페이징 처리
		PostPaging2 postPaging2 = postService.postPaging2(pg, comCategory,DHL);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("comCategory", comCategory);
		mav.addObject("DHL", DHL);
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.addObject("postPaging2", postPaging2);
		mav.setViewName("jsonView");
		
		return mav;
		
	}

	
	@RequestMapping(value="/postSearch", method=RequestMethod.POST)
	@ResponseBody  
	public ModelAndView postSearch(@RequestParam String pg, @RequestParam String comCategory,
								   @RequestParam String postSearchText) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pg", Integer.parseInt(pg));
		map.put("comCategory", comCategory);
		map.put("postSearchText", postSearchText);
		
		List<PostDTO> list = postService.postSearch(map);
		
		PostPaging postPaging = postService.postSearchPaging(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", Integer.parseInt(pg));
		mav.addObject("list", list);
		mav.addObject("postPaging", postPaging);
		mav.setViewName("jsonView");
		
		return mav;
		
	}
	@RequestMapping(value="/postDelete")
	@ResponseBody
	public void communityDelete(@RequestParam String seq) {
		 postService.postDelete(seq);
	}
	
	@RequestMapping(value = "/postView", method = RequestMethod.GET)
	public String postView(@RequestParam String seq, Model model) {
		PostDTO postDTO = postService.getPostView(seq);
		
		model.addAttribute("postDTO", postDTO);
		model.addAttribute("seq", Integer.parseInt(seq));
		model.addAttribute("display", "/post/postView.jsp");
		return "/section/login"; 
	}// postModify() 
	
	@RequestMapping(value="viewModify", method=RequestMethod.POST)
	@ResponseBody
	public void viewModify(@ModelAttribute PostDTO postDTO,
			@RequestParam MultipartFile img) {
		
		//D:\Spring\FinalProject\git_Project\gitAdmin\adminPage\src\main\webapp\storage
		//C:\\git_home\\gitAdmin\\adminPage\\src\\main\\webapp\\storage
		String filePath = "D:\\Spring\\FinalProject\\git_Project\\gitAdmin\\adminPage\\src\\main\\webapp\\storage";
		String filePathSimri = "D:\\Spring\\FinalProject\\git_Project\\simriTest\\simri\\src\\main\\webapp\\storage";
		String fileName = img.getOriginalFilename();
		File file = new File(filePath, fileName);//파일 생성
		File fileSimri = new File(filePathSimri, fileName);//파일 생성
		
		if (fileName.equals("")) {
			postDTO.setImage("null.jpg");
	      } else {
	         // 파일 복사
	         try {
	            FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
	            FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(fileSimri));
	         } catch (IOException e) {
	            e.printStackTrace();
	         }
	         postDTO.setImage(fileName);
	      }
		
		postService.viewModify(postDTO);
		
	}//공지사항 수정등록
	
//----------------------------연애심리--------------------
	
	@RequestMapping(value = "/writeLove", method = RequestMethod.GET)
	public String writeLove(@RequestParam(required=false, defaultValue="1") String pg,
							@RequestParam(required=false, defaultValue="최신순") String DHL1, Model model) { 
		model.addAttribute("pg", pg);
		model.addAttribute("DHL1", DHL1);
		model.addAttribute("display", "/post/writeLove.jsp");
		return "/section/login";
	}// 
	
	@RequestMapping(value = "/loveWriteForm", method = RequestMethod.GET)
	public String loveWriteForm(Model model) { 
		model.addAttribute("display", "/post/loveWriteForm.jsp");
		return "/section/login";
	}// 글쓰기
	
	@RequestMapping(value="/loveWrite", method=RequestMethod.POST)
	@ResponseBody
	public void loveWrite(@ModelAttribute PostDTO postDTO, 
						  @RequestParam MultipartFile img) {
		
		//D:\Spring\FinalProject\git_Project\gitAdmin\adminPage\src\main\webapp\storage
		//C:\\git_home\\gitAdmin\\adminPage\\src\\main\\webapp\\storage
		String filePath = "C:\\programming\\Spring\\git\\gitAdmin\\adminPage\\src\\main\\webapp\\storage";
		String filePathSimri = "C:\\programming\\Spring\\git\\simriTest\\simri\\src\\main\\webapp\\storage";
		String fileName = img.getOriginalFilename();
		File file = new File(filePath, fileName);//파일 생성
		File fileSimri = new File(filePathSimri, fileName);//파일 생성
		
		if (fileName.equals("")) {
	         postDTO.setImage("null.jpg");
	      } else {
	         // 파일 복사
	         try {
	            FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
	            FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(fileSimri));
	         } catch (IOException e) {
	            e.printStackTrace();
	         }
	         postDTO.setImage(fileName);
	      }
		postDTO.setEmail("admin@gamil.com");
		postDTO.setNickname("admin");
		postDTO.setPalette("관리자");
		
		postService.loveWrite(postDTO);
		
	}
	
	@RequestMapping(value="/getLovePostList", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getLovePostList(@RequestParam String comCategory, @RequestParam String DHL,
										@RequestParam(required=false, defaultValue="1") String pg) {
		
		List<PostDTO> list = postService.getLovePostList(pg, comCategory, DHL);
		
		//페이징 처리
		PostPaging2 postPaging2 = postService.postPaging2(pg, comCategory,DHL);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("comCategory", comCategory);
		mav.addObject("DHL", DHL);
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.addObject("postPaging2", postPaging2);
		mav.setViewName("jsonView");
		
		return mav;
		
	}
	
	@RequestMapping(value = "/loveView", method = RequestMethod.GET)
	public String loveView(@RequestParam String seq, Model model) {
		PostDTO postDTO = postService.getLoveView(seq);
		
		model.addAttribute("postDTO", postDTO);
		model.addAttribute("seq", Integer.parseInt(seq));
		model.addAttribute("display", "/post/loveView.jsp");
		return "/section/login"; 
	}// postModify() 
	
	
}









