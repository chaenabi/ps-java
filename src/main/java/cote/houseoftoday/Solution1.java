package cote.houseoftoday;


// 오늘의 집의 제품 목록 - 각 제품의 이름과 특성을 제공
// sofa, red long
// blanket, blue long
// towel, red
// curtain, blue long cheap

// 고객이 구매했던 제품 목록 ,이름만 제공
// towel
// curtain

// 고객에게 제품을 추천하려고 함
// 고객이 구매한 제품 목록을 이용해 제품의 우선순위를 정함
// 제품의 우선순위는 각 제품의 특성을 이용해 결정
// 고객이 구매하지 않은 제품 중에서 우선순위가 가장 높은 하나를 선택해 추천
// 특성의 우선순위는 다음과 같음
// 고객이 구매했던 제품들의 특성이 각각 몇 번 나타나는지 센다.
// 더 많이 나타난 특성의 우선순위가 더 높다.
// 나타는 횟수가 같으면 이름이 사전순으로 앞서는 특성이 더 높은 우선순위


import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    // costs = new int[]{1, 4, 99, 35, 50, 1000}
    public String solution(String[] products, String[] purchased) {

        Map<String, String> map = new HashMap<>();

        for (String product: products) {
            String[] split = product.split(" ");
            map.put(split[0], product);
        }

        


        return "";
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().solution(new String[]{"sofa red long"}, new String[]{"towel"}));
    }
}
