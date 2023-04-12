package spring.mvc.reboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import reanswer.data.model.ReanswerDao;
import reboard.data.model.ReboardDao;
import reboard.data.model.ReboardDto;

@Controller
public class BoardListController {

	
	@Autowired
	ReboardDao dao;
	
	@Autowired
	ReanswerDao adao;
	
	@GetMapping("/") //시작지점
	public String start()
	{
		return "redirect:board/list";
	}
	
	@GetMapping("/board/list")
	public ModelAndView list(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage)
	{
		ModelAndView model = new ModelAndView();
		
		//총글의 개수
		int totalCount = dao.getTotalCount();
		
		int totalPage;
		int startPage;
		int endPage;
		int start;
		int perPage=3;
		int perBlock=5;
	
		
		//총 페이지 개수
		totalPage = totalCount / perPage + (totalCount % perPage == 0 ? 0 : 1);
		//각블럭의 시작페이지.. 현재페이지가 3(s:1, e:5)  6(s:6, e:10)
		startPage = (currentPage - 1) / perBlock * perBlock + 1;
		endPage = startPage + perBlock - 1;
		//총페이지가8 (6~10 ... endpage를 8로 수정해주어야함.)
		if (endPage > totalPage)
		   endPage = totalPage;
		//각페이지에서 불러올 시작번호
		start = (currentPage - 1) * perPage;
		//각페이지에서 필요한 게시글 가져오기
		List<ReboardDto> list = dao.getList(start, perPage);
		
		
		//list에 각글에 대한 댓글개수 추가하기
		for(ReboardDto d:list)
		{
			d.setAcount(adao.getAnswerList(d.getNum()).size());
		}
		
		
		//각 페이지에 출력할 시작번호
		int no = totalCount-(currentPage-1)*perPage;
		
		//출력에 필요한 변수들을 model에 저장
		model.addObject("totalCount", totalCount);
		model.addObject("list", list); //댓글 포함한 후 전달
		model.addObject("totalPage", totalPage);
		model.addObject("startPage", startPage);
		model.addObject("endPage", endPage);
		model.addObject("perBlock", perBlock);
		model.addObject("currentPage", currentPage);
		model.addObject("no", no);
	
		model.setViewName("boardlist");
		
		return model;
	}
	
}
