package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        super(emailId, Integer.MAX_VALUE);
        calendar = new ArrayList<>();
        
        // The inboxCapacity is equal to the maximum value an integer can store.
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);
    }

    public int findMaxMeetings(){
        int ans = 0;
        LocalTime currTime = LocalTime.of(00, 00, 00);
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
         for(int i=0; i<calendar.size(); i++) {
             Meeting m = calendar.get(i);
             if(currTime.compareTo(m.getStartTime()) <= 0) {
                 ans++;
                 currTime = m.getEndTime().plusSeconds(1);
             }
         }
         return ans;
    }
}
