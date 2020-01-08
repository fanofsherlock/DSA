package Collections;

public class Equals {

	private String id;
	private int no;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	@Override
	public boolean equals(Object obj) {
	      if(obj==null||!(obj instanceof Equals)) return false;
	      if(obj==this) return true;
	   
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return id.length();
	}
	
}
