package com.ll.level0.p120883;

public class main {
    public String ain(String[] args) {
        String[] id_pw = {"meosseugi", "1234"};
        String answer="";
        String[][] db= new String[][]{{}};
        for (int i = 0; i < db.length; i++) {
            if(id_pw[0].equals(db[i][0])){
                if(id_pw[1].equals(db[i][1]))
                    return "login";
                else answer = "wrong pw";
            }
        }
        return answer.equals("wrong pw") ? answer : "fail";
    }
}