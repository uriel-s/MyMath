package Ex1;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Functions_GUI implements functions {
	public ArrayList<function> Func = new ArrayList<function>();
	public static Color[] Colors = {Color.blue, Color.cyan,
			Color.MAGENTA, Color.ORANGE, Color.red, Color.GREEN, Color.PINK};
	@Override
	public boolean add(function arg0) {
		return this.Func.add(arg0);

	}

	@Override
	public boolean addAll(Collection<? extends function> arg0) {
		// TODO Auto-generated method stub
		return this.Func.addAll(arg0);
	}

	@Override
	public void clear() {
		this.Func.clear();		
	}

	@Override
	public boolean contains(Object arg0) {
		return this.Func.contains(arg0);
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		return this.Func.containsAll(arg0);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.Func.isEmpty();
	}

	@Override
	public Iterator<function> iterator() {
		// TODO Auto-generated method stub
		return this.Func.iterator();
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return this.Func.remove(arg0);
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return this.Func.removeAll(arg0);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return this.Func.retainAll(c);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.Func.size();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return this.Func.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return this.Func.toArray(a);
	}

	@Override
	public void initFromFile(String file) throws IOException {
		function fun = new Monom(Monom.ZERO);
		String line = "";
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(file));

			while ((line = br.readLine()) != null) 
			{
				Func.add(fun.initFromString(line));
			}

		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}


	@Override
	public void saveToFile(String file) throws IOException {
		try 
		{
			PrintWriter pw = new PrintWriter(new File(file));

			StringBuilder sb = new StringBuilder();
			Iterator <function> i = this.Func.iterator();

			while(i.hasNext()) {
				sb.append(i.next().toString()+"\n"); 
			}

			pw.write(sb.toString());
			pw.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return;
		}
	}

	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		StdDraw.setCanvasSize(width,height);
		StdDraw.setXscale(rx.get_min(), rx.get_max());
		StdDraw.setYscale(ry.get_min(), ry.get_max());
		StdDraw.setPenRadius(0.01);
		double r = (rx.get_max()-rx.get_min())/resolution;
		for(int i=0; i<Func.size(); i++) {
			StdDraw.setPenColor(Colors[i%Colors.length]);
          for(double j=rx.get_min();j<=rx.get_max();j+=r) {
	            StdDraw.line(j, Func.get(i).f(j), j+r, Func.get(i).f(j+r));
          }
		}
	}

	@Override
	public void drawFunctions(String json_file) {
		// TODO Auto-generated method stub

	}

}
