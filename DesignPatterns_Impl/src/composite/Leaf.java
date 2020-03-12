package composite;

import java.util.ArrayList;

public interface Leaf {
  
	public String getColor();
	public void setColor(String color);
	public ArrayList<Integer> getInnervation();
	public void setInnervation(ArrayList<Integer> points);
	public Branch getBranch();
	public void setBranch(Branch mybranch);
	
	
}
