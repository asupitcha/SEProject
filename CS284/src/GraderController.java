import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GraderController {
	private String[][] grader;
	private String course;
	private String[][] data;
	private CalculateScoreController csc;
	
	public GraderController(int[] max,int[] percent, String[][] data, String course) throws FileNotFoundException {
		this.data = data;
		this.course = course;
		csc = new CalculateScoreController(max, percent, data);
		saveScore();
		saveScoreFile();
	}
	public String calculateGrade(double score){
		if(score < 41) return "F";
		else if(score >= 41 && score < 47) return "D";
		else if(score >= 47 && score < 53) return "D+";
		else if(score >= 53 && score < 60) return "C";
		else if(score >= 60 && score < 67) return "C+";
		else if(score >= 67 && score < 74) return "B";
		else if(score >= 74 && score < 81) return "B+";
		else return "A";
	}
	public void saveScore(){
		grader = new String[data.length][2];
		for(int i=0; i<data.length; i++){
			grader[i][0] = data[i][0];
			grader[i][1] = calculateGrade(csc.calculateSumScore()[i]);
			
		}
	}
	public void saveScoreFile() throws FileNotFoundException{
		PrintWriter out = new PrintWriter(course + "Grade.txt");
		for(int i=0; i<grader.length; i++){
			for(int j=0; j<grader[0].length; j++){
				out.print(grader[i][j] + " ");
			}
			out.println();
		}
		out.close();
	}
}