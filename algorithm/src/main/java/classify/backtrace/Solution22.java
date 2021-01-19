package classify.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/25
 * @description:
 **/
public class Solution22 {

    public static void main(String[] args) {
        Solution22 solution = new Solution22();
        int n = 3;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("(");
        stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());

        List<String> lists = solution.generateParenthesis(n);
        System.out.println(lists.toString());
    }
    public List<String> generateParenthesis(int n) {
        List<String> lists = new ArrayList<>();
        backtrace(lists, new ArrayList<>(), 0, 0, n);
        return lists;
    }

//    public void backtrace(List<String> lists, List<String> list, int left, int right, int n) {
//        if (left == n && right == n) {
//            lists.add(list.toString());
//            return;
//        }
//        if (left < n) {
//            list.add("(");
//            backtrace(lists, list, left + 1, right, n);
//            list.remove(list.size() - 1);
//        }
//        if (right < left) {
//            list.add(")");
//            backtrace(lists, list, left, right + 1, n);
//            list.remove(list.size() - 1);
//        }
//    }

    public void backtrace(List<String> lists, List<String> list, int left, int right, int n) {
        if (left == n && right == n) {
            lists.add(list.toString());

            return;
        }
        if (left < n) {
            list.add("(");
            backtrace(lists, list, left + 1, right, n);
            list.remove(list.size() - 1);
        }
        if (right < left) {
            list.add(")");
            backtrace(lists, list, left, right + 1, n);
            list.remove(list.size() - 1);
        }
    }
}
