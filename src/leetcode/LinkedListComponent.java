package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponent {

	public LinkedListComponent() {
		// TODO Auto-generated constructor stub
	}

	public int numComponents(ListNode head, int[] G) {
		int ans = 0;
		Set<Integer> Gset = new HashSet();
        for (int x: G) Gset.add(x);

        ListNode cur = head;

        while (cur != null) {
            if (Gset.contains(cur.val) &&
                    (cur.next == null || !Gset.contains(cur.next.val)))
                ans++;
            cur = cur.next;
        }

        return ans;
	}
}
