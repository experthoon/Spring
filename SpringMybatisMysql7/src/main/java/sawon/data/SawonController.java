package sawon.data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SawonController {
	
	@Autowired
	SawonDaoInter dao;
	
	//�����
	@GetMapping("/sawon/form")
	public String form()
	{
		return "sawon/addform";
	}
	
	@GetMapping("sawon/list") //�ε���
	public ModelAndView list(@RequestParam(required = false) String title,
			@RequestParam(required = false) String search)
	{
		ModelAndView model = new ModelAndView();
		
		//��ü����
		int totalCount = dao.getTotalCount();
		
		System.out.println(title + "," + search);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("title", title);
		map.put("search", search);
		
		//��üȸ������Ʈ
		List<SawonDto> totalList = dao.getAllDatas(map);
		
		model.addObject("totalCount", totalCount); //totalCount�� �޾Ƽ� �̸��� totalCount�� ����
		model.addObject("totalList", totalList);
		model.setViewName("sawon/sawonlist"); //������ ���ϸ�
		return model; //���� ���� ����
	}
	
	@PostMapping("/sawon/insert")
	public String inesert(@ModelAttribute SawonDto dto, 
			@RequestParam MultipartFile upload, // suvlet xml Ȯ�� upload
			HttpSession session) 
	{
		String path = session.getServletContext().getRealPath("WEB-INF/image");
		System.out.println(path);
		
		//dto�� ���� ����
		String photoname;
		
		//���������� ������ ��� no, ���� ���
		if(upload.getOriginalFilename().equals(""))
			photoname = "no";
		else {
			String fName = upload.getOriginalFilename();
			photoname = fName; //�̹��� �̸� ��
			
			//���ε�
			try {
				upload.transferTo(new File(path + "\\" + photoname));
				
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//dto�� photo�� ���ε��� photoname �־��ֱ�
		dto.setPhoto(photoname);
		
		//insert
		dao.insertSawon(dto);
		return "redirect:list";
	}
	
	//������
	@GetMapping("/sawon/updateform")
	public String uform(@RequestParam String num, Model model)
	{
		
		SawonDto dto = dao.getData(num);
		model.addAttribute("dto", dto);
		return "sawon/updateform";
	}
	
	//�̹��� ���� ��� �ʵ� ��� ����
	/*
	 * @PostMapping("/sawon/update") public String update(@ModelAttribute SawonDto
	 * dto,
	 * 
	 * @RequestParam MultipartFile upload, // suvlet xml Ȯ�� upload HttpSession
	 * session) { String path =
	 * session.getServletContext().getRealPath("WEB-INF/image");
	 * System.out.println(path);
	 * 
	 * //dto�� ���� ���� String photoname = "";
	 * 
	 * photoname = upload.getOriginalFilename();
	 * 
	 * //���ε� try { upload.transferTo(new File(path + "\\" + photoname));
	 * 
	 * } catch (IllegalStateException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } } //dto�� photo�� ���ε��� photoname �־��ֱ�
	 * dto.setPhoto(photoname);
	 * 
	 * //insert dao.updateSawon(dto); return "redirect:list"; }
	 */
	
	@PostMapping("/sawon/update")
	public String update(@ModelAttribute SawonDto dto, 
			@RequestParam MultipartFile upload, // suvlet xml Ȯ�� upload
			HttpSession session) 
	{
		String path = session.getServletContext().getRealPath("WEB-INF/image");
		System.out.println(path);
		
		//dto�� ���� ����
		String photoname;
		
		//���������� ������ ��� null, ���� ���
		if(upload.getOriginalFilename().equals(""))
			photoname = null;
		else {
			String fName = upload.getOriginalFilename();
			photoname = fName; //�̹��� �̸� ��
			
			//���ε�
			try {
				upload.transferTo(new File(path + "\\" + photoname));
				
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//dto�� photo�� ���ε��� photoname �־��ֱ�
		dto.setPhoto(photoname);
		
		//update
		dao.updateSawon(dto);
		return "redirect:list";
	}
	
	@GetMapping("/sawon/delete")
	public String deleteform(@RequestParam String num, HttpSession session)
	{
		
		String path = session.getServletContext().getRealPath("WEB-INF/image");
		String photo = dao.getData(num).getPhoto();
		
		File file = new File(path + "\\" + photo);
		if(file.exists())
			file.delete();
		dao.deleteSawon(num);
		return "redirect:list";
		
		
	}
	
	
}
