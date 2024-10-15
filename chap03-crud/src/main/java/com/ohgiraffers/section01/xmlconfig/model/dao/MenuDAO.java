package com.ohgiraffers.section01.xmlconfig.model.dao;

import com.ohgiraffers.section01.xmlconfig.model.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {
    public List<MenuDTO> selectAllMenu(SqlSession sqlSession){
        return  sqlSession.selectList("MenuMapper.selectAllMenu");
    }

    public MenuDTO selectMenuByMenuCode(SqlSession sqlSession,int code) {
        return  sqlSession.selectOne("MenuMapper.selectMenuByMenuCode", code);
    }

    public int insertNewMenu(SqlSession sqlSession, MenuDTO newMenu) {
        return  sqlSession.insert("MenuMapper.insertNewMenu", newMenu);
    }

    public int updateMenu(SqlSession sqlSession, MenuDTO modifyMenu) {
        return  sqlSession.update("MenuMapper.updateMenu", modifyMenu);
    }

    public int deleteMenu(SqlSession sqlSession, int code) {
        return  sqlSession.delete("MenuMapper.deleteMenuByMenuCode", code);
    }
}
