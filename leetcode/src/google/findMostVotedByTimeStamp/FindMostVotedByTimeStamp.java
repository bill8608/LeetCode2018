package google.findMostVotedByTimeStamp;

import java.util.*;
/* 2. 给一个vote list=[(a, 100), (b, 150), (a, 200)]  #(name, timestamp) 和时间T
        找T时间之前, 得票数最高的人(或任一得票数最高的人). 1point 3acres 璁哄潧
        ex: T=100 -> a, T=150 -> a or b, T=200 -> a

        3. 2的followup, 多给一个input K, 找T时间之前, Top K 得票数的人

        4. 也是followup, 一样给vote list, K, 但这次给Top K list, 找时间T*/
public class FindMostVotedByTimeStamp {
    public String findMostVoted(List<Vote> voteList, int timeStamp1) {
        if (voteList == null || voteList.size() == 0 || timeStamp1 < 0) {
            return null;
        }
        // No need to sort
        //Collections.sort(voteList, (v1, v2) -> (v1.timeStamp - v2.timeStamp));
        Map<String, Integer>  map = new HashMap<>();
        for (Vote vote : voteList) {
            if (vote.timeStamp > timeStamp1) {
                break;
            }
            map.put(vote.name, map.getOrDefault(vote.name, 0) + 1);
        }
        String mostVoted = null;
        int numOfVotes = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > numOfVotes) {
                numOfVotes = entry.getValue();
                mostVoted = entry.getKey();
            }
        }
        return mostVoted;
    }

    // follow-up : return top K most voted
    public List<String> findKMostVoted(List<Vote> voteList, int k, int timeStamp1) {
        if (voteList == null || voteList.size() == 0 || k < 1 || timeStamp1 < 0) {
            return null;
        }
        Collections.sort(voteList, (v1, v2) -> (v1.timeStamp - v2.timeStamp));
        Map<String, Integer>  map = new HashMap<>();
        for (Vote vote : voteList) {
            if (vote.timeStamp > timeStamp1) {
                break;
            }
            map.put(vote.name, map.getOrDefault(vote.name, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((entry1, entry2) -> (entry1.getValue() - entry2.getValue()));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (pq.size() < k) {
                pq.offer(entry);
            } else {
                if (entry.getValue() > pq.peek().getValue()) {
                    pq.poll();
                    pq.offer(entry);
                }

            }
        }
        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(0, pq.poll().getKey());
        }
        return res;
    }

    // follow-up 2: return top K most voted
    /*public int findTimeStampForKMostVotedArray(List<Vote> voteList, List<String> kMostVoted) {
        if (voteList == null || voteList.size() == 0 || kMostVoted == null || kMostVoted.size() == 0) {
            return -1;
        }
        Collections.sort(voteList, (v1, v2) -> (v1.timeStamp - v2.timeStamp));
        int furthestTimeStamp = 0;
        for ()
        Map<String, Integer>  map = new HashMap<>();
        for (Vote vote : voteList) {
            if (vote.timeStamp > timeStamp1) {
                break;
            }
            map.put(vote.name, map.getOrDefault(vote.name, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((entry1, entry2) -> (entry1.getValue() - entry2.getValue()));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (pq.size() < k) {
                pq.offer(entry);
            } else {
                if (entry.getValue() > pq.peek().getValue()) {
                    pq.poll();
                    pq.offer(entry);
                }

            }
        }
        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(0, pq.poll().getKey());
        }
        return res;
    }*/

    static class Vote {
        String name;
        int timeStamp;
        Vote(String name, int timeStamp) {
            this.name = name;
            this.timeStamp = timeStamp;
        }
    }

    public static void main(String[] args) {
        List<Vote> voteList = Arrays.asList(new Vote("A1", 100), new Vote("B1", 125), new Vote("A1", 150), new Vote("B1", 200), new Vote("B1", 225));
        FindMostVotedByTimeStamp obj = new FindMostVotedByTimeStamp();
        System.out.println(obj.findMostVoted(voteList, 125).equals("A1"));
        System.out.println(obj.findMostVoted(voteList, 150).equals("A1"));
        System.out.println(obj.findMostVoted(voteList, 200).equals("A1"));
        System.out.println(obj.findMostVoted(voteList, 250).equals("B1"));

        System.out.println("");
        obj.findKMostVoted(voteList, 2, 150).stream().forEach(System.out::println);
        System.out.println("");
        obj.findKMostVoted(voteList, 2, 250).stream().forEach(System.out::println);
    }
}
