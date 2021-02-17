package main.algorithm.sort;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 对一个省200万学生的高考成绩（假设成绩最多只有2位小数，0~900范围）进行排序，用尽可能高效的算法。
 *
 * @author LinKai
 * @time 2021/02/16-22:04:00
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
        String str = null;
        String fileName = ".\\排序\\200w.txt";
        InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        // data用于将所有未排序的成绩保存在数组中
        int[] data = new int[2100002];
        int i = 0;
        while ((str = br.readLine()) != null) {
            // 1. 读取文件，把学生的成绩转为整型数据保存在data数组
            double a = Double.valueOf(str);
            a = a * 100;
            data[i++] = (int) a;
        }
        System.out.println("数据读取完毕，size为" + i);
        long start = System.currentTimeMillis();
        countSort(data);
        System.out.println("计数排序消耗的时间为" + (System.currentTimeMillis() - start) + "ms");
    }

    /**
     * 1. 将学生成绩乘以100，转为整数
     * 2. 使用数组counts对学生成绩进行排序，下标为学生成绩，值为学生人数
     * 3. 遍历学生成绩数组data，将counts[data]自增
     * 4. 遍历排序数组，如果count[i]的值大于0，说明成绩i有count[i]个学生考出这个成绩
     * 5. 记得把成绩重新转为0~900的两位小数的值，有多少学生就写入多少成绩到文件中，完成排序
     *
     * @param data
     * @throws Exception
     */
    private static void countSort(int[] data) throws Exception {
        // 2. 排序的数组，下标为学生成绩，值为学生人数
        int[] counts = new int[90002];
        for (int i = 0; i < data.length; i++) {
            // 3. 遍历学生成绩数组data，将counts[data]自增
            counts[data[i]]++;
        }

        File file = new File(".\\排序\\200w-csort.txt");
        Writer out = new FileWriter(file);

        // 4. 遍历排序数组，如果count[i]的值大于0，说明成绩i有count[i]个学生考出这个成绩
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                // 5. 记得把成绩重新转为0~900的两位小数的值，有多少学生就写入多少成绩到文件中，完成排序
                for (int j = 0; j <= counts[i]; j++) {
                    out.write((i / 100.0) + "\r\n");
                }
            }
        }
        out.close();
    }
}
