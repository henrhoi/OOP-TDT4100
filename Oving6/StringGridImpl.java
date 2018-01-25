package oving6;

import java.util.ArrayList;
import java.util.Iterator;

public class StringGridImpl implements StringGrid{
	int rows;
	int columns;
	ArrayList<ArrayList<String>> board;
	boolean rowMajor;
	
	
	public StringGridImpl(int rows, int columnCount){
		this.rows = rows;
		columns = columnCount;
		rowMajor = false;
		board = new ArrayList<ArrayList<String>>();
		for (int i = 0; i<rows; i++){
			ArrayList<String> row = new ArrayList<>();
			for (int j = 0; j < columnCount; j++){
				row.add("");
			}
			board.add(row);
			
		}
		
	}

	@Override
	public int getRowCount() {
		return rows;
	}

	@Override
	public int getColumnCount() {
		return columns;
	}

	@Override
	public String getElement(int row, int column) {
		if (row>rows || row<0 || column<0 || column>columns){
			throw new IllegalArgumentException("Illegal row or column number");
		}
		return board.get(row).get(column);
	}

	@Override
	public void setElement(int row, int column, String element) {
		if (row>rows || row<0 || column<0 || column>columns){
			throw new IllegalArgumentException("Illegal row or column number");
		}
		this.board.get(row).set(column, element);
		
	}

	@Override
	public Iterator<String> iterator() {
		return new StringGridIterator(this, rowMajor);
	}

}
