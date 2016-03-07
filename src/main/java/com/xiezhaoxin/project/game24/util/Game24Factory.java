package com.xiezhaoxin.project.game24.util;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xiezhaoxin.project.game24.entity.Answer;
import com.xiezhaoxin.project.game24.entity.Game24;
import com.xiezhaoxin.project.game24.repository.AnswerRepository;
import com.xiezhaoxin.project.game24.repository.Game24Repository;
import com.xiezhaoxin.util.SumTime;

/**
 * 二十四点
 * 
 * @ClassName: Game24Factory
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XZX
 * @date 2016年1月9日 上午11:59:54
 *
 */
@Component
public class Game24Factory{
	
	@Autowired
	private Game24Repository game24Rep;
	@Autowired
	private AnswerRepository answerRep;
     
	public static Integer[] pokers = new Integer[4];
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
    
    private enum Poker{
        A("A",1),
        B("2",2),
        C("3",3),
        D("4",4),
        E("5",5),
        F("6",6),
        G("7",7),
        H("8",8),
        I("9",9),
        J("10",10),
        K("J",11),
        L("Q",12),
        M("K",13);
         
        private final String Name;
        @SuppressWarnings("unused")
        private final int Value;
         
        Poker(String name,int value){
            this.Name=name;
            this.Value=value;
        }
    }
    
    private enum Notation{
        Plus_sign(" + "),
        Subtraction_sign(" - "),
        Multiplication_sign(" × "),
        Division_sign(" ÷ "),
        Equality_sign(" = "),
        Left_parenthesis("("),
        Right_parenthesis(")");
         
        public String Name;
         
        Notation(String name){
            this.Name=name;
        }
    }
     
    private static void init(){
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
     
	@SuppressWarnings("unused")
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
		System.out.println();
	}
     
	public static Vector<String> check(Integer[] poker) {
		Vector<String> returnStrings = new Vector<String>();
		pokers = poker;
//		showPokers();
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
//		if (strings.isEmpty()) {
//			System.out.println("No Result!");
//		}
		returnStrings.addAll(strings);
		strings.removeAllElements();
		p.removeAllElements();
		notations.removeAllElements();
		z1 = z2 = z3 = 0;
		Result = Result2 = false;
		return returnStrings;
	}
     
	private static void showResult() {
		String string = "";
		if (Result && !Result2) {
			if (z1 < 4) {
				string = string + Notation.Left_parenthesis.Name + first + nota[0].Name + second + Notation.Right_parenthesis.Name;
			} else {
				string = string + Notation.Left_parenthesis.Name + second + nota[0].Name + first + Notation.Right_parenthesis.Name;
			}

			if (z2 < 4) {
				string = Notation.Left_parenthesis.Name + string + nota[1].Name + third + Notation.Right_parenthesis.Name;
			} else {
				string = Notation.Left_parenthesis.Name + third + nota[1].Name + string + Notation.Right_parenthesis.Name;
			}

			if (z3 < 4) {
				string = Notation.Left_parenthesis.Name + string + nota[2].Name + fourth + Notation.Right_parenthesis.Name;
			} else {
				string = Notation.Left_parenthesis.Name + fourth + nota[2].Name + string + Notation.Right_parenthesis.Name;
			}

			string = string + Notation.Equality_sign.Name + "24";
			strings.addElement(string);
//			System.out.println(string);

		} else if (Result && Result2) {
			String string2;
			if (z1 < 4) {
				string = string + Notation.Left_parenthesis.Name + first + nota[0].Name + second + Notation.Right_parenthesis.Name;
			} else {
				string = string + Notation.Left_parenthesis.Name + second + nota[0].Name + first + Notation.Right_parenthesis.Name;
			}

			if (z2 < 4) {
				string2 = Notation.Left_parenthesis.Name + third + nota[1].Name + fourth + Notation.Right_parenthesis.Name;
			} else {
				string2 = Notation.Left_parenthesis.Name + fourth + nota[1].Name + third + Notation.Right_parenthesis.Name;
			}

			if (z3 < 4) {
				string = Notation.Left_parenthesis.Name + string + nota[2].Name + string2 + Notation.Right_parenthesis.Name;
			} else {
				string = Notation.Left_parenthesis.Name + string2 + nota[2].Name + string + Notation.Right_parenthesis.Name;
			}
			
			string = string + Notation.Equality_sign.Name + "24";
			strings.addElement(string);
//			System.out.println(string);
		}
	}
     
    private static double workOut(int not, int x, double m, double n){
        switch(x){
            case 0:
                nota[not]=Notation.Plus_sign;
                return m+n;
            case 1:
                nota[not]=Notation.Subtraction_sign;
                if(m > n){                	
                	return m-n;
                }
            case 2:
                nota[not]=Notation.Multiplication_sign;
                return m*n;
            case 3:
                nota[not]=Notation.Division_sign;
                if(n==0) return Double.POSITIVE_INFINITY;
                if(m<0 || n<0 || m%1 != 0.0 || n%1 != 0.0 || m/n%1 != 0.0) {
                	return Double.POSITIVE_INFINITY;
                }
                return m/n;
            case 4:
                nota[not]=Notation.Subtraction_sign;
                if(m < n){                	
                	return n-m;
                }
            case 5:
                nota[not]=Notation.Division_sign;
                if(m==0) return Double.POSITIVE_INFINITY;
                if(m<0 || n<0 || m%1 != 0.0 || n%1 != 0.0 || n/m%1 != 0.0) {
                	return Double.POSITIVE_INFINITY;
                }
                return n/m;
            default:
                System.out.println("Wrong!");
                return 0;
        }
    }
    
	/**
	 * 遍历二十四点游戏所有题目
	 * 
	 * @Title: getAllTwentyFourPointGame
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件 
	 * @return void    返回类型
	 */
	public void saveAllGame24() {
		Date start = new Date();
		int min = 1;
		int max = 14;
		Map<Integer[], List<String>> param_content_init = new HashMap<Integer[], List<String>>();
		for (int a = min; a < max; a++) {
			for (int b = min; b < max; b++) {
				for (int c = min; c < max; c++) {
					for (int d = min; d < max; d++) {
						getOneResult(a, b, c, d, param_content_init);
					}
				}
			}
		}
		
		Map<String, Set<String>> param_content = new HashMap<String, Set<String>>();
		
		List<Game24> game24s = new ArrayList<Game24>();
		for (Integer[] keyInt : param_content_init.keySet()) {
			Arrays.sort(keyInt);
			// 题目去重
			String key = keyInt[0] + " " + keyInt[1] + " " + keyInt[2] + " " + keyInt[3];
			// 答案去重
			Set<String> contets = new HashSet<String>();
			for (String string : param_content_init.get(keyInt)) {
				contets.add(string);
			}
			param_content.put(key, contets);
			
		}
		
		 // 保存所有题目到数据库
		for (String key : param_content.keySet()) {
			String[] split = key.split(" ");
			Game24 game24 = game24Rep.save(new Game24(Integer.valueOf(split[0]), Integer.valueOf(split[1]), Integer.valueOf(split[2]), Integer.valueOf(split[3]), key));
			Set<Answer> answers = new HashSet<Answer>();
			for (String string : param_content.get(key)) {				
				answers.add(new Answer(string, game24));
			}
			answerRep.save(answers);
		}
		
		// 输出所有题目和其答案
		for (String key : param_content.keySet()) {
			System.err.println("-----------" + key + "-----------");
			for (String string : param_content.get(key)) {
				System.err.println(string);
			}
		}
		
		System.err.println(param_content.size());
		
		System.err.println(game24s.size());
		
		SumTime.getSumTime(new Date().getTime() - start.getTime());
	}
	
	public Set<String> getResult(Integer a, Integer b, Integer c, Integer d) {
		System.err.println("+++++++++++++" + a);
		Map<Integer[], List<String>> param_content_init = new HashMap<Integer[], List<String>>();
		Set<String> contets = new HashSet<String>();
		for (String string : getOneResult(a, b, c, d, param_content_init)) {
			contets.add(string);
		}
		return contets;
	}
	
	public static void main(String[] args) {
		Map<Integer[], List<String>> param_content_init = new HashMap<Integer[], List<String>>();
		List<String> list = getOneResult(6,4,9,6,param_content_init);
		System.err.println(list.size());
	}

	private static List<String> getOneResult(Integer a, Integer b, Integer c, Integer d, Map<Integer[], List<String>> param_content_init) {
		Integer[] param = new Integer[] { a, b, c, d };
		
		Vector<String> check = check(param);
		if(check != null && !check.isEmpty()){
			
			List<String> contentSet = new ArrayList<String>();
			for (String content : check) {
				contentSet.add(content.substring(1, content.length()).replace(") = ", " = "));
			}

			param_content_init.put(param, contentSet);
			return contentSet;
		}else {
			return null;
		}
	}
	
}