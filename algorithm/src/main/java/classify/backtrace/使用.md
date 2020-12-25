**如果是求子集，则使用start来标示开始；如果是求全集，则使用visited来标示；**  
backtrace方法固定格式：  
```java
public void classify.backtrace(List<List<Integer>> lists, List<Integer> list, int[] nums, int start, int target) {
}

public void classify.backtrace(List<List<Integer>> lists, List<Integer> list, int[] nums, boolean[] visited, int target) {
}

```