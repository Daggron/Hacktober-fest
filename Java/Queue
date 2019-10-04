public class Queue {

	protected int[] data;
	protected int size;
	protected int front;

	public Queue() {

		this.data = new int[5];
		this.size = 0;
		this.front = 0;

	}

	public Queue(int cap) {

		this.data = new int[cap];
		this.size = 0;
		this.front = 0;
	}

	public void Enqueue(int item) throws Exception {

		if (isFull()) {
			throw new Exception("Queue is Full");
		}
		int idx = (this.front + this.size) % this.data.length;
		this.data[idx] = item;
		this.size++;

	}

	public int Dequeue() throws Exception {

		if (isEmpty()) {
			throw new Exception("Queue is Empty");
		}
		int rv = this.data[this.front];
		this.data[this.front] = 0;
		this.front = (this.front + 1) % this.data.length;
		this.size--;
		return rv;

	}

	public int getFront() throws Exception {

		if (isEmpty()) {
			throw new Exception("Queue is Empty");
		}
		int rv = this.data[front];
		return rv;

	}

	public int size() {

		return this.size;

	}

	public boolean isFull() {

		return this.size == this.data.length;

	}

	public boolean isEmpty() {

		return this.size() == 0;

	}

	public void display() {

		for (int i = 0; i < this.size; i++) {
			int idx = (i + this.front) % this.data.length;
			System.out.print(this.data[idx] + " ");
		}
		System.out.println();
	}

}
