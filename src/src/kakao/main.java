package kakao;
import java.util.*;
public class main {

    public static void Main(String[] args) throws Exception{

    }

    class Solution {
        public int[] solution(String[] words, String[] queries) {
            HashMap<String,Integer> map = new HashMap(); // 쿼리 : 검색 결과 해시맵
            int[] answer = new int[queries.length];

            for(String q : queries){
                if(!map.containsKey(q)){ // 검색 기록이 없을 경우
                    int index = 0;
                    int s = q.length();
                    int start,end; // 검색 키워드 중 고정 문자열의 시작과 끝 인덱스
                    int tmp = 0; // 검색 키워드 중 와일드 카드 갯수
                    String qTmp = ""; // 검색 키워드 중 고정 문자열
                    for(int i = 0; i < s; i++){ // 전체 문자에서
                        if(q.substring(i,i+1).equals("?")) // 와일드 카드 갯수
                            tmp+=1;
                    }
                    if(q.substring(0,1).equals("?")){ // 접두사가 와일드 카드일 경우
                        start = tmp; // 고정 문자 시작의 인덱스
                        end = s; // 고정 문자 끝의 인덱스
                    } else { // 접미사가 와일드 카드일 경우
                        start = 0;
                        end = s-tmp;
                    }
                    qTmp = q.substring(start,end); // 비교할 고정 문자열
                    for(String k : words){ // 가사 내부에서
                        if(q.length() == k.length()){ // 우선적으로 문자열 길이가 동일할 때
                            String kTmp = k.substring(start,end); // 검색 키워드의 고정 문자열과 동일한 부분을 추출
                            if(qTmp.equals(kTmp)){ // 비교하여 동일할 경우 나머지는 와일드 카드이므로
                                index++;
                            }
                        }
                    }
                    map.put(q,index);
                }
            }
            for(int i = 0; i < queries.length; i++){
                String k = queries[i];
                answer[i] = map.get(k);
            }
            return answer;
        }

    }
}
