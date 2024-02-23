package com.company;
import com.company.entity.*;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Consumer;

public class Main {

    public static void test1() {
        try{
            Object object = "abc";
            object.toString();
        } catch(NullPointerException  | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } finally {
            System.out.println("我是finally");
        }
        System.out.println("程序继续正常运行");
        Random random = new Random();
        System.out.println(random.nextInt(100));
    }


    public static void main(String[] args) {
	    // write your code here
        List<String> list1 = new ArrayList<>();
        list1.add("BBB");
        list1.add("AAA");
        list1.sort(String::compareTo); //排序
        System.out.println(list1);

        List list2 = new ArrayList<>(Arrays.asList("aaa","bbb","ccc"));
        List list3 = new ArrayList();
        list3.addAll(Arrays.asList("aaa","bbb","ccc"));



        ArrayList<String> list = new ArrayList<>();
        list.add(0,"aaa");
        System.out.println(list);
        list.add(0,"bbb");
        System.out.println(list);
    }

    public static void test3() {
        Score<String> score1 = new Score<String>("gaoshu","xxxxx","优秀");
        Score<Integer> score2 = new Score<Integer>("gaoshu","xxxxx",99);
        System.out.println(score1.getValue());
        System.out.println(score2.getValue());

    }

    public static void test_hanoi() {
        hanoi('a','b','c',3);
    }
    public static void hanoi(char a, char b, char c, int n) {
        if(n == 1) {
            System.out.println(a + " -->" + c);
        } else {
            hanoi(a,c,b, n - 1);
            System.out.println(a + " -->" + c);
            hanoi(b,a,c,n - 1);
        }
    }

    public static void test_duichen() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(duichen(str.toCharArray()));
        System.out.println(duichen(str.toCharArray()));
    }

    public static boolean duichen(char[] str) {
        int i = 0, j = str.length - 1;
        while(i < j) {
            if(str[i] != str[j]) return false;
            i ++;
            j --;
        }
        return true;
    }

    public static void test_sort() {
        int[] arr = new int[]{3,4,5,6,3,45,345,345,2,1};
        bupper_sort(arr);
        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }

    public static void bupper_sort(int[] arr) {
        for(int i = 0; i < arr.length; i ++) {
            boolean flag = true;
            for(int j = 0; j < arr.length - i - 1; j ++) {
                if(arr[j] > arr[j + 1]) {
                    flag = false;
                    int tt = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tt;
                }
            }
            if(flag == true) {
                return;
            }
        }
    }
    private static int test(int a,int b) {
        if(b==0) throw new ArithmeticException("出书不能为0");
        return a / b;
    }
}
