package boot.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import boot.model.PersonDto;

@Controller
public class FormController {
	
	
	@GetMapping("/sist/form1")
	public String form1()
	{
		return "form/form1"; //WEB-INF/board/ 까지 등록
	}
	@GetMapping("/sist/form2")
	public String form2()
	{
		return "form/form2";
	}
	@GetMapping("/sist/form3")
	public String form3()
	{
		return "form/form3";
	}
	
	//@PostMapping("/sist/read1")
	//public String result1(@RequestParam String name, @RequestParam String java, @RequestParam String spring, Model model)
	//{
	//	model.addAttribute("name", name);
	//	model.addAttribute("java", java);
	//	model.addAttribute("spring", spring);
	//	return "result/result1" ;
	//}
	
	@PostMapping("/sist/read1")
	public ModelAndView readForm1(String name, int java, int spring)
	{
		ModelAndView mview = new ModelAndView();
		
		mview.addObject("name", name);
		mview.addObject("java", java);
		mview.addObject("spring", spring);
		mview.addObject("tot", spring+java);
		mview.addObject("avg", (spring+java)/2.0);
		
		//포워드 경로
		mview.setViewName("result/result1");
		
		return mview;
	}
	
	
	@PostMapping("/sist/read2")
	public String formRead2(@ModelAttribute("dto") PersonDto dto)
	{
		
		return "result/result2";
	}
	
	@PostMapping("/sist/read3")
	//map으로 읽을 경우 폼의 name이 key값으로 입력값이 value값으로 저장
	public ModelAndView formRead3(@RequestParam Map<String, String> map)
	{
		ModelAndView model = new ModelAndView();
		
		model.addObject("name", map.get("name"));
		model.addObject("blood", map.get("blood"));
		model.addObject("hp", map.get("hp"));
		
		model.setViewName("result/result3");
		
		return model;
	}
	
}
