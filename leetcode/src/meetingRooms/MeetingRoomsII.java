package meetingRooms;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (in1, in2) -> (in1.start - in2.start) );
        PriorityQueue<Interval> pq = new PriorityQueue<>((i1, i2) -> (i1.end - i2.end));

        pq.offer(intervals[0]);
        for (int i = 1; i < intervals.length; ++i) {
            Interval curr = pq.poll();
            if (intervals[i].start < curr.end) {
                pq.offer(intervals[i]);
            } else {
                curr.end = intervals[i].end;
            }
            pq.offer(curr);
        }
        //pq.forEach(interval -> System.out.println(interval.start + " , " + interval.end));
        return pq.size();
    }
    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static void main(String[] args) {
        MeetingRoomsII meetingRoomsII = new MeetingRoomsII();
        System.out.println(1 == meetingRoomsII.minMeetingRooms(new Interval[]{new Interval(0, 30), new Interval(40, 80), new Interval(100, 120)}));

        System.out.println(2 == meetingRoomsII.minMeetingRooms(new Interval[]{new Interval(0, 30), new Interval(40, 80), new Interval(75, 120)}));

        System.out.println(2 == meetingRoomsII.minMeetingRooms(new Interval[]{new Interval(9,10), new Interval(4,9), new Interval(4,17)}));


    }
}
