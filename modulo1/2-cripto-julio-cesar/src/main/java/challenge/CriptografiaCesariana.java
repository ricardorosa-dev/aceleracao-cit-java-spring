package challenge;

import java.util.Locale;

public class CriptografiaCesariana implements Criptografia {

    public String criptografar(String texto) {
        if (texto == "") {
            throw new IllegalArgumentException("O texto não pode estar vazio");
        }

        texto = texto.toLowerCase();
        String newTexto = "";

        // passa por todas as letras
        for (int i = 0; i < texto.length(); i++) {
            int asciiLetter = (int) texto.charAt(i);

            // se for número ou símbolo, mantém o caractere, senão adicionar 3
            if (asciiLetter > 65) {
                asciiLetter += 3;
            }
            char newLetter = (char) asciiLetter;
            newTexto += newLetter;
        }

        newTexto = newTexto.toLowerCase();
        System.out.println(newTexto);
        return newTexto;
    }

    public String descriptografar(String texto) {
        if (texto == "") {
            throw new IllegalArgumentException("O texto não pode estar vazio");
        }

        texto = texto.toLowerCase();
        String newTexto = "";

        // passa por todas as letras
        for (int i = 0; i < texto.length(); i++) {
            int asciiLetter = (int) texto.charAt(i);

            // se for número ou símbolo, mantém o caractere, senão adicionar 3
            if (asciiLetter > 65) {
                asciiLetter -= 3;
            }
            char newLetter = (char) asciiLetter;
            newTexto += newLetter;
        }

        newTexto = newTexto.toLowerCase();
        System.out.println(newTexto);
        return newTexto;
    }
}
