package ctr;

import inout.LerInstCaixeiro;

import java.util.Random;

public class Individuo implements Comparable {

	int []sq;
	double fitness;
	LerInstCaixeiro instcaix;

	public Individuo(LerInstCaixeiro ins){
		sq=new int[ins.getNp()];
		geraIndividuo(3);
		fitness=fitness(ins);
		instcaix=ins;
	}

	public Individuo(LerInstCaixeiro ins, Individuo a, Individuo b, double taxPerm){
		instcaix=ins;
		sq=cruzamento(a, b);
		permut(taxPerm);
		fitness=fitness(instcaix);
	}

	public void permut(double num){
		int tmp;
		boolean []qw = new boolean[sq.length];
		for(int i =0; i<qw.length; i++){
			qw[i] = false;
		}
		Random x = new Random();
		for(int i = 0; i < num*(sq.length/2); i++){
			for(;;){
				int rand1 = x.nextInt(sq.length);
				int rand2 = x.nextInt(sq.length);
				if(qw[rand1] == false && qw[rand2] == false){
					tmp = sq[rand1];
					sq[rand1] = sq[rand2];
					sq[rand2] = tmp;
					qw[rand1] = qw[rand2] = true;
					break;
				}
			}
			
		}
	}

	public static int[] cruzamento(Individuo a, Individuo b){
		int []sq2 = new int [a.getTamanho()];
		int i;
		//double t=Math.abs(Math.random());
		for (i = 0; i<sq2.length/2; i++){
			sq2[i] = a.getSq(i);
		}
		int l = i - 1;
		for (int k = 0; k<b.getTamanho(); k++){
			if(!verifica(sq2, l, b.getSq(k))){
				sq2[i]=b.getSq(k);
				i++;
			}
		}
		return sq2;

	}

	public static boolean verifica(int []vet, int i, int valor){
		for(int j = 0; j<=i; j++){
			if(valor == vet[j])
				return true;
		}
		return false;
	}

		
	public double getFitness() {
		return fitness;
	}

	public int getTamanho(){
		return sq.length;
	}

	public int getSq(int i) {
		return sq[i];
	}

	public void setSq(int[] sq) {
		this.sq = sq;
	}

	public double fitness(LerInstCaixeiro inst) {
		double res=0;
		for (int i=0;i<sq.length-1;i++){
			res+=inst.getPeso(sq[i], sq[i+1]);
		}
		res+=inst.getPeso(sq.length-1, 0);
		return res;
	}

	public void geraIndividuo(int nivel){
		for (int i = 0; i < sq.length; i++) {
			sq[i]=i;
		}
		Random a=new Random();
		for (int j=0;j<sq.length*nivel;j++){
			int r=Math.abs(a.nextInt()%sq.length);
			int r2=Math.abs(a.nextInt()%sq.length);
			int tmp=sq[r];
			sq[r]=sq[r2];
			sq[r2]=tmp;
		}
	}
	
	public int compareTo(Object arg0) {
		if (arg0 instanceof Individuo){
			Individuo tmp=(Individuo) arg0;
			if (this.getFitness()>tmp.getFitness())
			  return 1;
			else 
				if (this.getFitness()<tmp.getFitness())
					return -1;
				else
					return 0;
		}
		return 0;
	}
	
}