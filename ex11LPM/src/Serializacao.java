import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializacao {


    // Parte de serialização ainda não funciona corretamente


    // desserialização: recuperando os objetos gravados no arquivo binário "ArquivoNome" utilizando o método "readBinaryFile"
    public static ArrayList<Object> readBinaryFile(String arquivoNome) {
        ArrayList<Object> lista = new ArrayList();
        try {
            File arq = new File(arquivoNome);
            if (arq.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
                lista = (ArrayList<Object>) objInput.readObject();
                objInput.close();
            }
        } catch (IOException erro1) {
            System.out.printf("Erro: %s", erro1.getMessage());
        } catch (ClassNotFoundException erro2) {
            System.out.printf("Erro: %s", erro2.getMessage());
        }

        return (lista);
    }

    // serialização: gravando o objetos no arquivo binário "ArquivoNome" utilizando o método "writeBinaryFile"
    public static void writeBinaryFile(ArrayList<Object> lista, String arquivoNome) {
        File arq = new File(arquivoNome);
        try {
            arq.delete();
            arq.createNewFile();

            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
            objOutput.writeObject(lista);
            objOutput.close();

        } catch (IOException erro) {
            System.out.printf("Erro: %s", erro.getMessage());
        }
    }
}
