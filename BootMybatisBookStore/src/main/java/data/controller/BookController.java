package data.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import data.dto.BookDto;
import data.mapper.BookMapperInter;

@Controller
public class BookController {
	
	@Autowired
	BookMapperInter mapper;
	
	@GetMapping("/")
	public String start()
	{
		return "redirect:book/list";
	}
	
	@GetMapping("/book/list")
	public ModelAndView list()
	{
		ModelAndView mview = new ModelAndView();
		
		int totalCount = mapper.getTotalCount();
		
		//list
		List<BookDto> list = mapper.getAllDatas();
		
		mview.addObject("list", list);
		mview.addObject("totalCount", totalCount);
		mview.setViewName("booklist");
		return mview;
	}
	
	@GetMapping("/book/form")
	public String form()
	{
		return "addform";
	}
	
	@PostMapping("/book/insert")
	public String insert(@ModelAttribute BookDto dto, @RequestParam MultipartFile photo, HttpSession session)
	{
		String path = session.getServletContext().getRealPath("/image");
		System.out.println(path);
		
		if(photo.getOriginalFilename().equals(""))
			dto.setBookphoto(null);
		else {
			String photoname=photo.getOriginalFilename();
			dto.setBookphoto(photoname);
			
			try {
				photo.transferTo(new File(path + "\\" + photoname));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		mapper.insertBook(dto);
		
		return "redirect:list";
	}
}
