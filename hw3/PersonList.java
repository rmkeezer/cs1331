public class PersonList {

    private Person[] people;
    private int count;

    public PersonList(int maxSize) {
        people = new Person[maxSize];
    }

    public void listPeople() {
        for (int i = 0; i < people.length; i++) {
            if (people[i] != null) {
                System.out.println(people[i]);
            }
        }
    }

    public void add(Person p) {
        boolean breakout = false;
        for (int i = 0; i < people.length && !breakout; i++) {
            if (people[i] == null) {
                people[i] = p;
                breakout = true;
            }
        }
    }

}