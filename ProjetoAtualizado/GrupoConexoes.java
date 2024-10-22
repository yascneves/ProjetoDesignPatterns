import java.util.ArrayList;
import java.util.List;
/*
(Composite) Essa classe atua como a composição, representando uma coleção de objetos Conexao 
que podem ser tratados como uma única unidade. Ela implementa a interface IConexao, 
assim como os objetos individuais, permitindo que ambos (o grupo e as conexões individuais) 
sejam tratados da mesma forma.
*/
class GrupoConexoes implements IConexao // (Composite) "GrupoConexao" 
{
    private List<IConexao> conexoes = new ArrayList<>(); // (Composite) Essência do padrão (um objeto pode conter outros objetos de mesmo tipo).
    private String status;
    //
    // (Composite) O método abaixo (adicionarConexao) permite adicionar objetos Conexao ao ConexaoGrupo,
    // que é uma característica comum no padrão Composite, onde o "composite" é responsável 
    // por manter uma coleção de componentes.
    //
    public void adicionarConexao(IConexao conexao) 
    {
        conexoes.add(conexao);
    }
    
    public List<IConexao> getConexoes()
    {
        return conexoes;
    }
    
    // (Composite) Implementação do método conectar de forma a iterar sobre todas as conexões
    @Override
    public void conectar() throws Exception 
    {
        for (IConexao conexao : conexoes) {  // (Composite) Tratar todas as conexões contidas na composição de maneira uniforme
            conexao.conectar();              // Chama o método de cada componente, destacando o uso do Composite
        }
    }
    
    @Override
    public void validar() throws Exception 
    {
        for (IConexao conexao : conexoes)   // (Composite) Mesma ideia do método acima, agora na validação
        {  
            conexao.validar();               
        }
    }
    
    @Override
    public String getStatus() 
    {
        return "Grupo de Conexões";         // Retorna um status para o grupo como um todo
    }    
}