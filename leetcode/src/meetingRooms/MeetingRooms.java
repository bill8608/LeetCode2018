package meetingRooms;

import java.util.Arrays;

public class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, (i1, i2) -> (i1.start - i2.start));
        int start = intervals[0].start;
        int end = start;
        for (Interval interval : intervals) {
            if (interval.start < end) {
                return false;
            } else {
                end = interval.end;
            }
        }
        return true;
    }

    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static void main(String[] args) {
        MeetingRooms meetingRooms = new MeetingRooms();
        boolean canAttendAll = meetingRooms.canAttendMeetings(new Interval[]{new Interval(0, 30), new Interval(40, 80), new Interval(100, 120)});
        System.out.println(canAttendAll == true);

        canAttendAll = meetingRooms.canAttendMeetings(new Interval[]{new Interval(0, 30), new Interval(40, 80), new Interval(75, 120)});
        System.out.println(canAttendAll == false);

    }
}
