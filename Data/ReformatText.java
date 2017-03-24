import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ReformatText {
	public static void main(String[] args) throws IOException {
		ReformatText Cleveland = new ReformatText();
		/*String clevelandRead = "C:/Users/kriss/Documents/MachineLearning/HeartAttackPredict/Data/SampleDataCleveland.txt";
		String clevelandTempWrite = "C:/Users/kriss/Documents/MachineLearning/HeartAttackPredict/Data/ClevelandData.txt";
		String clevelandFinal = "C:/Users/kriss/Documents/MachineLearning/HeartAttackPredict/Data/ClevelandTraining.txt";
		Cleveland.commaParser(clevelandRead, clevelandTempWrite, 303);
		Cleveland.cleanseData(clevelandTempWrite, clevelandFinal , 303);
		ReformatText Hungary = new ReformatText();
		String hungaryRead = "C:/Users/kriss/Documents/MachineLearning/HeartAttackPredict/Data/SampleDataHungary.txt";
		String hungaryTempWrite = "C:/Users/kriss/Documents/MachineLearning/HeartAttackPredict/Data/HungaryDataTemp.txt";
		String hungaryFinal = "C:/Users/kriss/Documents/MachineLearning/HeartAttackPredict/Data/HungaryTraining.txt";
		Hungary.commaParser(hungaryRead, hungaryTempWrite, 293);
		Hungary.cleanseData(hungaryTempWrite, hungaryFinal , 293);
		ReformatText Virginia = new ReformatText();
		String virginiaRead = "C:/Users/kriss/Documents/MachineLearning/HeartAttackPredict/Data/SampleDataVA.txt";
		String virginiaTempWrite = "C:/Users/kriss/Documents/MachineLearning/HeartAttackPredict/Data/VADataTemp.txt";
		String virginiaFinal = "C:/Users/kriss/Documents/MachineLearning/HeartAttackPredict/Data/VATraining.txt";
		Virginia.commaParser(virginiaRead, virginiaTempWrite, 200);
		Virginia.cleanseData(virginiaTempWrite, virginiaFinal , 200);
		ReformatText Swiss = new ReformatText();
		String swissRead = "C:/Users/kriss/Documents/MachineLearning/HeartAttackPredict/Data/SampleDataSwiss.txt";
		String swissWrite = "C:/Users/kriss/Documents/MachineLearning/HeartAttackPredict/Data/SwissDataTemp.txt";
		String swissFinal = "C:/Users/kriss/Documents/MachineLearning/HeartAttackPredict/Data/SwissTraining.txt";
		Swiss.commaParser(swissRead, swissWrite, 122);
		Swiss.cleanseData(swissWrite, swissFinal , 122);*/
		ReformatText Other = new ReformatText();
		String otherRead = "C:/Users/kriss/Documents/MachineLearning/HeartAttackPredict/Data/SampleDataOther.txt";
		String otherWrite = "C:/Users/kriss/Documents/MachineLearning/HeartAttackPredict/Data/OtherDataTemp.txt";
		String otherFinal = "C:/Users/kriss/Documents/MachineLearning/HeartAttackPredict/Data/OtherTraining.txt";
		Other.otherParser(otherRead, otherWrite , 18492);
		Other.otherCleanser(otherWrite, otherFinal, 1541);
	}
	public void otherParser (String locationRead, String locationWrite, int numLines) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(locationRead));
		FileWriter writer = new FileWriter(locationWrite);
		String currLine = "";
		int line = 1;
		while (line <= numLines) {
			StringTokenizer ageLine = new StringTokenizer(br.readLine());
			ageLine.nextToken(); ageLine.nextToken();
			writer.write(" " + ageLine.nextToken() + " " + ageLine.nextToken());
			StringTokenizer BP = new StringTokenizer(br.readLine());
			BP.nextToken(); BP.nextToken();
			writer.write(" " + BP.nextToken());
			BP.nextToken();
			writer.write(" " + BP.nextToken());
			String temp =  br.readLine();
			StringTokenizer st = new StringTokenizer(temp);
			for (int i = 1; i <= 3; i++) {
				st.nextToken();
			}
			writer.write(" " + st.nextToken() + " ");
			System.out.println(line);
			br.readLine();
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			writer.write(st2.nextToken());
			StringTokenizer EKGO = new StringTokenizer(br.readLine());
			writer.write(" " + EKGO.nextToken());
				br.readLine();

			StringTokenizer st3 = new StringTokenizer(br.readLine());
			st3.nextToken();
			st3.nextToken();
			writer.write(" " + st3.nextToken());
			br.readLine();
			br.readLine();
			br.readLine();
			writer.write(System.getProperty("line.separator"));
			br.readLine();
			line = line + 12;
		}
		writer.close();
	}
	
	public void otherCleanser (String locationRead, String locationWrite, int numLines) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(locationRead));
		FileWriter writer = new FileWriter(locationWrite);
		String currLine = "";
		int line = 1;
		while (line <= numLines) { 
			String tempStore = br.readLine();
			StringTokenizer st = new StringTokenizer(tempStore);
			if (!st.nextToken().equals("-9") && !st.nextToken().equals("-9") && !st.nextToken().equals("-9") && !st.nextToken().equals("-9") && !st.nextToken().equals("-9") && !st.nextToken().equals("-9") && !st.nextToken().equals("-9")) {
				System.out.println("success");
				writer.write(tempStore);
				writer.write(System.getProperty("line.separator"));
			}
			line++;
		}
		writer.close();
	}

	public void commaParser (String locationRead, String locationWrite, int numLines) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(locationRead));
		FileWriter writer = new FileWriter(locationWrite);
		String currLine = "";
		int line = 1;
		while (line <= numLines) {
			currLine = br.readLine();
			for (int i = 0; i < currLine.length(); i++) {
				if (currLine.charAt(i) == ',') {
					writer.write(" ");
				}
				else if (currLine.charAt(i) == '?') {
					writer.write("2555");
				}
				else {
					writer.write(currLine.charAt(i));
				}
			}
			writer.write(System.getProperty("line.separator"));
			line++;
		}
		System.out.println("done");
		writer.close();
	}
	
	public void cleanseData(String locationRead, String locationWrite, int numLines) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(locationRead));
		FileWriter writer = new FileWriter(locationWrite);
		int currLine = 1;
		while (currLine <= numLines) { 
			String tempStore = br.readLine();
			StringTokenizer st = new StringTokenizer(tempStore);
			for (int i = 1; i <= 7; i++) {
				st.nextToken();
			}
			if (!st.equals("2555") && !st.nextToken().equals("2555")) {
				System.out.println("success");
				writer.write(tempStore);
				writer.write(System.getProperty("line.separator"));
			}
			currLine++;
		}
		writer.close();
	}
}
