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
	private String course;
	
	public FillScoreController(String fileName, String courseName) {		
		BufferedReader bf;
		String line = "";
		String[] str;
		this.fileName = fileName;
		
		try {
			bf = new BufferedReader(new FileReader(new File(fileName)));
			while((line = bf.readLine()) != null){
				str = line.split(" ");
				column = str.length;
				row++;
			}
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
		for(int i=0; i<row; i++){
			for(int j=0; j<column+gradeGrilienia; j++){
				if(data[i][j] == null) out.print(" ");
				else out.print(data[i][j] + " ");
			}
			out.println();
		}
		out.close();
	}
	public void addScore(String score, int x, int y){
		data[x][y] = score;
	}
}