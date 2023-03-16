import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PI {
    public static void main(String[] args) {
        int digits = 200000;
        long begin = System.currentTimeMillis();
        String pi = computePi(digits).toString();
        long end = System.currentTimeMillis();
        String zit = pipei(pi, "0312");
        System.out.println(zit);
        System.out.println(pi);
        System.out.println(end - begin + "ms");

    }

    /**
     * 查找字符
     *
     * @param pi
     * @param s
     * @return
     */
    private static String pipei(String pi, String s) {
        Pattern p = Pattern.compile(s);
        Matcher m = p.matcher(pi);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, "@@@@");
        }
        m.appendTail(sb);
        return sb.toString();
    }

    private static final BigDecimal FOUR = BigDecimal.valueOf(4);
    private static final int roundingMode = BigDecimal.ROUND_HALF_EVEN;

    private static BigDecimal computePi(int digits) {
        int scale = digits + 5;
        BigDecimal arctan1_5 = arctan(5, scale);
        BigDecimal arctan1_239 = arctan(239, scale);
        BigDecimal pi = arctan1_5.multiply(FOUR).subtract(arctan1_239).multiply(FOUR);
        return pi.setScale(digits, BigDecimal.ROUND_HALF_UP);
    }

    private static BigDecimal arctan(int inverseX, int scale) {
        BigDecimal result, numer, term;
        BigDecimal invX = BigDecimal.valueOf(inverseX);
        BigDecimal invX2 = BigDecimal.valueOf(inverseX * inverseX);

        numer = BigDecimal.ONE.divide(invX, scale, roundingMode);
        result = numer;
        int i = 1;
        do {
            numer = numer.divide(invX2, scale, roundingMode);
            int denom = 2 * i + 1;
            term = numer.divide(BigDecimal.valueOf(denom), scale, roundingMode);
            if (i % 2 != 0) {
                result = result.subtract(term);

            } else {
                result = result.add(term);
            }
            i++;
        } while (term.compareTo(BigDecimal.ZERO) != 0);
        return result;
    }
}
