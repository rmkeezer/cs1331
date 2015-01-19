/**
 * Represents a Pokedex - basically a Pokemon encyclopedia that adds new entries
 * when you encounter a Pokemon for the first time.
 * It also provides methods for organizing its information in useful ways.
 *
 * @author Joe Rossi
 * @version 1.0
 */
public class Pokedex {

    private MySortedSet<Pokemon> thePokemon;

    /**
     * Constructs a Pokedex object by setting up the sorted set of Pokemon
     */
    public Pokedex() {
        thePokemon = new MySortedSet<Pokemon>();
    }

    @Override
    public String toString() {
        return thePokemon.toString();
    }

    /**
     * Adds a Pokemon to the sorted set
     *
     * @param p the Pokemon to be added
     * @return true if the pokemon was not already in the set, false otherwise
     */
    public boolean add(Pokemon p) {
        return thePokemon.add(p);
    }

    /**
     * Returns the number of Pokemon in the Pokedex
     *
     * @return  the number of Pokemon in the Pokedex
     */
    public int countPokemon() {
        return thePokemon.size();
    }

    /**
     * Clear the Pokedex and start over
     */
    public void clear() {
        thePokemon.clear();
    }

    /**
     * Returns a set of alphabetized Pokemon, using a lambda expression
     *
     * @return  the alphabetized set
     */
    public MySortedSet<Pokemon> listAlphabetically() {
        return thePokemon.sort((a, b) -> a.getName()
            .compareToIgnoreCase(b.getName()));
    }

    /**
     * Returns a set of Pokemon grouped by type, using a lambda expression
     *
     * @return  the grouped by primary type set
     */
    public MySortedSet<Pokemon> groupByPrimaryType() {
        return thePokemon.sort((a, b) -> a.getPrimaryType().ordinal()
            - b.getPrimaryType().ordinal());
    }

    /**
     * Returns a set of all Pokemon of type t
     *
     * @param t the type we want listed
     * @return  the set of all Pokemon in the Pokedex of type t
     */
    public MySortedSet<Pokemon> listByType(PokemonType t) {
        return thePokemon.filter((a) -> a.getPrimaryType() == t || a.getSecondaryType() == t);
    }

    /**
     * Returns a set of Pokemon with numbers in the range [start, end]
     *
     * @param start the first number in the new set
     * @param end   the last number in the new set
     * @return  the set containing all Pokemon in the Pokedex from [start, end]
     */
    public MySortedSet<Pokemon> listRange(int start, int end) {
        for (Pokemon p1 : thePokemon) {
            if (p1.getNumber() >= start) {
                Pokemon p3 = p1;
                for (Pokemon p2 : thePokemon) {
                    if (p2.getNumber() >= end) {
                        return thePokemon.subSet(p1, p3);
                    }
                    p3 = p2;
                }
            }
        }
        return null;
    }
}
