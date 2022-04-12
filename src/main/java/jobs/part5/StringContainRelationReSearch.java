package jobs.part5;

import java.util.Scanner;

public class StringContainRelationReSearch {

        public static void main(String[] args){

            // Please Enter Your Code Here
            Scanner sc = new Scanner(System.in);
            String origin = sc.nextLine();
            String word = sc.nextLine();
            for (int i = 0, j = 0; i < origin.length(); i++) {
                if (origin.charAt(i) == word.charAt(j)) {
                    j++;
                    if (j == word.length()) {
                        System.out.println("YES");
                        return;
                    }
                }
                else {
                    if (j != 0) i -= j;
                    j = 0;
                }
            }

            System.out.println("NO");
        }

}
