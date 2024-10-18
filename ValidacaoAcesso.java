import java.util.*;

public class ValidacaoAcesso
{
    //private ModoAcesso modoAcesso = new ModoAcesso("", "", "");
    private Usuario user = new Usuario("admin", "111111", "0");
    private ModoAcesso2 modoAcesso = new ModoAcesso2("", user);

    
//  public ValidacaoAcesso(ModoAcesso pModo)
    public ValidacaoAcesso(ModoAcesso2 pModo)    
    {
        //this.modoAcesso = pModo;
        this.modoAcesso = pModo;        
    }
  //public Boolean ValidarConexao()    
    public Boolean VerificarConexao()
    {
        int retorno = 0;
        
        if (this.modoAcesso.modo() == "nuvem")
            retorno = AcessoInternetOK();
        else if (this.modoAcesso.modo() == "lan")
            retorno = AcessoRedeLocalOK();
        else if (this.modoAcesso.modo() == "local")
            retorno = AcessoBancoLocalOK();
            
        if (retorno == 1)
            return true;
        else
            return false;
    }
    //
    // Verifica funcionamento da Internet.
    //
    private int AcessoInternetOK() 
    {
        Random random = new Random();
        return random.nextInt((1 - 0) + 1) + 0;
    }
    //
    // Verifica funcionamento da Rede Local.
    //
    private int AcessoRedeLocalOK() 
    {
        Random random = new Random();
        return random.nextInt((1 - 0) + 1) + 0;
    }
    //
    // Verifica funcionamento do banco de dados na própria máquina.
    //
    private int AcessoBancoLocalOK() 
    {
        Random random = new Random();
        return random.nextInt((1 - 0) + 1) + 0;
    }
}