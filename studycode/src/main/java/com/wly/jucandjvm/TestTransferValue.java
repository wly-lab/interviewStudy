package com.wly.jucandjvm;

/**
 *基本类型会变 引用类型不会变
 * String 常量池 指向新常量 不变
 *
 */
public class TestTransferValue {
    public static void main(String[] args) {
        TestTransferValue test=new TestTransferValue();
        int age=20;
        test.changValue1(age);
        System.out.println("age---"+age);

        Person Person=new Person("abc");
        test.changeValue2(Person);
        System.out.println(Person.getName());

        String str="abc";//在常量池 方法区
        test.changeValue3(str);
        System.out.println(str);
    }

    private void changeValue3(String str) {
        str="xxx";
    }

    private void changeValue2(Person person) {
        person.setName("xxx");
    }

    private void changValue1(int age) {
        age=30;
    }

    private static class Person {
        private String name;
        public Person(String name){
            this.name=name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
