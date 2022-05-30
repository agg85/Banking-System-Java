public class Prac {
	public static void main(String[] args) {
		Example e1 = new Example("1");
		Example e2 = e1;
		e2.name = "2";
		System.out.println(e2.name);
	}
}

class Example{
	public String name;
	public Example(String nam) {
		name = nam;
	}
}