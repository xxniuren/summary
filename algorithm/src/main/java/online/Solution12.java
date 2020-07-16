package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/7/16
 * @description:
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M
 * 进行转换
 **/
public class Solution12 {

    public static void main(String[] args) {
        Solution12 solution = new Solution12();
        int num = 3;
        String val = solution.intToRoman(num);
        System.out.println(val);
    }

    public String intToRoman(int num) {
        String[] charSymbs = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] valSymbs = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuffer sb = new StringBuffer();
        int curr = 0;
        while (num > 0 && curr <= charSymbs.length - 1) {
            int mod = num / valSymbs[curr];
            num = num % valSymbs[curr];
            for (int i = 0; i < mod; i++) {
                sb.append(charSymbs[curr]);
            }
            curr++;
        }
        return sb.toString();
    }

}
