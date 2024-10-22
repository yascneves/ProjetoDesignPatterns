public class ModoAcesso2
{
    private String cModo = "";
    private Usuario cUsuario;  // <- Composição

    public ModoAcesso2(String pModo, Usuario pUsuario)
    {
        cModo = pModo;
        cUsuario = pUsuario;
    }
    
    public String modo() 
    {
        return cModo;
    }
    
    public Usuario usuario() 
    {
        return cUsuario;
    }
}