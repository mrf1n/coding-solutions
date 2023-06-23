package by.mrf1n;

public class T0779_KthSymbolInGrammar {
    public static void main(String[] args) {
        int[][] nks = new int[][]{
                {1, 1},
                {2, 1},
                {2, 2},
                {4, 5}
        };
        for (int[] nk : nks) {
            System.out.println(new T0779_KthSymbolInGrammar().kthGrammar(nk[0], nk[1]));
        }
    }

    public int kthGrammar(int n, int k) {
        if (n < 1 || k < 1 || k > Math.pow(2, (n - 1))) {
            return -1;
        }
        if (n == 1) {
            return 0;
        } else {
            int kth = kthGrammar(n - 1, (k + 1) / 2);
            return k % 2 == 1 ^ kth == 1 ? 0 : 1;
        }
    }

    public void kthGrammar(int n) {
        String line = "";
        for (int i = 0; i < n; i++) {
            StringBuilder tmp = new StringBuilder();
            if (line.equals("")) {
                tmp = new StringBuilder("0");
            } else {
                for (int j = 0; j < line.length(); j++) {
                    if (line.charAt(j) == '0') {
                        tmp.append("01");
                    } else if (line.charAt(j) == '1') {
                        tmp.append("10");
                    }
                }
            }
            line = tmp.toString();
            System.out.println(tmp);
        }
    }
}
