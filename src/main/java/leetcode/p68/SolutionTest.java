package leetcode.p68;

import org.junit.Assert;

import java.util.List;

public class SolutionTest {
    @org.junit.Test
    public void test1(){
        String[] strings = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> list = new Solution().fullJustify(strings, 16);
        Assert.assertEquals(3, list.size());
        Assert.assertEquals("This    is    an", list.get(0));
        Assert.assertEquals("example  of text", list.get(1));
        Assert.assertEquals("justification.  ", list.get(2));
        System.out.println(list);
    }

    @org.junit.Test
    public void test2(){
        String[] strings = {"What","must","be","acknowledgment","shall","be"};
        List<String> list = new Solution().fullJustify(strings, 16);
        Assert.assertEquals(3, list.size());

        Assert.assertEquals("What   must   be", list.get(0));
        Assert.assertEquals("acknowledgment  ", list.get(1));
        Assert.assertEquals("shall be        ", list.get(2));
        System.out.println(list);
    }

    @org.junit.Test
    public void test3(){
        String[] strings = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        List<String> list = new Solution().fullJustify(strings, 20);
        Assert.assertEquals(6, list.size());

        Assert.assertEquals("Science  is  what we", list.get(0));
        Assert.assertEquals("understand      well", list.get(1));
        Assert.assertEquals("enough to explain to", list.get(2));
        Assert.assertEquals("a  computer.  Art is", list.get(3));
        Assert.assertEquals("everything  else  we", list.get(4));
        Assert.assertEquals("do                  ", list.get(5));
        System.out.println(list);
    }
}
