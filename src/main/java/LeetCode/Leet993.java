package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leet993 {

    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) { // bfs
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }

            List<TreeNode> list = (List<TreeNode>) queue;

            int xindex = -1;
            int yindex = -1;

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null) {
                    if (list.get(i).val == x) {
                        xindex = i;
                    }
                    if (list.get(i).val == y) {
                        yindex = i;
                    }
                    if (xindex != -1 && yindex != -1) break;
                }
            }
            if (xindex != -1 && yindex != -1) {
                if (xindex / 2 == yindex / 2) return false;
                else return true;
            }
            else if (xindex != -1 || yindex != -1) {
                return false;
            }
        }
        /*
            1. 같은 레벨의 형제 또는 사촌을 구한다
            2. x의 위치와 y의 위치를 구한다.
            3-1. x가 없거나 y가 없다면 x와 y의 뎁스는 다르다. false
            3-2. 둘다 없다면 queue 계속 진행
            3-3. 둘다 있으면 (형제냐, 사촌이냐 검사를 해야함)
            01 23 45

            "01":0, "23":1, "45":2, "67":3
            0, 2, 4, 6

            0/2, 1/2 -> 0
            2/2, 3/2 -> 1
            4/2, 5/2 -> 2
         */

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(new Leet993().isCousins(root, 5, 4));
    }
}
