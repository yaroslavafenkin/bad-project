package com.example;

public class App {

    public static void main(String[] args) {

        /**
         * Magic indeed
         */
        int a = 10;
        System.out.println(a);
        
        try {
            int division = 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        String str = null;
        System.out.println(str.length());
    }

    /**
     * This does nothing meaningful.
     */
    public static final void duplicateCode1() {
        System.out.println("This is duplicate code");
    }

    public void duplicateCode2() {
        System.out.println("This is duplicate code");
    }
}
