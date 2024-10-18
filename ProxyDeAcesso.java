public class ProxyDeAcesso
{
    //private ModoAcesso modo = new ModoAcesso("", "", "");
    private Usuario user = new Usuario("admin", "111111", "0");
    private ModoAcesso2 modo = new ModoAcesso2("", user);

    public ProxyDeAcesso(ModoAcesso2 pModo)
    {
        this.modo = pModo;
    }
    
    //@Override
    public String ObterConexao()
    {
        String objetoConexao = "";
        
        ValidacaoAcesso validacao = new ValidacaoAcesso(this.modo);
        
        if (validacao.VerificarConexao())
            objetoConexao = "nuvem";  // retorna o objeto de conexao;
        else
        {
            //modo = new ModoAcesso("lan", "admin", "121212");
            modo = new ModoAcesso2("lan", user);            
            validacao = new ValidacaoAcesso(modo);
            
            if (validacao.VerificarConexao())
                objetoConexao = "lan";    // retorna o objeto de conexao;
            else
                objetoConexao = "local";  // retorna o objeto de conexao;                    
        }
        
        AtualizarFuncoesDisponiveis(objetoConexao);
        
        return objetoConexao;
    }
    
    public void AtualizarFuncoesDisponiveis(String pTipoConexao)
    {
        Boolean Cupons = false;
        Boolean Pagamentos = false;
        Boolean Vendas = false;
        Boolean Relatorios = false;
        Boolean Graficos = false;
        Boolean Cadastros = false;

        switch (pTipoConexao)
        {
            case "nuvem":
                Cupons = true;
                Pagamentos = true;
                Vendas = true;
                Relatorios = true;
                Graficos = true;
                Cadastros = true;
                break;
                
            case "lan":
                Cupons = true;
                Pagamentos = true;
                Vendas = true;
                Relatorios = false;
                Graficos = false;
                Cadastros = false;
                break;
                
            case "local":
                Cupons = true;
                Pagamentos = true;
                Vendas = true;
                Relatorios = false;
                Graficos = false;
                Cadastros = false;
                break;
        }
    }
/*    
    public void operacaoDeLeituraGravacao()
    {
        //if ("nuvem".equalsIgnoreCase(this.modo.modo()))
        if ("nuvem".equalsIgnoreCase(this.modo.modo()))         
        {
//            pasta = new PastaCompartilhada();
//            System.out.println("O proxy 'Pasta Compartilhada' invoca a pasta Real: " +
//                               "método usado: operacaoDeLeituraGravacao()'\n");
//            pasta.operacaoDeLeituraGravacao();
        } 
        else 
        {
//            System.out.println("O proxy 'Pasta Compartilhada' avisa: " +
//                               "'Você não tem permissão para acessar esta pasta'\n");
        }
        
    }
*/    
}