package classes;

/**
 * @author dylan
 *
 */
public class Pojo {

	private String field1 = "";

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}
	
	/**
	 * @param field1
	 * @param append
	 */
	public void append1(Pojo field1, String append) {
		String newString = field1.getField1() + append;
		field1.setField1(newString);
		try {
			this.wait();	// the synchronization is handled in the client
			newString = field1.getField1() + "wa!";
			field1.setField1(newString);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @param field1
	 * @param append
	 */
	public void append2(Pojo field1, String append) {
		String newString = field1.getField1() + append;
		field1.setField1(newString);
		this.notify();	// the synchronization is handled in the client
	}
	
}
