package com.company.reply.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.company.reply.dto.ReplyDTO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "com.company.mapper.replyMapper";
	
	@Override
	public List<ReplyDTO> replyList(int borderId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(Namespace+".replyList",borderId);
	}

	@Override
	public int replyWrite(ReplyDTO replyDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(Namespace+".replyWrite",replyDTO);
	}

	@Override
	public int replyUpdate(ReplyDTO replyDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(Namespace+".replyUpdate",replyDTO);
	}

	@Override
	public int replyDelete(int replyId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(Namespace+".replyDelete",replyId);
	}

	@Override
	public int replyCnt(int borderId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(Namespace+".replyCnt",borderId);
	}

}
