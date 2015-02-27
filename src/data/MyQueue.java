package data;

// TODO: Auto-generated Javadoc
/**
 * The Class MyQueue.
 * 
 * @param <E>
 *            the element type
 */
public class MyQueue<E> {

	/** The size. */
	private int size;

	/** The first. */
	private Node<E> first;

	/** The last. */
	private Node<E> last;

	/**
	 * Instantiates a new my queue.
	 */
	public MyQueue() {

		first = null;
		last = null;
		size = 0;

	}

	/**
	 * Enqueue.
	 * 
	 * @param data
	 *            the data
	 */
	public void enqueue(E data) {

		Node<E> newNode = new Node<E>(data, null);

		if (last == null) {

			last = newNode;

		} else {

			last.setNext(newNode);
			last = newNode;

		}

		if (first == null) {

			first = newNode;

		}

		size++;

	}

	/**
	 * Dequeue.
	 * 
	 * @return returns the first element of the queu
	 */
	public E dequeue() {

		if (isEmpty()) {

			throw new RuntimeException("Inget att avköa");

		} else {

			E temp = first.getData();

			if (first.getNext() == null) {

				first = null;
				last = null;

			} else {

				first = first.getNext();

			}

			size--;
			return temp;

		}

	}

	/**
	 * Size.
	 * 
	 * @return returns the size of the queue
	 */
	public int size() {

		return size;

	}

	/**
	 * Checks if is empty.
	 * 
	 * @return true, if is empty
	 */
	public boolean isEmpty() {

		return last == null;

	}

}
