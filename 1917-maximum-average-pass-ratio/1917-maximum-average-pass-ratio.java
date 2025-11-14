class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        double answer = 0.0;
        PriorityQueue<Student> q = new PriorityQueue<>(
            (a, b) -> Double.compare(b.gain(), a.gain()) // 증가분 큰 순
        );
        for (int i = 0; i < classes.length; i++) {
            Student s = new Student(classes[i][0], classes[i][1]);
            q.offer(s);
        }

        while (extraStudents > 0) {
            Student s = q.poll();
            s.pass++;
            s.total++;
            q.add(s);
            extraStudents--;
        }

        for (int i = 0; i < classes.length; i++) {
            Student s = q.poll();
            double r = s.ratio();
            answer += r;
        }
        return answer / classes.length;
    }
}

class Student implements Comparable<Student> {
    int pass;
    int total;

    public Student(int pass, int total) {
        this.pass = pass;
        this.total = total;
    }

    double ratio() {                // 합격 비율
        return (double) pass / total;
    }

    @Override
    public int compareTo(Student o) {  // 내림차순
        return Double.compare(this.ratio(), o.ratio());
    }
       double gain() {
        // (p+1)/(t+1) - p/t
        return ((double)(pass + 1) / (total + 1)) - ((double) pass / total);
    }
}