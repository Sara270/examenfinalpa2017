#  examenfinal

Add instructions for project developers here.

## Problema No.1
Para la realización del problema 1, se implementó la estructura de datos de Arraylist.
~~~
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

    public void swap(int i, E e, E n){
        set(i, e);
        set(i+1, e);
    }
    

    public void permutacion(int n, E e, E p) {
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
    ~~~
    En la cual como lo indico las instrucciones se implemento el metodo permutaciones el cual se repitio el metodo swap tantas veces como fuera posible hasta que se llegara a la cantidad de elementos en el heap.
    
