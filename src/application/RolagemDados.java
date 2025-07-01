package application;

import entities.Resultado;

import java.util.Random;
import java.util.Scanner;

import static entities.Resultado.interpretacaoDosDados;

public class RolagemDados {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            String rolagem = sc.nextLine();

            if (rolagem.equalsIgnoreCase("parar")) {
                break;
            }

            Resultado resultado = interpretacaoDosDados(rolagem, random);

            System.out.println("Resultado: " + resultado.getCalc());
            System.out.println();
        }

        sc.close();
    }
}
