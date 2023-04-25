package quiz.jshop.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JpashopDao {
	
	@Autowired
	JpashopDaoInter jshopInter;
	
	//insert
	public void insertShop(JpashopDto dto)
	{
		jshopInter.save(dto);
	}
	
	
	//select
	public List<JpashopDto> getAllDatas()
	{
		return jshopInter.findAll();
	}
	
	public JpashopDto getData(int num)
	{
		return jshopInter.getReferenceById(num);
	}
	
}
