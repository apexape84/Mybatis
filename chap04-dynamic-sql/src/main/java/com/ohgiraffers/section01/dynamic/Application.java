package com.ohgiraffers.section01.dynamic;

import com.ohgiraffers.common.SearchCriteria;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("==== 마이바티스 동적 SQL 학습 메뉴 ===");
            System.out.println("1. if 확인하기");
            System.out.println("2. choose(when, otherwise) 확인하기");
            System.out.println("3. foreach 확인하기");
            System.out.println("4. trim(where, set) 확인하기");
            System.out.println("9. 종료하기");

            int no = scanner.nextInt();

            switch(no){
                case 1 :
                    ifsubmenu();
                    break;
                case 2 :
                    chooseSubMenu();
                    break;
                case 3 :
                    foreachSubmenu();
                    break;
                case 4 :
                    trimSubmenu();
                    break;

                        


                case 9:
                    return;
            }
        }while(true);
    }

    private static void trimSubmenu() {
        Scanner scanner = new Scanner(System.in);
        MenuService menuService = new MenuService();
        do{
            System.out.println("======= 서브메뉴 ========");
            System.out.println("1. 검색조건이 있으면 메뉴코드로, 없으면 전체 조회");
            System.out.println("2. 메뉴 혹은 카테고리코드로 검색, 단 메뉴와 카테고리 둘 다 일치하는 경우도 검색, 검색 조건 없으면 전체 검색");
            System.out.println("3. 원하는 메뉴 정보만 수정하기");
            System.out.println("9. 이전메뉴로 돌아가기");

            int no = scanner.nextInt();

            switch(no){
                case 1 : menuService.searchMenuByCodeOrSearchAll(inputAllOrOne());
                    break;
                case 2 : menuService.searchMenuByNameOrCategory(inputSearchCriteriaMap());
                    break;
                case 3 : menuService.modifyMenu(inputChange());
                    break;
                case 9 : return;
            }
        }while(true);
    }

    private static Map<String,Object> inputChange() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("변경할 메뉴코드를 입력해 주세요 : ");
        int code = scanner.nextInt();
        scanner.nextLine();

        System.out.println("변경할 메뉴이름을 입력해 주세요 : ");
        String name = scanner.nextLine();
        System.out.println("변경할 카테고리 코드를 입력해 주세요 : ");
        int categoryCode = scanner.nextInt();
        scanner.nextLine();
        System.out.println("판매여부를 입력해 주세요 : ");
        String orderableStatus = scanner.nextLine();

        Map<String,Object> criteria = new HashMap<>();
        criteria.put("code",code);
        criteria.put("name",name);
        criteria.put("categoryCode",categoryCode);
        criteria.put("orderableStatus",orderableStatus);
        return criteria;
    }

    private static Map<String,Object> inputSearchCriteriaMap(){
        Scanner scanner = new Scanner(System.in);
        MenuService menuService = new MenuService();
        System.out.println("검색조건(category, name, both or null :");
        String condition = scanner.nextLine();

        Map<String, Object> criteria = new HashMap<>();

        if("category".equals(condition)){
            System.out.print("검색할 카테고리 코드를 입력해 주세요 : ");
            int categoryValue = scanner.nextInt();
            criteria.put("categoryValue", categoryValue);
        } else if("name".equals(condition)){
            System.out.print("검색할 메뉴이름 입력해 주세요 : ");
            String nameValue = scanner.nextLine();
            criteria.put("nameValue", nameValue);
        } else if("both".equals(condition)) {
            System.out.print("검색할 메뉴이름 입력해 주세요 : ");
            String nameValue = scanner.nextLine();
            System.out.print("검색할 카테고리 코드를 입력해 주세요 : ");
            int categoryValue = scanner.nextInt();
            criteria.put("categoryValue", categoryValue);
            criteria.put("nameValue", nameValue);
        }
        return criteria;
    }

    private static SearchCriteria inputAllOrOne() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("검색조건을 입력하시겠습니까?(예 or 아니오) : ");
        boolean hasSearchValue = "예".equals(scanner.nextLine()) ? true : false;

        SearchCriteria searchCriteria = new SearchCriteria();
        if(hasSearchValue) {
            System.out.print("검색할 메뉴 코드를 입력해주세요 : ");
            String code = scanner.nextLine();
            searchCriteria.setCondition("menuCode");
            searchCriteria.setValue(code);
        }

        return searchCriteria;
    }

    private static void foreachSubmenu() {
        Scanner scanner = new Scanner(System.in);
        MenuService menuService = new MenuService();
        do{
            System.out.println("======= 서브메뉴 ========");
            System.out.println("1. 랜덤으로 메뉴5개 추출하기");
            System.out.println("9. 이전메뉴로 돌아가기");

            int no = scanner.nextInt();

            switch(no){
                case 1 : menuService.searchMenuByRandomCode(creatRandomCodeList());
                    break;
                case 9 : return;
            }
        }while(true);
        
    }

    private static List<Integer> creatRandomCodeList() {
        Set<Integer> set = new HashSet<>();
        while(set.size() < 5){
            int temp = (int) ((Math.random() * 21)+1);
            set.add(temp);
        }

        List<Integer> menuCodeList = new ArrayList<>(set);
        Collections.sort(menuCodeList);
        return menuCodeList;
    }

    private static void chooseSubMenu() {
        Scanner scanner = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do{
            System.out.println("======= 서브메뉴 ========");
            System.out.println("1. 카테고리별 메뉴 보기");
            System.out.println("9. 이전메뉴로 돌아가기");

            int no = scanner.nextInt();

            switch(no){
                case 1 : menuService.searchMenuBySupCategory(inputSupCategory());
                    break;
                case 9 : return;
            }
        }while(true);
    }

    private static SearchCriteria inputSupCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("분류명을 입력해 주세요(식사, 음료, 디저트)");
        String value = scanner.nextLine();

        return new SearchCriteria("category", value);
    }

    private static void ifsubmenu() {
        Scanner scanner = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do{
            System.out.println("if 확인 메뉴");
            System.out.println("1. 입력하신 금액의 가격 이하의 메뉴를 추천해 드립니다");
            System.out.println("2. 메뉴이름 or 카테고리명으로 검색");
            System.out.println("9. 이전 메뉴로");
            int no = scanner.nextInt();

            switch(no){
                case 1 :
                    menuService.selectMenuByPrice(inputPrice()); break;

                case 2 :
                    menuService.searchMenu(inputSearchCriteria()); break;

                case 9:
                    return;


            }
        }while(true);

    }

    private static SearchCriteria inputSearchCriteria() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("무억으로 검색할까요? Name or Category : ");
        String condition = scanner.nextLine();
        System.out.println("검색어를 입력 해주세요 : ");
        String value = scanner.nextLine();

        return new SearchCriteria(condition, value);
    }

    private static int inputPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("금액을 입력해 주세요 : ");
        int price = scanner.nextInt();
        return price;
    }
}
