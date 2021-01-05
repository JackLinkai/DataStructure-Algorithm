package main.datastructure.array;

import java.io.*;
import java.util.Random;

/**
 * @author LinKai
 * @time 2020/9/14-21:04
 */
public class Test1 {
    /**
     * 文件位置
     */
    private static final  String FILE_NAME = "D:\\age.txt";

    /**
     * 总人口数
     */
    private static final int TOTAL_POPULATION = 1400000000;

    /**
     * 数组大小
     */
    private static final  int ALL_NUMBERS = 181;

    /**
     * 生成人口年龄文件
     * @throws Exception
     */
    public static void generateFile() throws Exception {
        final Random random = new Random();
        BufferedWriter objWriter = null;
        objWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE_NAME)));
        for (int i = 0; i < TOTAL_POPULATION; i++) {
            int age = Math.abs(random.nextInt()) % 180;
            objWriter.write(age + "\r\n");
        }
        objWriter.flush();
        objWriter.close();
    }

    /**
     * 获取文件中年龄所对应的人数
     * @throws FileNotFoundException
     */
    public static void getNumFromAge() throws Exception {
        String str = null;

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(FILE_NAME), "UTF-8");

        //开始时间
        Long start = System.currentTimeMillis();
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        int tot = 0;
        int[] data = new int[ALL_NUMBERS];

        /**
         * 时间复杂度O(n)
         */
        while ((str = bufferedReader.readLine()) != null) {
            int age=Integer.valueOf(str);
            data[age]++;
            tot++;
        }
        System.out.println("总数据："+tot);

        /**
         * 下标从0开始
         */
        for (int i = 0; i < ALL_NUMBERS; i++) {
            System.out.println(i+":"+data[i]);
        }
        System.out.println("花费的时间为："+(System.currentTimeMillis()-start)+"ms");
    }

    public static void main(String[] args) {
        try {
            generateFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            getNumFromAge();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
