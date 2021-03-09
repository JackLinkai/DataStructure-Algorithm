package main.algorithm.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 有n项活动申请使用同一个礼堂，每项活动有一个开始时间和一个结束时间，
 * 如果任何两个活动不能同时举行，问如何选择这些活动？
 *
 * @author LinKai
 * @time 2021/03/07-16:07:00
 */
public class GreedyActive {

    /**
     * 我们可以先按照结束时间从小到大排序，
     * 首先把第一个活动加入我们可以举办的列表，
     * 之后的活动只要开始时间大于列表中最后一个活动的结束时间就可以把活动添加到可以举办的列表中。
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Active> actives = new ArrayList<>();
        // n个活动
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            double start = sc.nextDouble();
            double end = sc.nextDouble();
            Active active = new Active(i, start, end);
            actives.add(active);
        }
        actives.sort(null);
        // 礼堂的开放时间
        double curTime = 0;
        for (int i = 0; i < n; i++) {
            Active active = actives.get(i);
            // 如果活动的时间比当前时间晚，就可以开
            if (active.startTime >= curTime) {
                System.out.println(active.toString());
                curTime = active.endTime;
            }
        }
    }
}

class Active implements Comparable<Active> {

    double startTime;
    double endTime;
    int id;

    public Active(int id, double startTime, double endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * jdk提供的排序方法
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Active o) {
        if (this.endTime > o.endTime) {
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Active{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", id=" + id +
                '}';
    }
}
