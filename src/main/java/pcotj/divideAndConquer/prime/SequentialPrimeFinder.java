package pcotj.divideAndConquer.prime;

public class SequentialPrimeFinder extends AbstractPrimeFinder {
  public int countPrimes(final int number) {
    return countPrimesInRange(1, number);
  }
  
  public static void main(final String[] args) {
    int num = 10000000;//Integer.parseInt(args[0]);
    new SequentialPrimeFinder().timeAndCompute(num);// 5.8s
  }
}
