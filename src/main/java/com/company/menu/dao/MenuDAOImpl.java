package com.company.menu.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.company.border.main.Criteria;
import com.company.menu.dto.MenuDTO;

@Repository
public class MenuDAOImpl implements MenuDAO {


	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "com.company.mapper.menuMapper";
	
	@Override
	public List<MenuDTO> menuList(Criteria criteria) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(Namespace+".menuList",criteria);
	}

	@Override
	public int menuWrite(MenuDTO menuDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(Namespace+".menuWrite",menuDTO);
	}

	@Override
	public int menuUpdate(MenuDTO menuDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int menuDelete(int menuId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MenuDTO menuView(int menuId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(Namespace+".menuView",menuId);
	}

	@Override
	public int menuCnt(Criteria criteria) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void menuViewCnt(int menuId) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void replyCnt(int menuId) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void replyDeleteCnt(int menuId) throws Exception {
		// TODO Auto-generated method stub

	}

}
