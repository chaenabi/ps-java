package LeetCode;

/**
 * 26. 정렬된 배열에서 중복 제거하기
 *
 * 오름차순으로 정렬된 정수 배열 nums가 주어졌을 때,
 * 각 고유한 요소가 한 번만 나타나도록 중복을 제자리에서(in-place) 제거하세요.
 * 요소들의 상대적인 순서는 유지되어야 합니다.
 *
 * 일부 언어에서는 배열의 길이를 변경할 수 없기 때문에,
 * 결과는 배열 nums의 첫 부분에 배치되어야 합니다.
 * 더 정확히 말하면, 중복 제거 후 k개의 요소가 있다면,
 * nums의 첫 k개 요소가 최종 결과를 담아야 합니다.
 * 첫 k개 요소 이후에 무엇이 남아있는지는 중요하지 않습니다.
 *
 * nums의 첫 k개 슬롯에 최종 결과를 배치한 후 k를 반환하세요.
 *
 * 다른 배열을 위한 추가 공간을 할당하지 마세요.
 * O(1)의 추가 메모리만 사용하여 입력 배열을 제자리에서 수정해야 합니다.
 *
 * 예제 1:
 * 입력: nums = [1,1,2]
 * 출력: 2, nums = [1,2,_]
 *
 * 예제 2:
 * 입력: nums = [0,0,1,1,1,2,2,3,3,4]
 * 출력: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 *
 * 제약 조건:
 * - 1 <= nums.length <= 3 * 10^4
 * - -100 <= nums[i] <= 100
 * - nums는 오름차순으로 정렬되어 있음
 */
public class Leet26 {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;

    }

    public static void main(String[] args) {
        Leet26 solution = new Leet26();

        System.out.println("=== Test Case 1 ===");
        int[] nums1 = {1, 1, 2};
        System.out.print("입력: [");
        printArray(nums1);
        System.out.println("]");

        int k1 = solution.removeDuplicates(nums1);
        System.out.println("반환값 k: " + k1);
        System.out.print("수정된 배열 (첫 " + k1 + "개): [");
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i]);
            if (i < k1 - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println();

        System.out.println("=== Test Case 2 ===");
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.print("입력: [");
        printArray(nums2);
        System.out.println("]");

        int k2 = solution.removeDuplicates(nums2);
        System.out.println("반환값 k: " + k2);
        System.out.print("수정된 배열 (첫 " + k2 + "개): [");
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i]);
            if (i < k2 - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println();

        System.out.println("=== Test Case 3 (모두 동일) ===");
        int[] nums3 = {1, 1, 1, 1, 1};
        System.out.print("입력: [");
        printArray(nums3);
        System.out.println("]");

        int k3 = solution.removeDuplicates(nums3);
        System.out.println("반환값 k: " + k3);
        System.out.print("수정된 배열 (첫 " + k3 + "개): [");
        for (int i = 0; i < k3; i++) {
            System.out.print(nums3[i]);
            if (i < k3 - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println();

        System.out.println("=== Test Case 4 (중복 없음) ===");
        int[] nums4 = {1, 2, 3, 4, 5};
        System.out.print("입력: [");
        printArray(nums4);
        System.out.println("]");

        int k4 = solution.removeDuplicates(nums4);
        System.out.println("반환값 k: " + k4);
        System.out.print("수정된 배열 (첫 " + k4 + "개): [");
        for (int i = 0; i < k4; i++) {
            System.out.print(nums4[i]);
            if (i < k4 - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
    }
}




















