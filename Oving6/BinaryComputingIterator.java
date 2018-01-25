package oving6;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.BinaryOperator;

public class BinaryComputingIterator implements BinaryOperator<Double>, Iterator<Double>{
	Double default1;
	Double default2;
	Iterator<Double> iterator1;
	Iterator<Double> iterator2;
	BinaryOperator<Double> operator;
	
	
	
	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, BinaryOperator<Double> operator){
		this.iterator1 = iterator1;
		this.iterator2 = iterator2;
		this.operator = operator;
		
	}
	
	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, Double default1, Double default2, BinaryOperator<Double> operator){
		this.default1 = default1;
		this.default2 = default2;
		this.iterator1 = iterator1;
		this.iterator2 = iterator2;
		this.operator = operator;
	}

	@Override
	public boolean hasNext() {
		if (iterator1.hasNext() && iterator2.hasNext()){
			return true;
		}
		if (iterator1.hasNext() && !iterator2.hasNext() && default2 != null){
			return true;
		}
		if (iterator2.hasNext() && !iterator1.hasNext() && default1 != null){
			return true;
		}

		return false;
	}

	@Override
	public Double next() {
		if (iterator1.hasNext() && iterator2.hasNext()){
			return operator.apply(iterator1.next(), iterator2.next());
		}
		if (iterator1.hasNext() && !iterator2.hasNext()){
			return operator.apply(iterator1.next(), default2);
		}
		if (iterator2.hasNext() && !iterator1.hasNext()){
			return operator.apply(default1, iterator2.next());
		}
			
		throw new NoSuchElementException();
	}

	@Override
	public Double apply(Double t, Double u) {
		return t+u;
	}


}
