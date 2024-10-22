/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.



//
// PROBLEMA:
// O caixa de uma loja possui uma aplicação cujo banco de dados está armazenado na nuvem.
// Em caso de problemas de acesso (sem conexão internet, por ex.) o sistema possui 
// um recurso de CONTINGÊNCIA que  permite a loja  funcionar  mesmo sem o acesso a 
// qualquer tipo de rede. O estratégia consiste em:
// 1º Tentar acessar o banco de dados na nuvem (pela conexão via internet);
// 2º Na indisponibilidade da internet, tentar acessar o banco de dados da rede local da loja;
// 3º Na indisponibilidade da LAN, gravar os dados no banco de dados na máquina local.
//
*******************************************************************************/

public class Main
{
    public static final String ANSI_RESET = "\u001B[0m";        
    public static final String ANSI_BLUE = "\u001B[34m";

	public static void main(String[] args) 
	{
        System.out.println(ANSI_BLUE + "STATUS CONEXÃO" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "==================================" + ANSI_RESET);          
    
        System.out.println("> 1. Acessando Banco de Dados");
        
	    ConexaoBD bd = new ConexaoBD();
	    bd.conectar();
	}
}
