import java.util.Arrays;
import java.util.Comparator;
import java.util.SimpleTimeZone;

/**
 * @author yang
 * 2021年05月09日 21:58:00
 */
public class 题27安排教室 {
    public static void main(String[] args) {

    }

    public static class Time {
        private int start;
        private int end;

        public Time(int start,int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class myCompartor implements Comparator<Time> {
        @Override
        public int compare(Time o1, Time o2) {
            return o1.end - o2.end;
        }
    }

    public static int getmaxClass(int[] starts, int[] ends ,int cur) {
        Time[] time = new Time[starts.length];
        Arrays.sort(time, new myCompartor());
        int res = 0;
        for (int i = 0; i < time.length; i++) {
            if (time[i].start > cur) {
                cur = time[i].end;
                res++;
            }else {
                break;
            }
        }
        return res;
    }
 }


