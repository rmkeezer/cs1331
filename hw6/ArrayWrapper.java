import java.util.NoSuchElementException;

/**
 * This ArrayWrappers acts as a dynamic collection that can resize at will
 * @author Matthew Keezer
 * @version 1.0
 */
public class ArrayWrapper<T> implements SimpleCollection<T> {

    private T[] arr;

    /**
     * Initializes the ArrayWrapper class by creating a new element array
     */
    public ArrayWrapper() {
        arr = (T[]) new Object[5];
    }

    /**
     * Adds an element into the collection.
     * If the new element would exceed the size of the backing array,
     * instead resize the array, doubling it in size and copy over the
     * old elements.
     *
     * @param elem The element being added.
     */
    @Override
    public void add(T elem) {
        if (size() == capacity()) {
            T[] newArr = (T[]) new Object[capacity() * 2];
            System.arraycopy(arr, 0, newArr, 0, capacity());
            arr = newArr;
        }
        arr[size()] = elem;
    }

    /**
     * Adds all elements in elems to the collection.
     * Hint: can this be implemented in terms of add(T elem)?
     *
     * @param elems Array of elements to be added.
     */
    @Override
    public void addAll(T[] elems) {
        for (int i = 0; i < elems.length; i++) {
            add(elems[i]);
        }
    }

    /**
     * Remove elem from the collection. Removing an element
     * should shift all the elements behind it forward, ensuring
     * that the backing array is contiguous. For example:
     *
     * Collection = ["hi", "hello", "wsup", "hey", null]
     * Collection after remove("hello") = ["hi", "wsup", "hey", null, null]
     *
     * @param elem Element to be removed.
     * @return true if the element was removed,
     *         false if it was not in the collection.
     */
    @Override
    public boolean remove(T elem) {
        int target = -1;
        int i = 0;
        for (; i < size(); i++) {
            if (arr[i].equals(elem)) {
                target = i;
            }
        }
        if (target == -1) {
            return false;
        }
        for (i = target; i < size(); i++) {
            if (i + 1 < capacity()) {
                arr[i] = arr[i + 1];
            } else {
                arr[i] = null;
            }
        }
        return true;
    }

    /**
     * Removes each element in elems from the collection.
     * Hint: can this be implemented in terms of remove(T elem)?
     *
     * @param elems Array of elements to be removed.
     * @return true if any elements were removed,
     *         false if no elements were removed.
     */
    @Override
    public boolean removeAll(T[] elems) {
        boolean removed = false;
        for (int i = 0; i < elems.length; i++) {
            if (remove(elems[i])) {
                removed = true;
            }
        }
        return removed;
    }

    /**
     * Checks to see if the collection contains a given element.
     *
     * @param elem The element we are checking for.
     * @return true if the collection contains elem, false otherwise.
     */
    @Override
    public boolean contains(T elem) {
        if (elem == null) {
            return false;
        }
        for (T o : arr) {
            if (o != null && o.equals(elem)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets an element from the collection, using its 0-based index.
     * If the index is within our backing array but more than our last
     * element, rather than returning null, this should throw
     * a java.util.NoSuchElementException.
     *
     * @param index The index of the element we want.
     * @return The element at the specified index.
     */
    @Override
    public T get(int index) {
        if (index < size()) {
            return arr[index];
        }
        throw new NoSuchElementException();
    }

    /**
     * Returns the current number of elements in the collection.
     *
     * @return The size of the collection.
     */
    @Override
    public int size() {
        int i = 0;
        for (T o : arr) {
            if (arr[i] != null) {
                i++;
            }
        }
        return i;
    }

    /**
     * Returns the current capacity of the collection - namely, the
     * size of its backing array.
     *
     * @return The total capacity of the collection.
     */
    @Override
    public int capacity() {
        return arr.length;
    }

    /**
     * Clears the collection, resetting size and starting from a fresh
     * backing array of size 5.
     */
    @Override
    public void clear() {
        arr = (T[]) new Object[5];
    }

    /**
     * Tests if the collection is empty, i.e. it contains no elements.
     *
     * @return true if the collection has no elements, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * While having toString be defined in the interface doesn't force you
     * to override the method in the implementing class, the format we
     * expect the toString() is as follows:
     *
     * [element1, element2, element3, ..., elementN]
     *
     * The end of the list should not contain any nulls, even if the
     * backing array is larger than the number of elements.
     *
     * @return [element1, element2, element3, ..., elementN]
     */
    @Override
    public String toString() {
        String output = "[";
        for (int i = 0; i < size() - 1; i++) {
            output += arr[i].toString() + ", ";
        }
        if (size() != 0) {
            output += arr[size() - 1].toString();
        }
        output += "]";
        return output;
    }
}