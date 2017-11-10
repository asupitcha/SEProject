import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FillScoreController {
	private String[][] data;
	private String fileName;
	private int row,column;
	private int gradeGrilienia;
	private String[] g;
	private int[] maxScore;
	private String status;
	private String course;
	
	public FillScoreController(String fileName, String courseName) {		
		BufferedReader bf;
		String line = "";
		String[] str;
		this.fileName = fileName;
		course = courseName;
		
		try {
			status = "false";
			bf = new BufferedReader(new FileReader(new File(fileName)));
			status = bf.readLine();
			while((line = bf.readLine()) != null){
				str = line.split(" ");
				column = str.length;
				row++;
			}
			readFileGradeGrilienia(courseName + "GradeGrilienia.txt");
			readFile();
			bf.close();
		} catch (FileNotFoundException e) {
			try {
				this.fileName = courseName + "StudentList.txt";
				bf = new BufferedReader(new FileReader(new File(this.fileName)));
				while((line = bf.readLine()) != null){
					str = line.split(" ");
					column = str.length;
					row++;
				}
				bf.close();
				readFileGradeGrilienia(courseName + "GradeGrilienia.txt");
				readFile();
				saveScoreFile(courseName + "Score.txt");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int getRow(){
		return row;
	}
	public String getStatus(){
		return status;
	}
	public void setStatus(String s){
		status = s;
	}
	public String[] readFileGradeGrilienia(String fileName){
		BufferedReader bf;
		String line = "";
		int i=0;
		try {
			bf = new BufferedReader(new FileReader(new File(fileName)));
			line = bf.readLine();
			gradeGrilienia = Integer.parseInt(line);
			g = new String[gradeGrilienia];
			while((line = bf.readLine()) != null){
				g[i] = line;
				i++;
			}
			bf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		maxScore = new int[gradeGrilienia];
		String[] str;
		for(int j=0; j<gradeGrilienia; j++){
			str = g[j].split(",");
			maxScore[j] = Integer.parseInt(str[1]);
		}
		return g;
	}
	public void readFile(){
		data = new String[row][column+gradeGrilienia];
		BufferedReader bf;
		String line = "";
		String[] str;
		int row = 0;

		try {
			bf = new BufferedReader(new FileReader(new File(fileName)));
			if(fileName.equals(course+ "Score.txt")) status = bf.readLine();
			while((line = bf.readLine()) != null){
				str = line.split(" ");
				for(int i=0; i<str.length; i++){
					data[row][i] = str[i];
				} row++;
			}
			bf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String[][] getData(){
		return data;
	}
	public void saveScoreFile(String filename) throws FileNotFoundException{
		PrintWriter out = new PrintWriter(filename);
		out.println(status);
		for(int i=0; i<row; i++){
			for(int j=0; j<column+gradeGrilienia; j++){
				if(data[i][j] == null) out.print(" ");
				else out.print(data[i][j] + " ");
			}
			out.println();
		}
		out.close();
	}
	public boolean addScore(String score, int x, int y){
		try{
			if(((Double.parseDouble(score) <= maxScore[y-3]) || (Integer.parseInt(score) <= maxScore[y-3])) && ((Double.parseDouble(score) >= 0) || (Integer.parseInt(score) >= 0))){
				data[x][y] = score;
				return true;
			}
			else
				throw new NumberFormatException();
		}catch(NumberFormatException e){
			return false;
		}catch(NullPointerException e){
			return false;
		}
	}
}