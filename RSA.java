import java.math.BigInteger;
import java.util.ArrayList;

public class RSA {
	public static void main(String[] args) {
		BigInteger zero = new BigInteger("0");
		BigInteger one = new BigInteger("1");
		BigInteger two = new BigInteger("2");
		BigInteger a = new BigInteger("3");

		// Trial Division gives a non trivial 3 digit factor of n
		BigInteger n = new BigInteger(
				"669429808862579361780690518095425093524096648810848762697739476303");
		System.out.println(sqrt(n));
		// BigInteger r = n.divide(new BigInteger("811"));

		// ArrayList<BigInteger> c = trialDivide(n);
		ArrayList<BigInteger> c = new ArrayList<BigInteger>();
		BigInteger s = sqrt(n);
		for (int j = 2; j <= 10000000; j++) {
			a = (s.add(BigInteger.valueOf(j)).modPow(two, n));
			c.add(a);

		}

	}

	// Trial Division Algorithm
	public static ArrayList<BigInteger> trialDivide(BigInteger n) {
		ArrayList<BigInteger> a = new ArrayList<BigInteger>();
		BigInteger zero = new BigInteger("0");
		BigInteger one = new BigInteger("1");
		BigInteger two = new BigInteger("2");
		BigInteger three = new BigInteger("3");
		BigInteger i;
		i = two;
		while (n.mod(i).equals(zero)) {
			a.add(i);
			System.out.println(i);
			n = n.divide(i);
		}
		BigInteger s = sqrt(n);

		for (i = three; i.compareTo(s) == -1; i = i.nextProbablePrime()) {
			if (n.mod(i).equals(zero)) {
				System.out.println(i);
				a.add(i);
				n = n.divide(i);
				i = i.andNot(one);
				s = sqrt(n).add(one);
			}
		}
		if (!n.equals(one))
			a.add(n);
		return a;
	}

	// Takes the square root of BigIntegers
	public static BigInteger sqrt(BigInteger n) {
		BigInteger a = BigInteger.ONE;
		BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8"))
				.toString());
		while (b.compareTo(a) >= 0) {
			BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
			if (mid.multiply(mid).compareTo(n) > 0)
				b = mid.subtract(BigInteger.ONE);
			else
				a = mid.add(BigInteger.ONE);
		}
		return a.subtract(BigInteger.ONE);
	}

}
