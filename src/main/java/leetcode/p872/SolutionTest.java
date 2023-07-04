package leetcode.p872;

import leetcode.common.MarshallUtils;
import leetcode.common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1(){
        TreeNode t1 = MarshallUtils.marshall(new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 4});
        TreeNode t2 = MarshallUtils.marshall(new Integer[]{3,5,1,6,7,4,2,null,null,null,null,null,null,9,8});

        boolean b = new Solution().leafSimilar(t1, t2);
        Assert.assertTrue(b);

    }
}
