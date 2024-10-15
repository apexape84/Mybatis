package com.ohgiraffers.section01.dynamic;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.common.Template.getSqlSession;

public class MenuService {
    private DynamicSqlMapper mapper;
    public void selectMenuByPrice(int price) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        /* hashmap을 사용해서 key값으로 접근하거나 dto를 사용해서 getter 메소드로 접근 */

        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("price", price);

        List<MenuDTO> menuList = mapper.selectMenuByPrice(map);

        if(menuList != null && menuList.size() > 0){
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        }else System.out.println("검색 결과가 없습니다.");

        sqlSession.close();
    }

    public void searchMenu(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenu(searchCriteria);

        if(menuList != null && menuList.size() > 0){
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        }else System.out.println("검색 결과가 없습니다.");

        sqlSession.close();
    }

    public void searchMenuBySupCategory(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenuBySupCategory(searchCriteria);

        if(menuList != null && menuList.size() > 0){
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        }else System.out.println("검색 결과가 없습니다.");

        sqlSession.close();
    }

    public void searchMenuByRandomCode(List<Integer> randomCodeList) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        Map<String, List<Integer>> criteria = new HashMap<>();

        criteria.put("randomCodeList", randomCodeList);

        List<MenuDTO> menuList = mapper.searchMenuByRandomCode(criteria);

        if(menuList != null && menuList.size() > 0){
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        }else System.out.println("검색 결과가 없습니다.");

        sqlSession.close();
    }

    public void searchMenuByNameOrCategory(Map<String, Object> criteria) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenuByNameOrCategory(criteria);

        if(menuList != null && menuList.size() > 0){
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        }else System.out.println("검색 결과가 없습니다.");

        sqlSession.close();
    }

    public void searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenuByCodeOrSearchAll(searchCriteria);

        if(menuList != null && menuList.size() > 0) {
            for (MenuDTO menu : menuList) {
                System.out.println(menu);
            }
        } else {
            System.out.println("검색 결과 없습니다.");
        }

        sqlSession.close();

    }

    public void modifyMenu(Map<String, Object> criteria) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        int result = mapper.modifyMenu(criteria);

        if(result > 0) {
            System.out.println("메뉴 정보 변경에 성공했습니다");
            sqlSession.commit();
        } else {
            System.out.println("메뉴변경 실패");
            sqlSession.rollback();
        }

        sqlSession.close();
    }
}
