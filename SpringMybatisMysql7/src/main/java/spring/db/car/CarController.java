package spring.db.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {

	@Autowired
	MyCarDao dao;
	
	@GetMapping("/samsung/list")
	public String list(Model model)
	{
		//전체개수
		int totalCount = dao.getTotalCount();
		
		//목록가져오기
		List<MyCarDto> list = dao.getAllDatas();
		
		
		//request에 저장
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		
		return "car/carlist";
	}

	@GetMapping("/samsung/writeform")
	public String carform()
	{
		return "car/writeform";
	}
	
	//insert
	@PostMapping("/samsung/write")
	public String insert(@ModelAttribute MyCarDto dto)
	{
		dao.insertMyCar(dto);
		return "redirect:list";
	}
	
	//수정폼으로 가기
	@GetMapping("/samsung/updateform")
	public String updateform(@RequestParam String num, Model model)
	{
		//dto 가져오기
		MyCarDto dto = dao.getData(num);
		
		//저장
		model.addAttribute("dto", dto);
		return "car/updateform";
	}
	
	//update
	@PostMapping("/samsung/update")
	public String update(@ModelAttribute MyCarDto dto)
	{
		dao.updateMyCar(dto);
		return "redirect:list";
	}
	
	//delete
	@GetMapping("/samsung/delete")
	public String deleteform(@RequestParam String num)
	{
		dao.deleteMyCar(num);
		return "redirect:list";
	}
	
}
