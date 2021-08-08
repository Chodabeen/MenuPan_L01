package src.edu.handong.csee.java.L01;

import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        Main stepL = new Main();
        stepL.l01();
    }

    void l01() {
      int menu;
      Scanner s = new Scanner(System.in);

      MenuPan m = new MenuPan();

      while(true){
        System.out.print("1) add, 2) modify, 3) remove, 4) list, 5) total number, 6) exit > ");
        menu = s.nextInt();

        if(menu == 1)
          m.add();
        else if(menu == 2)
          m.modify();
        else if(menu == 3)
          m.remove();
        else if(menu == 4)
          m.list();
        else if(menu == 5)
          m.total_number();
        else
          break;
      }

      System.out.print("Ended");

	}
}

class MenuPan {
  
  Scanner s = new Scanner(System.in);
  int num = 0;

  ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();

  // element 더하기
  void add(){
    
    String name, origin, price;
    ArrayList<String> data1 = new ArrayList<>();

    // 메뉴 한 개 정보 1차 arryaList에 저장
    System.out.print("Enter name, origin, price > "); 
    name = s.next();  
    origin = s.next();
    price = s.next(); 
    data1.add(name);
    data1.add(origin);
    data1.add(price);

    // 2차 arraylist에 1차 arraylist(메뉴) 집어넣기
    datas.add(data1);
  }

  // 리스트 보여주기
  void list(){

    int i, j;

    System.out.println("================================================");
    System.out.println("num     name            origin          price");
    // 메뉴 출력
    for(i = 0; i < datas.size(); i++){
      System.out.print((i+1) + "       ");
      for(j = 0; j < datas.get(i).size(); j++){
        if(j == 0 || j == 1)
          System.out.printf("%-16s", datas.get(i).get(j));
        else
          System.out.println(datas.get(i).get(j));
      }
    }
  }

  // element 수정
  void modify(){
    
    int mod_num;
    String name, origin, price;

    list();
    System.out.print("Enter a number to modify > ");
    mod_num = s.nextInt();

    System.out.print("Enter name, origin, price > ");
    name = s.next();
    origin = s.next();
    price = s.next();
    datas.get(mod_num-1).set(0, name);
    datas.get(mod_num-1).set(1, origin);
    datas.get(mod_num-1).set(2, price);
  }

  // element 삭제
  void remove(){
    
    list();
    int rem_num;

    System.out.print("Enter a number to remove > ");
    rem_num = s.nextInt();
    datas.remove(rem_num-1);
    System.out.println("Removed");
  }

  // 메뉴 몇 개 있는지 구하기
  void total_number(){

    System.out.println("Number of registered menu is " + datas.size());
  }
}