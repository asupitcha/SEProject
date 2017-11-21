
public class CalculateScoreController {
	private int[] percent;
	private int[] max;
	private String[][] data;
	
	public CalculateScoreController(int[] max,int[] percent, String[][] data) {
		this.max = max;
		this.percent = percent;
		this.data = data;
	}
	public double[] calculateSumScore(){
		double score[] = new double[data.length];
		double sum = 0;
		
		for(int i=0; i<data.length; i++){
			for(int j=data[0].length-4, k=0; j<data[0].length; j++,k++){
				sum += Double.parseDouble(data[i][j])*((double)percent[k]/(double)max[k]);
			}
			score[i] = sum;
			sum = 0;
		}
		return score;
	}
}