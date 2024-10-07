package com.ohgiraffers.section01.xmlconfig.view;

import com.ohgiraffers.section01.xmlconfig.model.dto.MenuDTO;

import java.util.List;

public class PrintResult {

    public void printMenuList(List<MenuDTO> menuList) {

        System.out.println("전체메뉴 조회 결과");

        for(MenuDTO : menuList){
            System.out.println(menuList);
        }

        System.out.println("======================");
    }
}
