package cn.xiezhaoxin.test;

public class TestA {
	public void aaa(){
		for(int i=0;i<1000000;i++){
			System.out.println(i);
		}
		
		TestB b = new TestB(); 
		b.testb();
	}
}
