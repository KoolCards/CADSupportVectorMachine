import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReformatText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/kriss/Documents/MachineLearning/HeartAttackPredict/Data/HeartDiseaseCleveland.txt"))) {
			String currentChar = "";
			int line = 1;
			ArrayList<String> patientNumber = new ArrayList<String>();
			ArrayList<String> patientAge = new ArrayList<String>();
			ArrayList<Character> patientSex = new ArrayList<Character>();
			ArrayList<String> patientBloodPressure = new ArrayList<String>();
			ArrayList<Character> patientECG = new ArrayList<Character>();
			ArrayList<String> patientCholestoral = new ArrayList<String>();
			while (line < 2820) {
				currentChar = br.readLine();
				if (line % 10 == 1 && line < 80) {
					patientNumber.add((currentChar.substring(0, 1)));
					patientAge.add((currentChar.substring(4, 6)));
					patientSex.add((currentChar.charAt(7)));
				} 
				else if (line % 10 == 2) {
					patientBloodPressure.add((currentChar.substring(5, 8)));
					patientCholestoral.add(currentChar.substring(11, 14));
				} 
				else if (line % 10 == 3 && currentChar.charAt(2) == '-') {
					patientECG.add((currentChar.charAt(7)));
				} 
				else if (line % 10 == 3 && currentChar.charAt(2) == '1') {
					patientECG.add((currentChar.charAt(6)));
				}
				if (line % 10 == 1 && line > 80 && line < 940) {
					patientNumber.add((currentChar.substring(0, 2)));
					patientAge.add((currentChar.substring(5, 7)));
					patientSex.add((currentChar.charAt(8)));
				}
				if (line % 10 == 1 && line > 940) {
					patientNumber.add((currentChar.substring(0, 3)));
					patientAge.add((currentChar.substring(6, 8)));
					patientSex.add((currentChar.charAt(9)));
				}
				line++;
			}

			FileWriter writer = new FileWriter("C:/Users/kriss/Documents/MachineLearning/HeartAttackPredict/Data/ClevelandData.txt");
			writer.write("patientNumber     patientAge     patientSex     patientBloodPressure     patientECG     patientCholestoral");
			writer.flush();
			writer.write(System.getProperty("line.separator"));
			int counter = 0;
			while (counter < patientNumber.size()) {
				writer.write(patientNumber.get(counter) + " ");
				writer.write(patientAge.get(counter) + " ");
				writer.write(patientSex.get(counter) + " ");
				writer.write(patientBloodPressure.get(counter) + " ");
				writer.write(patientECG.get(counter) + " ");
				writer.write(patientCholestoral.get(counter) + " ");
				writer.flush();
				writer.write(System.getProperty("line.separator"));
				writer.flush();
				counter++;
			}
			writer.close();
			reformatHungaria();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void reformatHungaria ()	{
		try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/kriss/Documents/MachineLearning/HeartAttackPredict/Data/HeartDiseaseVirginia.txt"))) {
			String currentChar = "";
			int line = 1;
			ArrayList<Integer> patientNumber = new ArrayList<Integer>();
			ArrayList<String> patientAge = new ArrayList<String>();
			ArrayList<Character> patientSex = new ArrayList<Character>();
			ArrayList<String> patientBloodPressure = new ArrayList<String>();
			ArrayList<Character> patientECG = new ArrayList<Character>();
			ArrayList<String> patientCholestoral = new ArrayList<String>();
			boolean [] isAbsent = new boolean[201];
			while (line < 201)	{
				currentChar = br.readLine();
				patientNumber.add(line);
				patientAge.add(currentChar.substring(0, 2));
				patientSex.add(currentChar.charAt(3));
				if (currentChar.charAt(7) == '9')	{
					patientBloodPressure.add(currentChar.substring(7,9));
				}
				else if (currentChar.charAt(7) == '?')	{
					patientBloodPressure.add("0");
					isAbsent[line] = true;
				}
				else {
					patientBloodPressure.add(currentChar.substring(7,10));
				}
				if (currentChar.charAt(11) != '0' && isAbsent[line] != true)
					patientCholestoral.add(currentChar.substring(11,14));
				else 
					patientCholestoral.add("0");
				if (currentChar.charAt(11) != '0' && currentChar.charAt(11) != '?'&& isAbsent[line] != true && patientCholestoral.get(line-1) != "0")
					patientECG.add(currentChar.charAt(17));
				else 
					patientECG.add('9');
				line++;
			}
			int counter = 0;
			FileWriter writer = new FileWriter("C:/Users/kriss/Documents/MachineLearning/HeartAttackPredict/Data/VirginiaData.txt");
			writer.write("patientNumber     patientAge     patientSex     patientBloodPressure     patientECG     patientCholestoral");
			writer.write(System.getProperty("line.separator"));
			while (counter < patientNumber.size()) {
				if (patientCholestoral.get(counter) != "0" && patientECG.get(counter) != '9')	{
					writer.write(patientNumber.get(counter) + " ");
					writer.write(patientAge.get(counter) + " ");
					writer.write(patientSex.get(counter) + " ");
					writer.write(patientBloodPressure.get(counter) + " ");
					writer.write(patientCholestoral.get(counter) + " ");
					writer.write(patientECG.get(counter) + " ");
					writer.write(System.getProperty("line.separator"));
					writer.flush();
				}
				counter++;
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
