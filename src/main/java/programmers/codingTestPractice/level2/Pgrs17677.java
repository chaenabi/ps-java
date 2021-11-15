package programmers.codingTestPractice.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * [1차] 뉴스 클러스터링]
 * https://programmers.co.kr/learn/courses/30/lessons/17677
 *
 * 문자열 길이:   2 <= str1, str1 <= 1000
 * 두 글자씩 끊어서 다중집합의 원소로 만든다. 영문자로된 글자 쌍만 유효하며
 * 공백, 숫자, 특수문자는 버린다. 
 * 대소문자 구별하지 않음
 * 자카드 유사도 출력. (교집합)/(합집합) * 65536, 소수점은 버린다.
 *
 * 합집합이 0이면 65536을 리턴한다.
 */
public class Pgrs17677 {

    public int solution(String str1, String str2) {

        str1 = leaveAlphaOnly(str1);
        str2 = leaveAlphaOnly(str2);

        List<String> str1List = cutStringTwoLetterEach(str1);
        List<String> str2List = cutStringTwoLetterEach(str2);

        List<String> intersection = searchSameElement(str1List, str2List);
        List<String> union = exceptSameElement(str1List, str2List);
        double zakad = (double) intersection.size() / union.size();
        if (union.size() == 0) return 65536;
        return (int) (zakad * 65536);
    }

    //

    // 4. 같은 요소 찾아서 반환 (교집합 수행)
    private List<String> searchSameElement(List<String> str1List, List<String> str2List) {
        List<String> list = new ArrayList<>();
        // {FR, RA, AN, NC, CE}
        // {FR, RE, EN, NC, CH}
        // 교: {FR, NC}
        // {1, 1, 1, 2, 3}
        // {1, 1, 1, 1, 1, 2}
        // 교: {1, 1, 1, 2}
        for (String str1 : str1List) {
            for (String str2 : str2List) {
                if (str1.equals(str2)) {
                    list.add(str1);
                    break;
                }
            }
        }
        return list;
    }

    // 5. 합집합 수행
    private List<String> exceptSameElement(List<String> str1List, List<String> str2List) {
        List<String> unionList = new ArrayList<>();
        // {FR, RA, AN, NC, CE}
        // {FR, RE, EN, NC, CH}
        // 합: {FR, RA, AN, NC, CE, RE, EN, CH}

        for (String str2 : str2List) {
            for (String str1 : str1List) {
                if (str2.equals(str1)) {
                    unionList.add(str2);
                    break;
                }
                if (!unionList.contains(str2)) {
                    unionList.add(str2);
                    break;
                }
            }
        }

        for (String str1 : str1List) {
            if (!unionList.contains(str1)) unionList.add(str1);
        }

        return unionList;
    }


    // 1. 영문자만 남기기
    private String leaveAlphaOnly(String str) {
        int strlen = str.length();

        char[] arr = new char[strlen];
        for (int i = 0; i < strlen; i++) {
            arr[i] = makeUpperCase(str.charAt(i));
        }

        for (int i = 0; i < strlen; i++) {
            if (90 < arr[i] || arr[i] < 65) {
                arr[i] = '$';
            }
        }

        return String.valueOf(arr);
    }

    // 2. 영문자를 모두 대문자로 변경
    private char makeUpperCase(char c) {
        if (c >= 97 && c <= 122) return (char) (c - 32);
        return c;
    }

    // 3. 2글자씩 끊어서 반환
    private List<String> cutStringTwoLetterEach(String str) {
        int strlen = str.length();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strlen; i++) {
            if (i + 1 >= strlen) break;
            if (str.charAt(i) != '$' && str.charAt(i + 1) != '$') {
                list.add((String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(i + 1))));
            }
        }
        return list;
    }

}
