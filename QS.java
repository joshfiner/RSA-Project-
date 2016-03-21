import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class QS {
	public static void main(String[] args) throws IOException {
		BigInteger zero = new BigInteger("0");
		BigInteger one = new BigInteger("1");
		BigInteger two = new BigInteger("2");
		BigInteger n = new BigInteger(
				"613054310726032886180943888436325837702226698886723435429939101863");

		BigInteger s = sqrt(n);
		// System.out.println(gcd(two, a));
		// ArrayList<BigInteger> list = new ArrayList<BigInteger>();
		// for (int j = 2; j <= 1000000; j++) {
		// a = (s.add(BigInteger.valueOf(j)).modPow(two, n));
		// list.add(a);
		// }
		// ArrayList<Pair> list = generateList(n, 1, 50000);
		ArrayList<BigInteger> factorbase = new ArrayList<BigInteger>(); // =
																		// generateFactorBase(n,
																		// 50000);
		Scanner scanner = null;
		scanner = new Scanner(new BufferedReader(new FileReader(
				"factorbase.txt")));
		// int b = 1;
		while (scanner.hasNextInt()) {
			factorbase.add(BigInteger.valueOf(scanner.nextInt()));
			// b++;
		}
		if (scanner != null)
			scanner.close();
		// for (int i = 0; i < 1000; i++) {
		// System.out.println(factorbase.get(i));
		// }

		// for (int i = 0; i < 50; i++) {
		//
		// }

		// BufferedWriter bw = null;
		// File file = new File("shankstonelli.txt");
		// if (!file.exists()) {
		// file.createNewFile();
		// }
		// FileWriter fw = new FileWriter(file.getAbsoluteFile());
		// bw = new BufferedWriter(fw);
		// for (int i = 1; i < factorbase.size(); i++) {
		// Pair p3 = shanksTonelli(n, factorbase.get(i));
		// bw.write(p3.getL() + " " + p3.getR() + " ");
		// }
		// bw.close();
		scanner = null;
		scanner = new Scanner(new BufferedReader(new FileReader(
				"shankstonelli.txt")));
		// int b = 1;
		while (scanner.hasNextInt()) {
			scanner.nextInt();
			// b++;
		}
		if (scanner != null)
			scanner.close();

		System.out.println(factorbase.size());
		//
		// for (int i = 0; i < factorbase.size(); i++) {
		//
		// System.out.println(factorbase.get(i));
		// }

		ArrayList<Pair> list = generateList(n, 1, 500000);
		// System.out.println(shanksTonelli(n, BigInteger.valueOf(78)));
		// System.out.println(legendre(n, BigInteger.valueOf(3)));

		// BufferedWriter bw = null;
		// File file = new File("list.txt");
		// if (!file.exists()) {
		// file.createNewFile();
		// }
		// FileWriter fw = new FileWriter(file.getAbsoluteFile());
		// bw = new BufferedWriter(fw);
		// for (int i = 0; i < list2.size(); i++) {
		// Pair p = list2.get(i);
		// bw.write(p.getL() + " " + p.getR() + ", ");
		// }
		// bw.close();
		// Hashtable<BigInteger, BigInteger> h = generateList3(n, 1, 10000);
		// keys = h.keys();
		Pair p;
		// System.out.println(p2.getL() + " " + p2.getR());

		// System.out.println(p2.getL() + " " + p2.getR());
		// j = ((p2.getR().add(s.negate())).mod(p)).intValue();
		// k = ((p2.getL().add(s.negate())).mod(p)).intValue();
		// System.out.println(j + " " + k + " ");
		//

		// }

		// /////
		list = sieve(n, list, factorbase);

		for (int i = 0; i < 200; i++) {
			Pair p4 = list.get(i);
			// System.out.println(i);
			// if (p4.getR().equals(BigInteger.ONE))
			System.out.println(p4.getR());
		}

	}

	public static ArrayList<Pair> sieve(BigInteger n, ArrayList<Pair> list,
			ArrayList<BigInteger> factorbase) throws IOException {
		BigInteger two = new BigInteger("2"), s = sqrt(n);
		int j, k;
		Scanner scanner = null;
		scanner = new Scanner(new BufferedReader(new FileReader(
				"shankstonelli.txt")));
		// int b = 1;

		for (int i = 1; i < list.size(); i += 2) {
			list.get(i).setR(list.get(i).getR().divide(two));
		}

		for (int i = 1; i < factorbase.size(); i++) {
			BigInteger p = factorbase.get(i);
			// System.out.println(i);

			j = ((BigInteger.valueOf(scanner.nextInt()).add(s.negate())).mod(p))
					.intValue() - 1;
			k = ((BigInteger.valueOf(scanner.nextInt()).add(s.negate())).mod(p))
					.intValue() - 1;

			// j = ((p.getR().add(s.negate())).mod(p)).intValue() - 1;
			// k = ((p.getL().add(s.negate())).mod(p)).intValue() - 1;
			// System.out.println(j + " " + k + " ");
			if (j == -1)
				j = j + p.intValue();
			if (k == -1)
				k = k + p.intValue();
			// System.out.println(j + " " + k + " ");

			while (j < list.size() && k < list.size()) {
				list.get(j).setR(list.get(j).getR().divide(p));
				list.get(k).setR(list.get(k).getR().divide(p));
				j = j + p.intValue();
				k = k + p.intValue();
				// System.out.println(j + " " + k + " ");
			}
		}

		if (scanner != null)
			scanner.close();

		return list;

	}

	public static BigInteger gcd(BigInteger x, BigInteger y) {
		if (y.equals(BigInteger.ZERO))
			return x;
		return gcd(y, x.mod(y));
	}

	public static int legendre(BigInteger a, BigInteger p) {
		BigInteger two = new BigInteger("2");
		BigInteger l;
		if (p.equals(two))
			return 1;
		l = a.modPow((p.add(BigInteger.ONE.negate())).divide(two), p);

		if (l.equals(p.add(BigInteger.ONE.negate())))
			return -1;
		return 1;
	}

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

	public static ArrayList<Integer> eratosthenes(int n) {
		int i, j, k, t, p;
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (i = 2; i <= n; i++) {
			a.add(i);
		}
		j = 0;
		while (j < Math.sqrt(a.size())) {
			p = a.get(j);
			if (p != 0) {
				for (k = j + p; k < a.size(); k += p) {
					a.set(k, 0);
				}
			}
			j++;
		}
		for (i = 0; i < a.size(); i++) {
			int val = a.get(i);
			if (val == 0) {
				a.remove(i);
				i--;
			}

		}
		return a;
	}

	public static ArrayList<Pair> generateList(BigInteger n, int starti,
			int endi) {
		ArrayList<Pair> a = new ArrayList<Pair>();
		BigInteger val;
		Pair p;
		BigInteger two = new BigInteger("2");
		BigInteger m = sqrt(n);
		BigInteger b = m.multiply(m);
		for (int i = starti; i <= endi; i++) {
			BigInteger c = two.multiply(m).multiply(BigInteger.valueOf(i));
			val = b.add(c).add(BigInteger.valueOf((long) Math.pow(i, 2)));
			p = new Pair(m.add(BigInteger.valueOf(i)), val.add(n.negate()));
			a.add(p);
		}
		return a;
	}

	public static void generateList2(BigInteger n, int starti, int endi)
			throws IOException {
		BufferedWriter bw = null;
		File file = new File("list.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		bw = new BufferedWriter(fw);
		BigInteger val;
		Pair p;
		BigInteger two = new BigInteger("2");
		BigInteger m = sqrt(n);
		BigInteger b = m.multiply(m);
		for (int i = starti; i <= endi; i++) {
			BigInteger c = two.multiply(m).multiply(BigInteger.valueOf(i));
			val = b.add(c).add(BigInteger.valueOf((long) Math.pow(i, 2)));

			bw.write(m.add(BigInteger.valueOf(i)) + " " + val.add(n.negate())
					+ ", ");
		}
		bw.close();
	}

	public static Hashtable<BigInteger, BigInteger> generateList3(BigInteger n,
			int starti, int endi) {
		Hashtable<BigInteger, BigInteger> h = new Hashtable<BigInteger, BigInteger>();
		BigInteger val;
		BigInteger c;
		BigInteger two = new BigInteger("2");
		BigInteger m = sqrt(n);
		BigInteger b = m.multiply(m);
		for (int i = starti; i <= endi; i++) {
			c = two.multiply(m).multiply(BigInteger.valueOf(i));
			val = b.add(c).add(BigInteger.valueOf((long) Math.pow(i, 2)));
			h.put(m.add(BigInteger.valueOf(i)), val.add(n.negate()));
		}
		return h;
	}

	public static ArrayList<BigInteger> generateFactorBase(BigInteger n,
			int bound) {
		ArrayList<Integer> a = eratosthenes(bound);
		ArrayList<BigInteger> fb = new ArrayList<BigInteger>();
		BigInteger val;
		int l;
		for (int i = 0; i < a.size(); i++) {
			val = BigInteger.valueOf(a.get(i));
			l = legendre(n, val);
			// System.out.println(l);
			if (l == 1) {
				fb.add(val);
			}
		}
		return fb;
	}

	public static Pair shanksTonelli(BigInteger n, BigInteger p) {
		BigInteger two = new BigInteger("2");
		BigInteger Q = p.add(BigInteger.ONE.negate());
		BigInteger R, c, t, b;
		int s = 0, m, i;
		Pair p2 = new Pair();
		while (Q.mod(two).equals(BigInteger.ZERO)) {
			Q = Q.divide(two);
			s++;

		}
		if (s == 1) {
			R = n.modPow((p.add(BigInteger.ONE)).divide(new BigInteger("4")), p);
			p2.setL(R);
			p2.setR(R.negate().mod(p));
			return p2;
		}

		int z = 2;
		while (legendre(BigInteger.valueOf(z), p) != -1) {
			z++;
		}
		c = BigInteger.valueOf(z).modPow(Q, p);
		R = n.modPow((Q.add(BigInteger.ONE)).divide(two), p);
		t = n.modPow(Q, p);
		m = s;

		while (true) {

			if (t.equals(BigInteger.ONE)) {
				p2.setL(R);
				p2.setR(R.negate().mod(p));
				return p2;
			}
			i = 1;
			while (i < m) {
				if (t.modPow(BigInteger.valueOf((long) Math.pow(2, i)), p)
						.equals(BigInteger.ONE)) {
					break;
				}

				i++;

			}
			b = c.modPow(BigInteger.valueOf((long) Math.pow(2, m - i - 1)), p);
			R = (R.multiply(b)).mod(p);
			c = (b.multiply(b)).mod(p);
			t = (t.multiply(c)).mod(p);
			m = i;

		}

	}
}
