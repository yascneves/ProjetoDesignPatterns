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
import java.util.*;

class Main {
    //
    // Valida funcionamento da Internet
    //
    public static int AcessoInternetOK() 
    {
        Random random = new Random();
        return random.nextInt((1 - 0) + 1) + 0;
    }
    //
    // Valida funcionamento da Rede Local
    //
    public static int AcessoRedeLocalOK() 
    {
        Random random = new Random();
        return random.nextInt((1 - 0) + 1) + 0;
    }

    public static void AcessarBancoDadosNuvem()
    {
        //
        // Registrando dados na nuvem
        //
        System.out.println("Acesso OK: Acesso NUVEM");
    }
    
    public static void AcessarBancoDadosLAN()
    {
        //
        // Registrando dados na Rede Local
        //
        System.out.println(">> MODO CONTINGÊNCIA: Acesso LAN");        
    }
    
    public static void AcessarBancoDadosLocal()
    {
        //
        // Registrando dados na máquina local
        //
        System.out.println(">> MODO CONTINGÊNCIA: Acesso LOCAL");        
    }
    //
    // Determinar o modo de acesso ao banco de dados
    //
    public static void AcessarBancoDados()
    {
        if (AcessoInternetOK() == 1)
        {
            AcessarBancoDadosNuvem();
        }
        else
        {
            System.out.println("Falha no acesso à internet!");
            
            if (AcessoRedeLocalOK() == 1)
            {
                AcessarBancoDadosLAN();
            }
            else
            {
                System.out.println("Falha no acesso à Rede LAN!");            
                AcessarBancoDadosLocal();
            }
        }
    }

    public static void main (String[] args)
    {
        AcessarBancoDados();
    }
}