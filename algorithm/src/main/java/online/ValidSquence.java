package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/1/19
 * @description:
 **/
public class ValidSquence {
    public static void main(String[] args) throws Exception {
        String s = "ab{c((d))}[ef]";
        char[] sequence = s.toCharArray();
        int head = 0;
        char[] stack = new char[s.length()];
        for (int i = 0; i < sequence.length; i++) {
            switch (sequence[i]) {
                case '{':
                case '[':
                case '(':
                    stack[head] = sequence[i];
                    head++;
                    break;
                case '}':
                    if (head == 0 || stack[head-1] != '{') {
                        System.out.println(false);
                    }
                    head--;
                    break;
                case ')':
                    if (head == 0 || stack[head-1] != '(') {
                        System.out.println(false);
                    }
                    head--;
                    break;
                case ']':
                    if (head == 0 || stack[head-1] != '[') {
                        System.out.println(false);
                    }
                    head--;
                    break;
            }
        }
        System.out.println(head == 0);

    }

    public boolean isValid(String s) {
        char[] sequence = s.toCharArray();
        int head = 0;
        char[] stack = new char[s.length()];
        for (int i = 0; i < sequence.length; i++) {
            switch (sequence[i]) {
                case '{':
                case '[':
                case '(':
                    stack[head] = sequence[i];
                    head++;
                    break;
                case '}':
                    if (head == 0 || stack[head-1] != '{') {
                        return false;
                    }
                    head--;
                    break;
                case ')':
                    if (head == 0 || stack[head-1] != '(') {
                        return false;
                    }
                    head--;
                    break;
                case ']':
                    if (head == 0 || stack[head-1] != '[') {
                        return false;
                    }
                    head--;
                    break;
            }
        }
        return head == 0;
    }
}
