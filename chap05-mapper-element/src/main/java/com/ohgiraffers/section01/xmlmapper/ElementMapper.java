package com.ohgiraffers.section01.xmlmapper;

import com.ohgiraffers.common.CategoryAndMenuDTO;
import com.ohgiraffers.common.MenuAndCategoryDTO;
import com.ohgiraffers.common.MenuDTO;

import java.util.List;

public interface ElementMapper {
    List<String> selectCacheTest();
    List<MenuDTO> selectResultMapTest();
    List<MenuDTO> selectResulMapConstructor();
    List<MenuAndCategoryDTO> selectResultMapAssociation();
    List<CategoryAndMenuDTO> selectResultMapCollection();
    List<MenuDTO> selectSqlTest();
}
