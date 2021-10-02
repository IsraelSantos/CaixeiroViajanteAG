package inout;

import java.util.Scanner;

import javax.swing.JOptionPane;

class Ponto{
	private double x;
	private double y;

	public Ponto(double x, double y){
		this.x=x;
		this.y=y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double distancia(Ponto b){
		return Math.sqrt((x-b.getX())*(x-b.getX())+(y-b.getY())*(y-b.getY()));
	}
}

public class LerInstCaixeiro {

	double [][]matriz=null;
	int np;//Número de pontos.
	float sol;
	short tipo;
	FileIn r=null;

	public LerInstCaixeiro(String instfile){
		//np=FileIn.numeroLinhas(instfile)-1;
		r=new FileIn(instfile);
		np=colheDadoInt(r.next());
		String so=r.next();
		if (so.length()==4){
			String tmp=r.next();
			if (tmp.charAt(0)!='?')
				sol=Float.parseFloat(tmp);
		}else{
			if (so.charAt(4)=='?'){
				sol=0;
			}else sol=colheDadoFloat(so);
		}
		tipo=(short)colheDadoInt(r.next());
		r.nextLine();
		matriz=new double[np][np];
		if (tipo==1)
			lerMatrizSimetrica();
		else{
			if (tipo==3){
				Ponto []pt=lerPontos();
				geraMatriz(pt);
			}
		}
	}
	
	public double getPeso(int i,int j){
		return matriz[i][j];
	}

	public int getNp() {
		return np;
	}


	public void setNp(int np) {
		this.np = np;
	}


	public float getSol() {
		return sol;
	}

	public int colheDadoInt(String dado){
		String res="";
		int j=0;
		while (!"=".equalsIgnoreCase(""+dado.charAt(j)))
			j++;
		for (int i=j+1;i<dado.length();i++){
			res=res+dado.charAt(i);
		}
		return Integer.parseInt(res);
	}

	public float colheDadoFloat(String dado){
		String res="";
		int j=0;
		while (!"=".equalsIgnoreCase(""+dado.charAt(j)))
			j++;
		for (int i=j+1;i<dado.length();i++){
			res=res+dado.charAt(i);
		}
		return Float.parseFloat(res);
	}

	public void lerMatrizSimetrica(){//Carrega a matriz simétrica na matriz de adjacência.
		if (matriz!=null){
			for (int i=0;i < np; i++){
				double tmp=0.0;
				int j=0;
				while (j<i){
					matriz[i][j]=matriz[j][i];
					j++;
				}
				for (;j<np; j++){
					if (i==j){
						matriz[i][j]=0.0;
					}else{
						tmp=r.nextDoublePonto();
						matriz[i][j]=tmp;
					}
				}
					
			}
		}else JOptionPane.showMessageDialog(null, "Matriz não iniciada!");
	}

	public Ponto[] lerPontos(){
		Ponto []res=new Ponto[np];
		String tes=r.nextLine();
		int nvl=numeroValoresLine(tes);
		if (nvl==3){
			Scanner tmp=new Scanner(tes);
			tmp.nextInt();
			res[0]=new Ponto(Double.parseDouble(tmp.next()), Double.parseDouble(tmp.next()));
			for (int i=1;i<np;i++){
				r.nextInt();
				res[i]=new Ponto(r.nextDoublePonto(),r.nextDoublePonto());
				//System.out.println(res[i].getX()+" "+res[i].getY());
			}
		}else
			if (nvl==2){
				Scanner tmp=new Scanner(tes);
				res[0]=new Ponto(Double.parseDouble(tmp.next()), Double.parseDouble(tmp.next()));
				for (int i=1;i<np;i++){
					res[i]=new Ponto(r.nextDoublePonto(),r.nextDoublePonto());
				}
			}
		return res;
	}

	public int numeroValoresLine(String ent){
		int res=0;
		Scanner sc=new Scanner(ent);
		while (sc.hasNext()){
			sc.next();
			res++;
		}
		return res;
	}

	public void geraMatriz(Ponto []ent){
		if (matriz != null && ent.length == np){
			for (int i=0;i<np;i++){
				for (int j=0;j<np;j++){
					matriz[i][j]=ent[i].distancia(ent[j]);
				}
			}
			//System.out.println(matriz[0][0]);
		}else JOptionPane.showMessageDialog(null, "Matriz não iniciada!");
	}

	public void printMatriz(){
		for (int i=0; i<np;i++){
			for (int j=0;j<np;j++)
				System.out.print(" "+matriz[i][j]);
			System.out.println();
		}
		//		for (int j=0;j<np;j++)
		//			System.out.print(" "+matriz[np-1][j]);
		//		System.out.println();
	}
}
