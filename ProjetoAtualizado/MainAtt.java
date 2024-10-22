public class Main 
{
    public static void main(String[] args) 
    {
        GrupoConexoes grupoConexoes = new GrupoConexoes();  // (Composite)
        IConexao nuvem = new Nuvem();
        IConexao lan = new Lan();
        IConexao local = new Local();
        
        Constantes.qtPassos++;
        
	    System.out.print(Constantes.CORAZUL);
        System.out.println("PROCESSO DE CONEXÃO");
        System.out.println("========================================");        
	    System.out.print(Constantes.CORPADRAO);        
        System.out.println("> " + Constantes.qtPassos + ". Acessando Banco de Dados\n");
        //
        // Adicionar as opções de conexão no grupo de conexões;
        //
        grupoConexoes.adicionarConexao(nuvem);        
        grupoConexoes.adicionarConexao(lan);
        grupoConexoes.adicionarConexao(local);
        //
        // Estratégia para tentar as conexões
        //
        Estrategia estrategia = new Estrategia(grupoConexoes);
        estrategia.conectar();
    }
}
