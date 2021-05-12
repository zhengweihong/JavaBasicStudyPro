package P09_2021051227;

public class Person {
	private String name,gender;
	private int age,relation;
	private int order;
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(String a,String b,int c,int d) {
		this.name = a;
		this.gender = b;
		this.age = c;
		this.relation = d;
		// TODO Auto-generated constructor stub
	}
	public void setOrder(int order) {
		this.order = order;
	}
	
	/**
	 * get ����
	 * 
	 */
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public int getAge() {
		return age;
	}
	public int getRelation() {
		return relation;
	}
}
