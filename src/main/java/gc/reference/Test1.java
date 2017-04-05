package gc.reference;

public class Test1
{
    static long NumberOfCreatedInstances = 0;
    static long NumberOfDeletedInstances = 0;
    public Test1() {NumberOfCreatedInstances++;}

    static public void main(String args[])
    {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000*10000; i++) {
            Test1 test1 = new Test1();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);

        System.out.println("starting....");
        for (int i = 0; ; i++) {
            Test1 obj = new Test1();
            obj = null;
            if (i%10000000 == 0)
            {
                System.out.println(
                        NumberOfCreatedInstances-NumberOfDeletedInstances);
            }
        }
    }
}
