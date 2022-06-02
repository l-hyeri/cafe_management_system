/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design_project.client;

import design_project.nutrition.nutrition_main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 이혜리
 */
public class Login {

    String URL = null;

    String ID = null;
    String PW = null;
    
    nutrition_main n = new nutrition_main();

    public Login(String URL) {
        this.URL = URL;
    }

    public void DoLogin() {
        Scanner sc = new Scanner(System.in);

        System.out.println("아이디 : ");
        ID = sc.nextLine();

        System.out.println("비밀번호 : ");
        PW = sc.nextLine();

        LoginCheck();

    }

    public boolean Compare(String url) {
        try {
            String str;
            String[] array = null;

            BufferedReader is = new BufferedReader(new FileReader(URL));

            Path path = Paths.get(URL);

            Charset cs = StandardCharsets.UTF_8;

            ArrayList<String> list = new ArrayList<String>();
            list = (ArrayList<String>) Files.readAllLines(path, cs);

            ArrayList<String> list_temp = new ArrayList<String>();
            ArrayList<String> id_list = new ArrayList<String>();
            ArrayList<String> pw_list = new ArrayList<String>();

            for (String i : list) {
                array = i.split("\n");
                list_temp.add(array[0]);
            }

            for (String i : list_temp) {
                String[] temp = i.split("/");
                id_list.add(temp[1]);
                pw_list.add(temp[2]);
            }

            for (int i = 0; i < id_list.size(); i++) {
                if (ID.equals(id_list.get(i)) && PW.equals(pw_list.get(i))) {
                    is.close();
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void LoginCheck() {

        boolean id_temp = Compare(URL);

        if (id_temp) {
            System.out.println("로그인 성공\n");
            System.out.println("-----------------------음료 및 케이크 영양 정보를 제공합니다-----------------------\n");
            n.nutrition();
        } else {
            System.out.println("로그인 실패\n");
            DoLogin();
        }

    }
}
