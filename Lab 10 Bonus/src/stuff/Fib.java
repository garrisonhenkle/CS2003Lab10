package stuff;

public class Fib {

	private int curr = 1;
	private int last = 0;
	private int max = (int) (2 * Math.pow(10, 9));
	private long sum = 0;
	private int temp = 0;

	public static void main(String args[]) {
		Fib f = new Fib();
		System.out.println(f.getSumOfOdd());
	}

	// returns the sum of all odd fibonacci terms
	public long getSumOfOdd() {

		// while the current term is less the than max (2 billion), if the current term
		// is odd, add it to the sum
		while (curr < max) {
			if (curr % 2 != 0) {
				sum += curr;
			}

			// store the current value in a temporary variable, add the value last to
			// current, then set last to the temporary value
			temp = curr;
			curr += last;
			last = temp;
		}

		return sum;
	}
}
