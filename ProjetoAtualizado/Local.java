// 
// Estratégia de conexão Lan
//
import java.util.*;

class Local implements IConexao 
{
    private String status;

    @Override
    public void conectar() throws Exception 
    {
        Constantes.qtPassos++;        
        
        if (status.contains("Falha"))
        {
            status = "Conexão falhou!";            
            System.out.println("> " + Constantes.qtPassos + ". Conexão NÃO estabelecida;");
            throw new Exception("");  // Simula um erro de conexão                       
        } 
        else 
        {
            status = "Conexão estabelecida!";            
            System.out.println("> " + Constantes.qtPassos + ". Conexão estabelecida;");
        }        
    }

    @Override
    public void validar() 
    {
        Constantes.qtPassos++;
        Random random = new Random();
        int r = random.nextInt((1) + 1);

        if (r == 1)
        {
            status = Constantes.CORAZUL + "Sucesso na conexão Local;" + Constantes.CORPADRAO;
        }
        else
        {
            status = Constantes.CORVERMELHA + "Falha na conexão Local;" + Constantes.CORPADRAO;
        }

        System.out.println("> " + Constantes.qtPassos + ". " + status);        
    }

    @Override
    public String getStatus() 
    {
        return status;
    }
}

