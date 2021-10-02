package inout;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileOut{
	private FileWriter arq;
	private BufferedWriter bw;

	public FileOut(String nome) {
		try{
			arq=new FileWriter(nome);
			bw=new BufferedWriter(arq);
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, "Não deu: :-("+e.getMessage());
		}
	}

	public void println(String entrada){
		try{
			bw.write(entrada+"\r\n");
			//bw.newLine();
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, "Não deu: :-("+e.getMessage());
		}
	}
	
	public void print(String entrada){
		try{
			bw.write(entrada);
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, "Não deu: :-("+e.getMessage());
		}
	}
	
	public void close(){
		try{
			bw.close();
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, "Não deu: :-("+e.getMessage());
		}
	}
}
