import java.io.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        PoissonDist poissonDist = new PoissonDist(1000, 1000000);
        double[] poissonDistArray = poissonDist.run();

        int mean = 0;
        for(int i=0; i< poissonDistArray.length; i++)
            mean += i * poissonDistArray[i];

        int sqrmean = 0;
        for(int i=0; i<poissonDistArray.length; i++)
            sqrmean += i * i * poissonDistArray[i];

        int variance = sqrmean - mean * mean;

        System.out.println("평균: " + mean);
        System.out.println("분산: " + variance);

        File file = new File("./poisson.csv");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for(int i=0; i<poissonDistArray.length-1; i++) {
                if(file.isFile() && file.canWrite()){
                    bw.write(i + "," + poissonDistArray[i]);
                    bw.newLine();
                }
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
