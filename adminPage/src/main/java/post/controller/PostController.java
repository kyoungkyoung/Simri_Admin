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

import community.bean.CommunityPaging;
import community.bean.CommunitySearchPaging;
import post.bean.PostDTO;
import post.bean.PostPaging;
import post.service.PostService;

@Controller
@RequestMapping(value="/post")
public class PostController {
	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "/writeManage", method = RequestMethod.GET)
	public String writeManage(@RequestParam(required=false, defaultValue="1") String pg, Model model) { 
		model.addAttribute("pg", pg);
		model.addAttribute("display", "/post/writeManage.jsp");
		return "/section/login";
	}// writeForm()
	
	@RequestMapping(value = "/postModify", method = RequestMethod.GET)
	public String postModify(Model model) { 
		model.addAttribute("display", "/post/postModify.jsp");
		return "/section/login";
	}// postModify()
	
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
		String filePath = "D:\\Spring\\FinalProject\\git_Project\\gitAdmin\\adminPage\\src\\main\\webapp\\storage";
		String fileName = img.getOriginalFilename();
		File file = new File(filePath, fileName);//파일 생성
		
		if (fileName.equals("")) {
	         postDTO.setImage("null.jpg");
	      } else {
	         // 파일 복사
	         try {
	            FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
	         } catch (IOException e) {
	            e.printStackTrace();
	         }
	         postDTO.setImage(fileName);
	      }
		postDTO.setEmail("admin@gamil.com");
		postDTO.setNickname("admin");
		postDTO.setPalette("관리자");
		
		System.out.println(postDTO);
		
		postService.postWrite(postDTO);
		
	}
	
	@RequestMapping(value="/getSimriPostList", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getSimriPostList(@RequestParam String comCategory, @RequestParam String pg) {
		
		System.out.println(comCategory+pg);
		
		List<PostDTO> list = postService.getSimriPostList(pg, comCategory);
		
		//페이징 처리
		PostPaging postPaging = postService.postPaging(pg, comCategory);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("comCategory", comCategory);
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.addObject("postPaging", postPaging);
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
	
}









