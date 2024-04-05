package mostlikelyasked;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TopVotedCandidate {



    // time -> leader
    private final TreeMap<Integer, Integer> leaderMap;

    public TopVotedCandidate(int[] persons, int[] times) {
        leaderMap = new TreeMap<>();
        Map<Integer, Integer> count = new HashMap<>(); // person -> count
        int maxVotes = 0; // Variable to keep track of the maximum votes
        int leader = -1; // Variable to store the current leader

        for (int i=0; i< persons.length; i++) {
            count.put(persons[i], count.getOrDefault(persons[i], 0) + 1);
            if (count.get(persons[i]) >= maxVotes) {
                maxVotes = count.get(persons[i]);
                leader = persons[i];
            }

            leaderMap.put(times[i], leader);
        }
    }

    public int q(int t) {
        return leaderMap.floorEntry(t).getValue();
    }
}
