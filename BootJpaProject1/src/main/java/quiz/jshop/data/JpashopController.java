package quiz.jshop.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JpashopController {
	
	@Autowired
	JpashopDao dao;
	
	@GetMapping("/")
	public String start()
	{
		return "redirect:shop/shopform";
	}
	
	@GetMapping("shop/shopform")
	public String form()
	{
		return "shopaddform";
	}
	
	@PostMapping("shop/insert")
	public String insert(@ModelAttribute JpashopDto dto)
	{
		
		dao.insertShop(dto);
		return "redirect:shopform";
	}
	
	@GetMapping("shop/list")
	public ModelAndView list()
	{
		ModelAndView mview = new ModelAndView();
		
		//dao 
		List<JpashopDto> list = dao.getAllDatas();
		
		//저장
		mview.addObject("list", list);
		mview.addObject("tcount", list.size());
		mview.setViewName("shoplist");
		return mview;
		
	}
	
	@GetMapping("shop/detail")
	public ModelAndView detail(@RequestParam int num)
	{
		ModelAndView mview = new ModelAndView();
		
		JpashopDto dto = dao.getData(num);
		
		mview.addObject("dto", dto);
		mview.setViewName("detailshop");
		
		return mview;
	}
	
}
