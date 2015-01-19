import java.util.Formatter;
import java.util.Locale;

/**
 * Represents a Pokemon object. Each has a number, a name, and two elemental
 * types, chosen from the PokemonType enumeration.
 *
 * @author  Joe Rossi
 * @version 1.0
 */
public class Pokemon implements Comparable<Pokemon> {

    private String name;
    private int number;
    private PokemonType primaryType, secondaryType;

    /**
     * Constructs a Pokemon object
     *
     * @param num   this Pokemon's unique number
     * @param name  this Pokemon's name
     * @param p this Pokemon's primary type
     * @param s this Pokemon's secondary type
     */
    public Pokemon(int num, String name, PokemonType p, PokemonType s) {
        number = num;
        this.name = name;
        primaryType = p;
        secondaryType = s;
    }

    @Override
    public int compareTo(Pokemon o) {
        return number - o.getNumber();
    }

    @Override
    public boolean equals(Object o) {
        return number == ((Pokemon) o).getNumber();
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.US);
        String[] types = {"NORMAL", "FIRE", "WATER", "ELECTRIC",
            "GRASS", "ICE", "FIGHTING", "POISON", "GROUND", "FLYING",
            "PSYCHIC", "BUG", "ROCK", "GHOST", "DRAGON", "NONE" };
        return formatter.format("%-5s %-15s %-8s %-8s", "" + number,
            name, types[primaryType.ordinal()], types[secondaryType.ordinal()])
            .toString();
    }

    /**
     * @return  the name of this Pokemon
     */
    public String getName() {
        return name;
    }

    /**
     * @return  the unique number of this Pokemon
     */
    public int getNumber() {
        return number;
    }

    /**
     * @return  the primary type of this Pokemon
     */
    public PokemonType getPrimaryType() {
        return primaryType;
    }

    /**
     * @return  the secondary type of this Pokemon
     */
    public PokemonType getSecondaryType() {
        return secondaryType;
    }
}
