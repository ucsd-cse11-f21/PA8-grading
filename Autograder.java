import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;

class Autograder {

    static <E> void genResult(String title, int num, boolean flag, E res, E ref) {
        String fb = title + " test " + num + " failed : Expected: " + ref + " ; Your result : " + res;
        if (flag) {
            fb = title + " test " + num + " passed";
        }
        System.out.println(fb);
    }

    static void printScore(String title, int score, int max) {
        System.out.println(title + " score : " + score + "/" + max);
    }

    static String pt2Str (Point p) {
        return "Point: x = " + p.x + ", y = " + p.y;
    }

    static String pt2Str (PointRef p) {
        return "Point: x = " + p.x + ", y = " + p.y;
    }

    static int bool2Int (boolean b) {
        if (b) {return 1;}
        else {return 0;}
    }

    public static void main (String[] args) {
        int score = 0;

        Point p1 = new Point(3, 2);
        Point p2 = new Point(-2, 2);
        Point p3 = new Point(5, 2);
        Point p4 = new Point(4, 1);
        Point p5 = new Point(-3, -2);

        PointRef pr1 = new PointRef(3, 2);
        PointRef pr2 = new PointRef(-2, 2);
        PointRef pr3 = new PointRef(5, 2);
        PointRef pr4 = new PointRef(4, 1);
        PointRef pr5 = new PointRef(-3, -2);

        //PointCompare
        try {
            PointCompare pc = new PointCompare();
            PointCompareRef pcr = new PointCompareRef();

            int res1_1 = pc.compare(p1, p2);
            int res1_2 = pc.compare(p1, p3);
            int res1_3 = pc.compare(p1, p4);
            int res1_4 = pc.compare(p1, p1);
            
            int ref1_1 = pcr.compare(pr1, pr2);
            int ref1_2 = pcr.compare(pr1, pr3);
            int ref1_3 = pcr.compare(pr1, pr4);
            int ref1_4 = pcr.compare(pr1, pr1);

            boolean pass1_1 = res1_1==ref1_1;
            boolean pass1_2 = res1_2==ref1_2;
            boolean pass1_3 = res1_3==ref1_3;
            boolean pass1_4 = res1_4==ref1_4;

            score = bool2Int(pass1_1) + bool2Int(pass1_2) + bool2Int(pass1_3) + bool2Int(pass1_4);
            genResult("PointCompare", 1, pass1_1, res1_1, ref1_1);
            genResult("PointCompare", 2, pass1_2, res1_2, ref1_2);
            genResult("PointCompare", 3, pass1_3, res1_3, ref1_3);
            genResult("PointCompare", 4, pass1_4, res1_4, ref1_4);
            printScore("PointCompare", score, 4);
        } catch (Exception e) {}

        //PointDistanceCompare
        try {
            PointDistanceCompare pdc = new PointDistanceCompare();
            PointDistanceCompareRef pdcr = new PointDistanceCompareRef();

            int res2_1 = pdc.compare(p1, p5);
            int res2_2 = pdc.compare(p1, p2);
            int res2_3 = pdc.compare(p1, p3);

            int ref2_1 = pdcr.compare(pr1, pr5);
            int ref2_2 = pdcr.compare(pr1, pr2);
            int ref2_3 = pdcr.compare(pr1, pr3);
            
            boolean pass2_1 = res2_1==ref2_1;
            boolean pass2_2 = res2_2==ref2_2;
            boolean pass2_3 = res2_3==ref2_3;

            score = bool2Int(pass2_1) + bool2Int(pass2_2) + bool2Int(pass2_3);
            genResult("PointDistanceCompare", 1, pass2_1, res2_1, ref2_1);
            genResult("PointDistanceCompare", 2, pass2_2, res2_2, ref2_2);
            genResult("PointDistanceCompare", 3, pass2_3, res2_3, ref2_3);
            printScore("PointDistanceCompare", score, 3);
        } catch (Exception e) {}
    }
}