// package
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
public class LeitorArquivo 
{
/**
* Metodo recebe o caminho completo. Ex.
"C:\\arquivos\\texto.txt"
* @param rota: a rota completa do arquivo
* @return As linhas do arquivo em uma única string.
*/
public static String lerArquivo(String rota)
{
        String retorno = "";
        try {
    BufferedReader br = Files.newBufferedReader(Paths.get(rota), StandardCharsets.UTF_8);
    String s;
    while ((s = br.readLine()) != null) 
    {
        retorno += s;
    }
    }
    catch(NoSuchFileException ns)
    {
        System.out.println("Esse arquivo não existe. " + ns.toString());
    }
    catch(MalformedInputException mf)
    {
        System.out.println("Erro durante a codificação: " + mf.toString());
    }
    catch(IOException io)
    {
        System.out.println("Erro durante a leitura. "+ io.toString());
    }
    catch(Exception e)
    {
        System.out.println("Erro não pôde ser identificado. "+ e.toString());
    }
return retorno;
}
}