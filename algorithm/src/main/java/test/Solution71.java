package test;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/18
 * @description:
 *
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分
 * 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 *
 * 输入："/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 **/
public class Solution71 {

    public String simplifyPath(String path) {
        List<String> stack = new ArrayList<>();
        String[] elements = path.split("/");
        Arrays.stream(elements).forEach(ele -> {
            if (!ele.equals("..") && !ele.equals(".") && !ele.equals("")) {
                stack.add(ele);
            } else if (ele.equals("..") && !stack.isEmpty()) {
                stack.remove(stack.size() - 1);
            }
        });
        StringBuilder sb = new StringBuilder();
        stack.stream().forEach(ele -> {
            sb.append("/").append(ele);
        });
        return sb.toString().equals("") ? "/" : sb.toString();
    }

}
