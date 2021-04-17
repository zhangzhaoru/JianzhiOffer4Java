package com.zhangzhaoru.java;

import org.junit.Test;

import java.util.*;

/**
 * @BelongsProject: JianzhiOffer
 * @BelongsPackage: com.zhangzhaoru.java
 * @Author: ZhangZhaoru
 * @Date: 2021/4/15 9:04 下午
 * @Description:
 */
public class ListUtil {
    public static ListNode findKthToTail(ListNode pHead, int k) {
        // write code here
        int len = getListLen(pHead);
        if (k > len) {
            return null;
        }
        return findKthFromHead(pHead, len - k + 1);

    }

    public static ListNode findKthToTailII(ListNode pHead, int k) {
        if (pHead == null) {
            return null;
        }
        ListNode right = pHead;
        int count = 0;
        while (right != null) {
            right = right.next;
            count += 1;
            if (count == k) {
                break;
            }
        }
        if (count != k) {
            return null;
        }
        ListNode left = pHead;
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        return left;
    }

    public static ListNode findKthFromHead(ListNode pHead, int k) {
        ListNode node = pHead;
        if (pHead.next == null) {
            return null;
        }
        while (k != 0) {
            node = node.next;
            k--;
        }
        if (k != 0) {
            return null;
        }
        return node;
    }

    public static int getListLen(ListNode pHead) {
        ListNode p = pHead;
        int count = 0;

        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode head) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.reverse(list);
        return list;
    }

    public static ArrayList<Integer> printListFromTailToHeadII(ListNode pHead) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<Integer> tempStack = new Stack<>();
        while (pHead != null) {
            tempStack.push(pHead.val);
            pHead = pHead.next;
        }

        while (!tempStack.empty()) {
            list.add(tempStack.pop());
        }
        return list;
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode listNode = new ListNode(-1);
        ListNode pHead = listNode;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                listNode.next = list2;
                list2 = list2.next;

            } else {
                listNode.next = list1;
                list1 = list1.next;
            }
            listNode = listNode.next;
        }
        if (list1 != null) {
            listNode.next = list1;
        }
        if (list2 != null) {
            listNode.next = list2;
        }
        return pHead.next;
    }

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int index = 0;
        int minLen = Math.min(getListLen(pHead1), getListLen(pHead2));
        while (index < minLen && findKthToTailII(pHead1, index + 1).val == (findKthToTailII(pHead2, index + 1)).val) {
            index++;
        }
        if (index == 0) {
            return null;
        } else {
            return findKthToTailII(pHead1, index);
        }
    }


    public static RandomListNode Clone(RandomListNode pHead) {
        RandomListNode p1 = pHead;

        while (p1 != null) {
            RandomListNode tempNode = new RandomListNode(p1.val);
            tempNode.next = p1.next;
            p1.next = tempNode;
            p1 = tempNode.next;
        }
        p1 = pHead;
        while (p1 != null) {
            // 随机指针可能出现空指针的情况
            p1.next.random = p1.random == null ? null : p1.random.next;
            p1 = p1.next.next;
        }
        RandomListNode copyHead = new RandomListNode(0);
        p1 = copyHead;
        RandomListNode p = pHead;
        while (p != null) {
            p1.next = p.next;
            p1 = p1.next;
            p.next = p1.next;
            p = p.next;
        }
        return copyHead.next;
    }


    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        HashSet<ListNode> set = new HashSet<>();
        while (pHead != null) {
            if (!set.contains(pHead)) {
                set.add(pHead);
                pHead = pHead.next;
            } else {
                return pHead;
            }
        }
        return null;
    }

    // 保留一个重复元素
    public static ListNode deleteDuplication(ListNode pHead) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode p = pHead;
        while (p != null) {
            if (map.containsKey(p.val)) {
                map.put(p.val, map.get(p.val) + 1);
            } else {
                map.put(p.val, 1);
            }
            p = p.next;
        }
        p = pHead;
        ListNode res = new ListNode(0);
        ListNode p1 = res;
        while (p != null) {
            p1.next = new ListNode(p.val);
            p1 = p1.next;
            ListNode curNode = p;
            for (int i = 1; i <= map.get(curNode.val); i++) {
                p = p.next;
            }
        }
        return res.next;
    }

    // 完全去除重复元素
    public static ListNode deleteDuplicationII(ListNode pHead) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode p = pHead;
        while (p != null) {
            if (map.containsKey(p.val)) {
                map.put(p.val, map.get(p.val) + 1);
            } else {
                map.put(p.val, 1);
            }
            p = p.next;
        }
        p = pHead;
        ListNode res = new ListNode(0);
        ListNode p1 = res;
        while (p != null) {
            if (map.get(p.val) == 1) {
                p1.next = new ListNode(p.val);
                p1 = p1.next;
            }
            p = p.next;
        }
        return res.next;
    }


    public static void printList(ListNode pHead) {
        while (pHead != null) {
            System.out.print(pHead.val + " ");
            pHead = pHead.next;
        }
        System.out.println();
    }

    @Test
    public void test1() {
        ListNode pHead = new ListNode(-1);
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        pHead.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ArrayList<Integer> list = printListFromTailToHead(l1);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
            System.out.println();
        }
    }

    @Test
    public void test2() {
        ListNode pHead = new ListNode(-1);
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        pHead.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode listNode = FindFirstCommonNode(l1, l1);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();

    }

    @Test
    public void test3() {
        ListNode pHead = new ListNode(1);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(5);
        pHead.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        ListNode listNode = deleteDuplication(pHead);
        printList(listNode);
    }


}
