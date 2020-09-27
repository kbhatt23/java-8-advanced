package streamsusage.parallel;

public class SumOperator {

	private int sum;
	
	public /* synchronized */ void incrment(int num) {
		sum+=num;
	}
	
	public int returnSum() {
		return sum;
	}
}
