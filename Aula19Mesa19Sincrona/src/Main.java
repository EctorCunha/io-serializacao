import model.Contato;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){

        List<Contato> contatos = new ArrayList<>();

        Contato contato1 = new Contato("Josefina","Josefina@hotmail.com","67488392975");
        Contato contato2 = new Contato("Cicleide","Cicleide@hotmail.com","93048561829");
        Contato contato3 = new Contato("Ronaldo","Ronaldo@hotmail.com","84738765921");


        contatos.add(contato1);
        contatos.add(contato2);
        contatos.add(contato3);


        FileOutputStream fo = null;

        try {
            fo = new FileOutputStream("OutputFileContatos.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fo);
            oos.writeObject(contatos);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        List<Contato> recuperarcontatos = null;
        FileInputStream fi = null;

        try {
            fi = new FileInputStream ("OutputFileContatos.txt");
            ObjectInputStream ois = new ObjectInputStream(fi);
            recuperarcontatos = (ArrayList) ois.readObject();


        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        for(Contato c : recuperarcontatos) {
            System.out.println(
                    c.getNome()
                            + " | " + c.getNome()
                            + " | " + c.getEmail()
                            + " | " + c.getTelefone()
            );
        }

    }
}