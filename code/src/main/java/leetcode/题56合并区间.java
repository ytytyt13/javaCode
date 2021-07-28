package leetcode;

import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author yang
 * 2021年06月17日 21:55:00
 */
public class 题56合并区间 {
    public static void main(String[] args) {

        int[][] arr ={{1,4},{2,3}};
        int[][] merge = merge(arr);

        for (int i = 0; i < merge.length; i++) {
            System.out.println(merge[i][0]+","+merge[i][1]);
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null | intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        ArrayList<int[]> res = new ArrayList<>();
        int begin = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length ; i++) {
            //System.out.println(intervals[i][0]+","+intervals[i][1]+"-"+begin+","+end);
            if (intervals[i][0] > end) {
                res.add(new int[]{begin,end});
                begin = intervals[i][0];
                end = intervals[i][1];
            }else if (intervals[i][1] > end){
                end  = intervals[i][1];
            }
        }

        res.add(new int[]{begin,end});


        return res.toArray(new int[res.size()][]);
    }


}
