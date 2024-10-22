public class ConexaoBD
{
    String conexaoDisponivel = "";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";        
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_BLACK = "\u001B[30m";
    
    public ConexaoBD()
    {
        
    }
    
    public void conectar()
    {
        String sel = "";
        String cor = "";
        //
        // Estabelece a tentativa padrão de conexão como NUVEM;
        // O proxy retornará, obrigatoriamente, alguma conexão possível.
        //
        //ModoAcesso modo = new ModoAcesso("nuvem", "admin", "111111");
        Usuario user = new Usuario("admin", "111111", "0");
        ModoAcesso2 modo = new ModoAcesso2("nuvem", user);
        
        ProxyDeAcesso px = new ProxyDeAcesso(modo);
        conexaoDisponivel = px.ObterConexao();
        
        System.out.println("> 2. Conexão Disponível: " + conexaoDisponivel);       
        //
        // BD disponível: operações liberadas
        //
        if (conexaoDisponivel != "nuvem")
        {
            System.out.println(ANSI_RED + "> 3. Sistema operando em modo de CONTINGÊNCIA." + ANSI_RESET);  
            sel = " ";
            cor = ANSI_BLACK; 
        }
        else
        {
            System.out.println(ANSI_BLUE + "> 3. Sistema operando NORMALMENTE." + ANSI_RESET);   
            sel = "x";
            cor = ANSI_RESET; 
        }
        //
        // Funções disponívels conforme disponibilidade da conexão do BD
        //
        System.out.println(ANSI_BLUE + "\n\nFUNÇOES DISPONÍVEIS" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "===================" + ANSI_RESET);                                               
        System.out.println(ANSI_RESET + "[x] Cupom Fiscal" + ANSI_RESET);                               
        System.out.println(ANSI_RESET + "[x] Pagamentos" + ANSI_RESET);
        System.out.println(ANSI_RESET + "[x] Vendas à Vista" + ANSI_RESET);        
        System.out.println(cor + "[" + sel + "] Relatórios" + ANSI_RESET);
        System.out.println(cor + "[" + sel + "] Gráficos" + ANSI_RESET);
        System.out.println(cor + "[" + sel + "] Cadastros" + ANSI_RESET);
    }
}