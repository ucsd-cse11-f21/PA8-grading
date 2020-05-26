import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.StringWriter;

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

    static <E> boolean same(List<E> e1, List<E> e2, Comparator<E> c) {
        if (e1.size() != e2.size()) {return false;}
        for (int i = 0; i < e1.size(); i++) {
            if (c.compare(e1.get(i), e2.get(i)) != 0) {
                return false;
            }
        }
        return true;
    }

    static <E> boolean same(E[] e1, E[] e2, Comparator<E> c) {
        if (e1.length != e2.length) {return false;}
        for (int i = 0; i < e1.length; i++) {
            if (c.compare(e1[i], e2[i]) != 0) {
                return false;
            }
        }
        return true;
    }

    static boolean sameSign(int a1, int a2) {
        if ((a1 > 0 && a2 > 0) || (a1 < 0 && a2 < 0) || (a1 == 0 && a2 == 0)) {
            return true;
        }
        else {
            return false;
        }
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

            boolean pass1_1 = sameSign(res1_1, ref1_1);
            boolean pass1_2 = sameSign(res1_2, ref1_2);
            boolean pass1_3 = sameSign(res1_3, ref1_3);
            boolean pass1_4 = sameSign(res1_4, ref1_4);

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
            
            boolean pass2_1 = sameSign(res2_1, ref2_1);
            boolean pass2_2 = sameSign(res2_2, ref2_2);
            boolean pass2_3 = sameSign(res2_3, ref2_3);

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

            boolean pass3_1 = sameSign(res3_1, ref3_1);
            boolean pass3_2 = sameSign(res3_2, ref3_2);
            boolean pass3_3 = sameSign(res3_3, ref3_3);

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

            boolean pass4_1 = sameSign(res4_1, ref4_1);  
            boolean pass4_2 = sameSign(res4_2, ref4_2);  
            boolean pass4_3 = sameSign(res4_3, ref4_3);

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

            boolean pass5_1 = sameSign(res5_1, ref5_1);
            boolean pass5_2 = sameSign(res5_2, ref5_2);
            boolean pass5_3 = sameSign(res5_3, ref5_3);
            boolean pass5_4 = sameSign(res5_4, ref5_4);

            score = bool2Int(pass5_1) + bool2Int(pass5_2) + bool2Int(pass5_3) + bool2Int(pass5_4);
            total_score += score;
            genResult("BooleanCompare", 1, pass5_1, res5_1, ref5_1);
            genResult("BooleanCompare", 2, pass5_2, res5_2, ref5_2);
            genResult("BooleanCompare", 3, pass5_3, res5_3, ref5_3);
            genResult("BooleanCompare", 4, pass5_4, res5_4, ref5_4);
            printScore("BooleanCompare", score, 4);
        } catch (Exception e) {}

        //CompareLists

        CompareLists cl = new CompareLists();
        CompareListsRef clr = new CompareListsRef();

        Boolean[] a1 = {true, false, false};
        Boolean[] a2 = {true, true, true, true};

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

        score = 0;
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
            genResult("minimum - ArrayList - PointCompare", 1, pass_min_1, res_min_1, ref_min_1);
            genResult("minimum - ArrayList - PointCompare", 2, pass_min_2, res_min_2, ref_min_2);
        } catch (Exception e) {}

        try{
            PointDistanceCompare pdc = new PointDistanceCompare();
            PointDistanceCompareRef pdcr = new PointDistanceCompareRef();
            PointCompareRef pcr = new PointCompareRef();

            Point res_min_1 = cl.minimum(ar5, pdc);
            Point res_min_2 = cl.minimum(ar6, pdc);

            Point ref_min_1 = clr.minimum(ar5, pdcr);
            Point ref_min_2 = clr.minimum(ar6, pdcr);

            boolean pass_min_1 = pcr.compare(res_min_1, ref_min_1)==0;
            boolean pass_min_2 = pcr.compare(res_min_2, ref_min_2)==0;

            score += bool2Int(pass_min_1) + bool2Int(pass_min_2);
            genResult("minimum - ArrayList - PointDistanceCompare", 1, pass_min_1, res_min_1, ref_min_1);
            genResult("minimum - ArrayList - PointDistanceCompare", 2, pass_min_2, res_min_2, ref_min_2);
        } catch (Exception e) {}

        try{
            StringCompare sc = new StringCompare();
            StringCompareRef scr = new StringCompareRef();

            String res_min_1 = cl.minimum(ar3, sc);
            String res_min_2 = cl.minimum(ar4, sc);

            String ref_min_1 = clr.minimum(ar3, scr);
            String ref_min_2 = clr.minimum(ar4, scr);

            boolean pass_min_1 = scr.compare(res_min_1, ref_min_1)==0;
            boolean pass_min_2 = scr.compare(res_min_2, ref_min_2)==0;

            score += bool2Int(pass_min_1) + bool2Int(pass_min_2);
            genResult("minimum - ArrayList - StringCompare", 1, pass_min_1, res_min_1, ref_min_1);
            genResult("minimum - ArrayList - StringCompare", 2, pass_min_2, res_min_2, ref_min_2);
        } catch (Exception e) {}

        try{
            StringLengthCompare slc = new StringLengthCompare();
            StringLengthCompareRef slcr = new StringLengthCompareRef();
            StringCompareRef scr = new StringCompareRef();

            String res_min_1 = cl.minimum(ar3, slc);
            String res_min_2 = cl.minimum(ar4, slc);

            String ref_min_1 = clr.minimum(ar3, slcr);
            String ref_min_2 = clr.minimum(ar4, slcr);

            boolean pass_min_1 = scr.compare(res_min_1, ref_min_1)==0;
            boolean pass_min_2 = scr.compare(res_min_2, ref_min_2)==0;

            score += bool2Int(pass_min_1) + bool2Int(pass_min_2);
            genResult("minimum - ArrayList - StringLengthCompare", 1, pass_min_1, res_min_1, ref_min_1);
            genResult("minimum - ArrayList - StringLengthCompare", 2, pass_min_2, res_min_2, ref_min_2);
        } catch (Exception e) {}

        try{
            BooleanCompare bc = new BooleanCompare();
            BooleanCompareRef bcr = new BooleanCompareRef();

            Boolean res_min_1 = cl.minimum(ar1, bc);
            Boolean res_min_2 = cl.minimum(ar2, bc);

            Boolean ref_min_1 = clr.minimum(ar1, bcr);
            Boolean ref_min_2 = clr.minimum(ar2, bcr);

            boolean pass_min_1 = bcr.compare(res_min_1, ref_min_1)==0;
            boolean pass_min_2 = bcr.compare(res_min_2, ref_min_2)==0;

            score += bool2Int(pass_min_1) + bool2Int(pass_min_2);
            genResult("minimum - ArrayList - BooleanCompare", 1, pass_min_1, res_min_1, ref_min_1);
            genResult("minimum - ArrayList - BooleanCompare", 2, pass_min_2, res_min_2, ref_min_2);
        } catch (Exception e) {}
        
        printScore("minimum - ArrayList", score, 10);
        total_score += score;
        score = 0;

        //minimum - Array
        try{
            PointCompare pc = new PointCompare();
            PointCompareRef pcr = new PointCompareRef();

            Point res_min_1 = cl.minimum(a5, pc);
            Point res_min_2 = cl.minimum(a6, pc);

            Point ref_min_1 = clr.minimum(a5, pcr);
            Point ref_min_2 = clr.minimum(a6, pcr);

            boolean pass_min_1 = pcr.compare(res_min_1, ref_min_1)==0;
            boolean pass_min_2 = pcr.compare(res_min_2, ref_min_2)==0;

            score += bool2Int(pass_min_1) + bool2Int(pass_min_2);
            genResult("minimum - Array - PointCompare", 1, pass_min_1, res_min_1, ref_min_1);
            genResult("minimum - Array - PointCompare", 2, pass_min_2, res_min_2, ref_min_2);
        } catch (Exception e) {}

        try{
            PointDistanceCompare pdc = new PointDistanceCompare();
            PointDistanceCompareRef pdcr = new PointDistanceCompareRef();
            PointCompareRef pcr = new PointCompareRef();

            Point res_min_1 = cl.minimum(a5, pdc);
            Point res_min_2 = cl.minimum(a6, pdc);

            Point ref_min_1 = clr.minimum(a5, pdcr);
            Point ref_min_2 = clr.minimum(a6, pdcr);

            boolean pass_min_1 = pcr.compare(res_min_1, ref_min_1)==0;
            boolean pass_min_2 = pcr.compare(res_min_2, ref_min_2)==0;

            score += bool2Int(pass_min_1) + bool2Int(pass_min_2);
            genResult("minimum - Array - PointDistanceCompare", 1, pass_min_1, res_min_1, ref_min_1);
            genResult("minimum - Array - PointDistanceCompare", 2, pass_min_2, res_min_2, ref_min_2);
        } catch (Exception e) {}

        try{
            StringCompare sc = new StringCompare();
            StringCompareRef scr = new StringCompareRef();

            String res_min_1 = cl.minimum(a3, sc);
            String res_min_2 = cl.minimum(a4, sc);

            String ref_min_1 = clr.minimum(a3, scr);
            String ref_min_2 = clr.minimum(a4, scr);

            boolean pass_min_1 = scr.compare(res_min_1, ref_min_1)==0;
            boolean pass_min_2 = scr.compare(res_min_2, ref_min_2)==0;

            score += bool2Int(pass_min_1) + bool2Int(pass_min_2);
            genResult("minimum - Array - StringCompare", 1, pass_min_1, res_min_1, ref_min_1);
            genResult("minimum - Array - StringCompare", 2, pass_min_2, res_min_2, ref_min_2);
        } catch (Exception e) {}

        try{
            StringLengthCompare slc = new StringLengthCompare();
            StringLengthCompareRef slcr = new StringLengthCompareRef();
            StringCompareRef scr = new StringCompareRef();

            String res_min_1 = cl.minimum(a3, slc);
            String res_min_2 = cl.minimum(a4, slc);

            String ref_min_1 = clr.minimum(a3, slcr);
            String ref_min_2 = clr.minimum(a4, slcr);

            boolean pass_min_1 = scr.compare(res_min_1, ref_min_1)==0;
            boolean pass_min_2 = scr.compare(res_min_2, ref_min_2)==0;

            score += bool2Int(pass_min_1) + bool2Int(pass_min_2);
            genResult("minimum - Array - StringLengthCompare", 1, pass_min_1, res_min_1, ref_min_1);
            genResult("minimum - Array - StringLengthCompare", 2, pass_min_2, res_min_2, ref_min_2);
        } catch (Exception e) {}

        try{
            BooleanCompare bc = new BooleanCompare();
            BooleanCompareRef bcr = new BooleanCompareRef();

            Boolean res_min_1 = cl.minimum(a1, bc);
            Boolean res_min_2 = cl.minimum(a2, bc);

            Boolean ref_min_1 = clr.minimum(a1, bcr);
            Boolean ref_min_2 = clr.minimum(a2, bcr);

            boolean pass_min_1 = bcr.compare(res_min_1, ref_min_1)==0;
            boolean pass_min_2 = bcr.compare(res_min_2, ref_min_2)==0;

            score += bool2Int(pass_min_1) + bool2Int(pass_min_2);
            genResult("minimum - Array - BooleanCompare", 1, pass_min_1, res_min_1, ref_min_1);
            genResult("minimum - Array - BooleanCompare", 2, pass_min_2, res_min_2, ref_min_2);
        } catch (Exception e) {}

        printScore("minimum - Array", score, 10);
        total_score += score;
        score = 0;

        //greater than
        try {
            PointCompare pc = new PointCompare();
            PointDistanceCompare pdc = new PointDistanceCompare();
            StringCompare sc = new StringCompare();
            StringLengthCompare slc = new StringLengthCompare();
            BooleanCompare bc = new BooleanCompare();

            PointCompareRef pcr = new PointCompareRef();
            PointDistanceCompareRef pdcr = new PointDistanceCompareRef();
            StringCompareRef scr = new StringCompareRef();
            StringLengthCompareRef slcr = new StringLengthCompareRef();
            BooleanCompareRef bcr = new BooleanCompareRef();

            List<Point> res_gt_1 = cl.greaterThan(ar5, pc, p2);
            List<Point> res_gt_2 = cl.greaterThan(ar6, pc, p1);
            List<Point> res_gt_3 = cl.greaterThan(ar5, pdc, p2);
            List<Point> res_gt_4 = cl.greaterThan(ar6, pdc, p1);
            List<String> res_gt_5 = cl.greaterThan(ar3, sc, "abc");
            List<String> res_gt_6 = cl.greaterThan(ar4, sc, "abc");
            List<String> res_gt_7 = cl.greaterThan(ar3, slc, "abc");
            List<String> res_gt_8 = cl.greaterThan(ar4, slc, "abc");
            List<Boolean> res_gt_9 = cl.greaterThan(ar1, bc, false);
            List<Boolean> res_gt_10 = cl.greaterThan(ar2, bc, true);

            List<Point> ref_gt_1 = clr.greaterThan(ar5, pcr, p2);
            List<Point> ref_gt_2 = clr.greaterThan(ar6, pcr, p1);
            List<Point> ref_gt_3 = clr.greaterThan(ar5, pdcr, p2);
            List<Point> ref_gt_4 = clr.greaterThan(ar6, pdcr, p1);
            List<String> ref_gt_5 = clr.greaterThan(ar3, scr, "abc");
            List<String> ref_gt_6 = clr.greaterThan(ar4, scr, "abc");
            List<String> ref_gt_7 = clr.greaterThan(ar3, slcr, "abc");
            List<String> ref_gt_8 = clr.greaterThan(ar4, slcr, "abc");
            List<Boolean> ref_gt_9 = clr.greaterThan(ar1, bcr, false);
            List<Boolean> ref_gt_10 = clr.greaterThan(ar2, bcr, true);

            boolean pass_gt_1 = same(res_gt_1, ref_gt_1, pcr);
            boolean pass_gt_2 = same(res_gt_2, ref_gt_2, pcr);
            boolean pass_gt_3 = same(res_gt_3, ref_gt_3, pcr);
            boolean pass_gt_4 = same(res_gt_4, ref_gt_4, pcr);
            boolean pass_gt_5 = same(res_gt_5, ref_gt_5, scr);
            boolean pass_gt_6 = same(res_gt_6, ref_gt_6, scr);
            boolean pass_gt_7 = same(res_gt_7, ref_gt_7, scr);
            boolean pass_gt_8 = same(res_gt_8, ref_gt_8, scr);
            boolean pass_gt_9 = same(res_gt_9, ref_gt_9, bcr);
            boolean pass_gt_10 = same(res_gt_10, ref_gt_10, bcr);

            score = bool2Int(pass_gt_1) + bool2Int(pass_gt_2) + bool2Int(pass_gt_3) + bool2Int(pass_gt_4) + bool2Int(pass_gt_5) + bool2Int(pass_gt_6) + bool2Int(pass_gt_7) + bool2Int(pass_gt_8) + bool2Int(pass_gt_9) + bool2Int(pass_gt_10);
            total_score += score;
            genResult("greaterThan - PointCompare", 1, pass_gt_1, res_gt_1, ref_gt_1);
            genResult("greaterThan - PointCompare", 2, pass_gt_2, res_gt_2, ref_gt_2);
            genResult("greaterThan - PointDistanceCompare", 1, pass_gt_3, res_gt_3, ref_gt_3);
            genResult("greaterThan - PointDistanceCompare", 2, pass_gt_4, res_gt_4, ref_gt_4);
            genResult("greaterThan - StringCompare", 1, pass_gt_5, res_gt_5, ref_gt_5);
            genResult("greaterThan - StringCompare", 2, pass_gt_6, res_gt_6, ref_gt_6);
            genResult("greaterThan - StringLengthCompare", 1, pass_gt_7, res_gt_7, ref_gt_7);
            genResult("greaterThan - StringLengthCompare", 2, pass_gt_8, res_gt_8, ref_gt_8);
            genResult("greaterThan - BooleanCompare", 1, pass_gt_9, res_gt_9, ref_gt_9);
            genResult("greaterThan - BooleanCompare", 2, pass_gt_10, res_gt_10, ref_gt_10);
            printScore("greaterThan", score, 10);
        } catch (Exception e) {}

        //inOrder -- ArrayList
        Point[] pNull = {p1, null, p2};
        String[] sNull = {"a", "b", null};
        Boolean[] bNull = {null, true, false};
        List<Point> prNull = new ArrayList<Point>(Arrays.asList(pNull));
        List<String> srNull = new ArrayList<String>(Arrays.asList(sNull));
        List<Boolean> brNull = new ArrayList<Boolean>(Arrays.asList(bNull));
        try {
            PointCompare pc = new PointCompare();
            PointDistanceCompare pdc = new PointDistanceCompare();
            StringCompare sc = new StringCompare();
            StringLengthCompare slc = new StringLengthCompare();
            BooleanCompare bc = new BooleanCompare();

            PointCompareRef pcr = new PointCompareRef();
            PointDistanceCompareRef pdcr = new PointDistanceCompareRef();
            StringCompareRef scr = new StringCompareRef();
            StringLengthCompareRef slcr = new StringLengthCompareRef();
            BooleanCompareRef bcr = new BooleanCompareRef();

            boolean res_io_1 = cl.inOrder(ar5, pc);
            boolean res_io_2 = cl.inOrder(ar5, pdc);
            boolean res_io_3 = cl.inOrder(ar3, sc);
            boolean res_io_4 = cl.inOrder(ar3, slc);
            boolean res_io_5 = cl.inOrder(ar1, bc);

            boolean ref_io_1 = clr.inOrder(ar5, pcr);
            boolean ref_io_2 = clr.inOrder(ar5, pdcr);
            boolean ref_io_3 = clr.inOrder(ar3, scr);
            boolean ref_io_4 = clr.inOrder(ar3, slcr);
            boolean ref_io_5 = clr.inOrder(ar1, bcr);

            boolean pass_io_1 = res_io_1==ref_io_1;
            boolean pass_io_2 = res_io_2==ref_io_2;
            boolean pass_io_3 = res_io_3==ref_io_3;
            boolean pass_io_4 = res_io_4==ref_io_4;
            boolean pass_io_5 = res_io_5==ref_io_5;

            score = bool2Int(pass_io_1) + bool2Int(pass_io_2) + bool2Int(pass_io_3) + bool2Int(pass_io_4) + bool2Int(pass_io_5);
            genResult("inOrder - ArrayList - PointCompare", 1, pass_io_1, res_io_1, ref_io_1);
            genResult("inOrder - ArrayList - PointDistanceCompare", 1, pass_io_2, res_io_2, ref_io_2);
            genResult("inOrder - ArrayList - StringCompare", 1, pass_io_3, res_io_3, ref_io_3);
            genResult("inOrder - ArrayList - StringLengthCompare", 1, pass_io_4, res_io_4, ref_io_4);
            genResult("inOrder - ArrayList - BooleanCompare", 1, pass_io_5, res_io_5, ref_io_5);
        } catch (Exception e) {}

        try {
            PointCompare pc = new PointCompare();
            StringCompare sc = new StringCompare();
            BooleanCompare bc = new BooleanCompare();

            boolean null_test_1 = cl.inOrder(prNull, pc);
            boolean null_test_2 = cl.inOrder(srNull, sc);
            boolean null_test_3 = cl.inOrder(brNull, bc);

            System.out.println("inOrder - ArrayList : Failed to handle null element exception.");
        } catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                score += 1;
                System.out.println("inOrder - ArrayList : Succeed in handling null element exception.");
            }
            else {
                System.out.println("inOrder - ArrayList : Failed to handle null element exception.");
            }
        }
        total_score += score;
        printScore("inOrder - ArrayList", score, 6);
        score = 0;
        try {
            PointCompare pc = new PointCompare();
            PointDistanceCompare pdc = new PointDistanceCompare();
            StringCompare sc = new StringCompare();
            StringLengthCompare slc = new StringLengthCompare();
            BooleanCompare bc = new BooleanCompare();

            PointCompareRef pcr = new PointCompareRef();
            PointDistanceCompareRef pdcr = new PointDistanceCompareRef();
            StringCompareRef scr = new StringCompareRef();
            StringLengthCompareRef slcr = new StringLengthCompareRef();
            BooleanCompareRef bcr = new BooleanCompareRef();

            boolean res_io_1 = cl.inOrder(a5, pc);
            boolean res_io_2 = cl.inOrder(a5, pdc);
            boolean res_io_3 = cl.inOrder(a3, sc);
            boolean res_io_4 = cl.inOrder(a3, slc);
            boolean res_io_5 = cl.inOrder(a1, bc);

            boolean ref_io_1 = clr.inOrder(a5, pcr);
            boolean ref_io_2 = clr.inOrder(a5, pdcr);
            boolean ref_io_3 = clr.inOrder(a3, scr);
            boolean ref_io_4 = clr.inOrder(a3, slcr);
            boolean ref_io_5 = clr.inOrder(a1, bcr);

            boolean pass_io_1 = res_io_1==ref_io_1;
            boolean pass_io_2 = res_io_2==ref_io_2;
            boolean pass_io_3 = res_io_3==ref_io_3;
            boolean pass_io_4 = res_io_4==ref_io_4;
            boolean pass_io_5 = res_io_5==ref_io_5;

            score = bool2Int(pass_io_1) + bool2Int(pass_io_2) + bool2Int(pass_io_3) + bool2Int(pass_io_4) + bool2Int(pass_io_5);
            genResult("inOrder - Array - PointCompare", 1, pass_io_1, res_io_1, ref_io_1);
            genResult("inOrder - Array - PointDistanceCompare", 1, pass_io_2, res_io_2, ref_io_2);
            genResult("inOrder - Array - StringCompare", 1, pass_io_3, res_io_3, ref_io_3);
            genResult("inOrder - Array - StringLengthCompare", 1, pass_io_4, res_io_4, ref_io_4);
            genResult("inOrder - Array - BooleanCompare", 1, pass_io_5, res_io_5, ref_io_5);
        } catch (Exception e) {}

        try {
            PointCompare pc = new PointCompare();

            boolean null_test_1 = cl.inOrder(pNull, pc);

            System.out.println("inOrder - Array : Failed to handle null element exception.");
        } catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                score += 1;
                System.out.println("inOrder - Array : Succeed in handling null element exception.");
            }
            else {
                System.out.println("inOrder - Array : Failed to handle null element exception.");
            }
        }
        total_score += score;
        printScore("inOrder - Array", score, 6);
        score = 0;

        try {
            List<Point> arm1 = new ArrayList<Point>() {
                {
                    add(p1);
                    add(p3);
                }
            };
            List<Point> arm2 = new ArrayList<Point>() {
                {
                    add(p5);
                    add(p4);
                    add(p1);
                }
            };
            List<Point> arm3 = new ArrayList<Point>() {
                {
                    add(p2);
                    add(p1);
                }
            };
            List<Point> arm4 = new ArrayList<Point>() {
                {
                    add(p4);
                }
            };
            List<String> arm5 = new ArrayList<String>() {
                {
                    add("aaaa");
                    add("ab");
                    add("acb");
                }
            };
            List<String> arm6 = new ArrayList<String>() {
                {
                    add("abcd");
                    add("faf");
                }
            };
            List<String> arm7 = new ArrayList<String>() {
                {
                    add("ca");
                    add("abc");
                    add("acb");
                }
            };
            List<String> arm8 = new ArrayList<String>() {
                {
                    add("aaaa");
                }
            };
            List<Boolean> arm9 = new ArrayList<Boolean>() {
                {
                    add(false);
                    add(false);
                }
            };
            List<Boolean> arm10 = new ArrayList<Boolean>() {
                {
                    add(false);
                    add(true);
                    add(true);
                }
            };

            PointCompare pc = new PointCompare();
            PointDistanceCompare pdc = new PointDistanceCompare();
            StringCompare sc = new StringCompare();
            StringLengthCompare slc = new StringLengthCompare();
            BooleanCompare bc = new BooleanCompare();

            PointCompareRef pcr = new PointCompareRef();
            PointDistanceCompareRef pdcr = new PointDistanceCompareRef();
            StringCompareRef scr = new StringCompareRef();
            StringLengthCompareRef slcr = new StringLengthCompareRef();
            BooleanCompareRef bcr = new BooleanCompareRef();

            List<Point> res_m_1 = cl.merge(pc, arm1, arm2);
            List<Point> res_m_2 = cl.merge(pdc, arm3, arm4);
            List<String> res_m_3 = cl.merge(sc, arm5, arm6);
            List<String> res_m_4 = cl.merge(slc, arm7, arm8);
            List<Boolean> res_m_5 = cl.merge(bc, arm9, arm10);

            List<Point> ref_m_1 = clr.merge(pcr, arm1, arm2);
            List<Point> ref_m_2 = clr.merge(pdcr, arm3, arm4);
            List<String> ref_m_3 = clr.merge(scr, arm5, arm6);
            List<String> ref_m_4 = clr.merge(slcr, arm7, arm8);
            List<Boolean> ref_m_5 = clr.merge(bcr, arm9, arm10);

            boolean pass_m_1 = same(res_m_1, ref_m_1, pcr);
            boolean pass_m_2 = same(res_m_2, ref_m_2, pcr);
            boolean pass_m_3 = same(res_m_3, ref_m_3, scr);
            boolean pass_m_4 = same(res_m_4, ref_m_4, scr);
            boolean pass_m_5 = same(res_m_5, ref_m_5, bcr);

            score = bool2Int(pass_m_1) + bool2Int(pass_m_2) + bool2Int(pass_m_3) + bool2Int(pass_m_4) + bool2Int(pass_m_5);
            genResult("merge - PointCompare", 1, pass_m_1, res_m_1, ref_m_1);
            genResult("merge - PointDistanceCompare", 1, pass_m_2, res_m_2, ref_m_2);
            genResult("merge - StringCompare", 1, pass_m_3, res_m_3, ref_m_3);
            genResult("merge - StringLengthCompare", 1, pass_m_4, res_m_4, ref_m_4);
            genResult("merge - BooleanCompare", 1, pass_m_5, res_m_5, ref_m_5);
        } catch (Exception e) {}

        try {
            PointCompare pc = new PointCompare();
            List<Point> null_test_1 = cl.merge(pc, prNull, ar5);
        } catch(Exception e) {
            if (e instanceof IllegalArgumentException) {
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                String exceptionAsString = sw.toString();
                if (exceptionAsString.contains("java.lang.IllegalArgumentException: null value in first list")) {
                    score++;
                    System.out.println("merge : Succeed in handling null element exception in first list");
                }
            }
            else {
                System.out.println("merge : Failed to handle null element exception in the first list.");
            }
        }

        try {
            PointCompare pc = new PointCompare();
            List<Point> null_test_1 = cl.merge(pc, ar5, prNull);
        } catch(Exception e) {
            if (e instanceof IllegalArgumentException) {
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                String exceptionAsString = sw.toString();
                if (exceptionAsString.contains("java.lang.IllegalArgumentException: null value in second list")) {
                    score++;
                    System.out.println("merge : Succeed in handling null element exception in second list");
                }
            }
            else {
                System.out.println("merge : Failed to handle null element exception in the second list.");
            }
        }
        printScore("merge score", score, 7);
        total_score += score;
        
        System.out.println("PA8 total score : " + total_score + "/66");
    }
}