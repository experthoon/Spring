package sawon.data;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SawonDao implements SawonDaoInter {

	@Autowired
	private SqlSession session;
	
	@Override
	public int getTotalCount() {
		return session.selectOne("getTotalCountOfSawon"); //파라미터 값 없으면 하나짜리로 하기
	}

	@Override
	public void insertSawon(SawonDto dto) {
		 session.insert("insertOfSawon", dto);
	}

	@Override
	public List<SawonDto> getAllDatas(Map<String, String> map) {
		return session.selectList("getAllDatasOfSawon", map);
	}

	@Override
	public SawonDto getData(String num) {
		return session.selectOne("getOneDataOfSawon", num);
	}

	@Override
	public void updateSawon(SawonDto dto) {
		session.update("updateOfSawon", dto);
	}

	@Override
	public void deleteSawon(String num) {
		session.delete("deleteOfSawon", num);
	}
	
}
