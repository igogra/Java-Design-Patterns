package behavioral.iterator;

interface IIterator {
	public boolean hasNext();

	public Object next();
}

interface IContainer {
	public IIterator createIterator();
}

class RecordCollection implements IContainer {
	private String recordArray[] = { "first", "second", "third", "fourth",
			"fifth" };

	@Override
	public IIterator createIterator() {
		RecordIterator iterator = new RecordIterator();
		return iterator;
	}

	private class RecordIterator implements IIterator {
		private int index;

		@Override
		public boolean hasNext() {
			if (index < recordArray.length) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public Object next() {
			if (this.hasNext()) {
				return recordArray[index++];
			} else {
				return null;
			}
		}
	}
}

public class DemoIterator {
	public static void main(String[] args) {
		RecordCollection recordCollection = new RecordCollection();
		IIterator iterator = recordCollection.createIterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
