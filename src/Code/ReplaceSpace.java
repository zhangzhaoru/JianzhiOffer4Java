package Code;

/**
 * 
 * @Description 将字符串中空格替换为指定字符串
 * @author ZhangZhaoRu
 * @version
 * @date 2021年3月4日下午9:02:58
 *
 */
public class ReplaceSpace {
	public static String replaceSpaceFun(String str) {
		String res = "";
		char[] arr = str.toCharArray();
		for(int i = 0;i<arr.length;i++) {
			if(arr[i]==' ') {
				res+="%20";
			}else {
				res+=String.valueOf(arr[i]);
			}
		}
		return res;
	}

	public static String reverse(String str) {
		return new StringBuilder(str).reverse().toString();
	}
	
	public static void main(String[] args) {
		String str = "We%20are%20happy.";
		System.out.println(replaceSpaceFun(str));
	}
}
