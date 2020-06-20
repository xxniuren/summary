package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/18
 * @description:
 * todo: 中午写思路，动态规划专栏还没弄明白： https://blog.csdn.net/qq_17550379/article/details/84191382
 **/
public class Solution44 {
    public static void main(String[] args) {
        Solution44 solution = new Solution44();
        String p = "**ab";
        String s = "ecab";
        boolean res = solution.isMatch(s, p);
        System.out.println(res);
    }
    /**
     * bbarc
     * *c
     * 该题解法为：两个指针，一个指s，另一个指p
     *           case1： 两个指针指向的字符相同或者p对应的是通配符？，那么两个指针往前走一步；
     *           case2： 如果p指向的是*，则把star的位置记录，并让p尝试再走一步，并把sPoint赋值给match；
     *           case3： 如果star ！= -1，则把match走一步，并把match的值赋给sPoint，并将pPoint = star+1做进一步尝试
     *
     *           把pPoint走完，把*给匹配掉，查看pPoint是否等于p字符串长度
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int sPoint = 0;
        int pPoint = 0;
        int match = 0;
        int star = -1;
        while (sPoint < s.length()) {
            //第一种情况，完全匹配
            if (pPoint < p.length() && (s.charAt(sPoint) == p.charAt(pPoint) || p.charAt(pPoint) == '?')) {
                sPoint++;
                pPoint++;
            } else if (pPoint < p.length() && p.charAt(pPoint) == '*') {
                star = pPoint;
                pPoint++;
                match = sPoint;
            } else if (star != -1) {
                match++;
                sPoint = match;
                pPoint = star + 1;
            } else return false;
        }
        while (pPoint < p.length() && p.charAt(pPoint) == '*') pPoint++;
        return pPoint == p.length();
    }

}
