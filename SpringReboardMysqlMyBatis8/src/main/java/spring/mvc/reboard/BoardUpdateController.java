package spring.mvc.reboard;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import reboard.data.model.ReboardDao;
import reboard.data.model.ReboardDto;

@Controller
public class BoardUpdateController {
	
	@Autowired
	ReboardDao dao;
	
	@GetMapping("/board/updatepassform")
	public ModelAndView upassform(@RequestParam String num, @RequestParam String currentPage)
	{
		ModelAndView model = new ModelAndView();
		
		model.addObject("num", num);
		model.addObject("currentPage", currentPage);
		
		model.setViewName("updatepassform");
		return model;
	}
	
	@PostMapping("/board/updatepass")
	public ModelAndView upass(@RequestParam int num, @RequestParam int pass, @RequestParam int currentPage)
	{
		ModelAndView model = new ModelAndView();
		
		//비번이 맞으면 수정폼.. 틀리면 passfail
		int check = dao.getCheckPass(num, pass);
		System.out.println(check);
		
		if(check==1)
		{
			//dto 얻는다(수정폼으로 가야하므로)
			ReboardDto dto = dao.getData(num);
			
			model.addObject("dto", dto);
			model.addObject("currentPage", currentPage);
			model.setViewName("updateform"); //포워드
		}else 
		{
			model.setViewName("passfail");
		}
		
		return model;
	}
	
	@PostMapping("/board/update")
	public String update(@ModelAttribute ReboardDto dto,
			@RequestParam ArrayList<MultipartFile> upload,
			HttpSession session, @RequestParam String currentPage)
	{
		String path = session.getServletContext().getRealPath("/WEB-INF/photo");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		System.out.println(path);
		
		String photo = "";
		
		//사진선택안했을경우 no, 했을경우는 ,로 나열
		if(upload.get(0).getOriginalFilename().equals(""))
			photo = "no";
		else {
			for(MultipartFile f:upload)
			{
				String fName = "f_" +sdf.format(new Date()) + f.getOriginalFilename();
				photo+=fName+",";
				
				try {
					f.transferTo(new File(path + "\\" + fName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			   photo = photo.substring(0, photo.length() - 1);
	      }
	      //dto에 photo 넣기
	      dto.setPhoto(photo);
	      dao.updateReboard(dto);
	      
	      return "redirect:content?num=" + dto.getNum() + "&currentPage=" + currentPage;
	   }
}
