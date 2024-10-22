//
// Interface da estratégia de conexão. 
// Classes que implementam esta interface pode ser usada como uma estratégia de conexão.
//
interface IConexao 
{
    void conectar() throws Exception; // permite simular uma exceção
    void validar() throws Exception;  // permite simular uma exceção
    String getStatus();
}