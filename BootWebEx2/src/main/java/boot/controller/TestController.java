package boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	
	@GetMapping("/")
	public ModelAndView list()
	{
		ModelAndView model = new ModelAndView();
		
		//모델에 저장
		model.addObject("name", "KIM BYUNG HUN");
		model.addObject("addr", "서울시 성동구");
		model.addObject("hp", "010-5190-3967");
		
		//포워드
		model.setViewName("redirect:sist/home");
		return model;
		
		
	}
}
