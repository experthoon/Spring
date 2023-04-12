package spring.mvc.reboard;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.Session;

import reboard.data.model.ReboardDao;

@Controller
public class BoardDeleteController {

	
	@Autowired
	ReboardDao dao;
	
	@GetMapping("/board/deletepassform")
	public ModelAndView dpassform(@RequestParam String num, @RequestParam String currentPage)
	{
		ModelAndView model = new ModelAndView();
		
		model.addObject("num", num);
		model.addObject("currentPage", currentPage);
		
		model.setViewName("deletepassform");
		return model;
	}
	
	//삭제 비밀번호 관련된 것은 포스트매핑
	@PostMapping("/board/delete") //서브밋 할때 액션이 delete
	public String delete(@RequestParam int num, @RequestParam String currentPage, @RequestParam int pass, HttpSession session)
	{
		//비번이 맞는지 체크
		int check = dao.getCheckPass(num, pass);
		
		if(check==0)
		{
			return "passfail";
		}
		else
		{
			//photo폴더의 사진 지우기
			String photo = dao.getData(num).getPhoto();
			
			if(!photo.equals("no"))
			{
				//,로분리
				String []fName = photo.split(",");
				
				//실제 업로드 경로
				String path = session.getServletContext().getRealPath("/WEB-INF/photo");
				
				for(String f:fName)
				{
					File file = new File(path + "\\" + f);
					file.delete();
				}
			}
			
			
			//db삭제
			dao.deleteBoard(num);
			return "redirect:list?currentPage=" + currentPage;
		}
		
	}
}
