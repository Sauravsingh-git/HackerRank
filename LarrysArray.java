static String larrysArray(int[] A) {

        int j = -1;

        for (int i = 0; i < A.length; i++) {
            int m = argMin(A, i);

            while (m != j+1 && ((m+1 < A.length && m-1 > j) || m-2 > j)) {
                if (m-2 > j) {
                    rotate(A, m-2, m-1, m);
                    m = m - 1;
                    rotate(A, m-1, m, m+1);
                    m = m - 1;
                } else if (m-1 > j && m+1 < A.length) {
                    rotate(A, m-1, m, m+1);
                    m = m - 1;
                }
            }

            if (m != j+1)
                return "NO";
            j = j + 1;
        }

        return "YES";
    }
