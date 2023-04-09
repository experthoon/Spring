package spring.db.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarMemberDao {

	@Autowired
	private SqlSession session;
	
	//총갯수
	public int getTotalCount()
	{
		return session.selectOne("getTotalCountOfMyCarMember");
	}
	
	//전체데이터
	public List<CarMemberDto> getAllDatas()
	{
		return session.selectList("getAllDatasOfCarMember");
	}
	
	//insert
	public void insertCarMember(CarMemberDto dto)
	{
		session.insert("insertOfCarMember", dto);
	}
	
	//수정폼
	public CarMemberDto getData(String num)
	{
		return session.selectOne("getOneDataOfCarMember", num);
	}
	
	//수정
	public void updateCarMember(CarMemberDto dto)
	{
		session.update("updateOfCarMember", dto);
	}
	
	//삭제
	public void deleteCarMember(String num)
	{
		session.delete("deleteOfCarMember", num);
	}

}
