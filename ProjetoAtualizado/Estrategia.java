//
// Padrão Strategy
// Esse padrão permite que um comportamento (aqui, as tentativas de conexão) 
// seja definido em tempo de execução, utilizando diferentes estratégias sem modificar o contexto.
//
import java.util.ArrayList;
import java.util.List;

class Estrategia 
{
    private IConexao[] conexoes; 
    private String status = "";
    //
    // Recebe estratégias de conexão no construtor
    //
    public Estrategia(GrupoConexoes pConexoes) 
    {
        conexoes = converterParaArray(pConexoes);        
    }

    private IConexao[] converterParaArray(GrupoConexoes pGrupoConexoes) 
    {
        List<IConexao> listaConexoes = pGrupoConexoes.getConexoes();
        return listaConexoes.toArray(new IConexao[0]);
    }
    //
    // Método que tenta conectar em sequência
    //
    public void conectar() 
    {
        String classeBemSucedida = "";
        
        for (IConexao conexao : conexoes) 
        {
            try 
            {
                conexao.validar();
                conexao.conectar();
                
                classeBemSucedida = conexao.getClass().getSimpleName(); // getClass (classe da instância atual) e getSimpleName (nome da classe)

                System.out.println("----------------------------------------"); 
                System.out.println("Conexão bem-sucedida com: " + classeBemSucedida);
                
                if (classeBemSucedida.contains("Nuvem"))
                    System.out.println("Sistema operando em modo PLENO.");                
                else
                {
                    System.out.print(Constantes.CORVERMELHA);                                    
                    System.out.println("Sistema operando em modo de CONTINGÊNCIA.");                
                    System.out.print(Constantes.CORPADRAO);                                                        
                }
                    

                status = classeBemSucedida;
                
                return; // Sai após a primeira conexão bem-sucedida
            } 
            catch (Exception e) 
            {
                System.out.println(e.getMessage()); 
            }
        }
        
        status = "nenhuma";
        
        System.out.println("----------------------------------------");     
        System.out.print(Constantes.CORVERMELHA);                
        System.out.println("Todas as tentativas de conexão falharam.");
        System.out.println("Sistema Inoperante!");                
        System.out.print(Constantes.CORPADRAO);                
    }
    //
    // Exibir o status da última tentativa de conexão
    //
    public void statusConexao() 
    {
        for (IConexao conexao : conexoes) 
        {
            String status = conexao.getStatus();
            
            if (status != null) 
            {
                System.out.println("Status atual: " + status);                
                return;
            }
        }
        
        System.out.println(Constantes.CORVERMELHA);        
        System.out.println("Nenhuma conexão bem-sucedida.");
        System.out.println(Constantes.CORPADRAO);        
    }
    
    public String getStatus()
    {
        return status;
    }
}