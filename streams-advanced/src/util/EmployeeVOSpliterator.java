package util;

import java.util.Spliterator;
import java.util.function.Consumer;

import data.EmployeeVO;

public class EmployeeVOSpliterator implements Spliterator<EmployeeVO>{

	private EmployeeVO employee;
	
	private Spliterator<String> baseSpliterator;
	
	public EmployeeVOSpliterator(Spliterator<String> baseSpliterator) {
		this.baseSpliterator=baseSpliterator;
	}
	@Override
	public boolean tryAdvance(Consumer<? super EmployeeVO> action) {
		boolean success = baseSpliterator.tryAdvance( line -> this.employee=StreamUtil.transformFileLineToEmployeeVO(line));
		if(success) {
			action.accept(employee);
			return true;
		}
		return false;
	}

	@Override
	public Spliterator<EmployeeVO> trySplit() {
		return null;
	}

	@Override
	public long estimateSize() {
		//each line represent one single employee
		return baseSpliterator.estimateSize();
	}

	@Override
	public int characteristics() {
		return baseSpliterator.characteristics();
	}

}
