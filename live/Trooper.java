import java.util.ArrayList;
import java.util.Collections;
import java.lang.Comparable;
import java.util.Set;
import java.util.HashSet;

public class Trooper {
	private String name;
	private boolean mustached;
	public Trooper(String name, boolean hasMustache) {
		this.name = name; this.mustached = hasMustache;
	}
	public String getName() { return name; }
	public boolean hasMustache() { return mustached; }
	@Override
	public boolean equals(Object other) {
		System.out.println("CHECKING");
		if (this == other) return true;
		if (null == other || !(other instanceof Trooper)) return false;
		Trooper that = (Trooper) other;
		return this.name.equals(that.name) && this.mustached == that.mustached;
	}
	public int hashCode() { return super.hashCode(); }

	public String toString() {
		return name;
	}

	public static void main(String[] args) {
		ArrayList<Trooper> troopers = new ArrayList<>();
		Trooper temp = new Trooper("Mac", true);
		troopers.add(new Trooper("Farva", true));
		troopers.add(new Trooper("Farva", true));
		troopers.add(new Trooper("Rabbit", false));
		troopers.add(new Trooper("Mac", true));
		Set<Trooper> trooperSet = new HashSet<>(troopers);
		System.out.println(troopers.contains(new Trooper("Mac", true)));

	}
}