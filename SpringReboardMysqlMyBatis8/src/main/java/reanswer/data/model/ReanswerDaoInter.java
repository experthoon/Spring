package reanswer.data.model;

import java.util.List;

public interface ReanswerDaoInter {
	public void insertReanswer(ReanswerDto dto);
	public List<ReanswerDto> getAnswerList(int num);
	public int getAnswerCheckPass(int idx, int pass);
	public void deleteReanswer(int idx);
}
