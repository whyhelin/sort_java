package cn.itcast;

/*
 * �鲢����(merge)��Ҳ�й鲢�㷨��ָ���ǽ������Ѿ���������кϲ���һ�����еĲ����� ����
 * ����������{6��202��100��301��38��8��1} ����
 * ��ʼ״̬�� [6] [202] [100] [301] [38] [8] [1] �Ƚϴ��� ����
 * i=1 [6 202 ] [ 100 301] [ 8 38] [ 1 ]��3 ����
 * i=2 [ 6 100 202 301 ] [ 1 8 38 ]��4 ����
 * i=3��[ 1 6 8 38 100 202 301 ] 4 
 */
public class MergeSort {
	public static void sort(int[] data) {
		int len = data.length;
		int[] temp = new int[len];
		mergeSort(data, temp, 0, len - 1);
	}

	private static void mergeSort(int[] data, int[] temp, int left, int right) {
		int mid = (left + right) / 2;
		if (left == right)
			return;
		mergeSort(data, temp, left, mid);
		mergeSort(data, temp, mid + 1, right);

		for (int i = left; i <= right; i++) {
			temp[i] = data[i];
		}

		int m = left;
		int n = mid + 1;
		for (int k = left; k <= right; k++) {
			if (m == mid + 1)
				data[k] = temp[n++];
			else if (n > right)
				data[k] = temp[m++];
			else if (temp[m] < temp[n])
				data[k] = temp[m++];
			else
				data[k] = temp[n++];
		}
	}
}
