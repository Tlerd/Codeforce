import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        // int T = sc.nextInt(); // nếu có nhiều test case
        // while (T-- > 0) solve(sc);
        solve(sc);
        close();
    }

    static void solve(FastScanner sc) {
        // Code chính ở đây

        int d = sc.nextInt();
        int SumTime = sc.nextInt();

        int[] MinTime = new int[d];
        int[] MaxTime = new int[d];

        int MinSum = 0;
        int MaxSum = 0;
        for (int i = 0; i < d; i++) {
            MinTime[i] = sc.nextInt();
            MaxTime[i] = sc.nextInt();

            MinSum += MinTime[i];
            MaxSum += MaxTime[i];
        }

        if (SumTime < MinSum ||  SumTime > MaxSum) {
            System.out.println("NO");
            return;
        }

        int[] schedule =  new int[d];

        for (int i = 0; i < d; i++){
           schedule[i] = MinTime[i];
        }

        int remain = SumTime - MinSum;

        for (int i = 0; i < d; i++) {
            if (remain == 0){
                break;
            }

            int canAdd = MaxTime[i] - schedule[i];
            int add = Math.min(canAdd, remain);
            schedule[i] += add;
            remain -= add;
        }

        System.out.println("YES");
        for (int i = 0; i < d; i++) {
            System.out.print(schedule[i] + " ");
        }
    }

    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static void close() {
        out.flush();
        out.close();
    }
}