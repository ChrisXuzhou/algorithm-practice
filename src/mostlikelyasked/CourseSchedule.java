package mostlikelyasked;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] prerequisite: prerequisites) {
            adjList.get(prerequisite[1]).add(prerequisite[0]);
        }

        // make sure there is no conflict requirements in the adjList
        boolean[] visited = new boolean[numCourses];
        boolean[] beingVisited = new boolean[numCourses];

        // Perform DFS on each node
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (isCyclic(adjList, visited, beingVisited, i)) {
                    return false; // If a cycle is detected, return false
                }
            }
        }

        return true;
    }

    // Depth-first search to detect cycles
    private boolean isCyclic(List<List<Integer>> adjList, boolean[] visited, boolean[] beingVisited, int course) {
        if (beingVisited[course]) {
            return true; // Cycle detected
        }

        if (visited[course]) {
            return false; // Node already visited, no need to explore further
        }

        // Mark the current node as being visited
        beingVisited[course] = true;

        // Recursively visit neighbors
        for (int neighbor : adjList.get(course)) {
            if (isCyclic(adjList, visited, beingVisited, neighbor)) {
                return true; // If cycle detected in neighbor, return true
            }
        }

        // Mark the current node as visited and not being visited
        visited[course] = true;
        beingVisited[course] = false;

        return false; // No cycle detected
    }

}
