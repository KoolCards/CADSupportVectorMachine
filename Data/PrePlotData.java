import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class PrePlotData {
	public static void main (String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/kriss/Documents/MachineLearning/HeartAttackPredict/Data/trainingDataFinal.txt"));
		FileWriter writer = new FileWriter("C:/Users/kriss/Documents/MachineLearning/HeartAttackPredict/Data/plotData.txt");
		for (int i = 1; i <= 2251; i++) {
			StringTokenizer curr = new StringTokenizer(br.readLine());
			String tempECG = curr.nextToken();
			String tempBP = curr.nextToken();
			String tempClassify = curr.nextToken();
			if (tempClassify.charAt(0) > 0) {
				writer.write(tempECG + " " + tempBP + " " + "1");
			}
		}
	}
}
