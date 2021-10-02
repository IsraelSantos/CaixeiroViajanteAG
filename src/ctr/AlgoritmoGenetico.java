package ctr;

import inout.LerInstCaixeiro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AlgoritmoGenetico {
	
	List <Individuo> lis;
	double taxaMorte;
	Individuo melhorIndividuo;
	Individuo melInicial;
	Individuo piorIndiv;
	double resultMedio=0;
	double taxaPermut;
	int numG;
	LerInstCaixeiro inst;
	
	public AlgoritmoGenetico(int tamanho, double taxaPermut, double taxaMorte, int numGera, LerInstCaixeiro ins){
		this.taxaPermut = taxaPermut;
		this.taxaMorte = taxaMorte;
		this.numG=numGera;
		this.inst=ins;
		lis = new ArrayList<Individuo>();
		for (int i=0;i<tamanho;i++){
			lis.add(new Individuo(ins));
		}
		Collections.sort(lis);
		melInicial=melhorIndividuo=lis.get(0);
		piorIndiv=lis.get(0);
	}
	
	public void AG(){
		//Random a=new Random();
		for (int i=0;i<numG;i++){//Gerações
			for(int j=lis.size()-1,k=1;j>lis.size()-(taxaMorte*lis.size());j--,k++){
				//lis.get(Math.abs(a.nextInt(lis.size())))
				lis.set(j, new Individuo(inst, lis.get(0), lis.get(k), taxaPermut));//Substitue os individuos mais fracos por novos.
			}
			Collections.sort(lis);
			resultMedio+=lis.get(0).getFitness();
			if(lis.get(0).compareTo(melhorIndividuo)<0){
				melhorIndividuo=lis.get(0);
		
			}
			if(lis.get(0).compareTo(piorIndiv)>0){
				piorIndiv=lis.get(0);
			}
		}
		
		resultMedio=resultMedio/numG;
	}
	

	public double getResultMedio() {
		return resultMedio;
	}

	public Individuo getPiorIndiv() {
		return piorIndiv;
	}

	public Individuo getMelhorIndividuo() {
		return melhorIndividuo;
	}

	public Individuo getMelInicial() {
		return melInicial;
	}
	
	
	
}
