package ctr;

import inout.FileOut;
import inout.LerInstCaixeiro;

import java.text.DecimalFormat;

public class ClassTeste {

	public static void main(String[] args) {

		int tamPop=1000;
		double taxaPermult=0.0001;
		double taxaMorte=0.9;
		int numGera=1000;
		FileOut f=new FileOut("saida.txt");
		
		if (args.length!=0){
			LerInstCaixeiro l=new LerInstCaixeiro(args[0]);
			double res=0;
			double meini=0;
			long tempo=0;
			double max=0;
			double melhor=0;
			double resultMedio=0;
			
			if (l.getSol()!=0){
				for (int j = 0; j < 3; j++) {//"Executá-lo pelo menos três vezes para cada instância."
					long ini=System.currentTimeMillis();
					AlgoritmoGenetico k=new AlgoritmoGenetico(tamPop,
							taxaPermult,
							taxaMorte,
							numGera,
							l);
					k.AG();
					long fim=System.currentTimeMillis();
					if (j==0)
						melhor=k.getMelhorIndividuo().getFitness();
					else
						if (melhor>k.getMelhorIndividuo().getFitness())
							melhor=k.getMelhorIndividuo().getFitness();
					res+=k.getMelhorIndividuo().getFitness();
					meini+=k.getMelInicial().getFitness();
					tempo+=fim-ini;
				}
				DecimalFormat fmt = new DecimalFormat("0.00");
				DecimalFormat fmt2 = new DecimalFormat("0.0000");
				String saida="Num:"+1+"\t"+"Ref:"+args[0]+"\t"+"n: "+l.getNp()+"\t"+"Otimo: "+fmt.format(l.getSol())+"\t"+"Inicial: "+fmt.format(meini/3)+"\t"+"tempo(s): "+fmt.format(((double)(tempo))/3000)+"\t"+"Melhor: "+fmt.format(melhor)+"\t"+"Gap: "+fmt2.format((melhor)/l.getSol());

				System.out.println(saida);
				f.println(saida);
			}else{
				for (int j = 0; j < 3; j++) {//"Executá-lo pelo menos três vezes para cada instância."
					long ini=System.currentTimeMillis();
					AlgoritmoGenetico k=new AlgoritmoGenetico(tamPop,
							taxaPermult,
							taxaMorte,
							numGera,
							l);
					k.AG();
					long fim=System.currentTimeMillis();
					if (j==0)
						melhor=k.getMelhorIndividuo().getFitness();
					else
						if (melhor>k.getMelhorIndividuo().getFitness())
							melhor=k.getMelhorIndividuo().getFitness();
					res+=k.getMelhorIndividuo().getFitness();
					meini+=k.getMelInicial().getFitness();
					tempo+=fim-ini;
					if (k.getMelhorIndividuo().getFitness()>max)
						max=k.getPiorIndiv().getFitness();
					resultMedio+=k.getResultMedio();
				}
				DecimalFormat fmt = new DecimalFormat("0.00");
				String saida="Num:"+1+"\t"+"Ref: "+args[0]+"\t"+"n: "+l.getNp()+"\t"+"Inicial: "+fmt.format(meini/3)+"\t"+"Max: "+fmt.format(max)+"\t"+"Media: "+fmt.format(res/3)+"\t"+"Melhor: "+fmt.format(melhor)+"\t"+"tempo(s): "+fmt.format(((double)(tempo))/3000);

				System.out.println(saida);
				f.println(saida);
			}
		}else{


			String vet[]=new String[10];
			vet[0]="PCV26";
			vet[1]="kroC100";
			vet[2]="ali535";
			vet[3]="a280";
			vet[4]="ulyss16";
			vet[5]="bays29";
			vet[6]="brazil58";
			vet[7]="pcv159";
			vet[8]="nrw1379";
			vet[9]="fl1400";
			

			


			int i;
			for (i=0;i<4;i++){
				LerInstCaixeiro l=new LerInstCaixeiro("arquivos//"+vet[i]+".txt");
				double res=0;
				double meini=0;
				long tempo=0;
				double melhor=0;
				for (int j = 0; j < 3; j++) {//"Executá-lo pelo menos três vezes para cada instância."
					long ini=System.currentTimeMillis();
					AlgoritmoGenetico k=new AlgoritmoGenetico(tamPop,
							taxaPermult,
							taxaMorte,
							numGera,
							l);
					k.AG();
					long fim=System.currentTimeMillis();
					if (j==0)
						melhor=k.getMelhorIndividuo().getFitness();
					else
						if (melhor>k.getMelhorIndividuo().getFitness())
							melhor=k.getMelhorIndividuo().getFitness();
					res+=k.getMelhorIndividuo().getFitness();
					meini+=k.getMelInicial().getFitness();
					tempo+=fim-ini;
				}
				DecimalFormat fmt = new DecimalFormat("0.00");
				DecimalFormat fmt2 = new DecimalFormat("0.0000");
				String saida=(i+1)+"\t"+vet[i]+"\t"+l.getNp()+"\t"+fmt.format(l.getSol())+"\t"+fmt.format(meini/3)+"\t"+fmt.format(((double)(tempo))/3000)+"\t"+fmt.format(melhor)+"\t"+fmt2.format((melhor)/l.getSol());

				System.out.println(saida);
				f.println(saida);
			}

			for (i=4;i<10;i++){
				LerInstCaixeiro l=new LerInstCaixeiro("arquivos//"+vet[i]+".txt");
				double res=0;
				double meini=0;
				long tempo=0;
				double max=0;
				double melhor=0;
				double resultMedio=0;
				for (int j = 0; j < 3; j++) {//"Executá-lo pelo menos três vezes para cada instância."
					long ini=System.currentTimeMillis();
					AlgoritmoGenetico k=new AlgoritmoGenetico(tamPop,
							taxaPermult,
							taxaMorte,
							numGera,
							l);
					k.AG();
					long fim=System.currentTimeMillis();
					if (j==0)
						melhor=k.getMelhorIndividuo().getFitness();
					else
						if (melhor>k.getMelhorIndividuo().getFitness())
							melhor=k.getMelhorIndividuo().getFitness();
					res+=k.getMelhorIndividuo().getFitness();
					meini+=k.getMelInicial().getFitness();
					tempo+=fim-ini;
					if (k.getMelhorIndividuo().getFitness()>max)
						max=k.getPiorIndiv().getFitness();
					resultMedio+=k.getResultMedio();
				}
				DecimalFormat fmt = new DecimalFormat("0.00");
				String saida=(i+1)+"\t"+vet[i]+"\t"+l.getNp()+"\t"+fmt.format(meini/3)+"\t"+fmt.format(max)+"\t"+fmt.format(res/3)+"\t"+fmt.format(melhor)+"\t"+fmt.format(((double)(tempo))/3000);

				System.out.println(saida);
				f.println(saida);
			}

			
		}

		f.close();
	}

}
