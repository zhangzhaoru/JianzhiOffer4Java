package Code;

import java.util.Iterator;

/*
 * 剑指Offer 找出数组中重复的数字
 * 建立一一对应的数组arr[i] = i
 * findDuplicate1只输出其中一个结果
 * findDuplicate2输出所有重复结果
 */
public class FindRepectNum {
	int findDuplicate1(int[] arr) {
		// 空数组或者对于数组类型的空引用int[] arr = null
		if (arr == null) {
			System.out.println("空数组引用");
			return -1;
		}
		if (arr.length == 0) {
			System.out.println("数组输入无效！");
			return -1;
		}
		for (int num : arr) {
			if (num < 0 || num > arr.length - 1) {
				System.out.println("数组元素超出范围");
				return -1;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			int temp = -1;
			while (arr[i] != i) {
				if (arr[arr[i]] == arr[i]) {
					return arr[i];
				} else {
					temp = arr[i];
					arr[i] = arr[temp];
					arr[temp] = temp;
				}
			}
		}
		System.out.println("数组中无重复数字！");
		return -1;
	}

	int[] findDuplicate2(int[] arr) {
		// 空数组或者对于数组类型的空引用int[] arr = null
		if (arr == null) {
			System.out.println("空数组引用");
			return null;
		}
		int[] res = new int[arr.length];
		if (arr.length == 0) {
			System.out.println("数组输入无效！");
			return res;
		}
		for (int num : arr) {
			if (num < 0 || num > arr.length - 1) {
				System.out.println("数组元素超出范围");
				return res;
			}
		}
		int k = 0;
		for (int i = 0; i < arr.length; i++) {
			int temp = -1;
			while (arr[i] != i) {
				if (arr[arr[i]] == arr[i]) {
					res[k] = arr[i];
					k++;
				}
				temp = arr[i];
				arr[i] = arr[temp];
				arr[temp] = temp;
			}
		}
		if (res.length == 0) {
			System.out.println("数组中无重复数字！");
		}
		return res;
	}

	//
	// ==================================测试代码==================================
	/**
	 * 数组为null
	 */
	void test1() {
		System.out.print("test1：");
		int[] a = null;
		int dup = findDuplicate1(a);
		if (dup >= 0)
			System.out.println("重复数字为：" + dup);
	}

	/**
	 * 数组无重复数字
	 */
	void test2() {
		System.out.print("test2：");
		int[] a = { 0, 1, 2, 3 };
		int dup = findDuplicate1(a);
		if (dup >= 0)
			System.out.println("重复数字为：" + dup);
	}

	/**
	 * 数组数字越界
	 */
	void test3() {
		System.out.print("test3：");
		int[] a = { 1, 2, 3, 4 };
		int dup = findDuplicate1(a);
		if (dup >= 0)
			System.out.println("重复数字为：" + dup);
	}

	/**
	 * 数组带重复数字
	 */
	void test4() {
		System.out.print("test4：");
		int[] a = { 1, 2, 3, 2, 4 };
		int dup = findDuplicate1(a);
		if (dup >= 0)
			System.out.println("重复数字为：" + dup);
	}

	void test5() {
		System.out.print("test5：");
		int[] a = { 1, 2, 3, 3, 2, 4 };
		int[] res = findDuplicate2(a);
		for (int i = 0; i < res.length - 1; i++) {
			System.out.println(res[i]);
		}
	}

	public static void main(String[] args) {
		FindRepectNum findRepectNum = new FindRepectNum();
		findRepectNum.test1();
		findRepectNum.test2();
		findRepectNum.test3();
		findRepectNum.test4();
		// findRepectNum.test5();
	}
}
