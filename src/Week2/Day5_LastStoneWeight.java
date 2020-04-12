package Week2;

import java.util.Collections;
import java.util.PriorityQueue;

public class Day5_LastStoneWeight {
    public static void main(String[] args) {
        /*
        We have a collection of stones, each stone has a positive integer weight.
        Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights
         x and y with x <= y.  The result of this smash is:

        If x == y, both stones are totally destroyed;
        If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
        At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)


        Example 1:

        Input: [2,7,4,1,8,1]
        Output: 1
        Explanation:
        We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
        we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
        we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
        we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.


        Note:

        1 <= stones.length <= 30
        1 <= stones[i] <= 1000
           Hide Hint #1
        Simulate the process. We can do it with a heap, or by sorting some list of stones every time we take a turn.
        */

        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(stones));


    }

    public static int lastStoneWeight(int[] stones) {

        if (stones == null || stones.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.add(stone);

        }

        while (maxHeap.size() > 1) {
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            int diff = x - y;
            if (diff > 0) {
                maxHeap.add(diff);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }


}
