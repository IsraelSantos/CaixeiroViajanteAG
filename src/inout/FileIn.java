package inout;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileIn{
	File arq;
	Scanner sc;

	public FileIn(String nome) {
		try{
			arq=new File(nome); 
			sc=new Scanner(arq);
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, "Não deu: :-("+e.getMessage());
		}
	}

	public int nextInt(){
		return sc.nextInt();
	}

	public double nextDouble(){
		return sc.nextDouble();
	}

	public float nextFloat(){
		return sc.nextFloat();
	}

	public String next(){
		return sc.next();
	}

	public String nextLine(){
		return sc.nextLine();
	}

	public double nextDoublePonto(){
		return Double.parseDouble(sc.next());
	}

	public float nextFloatPonto(){
		return Float.parseFloat(sc.next());
	}

	public boolean hasNext(){
		return sc.hasNext();
	}

	static int numeroLinhas(String arq){
		int res=0;
		File f;
		Scanner sc2;
		try{
			f=new File(arq); 
			sc2=new Scanner(f);
			while (sc2.hasNext()){
				sc2.nextLine();
				res++;
			}
			sc2.close();
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, "Não deu: :-("+e.getMessage());
		}
		return res;
	}
}
