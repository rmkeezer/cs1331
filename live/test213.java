import java.util.ArrayList;
import java.util.stream.Stream;

public class test213 {
	public static void main(String[] args) {
		ArrayList<test2> labels = new ArrayList<test2>();
		labels.add(new test2("PENIS"));
		labels.add(new test2("PENiS"));
		labels.add(new test2("PENIs"));
		labels.add(new test2("PeNIS"));
		labels.add(new test2("PEnIS"));
		labels.add(new test2("pENIS"));
		labels.add(new test2("penis"));
		labels.stream().filter(a -> !a.isDisabled()).forEach(a -> System.out.println(a.getText()));
	}
}

class test2 {
	private String words;
	public test2(String words) {
		this.words = words;
	}
	public String getText() {
		return words;
	}
	public boolean isDisabled() {
		return false;
	}
}