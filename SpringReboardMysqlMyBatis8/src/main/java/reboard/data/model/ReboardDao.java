package reboard.data.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReboardDao implements ReboardDaoInter {
	
	@Autowired
	private SqlSession session;
	
	public int getTotalCount() {
		return session.selectOne("getTotalCountOfReboard");
	}

	@Override
	public int getMaxNum() {
		// TODO Auto-generated method stub
		return session.selectOne("MaxNumOfReboard");
	}

	@Override
	public void updateRestep(int regroup, int restep) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("regroup", regroup);
		map.put("restep", restep);
		
		session.update("updateStepOfReboard", map);
	}

	@Override
	public void insertReboard(ReboardDto dto) {
		// TODO Auto-generated method stub
		int num = dto.getNum(); //0: ����  1���� ū �� : ���
		int regroup = dto.getRegroup();
		int restep = dto.getRestep();
		int relevel = dto.getRelevel();
		
		if(num==0) //����
		{
			regroup = getMaxNum() + 1; //num�� �ִ밪 +1
			restep = 0;
			relevel = 0;
		}else { //����� ���
			
			//���� �׷��߿��� ���޹��� restep���� ū �۵��� ��� + 1
			updateRestep(regroup, restep);
			//���޹��� step�� level�� +1
			restep++;
			relevel++;
			
		}
		//�ٲﰪ���� �ٽ� dto�� ��´�
		dto.setRegroup(regroup);
		dto.setRestep(restep);
		dto.setRelevel(relevel);
		
		//insert
		session.insert("insertOfReboard", dto);
	}

	@Override
	public List<ReboardDto> getList(int start, int perpage) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("start", start);
		map.put("perpage", perpage);
		return session.selectList("getAllPagingOfReboard", map);
	}

	@Override
	public void updateReadcount(int num) {
		session.update("updateReadCountOfReboard",num);
	}

	@Override
	public ReboardDto getData(int num) {
		return session.selectOne("getDataOfReboard", num);
	}

	@Override
	public int getCheckPass(int num, int pass) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", num);
		map.put("pass", pass);
		
		return session.selectOne("checkEqualPassOfReboard", map);
		
		
	}

	@Override
	public void deleteBoard(int num) {
		
		session.delete("deleteOfReboard", num);
	}

	@Override
	public void updateReboard(ReboardDto dto) {
		// TODO Auto-generated method stub
		session.update("updateOfReboard", dto);
	}

	@Override
	public List<ReboardDto> getAllDatas() {
		// TODO Auto-generated method stub
		return session.selectList("selectAllOfReboard");
	}
}