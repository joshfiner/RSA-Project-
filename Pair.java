import java.math.BigInteger;

public class Pair {
	private BigInteger l;
	private BigInteger r;

	public Pair() {
		this.l = null;
		this.r = null;

	}

	public Pair(BigInteger a, BigInteger b) {
		this.l = a;
		this.r = b;

	}

	public BigInteger getL() {
		return l;
	}

	public void setL(BigInteger l) {
		this.l = l;
	}

	public BigInteger getR() {
		return r;
	}

	public void setR(BigInteger r) {
		this.r = r;
	}

	public void print() {
		String s;
		s = l.toString() + " " + r.toString();
		System.out.println(s);
	}
}
