# Sistema de Rolagem de Dados

Um sistema simples para rolagem de dados em Java, ideal para jogos de RPG e outras aplicações que necessitem de dados aleatórios.

## Funcionalidades

- **Rolagem múltipla**: Role vários dados de uma vez (Por exemplo: `2d20`, `3d20`, `4d20`...)
- **Diferentes tipos de dados**: Suporte para dados com qualquer número de lados (d4, d6, d8, d12, d20, d100, etc.)
- **Bônus adicionais**: Adicione modificadores aos dados (Por exemplo: `1d20+4+2`)
- **Resultados individuais**: Cada dado é mostrado separadamente
- **Interface interativa**: Continue rolando até digitar "sair"

## Exemplos de Uso

### Formato de Entrada
O sistema aceita expressões no formato RPG padrão:
- `1d20` - Rola um dado de 20 lados
- `2d6+3` - Rola dois dados de 6 lados e adiciona 3
- `3d8+2+1` - Rola três dados de 8 lados e adiciona 2 e 1 <br>

```
2d20+1+2
Resultado: 15+1+2 = 18 | 10+1+2 = 13

3d6
Resultado: 4 = 4 | 2 = 2 | 6 = 6

1d100+10
Resultado: 87+10 = 97
```

## Como Executar

### Passos para executar

1. **Clone o repositório**
   ```bash
   git clone https://github.com/JooJHenrique/DiceRolls.git
   cd DiceRolls
   ```

2. **Compile o projeto**
   ```bash
   javac -d . application/RolagemDados.java entities/Resultado.java
   ```

3. **Execute o programa**
   ```bash
   java application.RolagemDados
   ```

4. **Utilize o sistema**
   - Digite sua rolagem no formato `XdY+Z` onde:
     - `X` = número de dados
     - `Y` = número de lados do dado
     - `Z` = bônus adicional (opcional)
   - Digite `sair` para encerrar
  
### Pré-requisitos
- Java 8 ou superior
- IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code, etc.)

## Como Funciona

### Processamento
1. **Análise da expressão**: A string é dividida pelos sinais de "+"
2. **Separação de dados e bônus**: Identifica a parte dos dados (Por exemplo: "2d20") e os modificadores
3. **Rolagem individual**: Cada dado é rolado separadamente
4. **Cálculo final**: Para cada dado, soma-se os bônus e mostra o resultado

### Exemplo de Processamento
Para a entrada `2d20+4+2`:
- **Dados**: 2 dados de 20 lados
- **Bônus**: +4 +2 (total +6)
- **Processo**: 
  - Dado 1: rola 15, soma +6 = 21
  - Dado 2: rola 10, soma +6 = 16
- **Saída**: `15+4+2 = 21 | 10+4+2 = 16`

## 🛠️ Tecnologias Utilizadas

- **Java**: Linguagem principal.
- **Scanner**: Para entrada do usuário.
- **Random**: Geração de números aleatórios.
- **StringBuilder**: Manipulação eficiente de strings.
