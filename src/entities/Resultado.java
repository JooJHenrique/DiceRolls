package entities;

import java.util.Random;

public class Resultado {

    private String calc;
    private Integer total;

    public Resultado(String calc, Integer total) {
        this.calc = calc;
        this.total = total;
    }

    public String getCalc() {
        return calc;
    }

    public Integer getTotal() {
        return total;
    }

    // metodo estático principal que interpreta a expressão dos dados
    public static Resultado interpretacaoDosDados(String expressao, Random random) {

        // divide a expressão pelos sinais de "+" para separar os dados e bônus
        // exemplo "2d20+4+2" vira ["2d20", "4", "2"]
        String[] partes = expressao.split("\\+");

        // a primeira parte sempre contém os dados (exemplo "1d8")
        String dadosParte1 = partes[0].trim();

        // calcula a soma dos bônus adicionais (todo número após o primeiro "+")
        int extraSoma = 0;
        StringBuilder extraSomaString = new StringBuilder();

        // loop para processar cada bônus (indice 1 em diante)
        for (int i = 1; i < partes.length; i++) {
            int valor = Integer.parseInt(partes[i].trim());
            extraSoma += valor; // soma para cálculo
            extraSomaString.append("+").append(valor); // string para exibição
        }

        // separa a quantidade de dados do tipo de dado
        // por exemplo: "2d20" vira ["2", "20"]
        String[] dadosParte2 = dadosParte1.split("d");
        int numDados = Integer.parseInt(dadosParte2[0]); // quantidade de dados
        int ladoDados = Integer.parseInt(dadosParte2[1]); // lados dos dados

        // string pra armazenar o resultado final
        String resultado = "";

        // loop para rolar cada dado individualmente
        for (int i = 0; i < numDados; i++) {

            // rola um dado (1 até o número de lados)
            int rolar = random.nextInt(ladoDados) + 1;

            // calcula o total individual (valor do dado + bônus)
            int totalIndividual = rolar + extraSoma;

            // monta a string do cálculo individual
            String calcIndividual = String.valueOf(rolar);
            if (extraSoma > 0) {
                calcIndividual += extraSomaString.toString(); // adiciona os bônus
            }

            // adiciona o resultado individual ao resultado final
            // ex formato: "8+3+2 = 13"
            resultado += calcIndividual + " = " + totalIndividual;

            // adiciona separador "|" entre os dados
            if (i < numDados - 1) {
                resultado += " | ";
            }
        }

        // retorna um novo objeto Resultado com a string montada
        // o total é 0 pq não usamos mais esse valor neste formato
        return new Resultado(resultado, 0);

    }
}
