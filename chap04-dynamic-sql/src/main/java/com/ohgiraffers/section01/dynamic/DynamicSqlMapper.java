package com.ohgiraffers.section01.dynamic;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;

import java.util.List;
import java.util.Map;

public interface DynamicSqlMapper {
    List<MenuDTO> selectMenuByPrice(Map<String, Integer> map);

    List<MenuDTO> searchMenu(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenuBySupCategory(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenuByRandomCode(Map<String, List<Integer>> criteria);

    List<MenuDTO> searchMenuByNameOrCategory(Map<String, Object> criteria);

    List<MenuDTO> searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria);

    int modifyMenu(Map<String, Object> criteria);
}
