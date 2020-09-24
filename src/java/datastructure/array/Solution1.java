package java.datastructure.array;

import java.io.*;

/**
 * @author LinKai
 * @time 2020/9/14-21:04
 */
public class Solution1 {
    /**
     * 文件位置
     */
    private static final  String FILE_NAME = "";

    /**
     *
     */
    private static final  int ALL_NUMBERS = 180;

    /**
     * 获取文件中年龄所对应的人数
     * @throws FileNotFoundException
     */
    public void getNumFromAge() throws Exception {
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

}
