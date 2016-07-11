package cn.xiezhaoxin.project.game24.util;

/**
 * Author:Yuanhonglong
 * QQ:1948281915
 * Date:2014-1-9
 */
import java.util.Vector;

public class SplendedPoint24 {

	public static int[] pokers = new int[4];
	public static boolean Result = false, Result2 = false;
	public static Vector<Poker> p = new Vector<Poker>();
	public static Vector<Notation> notations = new Vector<Notation>();
	public static Notation[] nota = new Notation[3];
	public static int first = 0;
	public static int second = 0;
	public static int third = 0;
	public static int fourth = 0;
	public static int z1 = 0, z2 = 0, z3 = 0;
	public static Vector<String> strings = new Vector<String>();

	private enum Poker {
		A("A", 1), B("2", 2), C("3", 3), D("4", 4), E("5", 5), F("6", 6), G("7", 7), H("8", 8), I("9", 9), J("10",
				10), K("J", 11), L("Q", 12), M("K", 13);

		private final String Name;
		@SuppressWarnings("unused")
		private final int Value;

		Poker(String name, int value) {
			this.Name = name;
			this.Value = value;
		}
	}

	private enum Notation {
		Plus_sign("+"), Subtraction_sign("-"), Multiplication_sign("×"), Division_sign("÷"), Equality_sign(
				"="), Left_parenthesis("("), Right_parenthesis(")");

		public String Name;

		Notation(String name) {
			this.Name = name;
		}
	}

	public static int[] getPokers() {
		pokers = new int[4];
		for (int i = 0; i < pokers.length; i++) {
			int theValue = (int) (Math.random() * 13) + 1;
			pokers[i] = theValue;
		}
		return pokers;
	}

	private static void init() {
		p.addElement(Poker.A);
		p.addElement(Poker.B);
		p.addElement(Poker.C);
		p.addElement(Poker.D);
		p.addElement(Poker.E);
		p.addElement(Poker.F);
		p.addElement(Poker.G);
		p.addElement(Poker.H);
		p.addElement(Poker.I);
		p.addElement(Poker.J);
		p.addElement(Poker.K);
		p.addElement(Poker.L);
		p.addElement(Poker.M);
		notations.addElement(Notation.Plus_sign);
		notations.addElement(Notation.Multiplication_sign);
		notations.addElement(Notation.Division_sign);
		notations.addElement(Notation.Subtraction_sign);
	}

	private static void showPokers() {
		init();
		System.out.print("得到的牌为:");
		for (int poker : pokers) {
			for (int j = 1; j < 14; j++) {
				if (j == poker) {
					System.out.print(p.get(j - 1).Name + "  ");
					break;
				}
			}
		}
		System.out.println(".");
	}

	public static void check(int[] poker) {
		pokers = poker;
		showPokers();
		assert poker.length == 4 : "Wrong!";
		for (int element : poker) {
			assert (element < 14) && (element > 0) : "Wrong!";
		}
		double sum = 0;
		{
			for (int i = 0; i < poker.length; i++) {
				first = poker[i];
				for (int j = 0; (j < poker.length) && (j != i); j++) {
					second = poker[j];
					for (int m = 0; (m < poker.length) && (m != j) && (m != i); m++) {
						third = poker[m];
						for (int n = 0; (n < poker.length) && (n != m) && (n != j) && (n != i); n++) {
							fourth = poker[n];
							for (; z1 < 6; z1++) {
								double s1 = sum;
								sum = workOut(0, z1, first, second);
								for (; z2 < 6; z2++) {
									double s2 = sum;
									sum = workOut(1, z2, sum, third);
									for (; z3 < 6; z3++) {
										double s3 = sum;
										sum = workOut(2, z3, sum, fourth);
										if ((sum >= 23.999) && (sum <= 24.001)) {
											// Double类型计算机计算有微小误差
											Result = true;
											showResult();
											Result = Result2 = false;
										}
										sum = s3;
										nota[2] = null;
									}
									z3 = 0;
									sum = s2;
									nota[1] = null;
								}
								z2 = 0;
								sum = s1;
								nota[0] = null;
							}
							z1 = 0;
						}
					}
				}
			}
			for (int i = 0; i < poker.length; i++) {
				first = poker[i];
				for (int j = 0; (j < poker.length) && (j != i); j++) {
					second = poker[j];
					for (int m = 0; (m < poker.length) && (m != j) && (m != i); m++) {
						third = poker[m];
						for (int n = 0; (n < poker.length) && (n != m) && (n != j) && (n != i); n++) {
							fourth = poker[n];
							for (; z1 < 6; z1++) {
								double s1 = sum;
								sum = workOut(0, z1, first, second);
								for (; z2 < 6; z2++) {
									double s2 = sum;
									double sum2 = workOut(1, z2, third, fourth);
									for (; z3 < 6; z3++) {
										double s3 = sum;
										double s4 = sum2;
										sum = workOut(2, z3, sum, sum2);
										if ((sum >= 23.999) && (sum <= 24.001)) {
											Result = true;
											Result2 = true;
											showResult();
											Result = Result2 = false;
										}
										sum = s3;
										sum2 = s4;
										nota[2] = null;
									}
									z3 = 0;
									sum = s2;
									nota[1] = null;
								}
								z2 = 0;
								sum = s1;
								nota[0] = null;
							}
							z1 = 0;
						}
					}
				}
			}
		}
		if (strings.isEmpty()) {
			String string = "No Result!";
			System.out.println(string);
		}
		strings.removeAllElements();
		p.removeAllElements();
		notations.removeAllElements();
		z1 = z2 = z3 = 0;
		Result = Result2 = false;
	}

	private static void showResult() {
		String string = "";
		if (Result && !Result2) {
			if (z1 < 4) {
				string = string + Notation.Left_parenthesis.Name + first + nota[0].Name + second
						+ Notation.Right_parenthesis.Name;
			} else {
				string = string + Notation.Left_parenthesis.Name + second + nota[0].Name + first
						+ Notation.Right_parenthesis.Name;
			}
			if (z2 < 4) {
				string = Notation.Left_parenthesis.Name + string + nota[1].Name + third
						+ Notation.Right_parenthesis.Name;
			} else {
				string = Notation.Left_parenthesis.Name + third + nota[1].Name + string
						+ Notation.Right_parenthesis.Name;
			}
			if (z3 < 4) {
				string = Notation.Left_parenthesis.Name + string + nota[2].Name + fourth
						+ Notation.Right_parenthesis.Name;
			} else {
				string = Notation.Left_parenthesis.Name + fourth + nota[2].Name + string
						+ Notation.Right_parenthesis.Name;
			}
			string = string + Notation.Equality_sign.Name + "24";
			strings.addElement(string);
			System.out.println(string);
		} else if (Result && Result2) {
			String string2;
			if (z1 < 4) {
				string = string + Notation.Left_parenthesis.Name + first + nota[0].Name + second
						+ Notation.Right_parenthesis.Name;
			} else {
				string = string + Notation.Left_parenthesis.Name + second + nota[0].Name + first
						+ Notation.Right_parenthesis.Name;
			}
			if (z2 < 4) {
				string2 = Notation.Left_parenthesis.Name + third + nota[1].Name + fourth
						+ Notation.Right_parenthesis.Name;
			} else {
				string2 = Notation.Left_parenthesis.Name + fourth + nota[1].Name + third
						+ Notation.Right_parenthesis.Name;
			}
			if (z3 < 4) {
				string = Notation.Left_parenthesis.Name + string + nota[2].Name + string2
						+ Notation.Right_parenthesis.Name;
			} else {
				string = Notation.Left_parenthesis.Name + string2 + nota[2].Name + string
						+ Notation.Right_parenthesis.Name;
			}
			string = string + Notation.Equality_sign.Name + "24";
			strings.addElement(string);
			System.out.println(string);
		}
	}

	private static double workOut(int not, int x, double m, double n) {
		switch (x) {
		case 0:
			nota[not] = Notation.Plus_sign;
			return m + n;
		case 1:
			nota[not] = Notation.Subtraction_sign;
			return m - n;
		case 2:
			nota[not] = Notation.Multiplication_sign;
			return m * n;
		case 3:
			nota[not] = Notation.Division_sign;
			if (n == 0) {
				return Double.POSITIVE_INFINITY;
			}
			return m / n;
		case 4:
			nota[not] = Notation.Subtraction_sign;
			return n - m;
		case 5:
			nota[not] = Notation.Division_sign;
			if (m == 0) {
				return Double.POSITIVE_INFINITY;
			}
			return n / m;
		default:
			System.out.println("Wrong!");
			return 0;
		}
	}

	public static void main(String[] args) {
		int[] p1 = { 2, 7, 11, 12 };
		int[] p2 = { 2, 7, 12, 11 };
		int[] p3 = { 2, 12, 7, 11 };
		int[] p4 = { 2, 12, 11, 7 };
		int[] p5 = { 2, 11, 12, 7 };
		int[] p6 = { 2, 11, 7, 12 };
		check(p1);
		check(p2);
		check(p3);
		check(p4);
		check(p5);
		check(p6);
	}
}