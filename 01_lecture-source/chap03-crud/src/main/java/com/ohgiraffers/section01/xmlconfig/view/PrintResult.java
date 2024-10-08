package com.ohgiraffers.section01.xmlconfig.view;

import com.ohgiraffers.section01.xmlconfig.model.dto.MenuDTO;

import java.util.List;

public class PrintResult {
    // 1번 전체조회를 누르고 실행 결과 값을 보는 메소드
    public void printMenuList(List<MenuDTO> menuList) {

        System.out.println("요청하신 전체 메뉴 조회 결과 입니다.");

        for(MenuDTO menu : menuList) {
            System.out.println(menu);
        }

        System.out.println("================================");

    }
    public void printErrorMessage(String errorCode){
        String errorMessage =" ";
        switch (errorCode){
            case "selectList" :
                errorMessage ="전체메뉴 조회에 실패했습니다.";
                break;
            case "selectOne" :
                errorMessage ="선택메뉴 조회에 실패했습니다.";
                break;
            case "insert" :
                errorMessage="메뉴 추가에 실패했습니다.";
                break;
            case "update" :
                errorMessage="메뉴 수정에 실패했습니다";
                break;
            case "delete" :
                errorMessage="메뉴 수정에 실패했습니다";
                break;
        }
    }

    public void printMenu(MenuDTO menu) {
        System.out.println(menu.getMenuCode()+"번 메뉴 조회 결과입니다.");
        System.out.println(menu);
    }

    public void printSuccessMessage(String insert) {
        System.out.println("성공");
    }
}