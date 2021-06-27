package post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/post")
public class PostController {
	
	@RequestMapping(value = "/writeManage", method = RequestMethod.GET)
	public String writeManage(Model model) { 
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
}
