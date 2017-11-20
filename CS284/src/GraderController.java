import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GraderController {
	private int[] percent;
	private int[] max;
	private String[][] data;
	private String[][] grader;
	private String course;
	
	public GraderController(int[] m,int[] g, String[][] d, String course) throws FileNotFoundException {
		max = m;
		percent = g;
		data = d;
		this.course = course;
		calculateSumScore();
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
	public void calculateSumScore(){
		double score[] = new double[data.length];
		double sum = 0;
		
		for(int i=0; i<data.length; i++){
			for(int j=data[0].length-4, k=0; j<data[0].length; j++,k++){
				sum += Double.parseDouble(data[i][j])*((double)percent[k]/(double)max[k]);
			}
			score[i] = sum;
			sum = 0;
		}
		
		grader = new String[data.length][4];
		for(int i=0; i<data.length; i++){
			for(int j=0; j<4; j++){
				if(j == 3) grader[i][j] = calculateGrade(score[i]);
				else grader[i][j] = data[i][j];
			}
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