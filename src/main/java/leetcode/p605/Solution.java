package leetcode.p605;

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int lastFlowerIndex = -1;
        for (int i = flowerbed.length-1; i >=0 ; i--) {
            if (flowerbed[i]==1) {
                lastFlowerIndex = i;
                break;
            }
        }

        if (lastFlowerIndex == -1) {
            int permitMax = (flowerbed.length + 1) / 2;
            //System.out.println("permitMax:"+permitMax);
            return permitMax >= n;
        }

        int oldSeqFlowerIndex = -1;
        int flowerIndex = -1;
        int permitMax = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                flowerIndex = i;
                break;
            }
        }
        while (flowerIndex > oldSeqFlowerIndex) {
            if (oldSeqFlowerIndex == -1){
                permitMax += flowerIndex / 2;

            }else {
                if (flowerIndex - oldSeqFlowerIndex >= 4){
                    permitMax += (flowerIndex-oldSeqFlowerIndex-2)/2;
                }
            }
            oldSeqFlowerIndex = flowerIndex;

            for (int i = flowerIndex+1; i < flowerbed.length; i++) {
                if (flowerbed[i] == 1) {
                    flowerIndex = i;
                    break;
                }
            }

            //while (flowerIndex < flowerbed.length-1 && flowerbed[++flowerIndex]==0){}
        }

        permitMax += (flowerbed.length - lastFlowerIndex-1)/2;
        //System.out.println("permitMax:"+permitMax);
        return permitMax >= n;
    }
}
