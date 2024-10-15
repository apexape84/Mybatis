package com.ohgiraffers.section01.xmlmapper;

import com.ohgiraffers.common.CategoryAndMenuDTO;
import com.ohgiraffers.common.MenuAndCategoryDTO;
import com.ohgiraffers.common.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

public class ElementService {
    private ElementMapper mapper;
    public void selectCacheTest() {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementMapper.class);

        for(int i=0; i<10; i++){
            Long stTime = System.currentTimeMillis();
            List<String> menuNameList = mapper.selectCacheTest();
            System.out.println("menuNameList = " + menuNameList);
            Long edTime = System.currentTimeMillis();
            Long itvTime = edTime - stTime;
            System.out.println("itvTime = " + itvTime);
        }
        sqlSession.close();
    }

    public void selectResultMapTest() {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementMapper.class);

        List<MenuDTO> menuList = mapper.selectResultMapTest();

        for(MenuDTO menu : menuList){
            System.out.println("menu = " + menu);
        }
        sqlSession.close();
    }

    public void selectResultMapConstructor() {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementMapper.class);

        List<MenuDTO> menuList = mapper.selectResulMapConstructor();

        for(MenuDTO menu : menuList){
            System.out.println("menu = " + menu);
        }
        sqlSession.close();
    }

    public void selectResultMapAssociation() {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementMapper.class);

        List<MenuAndCategoryDTO> menuList = mapper.selectResultMapAssociation();

        for(MenuAndCategoryDTO menu : menuList){
            System.out.println(menu);
        }
        sqlSession.close();
    }

    public void selectResultMapCollection() {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementMapper.class);

        List<CategoryAndMenuDTO> menuList = mapper.selectResultMapCollection();

        for(CategoryAndMenuDTO menu : menuList){
            System.out.println(menu);
        }
        sqlSession.close();
    }

    public void selectSql() {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementMapper.class);

        List<MenuDTO> menuList = mapper.selectSqlTest();

        for(MenuDTO menu : menuList){
            System.out.println("menu = " + menu);
        }
        sqlSession.close();
    }
}
