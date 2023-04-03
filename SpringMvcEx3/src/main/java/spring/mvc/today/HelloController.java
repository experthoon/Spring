package spring.mvc.today;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	
	@GetMapping("/happy")
	public String one()
	{
		return "nice";
	}
	
	@GetMapping("/hello")
	public String two(Model model)
	{
		model.addAttribute("msg", "msg�� ����");
		
		return "hello";
	}
	
	@GetMapping("/nice/hi")
	public String three(Model model)
	{
		model.addAttribute("name", "�躴��");
		model.addAttribute("addr", "����� ������");
		
		return "nace";
	}
}
