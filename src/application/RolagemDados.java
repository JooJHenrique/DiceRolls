package application;

import entities.Resultado;

import java.util.Random;
import java.util.Scanner;

import static entities.Resultado.interpretacaoDosDados;

public class RolagemDados {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        intro();
        System.out.println("Role o dado ou digite 'parar' para sair:");
        while (true) {
            String rolagem = sc.nextLine();
            if (rolagem.equalsIgnoreCase("parar")) {
                System.out.println("Rolls finalizados. Até mais!!");
                break;
            }
            try {
                Resultado resultado = interpretacaoDosDados(rolagem, random);
                System.out.println("Resultado: " + resultado.getCalc());
                System.out.println();
            } catch (IllegalArgumentException e) {
                System.out.println("Formato inválido! Modo de usar: 2d6+4 ou 1d20+2+5\n");
                System.out.println("Tente novamente:");
            }
        }
        sc.close();
    }
    private static void intro() {
        System.out.println("----------------------------------");
        System.out.println("🎲 Bem vindo ao DiceRolls 🎲");
        System.out.println("Como usar: informe a quantidade, o dado e o bônus.");
        System.out.println("Exemplo: 1d20 ou 1d20+2+5");
        System.out.println("Digite 'parar' para encerrar o programa!");
        System.out.println("----------------------------------");
    }
}