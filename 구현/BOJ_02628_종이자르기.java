/**
 * BOJ : 2628 S5 종이자르기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_02628_종이자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Integer> rowList = new ArrayList<>();
        List<Integer> colList = new ArrayList<>();

        rowList.add(0);
        rowList.add(X);
        colList.add(0);
        colList.add(Y);

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            if (num == 0)
                rowList.add(Integer.parseInt(st.nextToken()));
            else
                colList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(rowList);
        Collections.sort(colList);

        int maxX = 0, maxY = 0;

        for (int i = 0; i < rowList.size() - 1; i++) {
            int dist = rowList.get(i + 1) - rowList.get(i);

            maxX = Math.max(maxX, dist);
        }

        for (int i = 0; i < colList.size() - 1; i++) {
            int dist = colList.get(i + 1) - colList.get(i);

            maxY = Math.max(maxY, dist);
        }

        System.out.println(maxX * maxY);
    }
}
