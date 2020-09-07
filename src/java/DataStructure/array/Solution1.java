package java.DataStructure.array;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        String str = null;
        //文件位置
        String fileName = "";
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(fileName), "UTF-8");

        //开始时间
        Long start = System.currentTimeMillis();
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        int tot = 0;
        int data[] = new int[180];
        while ((str = bufferedReader.readLine()) != null) { //时间复杂度O(n).
            int age=Integer.valueOf(str);
            data[age]++;
            tot++;
        }
        System.out.println("总数据："+tot);
        for (int i = 0; i < 180; i++) { //下标从0开始
            System.out.println(i+":"+data[i]);
        }
        System.out.println("花费的时间为："+(System.currentTimeMillis()-start)+"ms");
    }
}
