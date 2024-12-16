class Solution {

    class Class {
        int pass;
        int total;

        public Class(int pass, int total) {
            this.pass = pass;
            this.total = total;
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {

        PriorityQueue<Class> pq = new PriorityQueue<>((a, b) -> {
            double diffA = (double) (a.pass + 1) / (a.total + 1) - (double) a.pass / a.total;
            double diffB = (double) (b.pass + 1) / (b.total + 1) - (double) b.pass / b.total;
            return Double.compare(diffB, diffA);
        });

        for (int[] c : classes) {
            pq.offer(new Class(c[0], c[1]));
        }

        while (extraStudents-- > 0) {
            Class cur = pq.poll();
            cur.pass += 1;
            cur.total += 1;
            pq.offer(cur);
        }

        double totalRatio = 0.0;
        int n = classes.length;

        while (!pq.isEmpty()) {
            Class cur = pq.poll();
            totalRatio += (double) cur.pass / cur.total;
        }

        return totalRatio / n;
    }
}