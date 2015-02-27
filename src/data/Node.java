package data;

// TODO: Auto-generated Javadoc
/**
 * The Class Node.
 *
 * @param <E>
 *            the element type
 */
public class Node<E> {

	/** The data. */
	private E data;

	/** The next. */
	private Node<E> next;

	/**
	 * Instantiates a new node.
	 *
	 * @param data
	 *            the data
	 * @param next
	 *            the next
	 */
	public Node(E data, Node<E> next) {

		this.data = data;
		this.next = next;

	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public E getData() {

		return data;

	}

	/**
	 * Gets the next.
	 *
	 * @return the next
	 */
	public Node<E> getNext() {

		return next;

	}

	/**
	 * Sets the next.
	 *
	 * @param next
	 *            the new next
	 */
	public void setNext(Node<E> next) {

		this.next = next;

	}

}
