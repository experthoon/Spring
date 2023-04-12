package reanswer.data.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReanswerDao implements ReanswerDaoInter {

	@Autowired
	private SqlSession session;
	
	
	@Override
	public void insertReanswer(ReanswerDto dto) {
			session.insert("insertOfReanswer", dto);
	}


	@Override
	public List<ReanswerDto> getAnswerList(int num) {
		return session.selectList("getNumAllDatasOfReanswer", num);
	}


	@Override
	public int getAnswerCheckPass(int idx, int pass) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("idx", idx);
		map.put("pass",pass);
		
		
		return session.selectOne("checkEqualPassOfReanswer", map);
	}


	@Override
	public void deleteReanswer(int idx) {
		
		session.delete("deleteOfReanswer", idx);
		
	}

}
