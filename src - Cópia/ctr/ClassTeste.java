package ctr;

import inout.FileIn;
import inout.LerInstCaixeiro;

public class ClassTeste {
	
	public static void main(String[] args) {
		FileIn f=new FileIn("teste.txt");
		int a=0;
		float b=0.0f;
		float c=0.0f;
//		while (f.hasNext()){
//			a=f.nextInt();
//			b=f.nextFloatPonto();
//			c=f.nextFloatPonto();
//			System.out.println(a+" "+b+" "+c);
//		}
		LerInstCaixeiro l=new LerInstCaixeiro("teste.txt");
		l.printMatriz();
		
	}

}
