package streamsusage.parallel;

import java.util.stream.IntStream;

public class SumMutation {
public static void main(String[] args) {
	SumOperator op = new SumOperator();
	
	IntStream.range(1, 100000)
	//mutation is dangerous in parallel stream
		.parallel()
		//ordered one gos in sequnce so with paralle we must use this
		//but then perfrmace is impacted if items are less
	.forEachOrdered(op::incrment);
	//	.forEach(op::incrment);
	
	System.out.println(op.returnSum());
	
	System.out.println(IntStream.range(1, 100000).sum());
}
}
