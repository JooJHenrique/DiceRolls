package application;

import entities.Resultado;

import java.util.Random;
import java.util.Scanner;

import static entities.Resultado.interpretacaoDosDados;

public class RolagemDados {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        // loop infinito até o usuário digitar "parar" pra finalizar o programa
        while (true) {
            String rolagem = sc.nextLine();

            // verifica se o usuário quer finalizar o programa, ignora maiúscula e minúscula
            if (rolagem.equalsIgnoreCase("parar")) {
                break;
            }

            // chama o metodo para interpretar os dados e obter o resultado
            Resultado resultado = interpretacaoDosDados(rolagem, random);

            // exibi o resultado da rolagem
            System.out.println("Resultado: " + resultado.getCalc());
            System.out.println();
        }

        sc.close();
    }
}
