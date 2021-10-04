import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 숫자
		int n = Integer.parseInt(br.readLine());
		// 개미 수열
		// 1 -> 1
		// 2 -> 1 1* = 11
		// 3 -> 1 2* = 12
		// 4 -> 1 1* 2 1* = 1121
		// 5 -> 1 2* 2 1* 1 1* = 122111
		System.out.println(gami(n));
		
	}
	
	public static String gami(int n) {
        String s = "1";
        for (int i = 2; i <= n; i++) {
            int cnt = 1;
            char num = s.charAt(0);
            StringBuilder sb = new StringBuilder();
            
            for (int j = 1; j < s.length(); j++) {
                char c = s.charAt(j);
                // 연속 되는 수가 다른 수일 때
                if (num != c) {
                    sb.append(num).append(cnt);
                    // 다음수로 교체
                    num = c;
                    cnt = 1;
                }
                // 11 이런식으로 연속되어 같은 수일 때 
                else cnt++;
            }
            
            sb.append(num).append(cnt);
            // 문자열 갱신
            s = sb.toString();
        }
        return s;
    }
	
}
