package Code;

/**
 * 
 * @Description 二维数组查找
 * @author ZhangZhaoRu
 * @version
 * @date 2021年3月4日下午7:39:42
 *
 */
public class Search2DArr {
	public boolean isExistTarget(int[][] data, int target) {
//		if (data == null) {
//			return false;
//		}
		int row = data.length;
		int col = data[0].length;
		if(row==0||col==0) {
			return false;
		}
		if (target < data[0][0] || target > data[row - 1][col - 1]) {
			return false;
		}
		int i = 0;
		int j = col - 1;
		while (i < row && j >= 0) {
			if (data[i][j] > target) {
				j--;
			} else if (data[i][j] < target) {
				i++;
			} else if (data[i][j] == target) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] data = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		Search2DArr search2dArr = new Search2DArr();
		if(search2dArr.isExistTarget(data, 5)) {
			System.out.println("Can find the target!");
		}else {
			System.out.println("Can't find the target!");
		}
	}
}
