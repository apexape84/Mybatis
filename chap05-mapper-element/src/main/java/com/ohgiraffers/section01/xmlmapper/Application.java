package com.ohgiraffers.section01.xmlmapper;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ElementService elementService = new ElementService();

        do{
            System.out.println("====== Mapper Element Test =======");
            System.out.println("1. <cache> ");
            System.out.println("2. <resultMap> ");
            System.out.println("3. <sql> ");
            System.out.println("4. <insert> ");
            System.out.println("9. EXIT");
            System.out.print("원하시는 메뉴를 골라주세요 : ");

            int no = scanner.nextInt();

            switch (no){
                case 1 :
                    elementService.selectCacheTest(); break;

                case 2 :
                    resultMapSubMenu(); break;
                case 3 :
                    elementService.selectSql(); break;

                case 9 :
                    return;
            }
        }while(true);

    }

    private static void resultMapSubMenu() {
        Scanner scanner = new Scanner(System.in);
        ElementService elementService = new ElementService();

        do{
            System.out.println("====== ResultMap Sub Menu ======");
            System.out.println("1. <resultMap> 테스트 ");
            System.out.println("2. <constructor> 테스트 ");
            System.out.println("3. <association> 테스트 ");
            System.out.println("4. <collection> 테스트 ");
            System.out.println("9. EXIT");
            System.out.print("메뉴를 선택해 주세요 : ");
            int no = scanner.nextInt();

            switch (no){
                case 1 :
                    elementService.selectResultMapTest(); break;
                case 2 :
                    elementService.selectResultMapConstructor(); break;
                case 3 :
                    elementService.selectResultMapAssociation(); break;
                case 4 :
                    elementService.selectResultMapCollection(); break;
                case 9 :
                    return;
            }
        }while(true);
    }
}
