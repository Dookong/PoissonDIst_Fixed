import java.util.Random;

public class PoissonDist {
    private double probability;
    private int intervalNum;
    private int trialNum;

    private int[] successNumArray;
    private double[] probabilityArray;

    public PoissonDist(int intervalNum, int trialNum) {
        this.intervalNum = intervalNum;
        this.trialNum = trialNum;
        successNumArray = new int[intervalNum+1];
    }
    double[] run() {
        for(int i=0; i<trialNum; i++) {
            int successNum = 0;
            for(int j=0; j<intervalNum; j++) {
                int random = new Random().nextInt(10);
                if(random == 0) {
                    successNum++;
                }
            }
            successNumArray[successNum]++;
        }
        probabilityArray = new double[successNumArray.length];
        for(int i=0; i<successNumArray.length; i++)
            probabilityArray[i] = successNumArray[i] / (double)trialNum;
        return probabilityArray;
    }
}