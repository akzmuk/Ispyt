//#1

package com.kuzmuka.ispyt1;
public class Ispyt1 {

    public interface IArrayVector<E extends Comparable<E>> {
    int getSize();
    E getElement(int index);
    void setElement(int index, E element);
    E min();
    E max();
    E getNorm();
    IArrayVector<E> sort();
    IArrayVector<E> mult(E number);
    IArrayVector<E> sum(IArrayVector<E> vector);
    IArrayVector<E> scalarMult(IArrayVector<E> vector);
}
    
    public abstract class AArrayVector<E extends Comparable<E>> implements
        IArrayVector<E>, Cloneable {
    private E[] elements = null;
    public AArrayVector(int size) {
        elements = createArray(size);
    }
    @Override
    public final E getElement(int index) {
        if (null == elements || index > getSize()) {
            return null;
        }
        return (E) elements[index];
    }
    @Override
    public final void setElement(int index, E element) {
        if (0 <= index && index <= getSize()) {
            elements[index] = element;
        }
    }
    protected abstract E[] createArray(int size);
    @Override
    public int getSize() {
        if (null == elements) {
            return 0;
        }
        return elements.length;
    }
    @Override
    public final E max() {
        E max = null;
        for (int i = 0; i < getSize(); i++) {
            if (null == max || (1 > max.compareTo(elements[i]))) {
                max = elements[i];
            }
        }
        return max;
    }
    @Override
    public final E min() {
        E min = null;
        for (int i = 0; i < elements.length; i++) {
            if (null == min || (-1 < min.compareTo(elements[i]))) {
                min = elements[i];
            }
        }
        return min;
    }
    @Override
    public AArrayVector<E> sort() {
        AArrayVector<E> cloned = (AArrayVector<E>) clone();
        if (2 > getSize()) {
            return cloned;
        }
        return cloned;
    }
    @Override
    protected AArrayVector<E> clone() {
        AArrayVector<E> instance = createInstance();
        for (int i = 0; i < getSize(); i++) {
            instance.setElement(i, getElement(i));
        }
        return instance;
    }
    protected abstract AArrayVector<E> createInstance();
}
    
    
    public class IntegerArrayVector extends AArrayVector<Integer> {
    public IntegerArrayVector(int size) {
        super(size);
    }
    @Override
    protected Integer[] createArray(int size) {
        return new Integer[size];
    }
    @Override
    protected AArrayVector<Integer> createInstance() {
        return new IntegerArrayVector(getSize());
    }
    @Override
    public Integer getNorm() {
        return null;
    }
    @Override
    public IArrayVector<Integer> mult(Integer number) {
        AArrayVector<Integer> copy = createInstance();
        return copy;
    }
    @Override
    public IArrayVector<Integer> scalarMult(IArrayVector<Integer> vector) {
        return null;
    }
    @Override
    public IArrayVector<Integer> sum(IArrayVector<Integer> vector) {
        return null;
    }
    public static void main(String[] args) {
        IArrayVector<Integer> vector = new IntegerArrayVector(3);
        vector.setElement(0, 7);
        vector.setElement(0, 3);
        vector.setElement(0, 5);
        vector.sort();
    }
}
}
