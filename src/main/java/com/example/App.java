package com.example;

public class App {

    public static void main(String[] args) {
        int a = 10;
        String b = "string";

        String password = "password123";
        String unusedVar = "I am not used";

        try {
            int division = 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        String str = null;
        System.out.println(str.length());

        Object obj = "some string";
        Integer casted = (Integer) obj;  // This will produce a ClassCastException
    }

    public void duplicateCode1() {
        System.out.println("This is duplicate code");
    }

    public void duplicateCode2() {
        System.out.println("This is duplicate code");
    }
}
