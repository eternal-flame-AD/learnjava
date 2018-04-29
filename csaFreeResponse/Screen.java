package csaFreeResponse;

import java.util.ArrayList;

class Pixel {
	private int row;
	private int col;
	public Pixel (int r,int c) {
		row=r;
		col=c;
	}
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
}
public class Screen {
	private ArrayList<Pixel>[] data; //The book sucks, it used ArrayList<int>
	private int numCols;
	public Screen (int width, int height) {
		data=new ArrayList[height];
		numCols=width;
		int i;
		for (i=0;i<height;i++) {
			data[i]=new ArrayList<Pixel>();
		}
	}
	public Pixel pixelAt(int row, int col) {
		ArrayList<Pixel> target=data[row];
		for (Pixel a:target) {
			if (a.getCol()==col) {
				return a;
			}
		}
		return null;
	}
	public void pixelOn(int row, int col) {
		ArrayList<Pixel> target=data[row];
		int pos=0;
		for (Pixel a:target) {
			if (a.getCol()>col) {
				pos++;
			} else {
				break;
			}
		}
		target.add(pos,new Pixel(row,col));
	}
}
