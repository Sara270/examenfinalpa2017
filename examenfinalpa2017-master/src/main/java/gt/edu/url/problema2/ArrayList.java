/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.url.problema2;

/**
 *
 * @author Sara
 */
public class ArrayList <E> implements List <E>{

   public static final int CAPACITY = 16;
	private E[] data;
	private int size = 0;

	public ArrayList() {
		this(CAPACITY);
	}

	public ArrayList(int capacity) {
		data = (E[]) new Object[capacity];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E get(int i) {
		checkIndex(i, size);
		return data[i];
	}

	public E set(int i, E e) {
		checkIndex(i, size);
		E temp = data[i];
		data[i] = e;
		return temp;
	}

	public void add(int i, E e) {
		checkIndex(i, size + 1);
		if (size == data.length)
			resize(2 * data.length);
		for (int k = size - 1; k >= i; k--)
			data[k + 1] = data[k];
		data[i] = e; 
		size++;

	}

	public E remove(int i) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		E temp = data[i];
		for (int k = i; k < size - 1; k++)
			data[k] = data[k + 1];
		data[size - 1] = null;
		size--;
		return temp;
	}

	protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
		if (i < 0 || i >= n)
			throw new IndexOutOfBoundsException("Illegal index: " + i);
	}

	/**
	 * Internal method to increase array capacity
	 * @param capacity
	 */
	protected void resize(int capacity) {
		E[] temp = (E[]) new Object[capacity];
		for (int k=0; k < size; k++)
			temp[k] = data[k];
		data = temp;
	}

    public void swap(int i, E e, E n){ // Metodo que intercambia  las posiciones de dos objetos ( numero )
        set(i, e);
        set(i+1, e);
    }
    

    public void permutacion(int n, E e, E p) { // Metodo que repite el proceso el numero de  veces de la cantidad en el heap
            if (n == 1) {
               System.out.println(e);
            }
            else{
                for (int i = 0; i < n - 1; i += 1){
                    do {
                       swap(i, e, p);
                    }while(n-1 == i);
                }
            }
    }
}
