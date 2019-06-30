package edu.ifal.jogodaforca;

import java.util.ArrayList;
import java.util.Scanner;

import edu.ifal.jogodaforca.modelo.Banco;
import edu.ifal.jogodaforca.modelo.Jogador;

public class App 
{
    public static void main( String[] args )
    {
    	Scanner read = new Scanner(System.in);
        Jogador player =  new Jogador();
        Banco bank = new Banco();
        int erros = 0;
        int respJogarNovamente;
        
        do {
        	System.out.println("============ Jogo da Forca ==============");
            System.out.print("Digite o nome do jogador: ");
            String nome = read.nextLine();
            
            player.setNome(nome);
            
            limparTela();
            
            System.out.println("============ Jogo da Forca ==============");
            System.out.println("Jogador: " + player.getNome());
            
            String palavra = bank.sorteio();
            char palavraSecreta[] = new char[palavra.length()];
            
            System.out.println("=========================================");
            System.out.println("A palavra tem: " + palavra.length() + " letras.");
            
            inicializarPalavraSecreta(palavraSecreta);
            imprimirPalavraSecreta(palavraSecreta);
            
            ///////////////////////////////////////////////////////////////
            while(erros < 5 && !verificarVitoria(palavra, palavraSecreta)) {
    	        System.out.println("\n=========================================");
    	        System.out.println("=             Tema: Minecraft.          =");
    	        System.out.println("=========================================");
    	        System.out.println("Palavra sendo descoberta: ");
    	        imprimirPalavraSecreta(palavraSecreta);
    	        System.out.print("\n-> Digite a letra que você acha que tem: ");
    	        
    	        String letra = read.nextLine();
    	        System.out.println("=========================================");
    	        
    	        boolean contemLetra = palavra.contains(letra);
    	        
    	        limparTela();
    	        
    	        if(contemLetra) {
    	        	for(int i = 0; i < palavra.length(); i++) {
    	        		
    	            	if(palavra.charAt(i) == letra.charAt(0)) {
    	            	//	System.out.print(letra);
    	            		palavraSecreta[i] = letra.charAt(0);
    	            	}
    	            }
    	        }
    	        
    	        else {
    	        	System.out.println("Eroooou!");
    	        	System.out.println("Lembre-se: A palavra tem " + palavra.length() + " letras.");
    	        	erros++;
    	        }
    	        
    	        
    	        System.out.println("\nSua ultima tentativa foi a letra: " + letra);
    	        desenharCondenado(erros);
            }
            limparTela();
            if(verificarVitoria(palavra, palavraSecreta)) {
            	System.out.println("=========================================");
            	System.out.println("=                WINNER                 =");
            	System.out.println("=       Parabéns! Você salvou José!     =");
            	System.out.println("=            ___                        =");
            	System.out.println("=           (°-°)/ Obrigado " + player.getNome() + "!");
            	System.out.println("=========================================");
            }else {
            	System.out.println("=========================================");
            	System.out.println("=                 LOSER                 =");
            	System.out.println("=       Por sua culpa, José morreu! ;c  =");
            	System.out.println("=            ___                        =");
            	System.out.println("=           (#-#) R.I.P José.           =");
            	System.out.println("=       A palavra era: " + palavra);
            	System.out.println("=========================================");
            }
            
            erros = 0;
            
            System.out.println("VIDAS ESTÃO EM JOGO!");
            System.out.println("Deseja jogar novamente?[1-Sim/2-Não]");
            respJogarNovamente = read.nextInt();
            
            limparTela();
            
            read.nextLine();
            
            ///////////////////////////////////////////////////////////////
        }while(respJogarNovamente == 1);
        
        if(respJogarNovamente == 2) {
        	limparTela();
        	System.out.println("=========================================");
        	System.out.println("=         Obrigado por jogar!           =");
        	System.out.println("=========================================");
        }
        
        read.close();
    }
    
    public static void imprimirPalavraSecreta(char[] palavraSecreta) {
    	for(int i = 0; i < palavraSecreta.length; i++) {
    		System.out.print(palavraSecreta[i]);
    	}
    }
    
    public static char[] inicializarPalavraSecreta(char[] palavraSecreta) {
    	for(int i = 0; i < palavraSecreta.length; i++) {
    		palavraSecreta[i] = '_'; 
    	}
    	return palavraSecreta;
    }
    
    public static boolean verificarVitoria(String palavraSorteada, char[] palavraSecreta) {
    	String palavraEscondidaAuxiliar = new String(palavraSecreta);
    	if(palavraSorteada.equals(palavraEscondidaAuxiliar)) {
    		return true;
    	}
    	
    	return false;
    }
    
    public static void desenharCondenado(int qntErros) {
    	ArrayList<String> corpo = new ArrayList<String>();
    	corpo.add("'º ");
    	corpo.add("´| ");
    	corpo.add("´|`");
    	corpo.add("´  ");
    	corpo.add("´ `");
    	
    	System.out.println("Corpo da vitima sendo assassinada:");
    	switch (qntErros) {
		case 1:
			System.out.println(corpo.get(0));
			break;
		case 2: 
			System.out.println(corpo.get(0));
			System.out.println(corpo.get(1));
			break;
		case 3: 
			System.out.println(corpo.get(0));
			System.out.println(corpo.get(2));
			break;
		case 4: 
			System.out.println(corpo.get(0));
			System.out.println(corpo.get(2));
			System.out.println(corpo.get(3));
			break;
		case 5:
			System.out.println(corpo.get(0));
			System.out.println(corpo.get(2));
			System.out.println(corpo.get(4));
			break;
		default:
			System.out.println("AINDA SEM VITIMA!");
			break;
		}
    }
    
    public static void limparTela() {
    	for(int i = 0; i < 25; i++) {
        	System.out.println("");
        }
    }
}
