package spring.mvc.json;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController /*Json�����̹Ƿ� �Ϲݸ޼��� �ȵ�*/
public class JsonTest2Controller {

	@GetMapping("/list2")
	public List<PhotoDto> list2()
	{
		List<PhotoDto> list = new ArrayList<PhotoDto>();
		
		list.add(new PhotoDto("�׸�1", "01.png"));
		list.add(new PhotoDto("�׸�2", "02.png"));
		list.add(new PhotoDto("�׸�3", "03.png"));
		list.add(new PhotoDto("�׸�4", "04.png"));
		list.add(new PhotoDto("�׸�5", "05.png"));
		list.add(new PhotoDto("�׸�6", "06.png"));
		list.add(new PhotoDto("�׸�7", "07.png"));
		list.add(new PhotoDto("�׸�8", "08.png"));
		list.add(new PhotoDto("�׸�9", "09.png"));
		list.add(new PhotoDto("�׸�10", "10.png"));
		return list;
	}
	
	@GetMapping("/list3")
	public List<PhotoDto> list3()
	{
		List<PhotoDto> list = new ArrayList<PhotoDto>();
		
		list.add(new PhotoDto("�׸�1", "01.png"));
		list.add(new PhotoDto("�׸�2", "02.png"));
		list.add(new PhotoDto("�׸�3", "03.png"));
		list.add(new PhotoDto("�׸�4", "04.png"));
		list.add(new PhotoDto("�׸�5", "05.png"));
		list.add(new PhotoDto("�׸�6", "06.png"));
		list.add(new PhotoDto("�׸�7", "07.png"));
		list.add(new PhotoDto("�׸�8", "08.png"));
		list.add(new PhotoDto("�׸�9", "09.png"));
		list.add(new PhotoDto("�׸�10", "10.png"));
		return list;
	}
	
}
