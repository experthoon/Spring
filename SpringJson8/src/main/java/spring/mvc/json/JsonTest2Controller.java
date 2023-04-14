package spring.mvc.json;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController /*Json전용이므로 일반메서드 안됨*/
public class JsonTest2Controller {

	@GetMapping("/list2")
	public List<PhotoDto> list2()
	{
		List<PhotoDto> list = new ArrayList<PhotoDto>();
		
		list.add(new PhotoDto("그림1", "01.png"));
		list.add(new PhotoDto("그림2", "02.png"));
		list.add(new PhotoDto("그림3", "03.png"));
		list.add(new PhotoDto("그림4", "04.png"));
		list.add(new PhotoDto("그림5", "05.png"));
		list.add(new PhotoDto("그림6", "06.png"));
		list.add(new PhotoDto("그림7", "07.png"));
		list.add(new PhotoDto("그림8", "08.png"));
		list.add(new PhotoDto("그림9", "09.png"));
		list.add(new PhotoDto("그림10", "10.png"));
		return list;
	}
	
	@GetMapping("/list3")
	public List<PhotoDto> list3()
	{
		List<PhotoDto> list = new ArrayList<PhotoDto>();
		
		list.add(new PhotoDto("그림1", "01.png"));
		list.add(new PhotoDto("그림2", "02.png"));
		list.add(new PhotoDto("그림3", "03.png"));
		list.add(new PhotoDto("그림4", "04.png"));
		list.add(new PhotoDto("그림5", "05.png"));
		list.add(new PhotoDto("그림6", "06.png"));
		list.add(new PhotoDto("그림7", "07.png"));
		list.add(new PhotoDto("그림8", "08.png"));
		list.add(new PhotoDto("그림9", "09.png"));
		list.add(new PhotoDto("그림10", "10.png"));
		return list;
	}
	
}
