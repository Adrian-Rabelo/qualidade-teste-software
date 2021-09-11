package qts.locadora.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class LancandoExcecoes {

	public static void main(String[] args) throws FileNotFoundException {
		
		meuMetodo();

	}
	
	public static void meuMetodo() throws FileNotFoundException {
		
		InputStream is = new FileInputStream("meuArg.txt");
	}

}
