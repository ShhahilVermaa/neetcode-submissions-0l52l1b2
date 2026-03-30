class Solution {

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start >= end) return;

        int middle = (start + end) / 2;

        mergeSort(nums, start, middle);
        mergeSort(nums, middle + 1, end);

        merge(nums, start, middle, end);
    }

    private void merge(int[] arr, int start, int middle, int end) {

        ArrayList<Integer> temp = new ArrayList<>();

        int i = start;
        int j = middle + 1;

        while (i <= middle && j <= end) {
            if (arr[i] <= arr[j]) {
                temp.add(arr[i++]);
            } else {
                temp.add(arr[j++]);
            }
        }

        while (i <= middle) temp.add(arr[i++]);
        while (j <= end) temp.add(arr[j++]);

        for (int p = 0; p < temp.size(); p++) {
            arr[start + p] = temp.get(p);
        }
    }
}