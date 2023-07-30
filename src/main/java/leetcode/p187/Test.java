package leetcode.p187;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;

import java.io.InputStream;
import java.util.List;

public class Test {
    @org.junit.Test
    public void test1(){
        List<String> list = new Solution().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        Assert.assertTrue(list.size() == 2);
         Assert.assertTrue(list.contains("AAAAACCCCC"));
        Assert.assertTrue(list.contains("CCCCCAAAAA"));
        System.out.println(list);
    }

    @org.junit.Test
    public void test2(){
        List<String> list = new Solution().findRepeatedDnaSequences("AAAAAAAAAAAAA");
        Assert.assertTrue(list.size() == 1);
        System.out.println(list);
    }

    @org.junit.Test
    public void test3() throws Exception{
        InputStream stream = Test.class.getClassLoader().getResourceAsStream("leetcode/p187/a.txt");
        String s = IOUtils.toString(stream);
        s = s.replaceAll("\"", "");
        List<String> list = new Solution().findRepeatedDnaSequences(s);
        System.out.println(list);
        System.out.println(list.size());
        Assert.assertTrue(list.size() == 0);
    }
}
