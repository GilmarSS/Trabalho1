public class Spam
{
    private static String[][] condicoes =
    {
        {"URGENTE", "10"},
        {"Gratis agora", "5"},
        {"Cartão de crédito aprovado", "8"},
        {"Acesse o link", "9"},
        {"Oferta imperdível", "3"},
        {"Descontos de até", "2"},
        {"Segurança", "4"},
        {"Clique aqui e ganhe já", "10"},
        {"Chave", "6"},
        {"Economizar", "9"}
    };
    public static int Analisar(String texto)
    {
        int pontuacao = 0;
        String textoLower = texto.toLowerCase();
        for(String[] condicaoP : condicoes)
        {
            String condicao = condicaoP[0].toLowerCase();
            int peso = Integer.parseInt(condicaoP[1]);
            if(textoLower.contains(condicao))
            {
                 pontuacao += peso;
            }

        }
        return pontuacao;
    }
    public static String Pontos (int pontuacao)
    {
        
        if (pontuacao >= 5)
        {
            return "fracamente suspeito";
        }
        else if (pontuacao > 30)
        {
            return "potencialmente suspeito";
        } 
        else if (pontuacao > 70)
        {
            return "spam";
        } 
        else
        {
            return "não suspeito";
        }
    }
    
public static void main(String[] args)
{
    String caminho = "spamteste.txt";
    String texto = LeitorArquivo.lerArquivo(caminho);

    int pontuacao = Spam.Analisar(texto);
    String pontos = Spam.Pontos(pontuacao);
    
    System.out.println("Pontuação final: " + pontuacao);
    System.out.println("Classificação: " + pontos);
}
}