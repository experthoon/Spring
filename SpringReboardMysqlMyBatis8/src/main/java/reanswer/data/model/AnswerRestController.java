package reanswer.data.model;



import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reboard.data.model.ReboardDaoInter;
import reboard.data.model.ReboardDto;

@RestController
public class AnswerRestController {
	
	@Autowired
	ReanswerDao adao;
	@Autowired
	ReboardDaoInter dao;
	
	@GetMapping("board/adelete") //ajax�� url ��ġ
	public HashMap<String, Integer> answerDelete(@RequestParam int idx,
			@RequestParam int pass)
	{
		int check = adao.getAnswerCheckPass(idx, pass);
		
		if(check==1)
		{
			adao.deleteReanswer(idx);
		}
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("check", check);
		return map;
	}	
	
	
	//ajax
	@GetMapping("/rest/list1")
	public List<ReboardDto> ajaxlist()
	{
		List<ReboardDto> list = dao.getAllDatas();
		
		for(ReboardDto dto:list)
		{
			if(!dto.getPhoto().equals("no"))
			{
				String [] photos = dto.getPhoto().split(",");
				dto.setPhoto(photos[0]); //������ ù��° �������� �ֱ�
			}
		}
		
		return list;
	}
	
	
	/*public int delete(@RequestParam int idx, @RequestParam int pass)
	{
		int check = dao.getAnswerCheckPass(idx, pass);
		
		if(check==1)
		{
			dao.deleteReanswer(idx);
		}
		return check;
	}*/
	
}
