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

    static int bool2Int (boolean b) {
        if (b) {return 1;}
        else {return 0;}
    }

    public static void main (String[] args) {
        int total_score = 0;
        int score = 0;

        Point p1 = new Point(3, 2);
        Point p2 = new Point(-2, 2);
        Point p3 = new Point(5, 2);
        Point p4 = new Point(4, 1);
        Point p5 = new Point(-3, -2);

        //PointCompare
        try {
            PointCompare pc = new PointCompare();
            PointCompareRef pcr = new PointCompareRef();

            int res1_1 = pc.compare(p1, p2);
            int res1_2 = pc.compare(p1, p3);
            int res1_3 = pc.compare(p1, p4);
            int res1_4 = pc.compare(p1, p1);
            
            int ref1_1 = pcr.compare(p1, p2);
            int ref1_2 = pcr.compare(p1, p3);
            int ref1_3 = pcr.compare(p1, p4);
            int ref1_4 = pcr.compare(p1, p1);

            boolean pass1_1 = res1_1==ref1_1;
            boolean pass1_2 = res1_2==ref1_2;
            boolean pass1_3 = res1_3==ref1_3;
            boolean pass1_4 = res1_4==ref1_4;

            score = bool2Int(pass1_1) + bool2Int(pass1_2) + bool2Int(pass1_3) + bool2Int(pass1_4);
            total_score += score;
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

            int ref2_1 = pdcr.compare(p1, p5);
            int ref2_2 = pdcr.compare(p1, p2);
            int ref2_3 = pdcr.compare(p1, p3);
            
            boolean pass2_1 = res2_1==ref2_1;
            boolean pass2_2 = res2_2==ref2_2;
            boolean pass2_3 = res2_3==ref2_3;

            score = bool2Int(pass2_1) + bool2Int(pass2_2) + bool2Int(pass2_3);
            total_score += score;
            genResult("PointDistanceCompare", 1, pass2_1, res2_1, ref2_1);
            genResult("PointDistanceCompare", 2, pass2_2, res2_2, ref2_2);
            genResult("PointDistanceCompare", 3, pass2_3, res2_3, ref2_3);
            printScore("PointDistanceCompare", score, 3);
        } catch (Exception e) {}

        String s1 = "aTest";
        String s2 = "bTest";
        String s3 = "aT";
        String s4 = "longTest";

        //StringCompare
        try {
            StringCompare sc = new StringCompare();
            StringCompareRef scr = new StringCompareRef();

            int res3_1 = sc.compare(s1, s2);
            int res3_2 = sc.compare(s1, s3);
            int res3_3 = sc.compare(s1, s1);

            int ref3_1 = scr.compare(s1, s2);
            int ref3_2 = scr.compare(s1, s3);
            int ref3_3 = scr.compare(s1, s1);

            boolean pass3_1 = res3_1==ref3_1;
            boolean pass3_2 = res3_2==ref3_2;
            boolean pass3_3 = res3_3==ref3_3;

            score = bool2Int(pass3_1) + bool2Int(pass3_2) + bool2Int(pass3_3);
            total_score += score;
            genResult("StringCompare", 1, pass3_1, res3_1, ref3_1);
            genResult("StringCompare", 2, pass3_2, res3_2, ref3_2);
            genResult("StringCompare", 3, pass3_3, res3_3, ref3_3);
            printScore("StringCompare", score, 3);
        } catch (Exception e) {}

        //StringLengthCompare
        try {
            StringLengthCompare slc = new StringLengthCompare();
            StringLengthCompareRef slcr = new StringLengthCompareRef();

            int res4_1 = slc.compare(s1, s2);
            int res4_2 = slc.compare(s1, s3);
            int res4_3 = slc.compare(s1, s4);

            int ref4_1 = slcr.compare(s1, s2);
            int ref4_2 = slcr.compare(s1, s3);
            int ref4_3 = slcr.compare(s1, s4);

            boolean pass4_1 = res4_1==ref4_1;  
            boolean pass4_2 = res4_2==ref4_2;  
            boolean pass4_3 = res4_3==ref4_3;

            score = bool2Int(pass4_1) + bool2Int(pass4_2) + bool2Int(pass4_3);
            total_score += score;
            genResult("StringLengthCompare", 1, pass4_1, res4_1, ref4_1);
            genResult("StringLengthCompare", 2, pass4_2, res4_2, ref4_2);
            genResult("StringLengthCompare", 3, pass4_3, res4_3, ref4_3);
            printScore("StringLengthCompare", score, 3);
        } catch (Exception e) {}

        //BooleanCompare
        try {
            BooleanCompare bc = new BooleanCompare();
            BooleanCompareRef bcr = new BooleanCompareRef();

            int res5_1 = bc.compare(true, true);
            int res5_2 = bc.compare(true, false);
            int res5_3 = bc.compare(false, false);
            int res5_4 = bc.compare(false, true);

            int ref5_1 = bcr.compare(true, true);
            int ref5_2 = bcr.compare(true, false);
            int ref5_3 = bcr.compare(false, false);
            int ref5_4 = bcr.compare(false, true);

            boolean pass5_1 = res5_1==ref5_1;
            boolean pass5_2 = res5_2==ref5_2;
            boolean pass5_3 = res5_3==ref5_3;
            boolean pass5_4 = res5_4==ref5_4;

            score = bool2Int(pass5_1) + bool2Int(pass5_2) + bool2Int(pass5_3) + bool2Int(pass5_4);
            total_score += score;
            genResult("BooleanCompare", 1, pass5_1, res5_1, ref5_1);
            genResult("BooleanCompare", 2, pass5_2, res5_2, ref5_2);
            genResult("BooleanCompare", 3, pass5_3, res5_3, ref5_3);
            genResult("BooleanCompare", 4, pass5_4, res5_4, ref5_4);
            printScore("BooleanCompare", score, 4);
        } catch (Exception e) {}

        //CompareLists
        score = 0;

        CompareLists cl = new CompareLists();
        CompareListsRef clr = new CompareListsRef();

        Boolean[] a1 = {true, false, false};
        Boolean[] a2 = {true, true, false, true};

        List<Boolean> ar1 = new ArrayList<Boolean>(Arrays.asList(a1));
        List<Boolean> ar2 = new ArrayList<Boolean>(Arrays.asList(a2));

        String[] a3 = {"abc", "ab", "aaaa", "bcd"};
        String[] a4 = {"abc", "bcde", "cdefg"};

        List<String> ar3 = new ArrayList<String>(Arrays.asList(a3));
        List<String> ar4 = new ArrayList<String>(Arrays.asList(a4));

        Point[] a5 = {p1, p2, p3, p4, p5};
        Point[] a6 = {p3, p2, p5};

        List<Point> ar5 = new ArrayList<Point>(Arrays.asList(a5));
        List<Point> ar6 = new ArrayList<Point>(Arrays.asList(a6));

        //minimum - ArrayList
        try{
            PointCompare pc = new PointCompare();
            PointCompareRef pcr = new PointCompareRef();

            Point res_min_1 = cl.minimum(ar5, pc);
            Point res_min_2 = cl.minimum(ar6, pc);

            Point ref_min_1 = clr.minimum(ar5, pcr);
            Point ref_min_2 = clr.minimum(ar6, pcr);

            boolean pass_min_1 = pcr.compare(res_min_1, ref_min_1)==0;
            boolean pass_min_2 = pcr.compare(res_min_2, ref_min_2)==0;

            score += bool2Int(pass_min_1) + bool2Int(pass_min_2);
            genResult("PointCompare (ArrayList<String>)", 1, pass_min_1, res_min_1, ref_min_1);
            genResult("PointCompare (ArrayList<String>)", 1, pass_min_2, res_min_2, ref_min_2);
        } catch (Exception e) {}

        System.out.println("PA8 total score : " + total_score);
    }
}