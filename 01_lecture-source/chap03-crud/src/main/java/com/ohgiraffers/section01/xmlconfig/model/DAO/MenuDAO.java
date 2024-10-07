package com.ohgiraffers.section01.xmlconfig.model.DAO;

import com.ohgiraffers.section01.xmlconfig.model.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {
    public List<MenuDTO> selectAllMenu(SqlSession sqlSession){
        return  sqlSession.selectList("MenuMapper.selectAllMenu");
    }
}
