package com.test.calculate;

import java.util.*;
import java.util.function.Consumer;

public class TestA {

    private static TreeNode helper(Queue<Integer> q, int max, int min) {
        if (q.isEmpty()) {
            return null;
        }

        if (q.peek() >= max || q.peek() <= min) {
            return null;
        }

        TreeNode root = new TreeNode(q.poll());
        root.left = helper(q, root.val, min);
        root.right = helper(q, max, root.val);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(largestSumAfterKNegations(new int[]{-3, 3, 1, -5, -2}, 3));
       /* Queue<Integer> q = new LinkedList<>();
        for (int i : new int[]{8,5,1,7,10,12}) {
            q.offer(i);
        }
        System.out.println(helper(q, Integer.MAX_VALUE, Integer.MIN_VALUE));*/
        System.out.println(bstFromPreorder(new int[]{8,5,1,7,10,12}));

        System.out.println(numDupDigitsAtMostN(723));

        System.out.println(myPow(2, 10));
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode reverse = reverse(node1, 1);
        System.out.println(reverse);
    }

    public static int largestSumAfterKNegations(int[] A, int K) {
        int[] cnt = new int[201];
        int res = 0;
        for (int i : A) ++cnt[i + 100];
        for (int i = -100; i <= 100 && K > 0; ++i) {
            if (cnt[i + 100] > 0) {
                int k = i < 0 ? Math.min(K, cnt[i + 100]) : K % 2;
                cnt[-i + 100] += k;
                cnt[i + 100] -= k;
                K = i < 0 ? K - k : 0;
            }
        }
        for (int i = -100; i <= 100; ++i) res += i * cnt[i + 100];
        return res;
        /*PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int x: A) pq.add(x);
        while( K--  > 0)
            pq.add(-pq.poll());

        int sum  = 0;
        for(int i = 0; i < A.length; i++){
            sum += pq.poll();
        }
        return sum;*/
        /*List<Integer> list = new ArrayList<>();
        for(int a : A){
            list.add(a);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? -1 : 1;
            }
        });
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if(num < 0 && K > 0) {
                num = -num;
            } else if(num >= 0 && K > 0 && K % 2 != 0) {
                if(i == 0) {
                    num = - num;
                } else {
                    num = -list.get(i - 1) < num ? list.get(i - 1) * 2 + num : -num;
                }
                K = 0;
            } else if (num >= 0 && K > 0 && K % 2 == 0) {
                K = 0;
            }
            sum += num;
            K--;
        }
        return sum;*/
    }

    public static int numDupDigitsAtMostN(int N) {
        // Transform N + 1 to arrayList
        List<Integer> L = new ArrayList<Integer>();
        for (int x = N + 1; x > 0; x /= 10)
            L.add(0, x % 10);

        // Count the number with digits < N
        int res = 0, n = L.size();
        for (int i = 1; i < n; ++i)
            res += 9 * A(9, i - 1);

        // Count the number with same prefix
        Set<Integer> seen = new HashSet();
        for (int i = 0; i < n; ++i) {
            for (int j = i > 0 ? 0 : 1; j < L.get(i); ++j)
                if (!seen.contains(j))
                    res += A(9 - i, n - i - 1);
            if (seen.contains(L.get(i))) break;
            seen.add(L.get(i));
        }
        return N - res;
    }

    public static int A(int m, int n) {
        return n == 0 ? 1 : A(m, n - 1) * (m - n + 1);
    }

    public static double myPow(double x, int n) {
       /*double num = x;
       while (n > 1) {
           x *= num;
           n--;
       }
       return x;*/
        if (n == 0) return 1;
        if (n < 0) return 1 / x * myPow(1 / x, -(n +1));
        return (n & 1) == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

    public static ListNode reverse(ListNode node, int k) {
        ListNode first = new ListNode(0);
        first.next = node;
        return reverseListNode(first, k);
    }

    private static int lengthListNode(ListNode node) {
        int length = 1;
        while (node.next != null) {
            node = node.next;
            length++;
        }
        return length;
    }

    public static ListNode reverseListNode(ListNode node, int k) {
        ListNode lastPreviousNode = node.next;
        ListNode lastNode = lastPreviousNode.next;
        if(lengthListNode(node) - 1 < k) {
            return node;
        }
        for (int i = 0; i < k - 1; i++) {
            lastPreviousNode.next = lastNode.next;
            lastNode.next = node.next;
            node.next = lastNode;
            lastNode = lastPreviousNode.next;
        }
        if(lastPreviousNode.next != null) {
            ListNode reverse = reverseListNode(lastPreviousNode, k);
            lastPreviousNode.next = reverse.next;
        }
        return node;
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        List<Integer> preOrders = arrayToList(preorder);
        return bstFromPreorder(preOrders);
    }

    public static TreeNode bstFromPreorder(List<Integer> preOrders) {
        TreeNode treeNode = new TreeNode(preOrders.get(0));
        int splitIndex = preOrders.size();
        if(splitIndex == 1) {
            return treeNode;
        }
        for (int i = 1; i < preOrders.size(); i++) {
            if(preOrders.get(i) > preOrders.get(0)) {
                splitIndex = i;
                break;
            }
        }

        List<Integer> leftOrders = preOrders.subList(1, splitIndex);
        List<Integer> rightOrders = preOrders.subList(splitIndex, preOrders.size());
        if(leftOrders.size() == 0) {
            treeNode.left = null;
        } else {
            treeNode.left = bstFromPreorder(leftOrders);
        }
        if(rightOrders.size() == 0) {
            treeNode.right = null;
        } else {
            treeNode.right = bstFromPreorder(rightOrders);
        }
        return treeNode;
    }

    public static List<Integer> arrayToList(int[] buf){
        List<Integer> list = new ArrayList();
        for(int i : buf){
            list.add(i);
        }
        return list;
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

class ListNode<T> implements Iterable<T> {
     T val;
     ListNode next;
     ListNode(T x) { val = x; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T t : this) {
            sb.append(t.toString()).append("->");
        }
        return sb.toString();
    }


    public Iterator<T> iterator() {
        return new Itr(this);
    }

    private class Itr implements Iterator {

        ListNode current = null;

        public Itr(ListNode node) {
            current = node;
        }


        public boolean hasNext() {
            return current.next != null;
        }


        public Object next() {
            current = current.next;
            return current.val;
        }

        public void remove() {

        }

        public void forEachRemaining(Consumer action) {

        }
    }

}
