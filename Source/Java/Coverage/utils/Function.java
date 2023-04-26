package utils;

import entity.TQuestion;

import java.text.DecimalFormat;
import java.util.*;

public class Function {

    /**
     * 获取题目正确率的可能性列表
     *
     * @param count   总题目数
     * @param strings 各个题目类别正确率
     * @return list
     */
    public static List<List<String>> getQuestionList(int count, String[] strings) {
        List<List<String>> list = new ArrayList();
        Set<TQuestion> set = new HashSet<>();
        for (int i = 1; i < count; i++) {
            for (int j = 1; j < count; j++) {
                for (int k = 1; k < count; k++) {
                    for (int l = 0; l < count; l++) {
                        if (i + j + k + l == count) {

                            for (int m = 0; m < 20; m++) {
                                if (strings[0].equals(getCoverage(m, i))) {
                                    TQuestion TQuestion = new TQuestion(strings[0], (Integer.toString(m)), Integer.toString(i));
                                    set.add(TQuestion);
                                }
                                if (strings[1].equals(getCoverage(m, j))) {
                                    TQuestion TQuestion = new TQuestion(strings[1], (Integer.toString(m)), Integer.toString(j));
                                    set.add(TQuestion);
                                }
                                if (strings[2].equals(getCoverage(m, k))) {
                                    TQuestion TQuestion = new TQuestion(strings[2], (Integer.toString(m)), Integer.toString(k));
                                    set.add(TQuestion);
                                }
                                if (strings[3].equals(getCoverage(m, l))) {
                                    TQuestion TQuestion = new TQuestion(strings[3], (Integer.toString(m)), Integer.toString(l));
                                    set.add(TQuestion);
                                }
                            }
                        }
                    }
                }
            }
        }
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Set<String> set3 = new HashSet<>();
        Set<String> set4 = new HashSet<>();
        for (TQuestion TQuestion : set) {
            if (TQuestion.getPercentage().equals(strings[0])) {
                set1.add(TQuestion.getTitleCount() + ";" + TQuestion.getCorrectCount());
                map.put(strings[0], set1);
                continue;
            }
            if (TQuestion.getPercentage().equals(strings[1])) {
                set2.add(TQuestion.getTitleCount() + ";" + TQuestion.getCorrectCount());
                map.put(strings[1], set2);
                continue;
            }
            if (TQuestion.getPercentage().equals(strings[2])) {
                set3.add(TQuestion.getTitleCount() + ";" + TQuestion.getCorrectCount());
                map.put(strings[2], set3);
                continue;
            }
            if (TQuestion.getPercentage().equals(strings[3])) {
                set4.add(TQuestion.getTitleCount() + ";" + TQuestion.getCorrectCount());
                map.put(strings[3], set4);
            }
        }

        Set<String> stringSet1 = map.get(strings[0]);
        Set<String> stringSet2 = map.get(strings[1]);
        Set<String> stringSet3 = map.get(strings[2]);
        Set<String> stringSet4 = map.get(strings[3]);
        for (String s1 : stringSet1) {
            for (String s2 : stringSet2) {
                for (String s3 : stringSet3) {
                    for (String s4 : stringSet4) {
                        if (Integer.parseInt(s1.split(";")[0]) + Integer.parseInt(s2.split(";")[0]) + Integer.parseInt(s3.split(";")[0]) + Integer.parseInt(s4.split(";")[0]) == 60) {

                            List<String> list1 = new ArrayList();

                            list1.add(strings[0] + ":" + s1);
                            list1.add(strings[1] + ":" + s2);
                            list1.add(strings[2] + ":" + s3);
                            list1.add(strings[3] + ":" + s4);
                            list.add(list1);
                        }
                    }
                }
            }

        }
        return list;
    }

    /**
     * 获取题目正确率
     *
     * @param right 正确数
     * @param all   总数
     * @return 正确率
     */
    private static String getCoverage(int right, int all) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format((double) right / all);
    }

    /**
     * 右对齐
     *
     * @param src 原字符
     * @param len 总长度
     * @param ch  补充字符
     * @return 右对齐后补充后字符
     */
    public static String padRight(String src, int len, char ch) {
        int diff = len - src.length();
        if (diff <= 0) {
            return src;
        }

        char[] charr = new char[len];
        System.arraycopy(src.toCharArray(), 0, charr, 0, src.length());
        for (int i = src.length(); i < len; i++) {
            charr[i] = ch;
        }
        return new String(charr);
    }

    /**
     * 左对齐
     *
     * @param src 原字符
     * @param len 总长度
     * @param ch  补充字符
     * @return 左对齐后补充后字符
     */
    public static String padLeft(String src, int len, char ch) {
        int diff = len - src.length();
        if (diff <= 0) {
            return src;
        }

        char[] charr = new char[len];
        System.arraycopy(src.toCharArray(), 0, charr, diff, src.length());
        for (int i = 0; i < diff; i++) {
            charr[i] = ch;
        }
        return new String(charr);
    }
}
