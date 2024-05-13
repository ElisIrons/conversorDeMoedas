import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conversao conversor = new Conversao();
        int opcao = 0;

        Map<String, String> convertendoOpcoes = new HashMap<>();
        convertendoOpcoes.put("1", "ARS");
        convertendoOpcoes.put("2", "BOB");
        convertendoOpcoes.put("3", "CLP");
        convertendoOpcoes.put("4", "COP");
        convertendoOpcoes.put("5", "USD");
        convertendoOpcoes.put("6", "BRL");

        while (true) {
            System.out.println("\n$$$$$$$$$$$$$$$$$$$$$$$$$   CONVERSOR DE MOEDAS  $$$$$$$$$$$$$$$$$$$$$$$$$$$");
            System.out.println("$$                                                                        $$");
            System.out.println("$$ Digite o número que corresponde a opção da moeda que deseja converter: $$");
            System.out.println("$$                                                                        $$");
            System.out.println("$$                       1. ARS - Peso argentino                          $$");
            System.out.println("$$                       2. BOB - Boliviano boliviano                     $$");
            System.out.println("$$                       3. CLP - Peso chileno                            $$");
            System.out.println("$$                       4. COP - Peso colombiano                         $$");
            System.out.println("$$                       5. USD - Dólar americano                         $$");
            System.out.println("$$                       6. BRL - Real brasileiro                         $$");
            System.out.println("$$                       7. Sair                                          $$");
            System.out.println("$$                                                                        $$");
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

            String primeiraMoeda = scanner.nextLine();

            if (primeiraMoeda.equals("7")) {
                System.out.println("$aindo...");
                break;
            }

            String base_code = convertendoOpcoes.get(primeiraMoeda);

            System.out.println("Digite o valor em " + base_code + " que deseja converter: ");
            double valor = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Digite o número que corresponde a moeda para a qual deseja converter: ");
            String target_code = convertendoOpcoes.get(scanner.nextLine().toUpperCase());

            Moeda moeda = conversor.convertendo(base_code, target_code);

            if (moeda.getResult().equals("success")) {
                double quantidadeConvertida = valor * moeda.getConversionRate();
                System.out.println("A conversão de " + base_code +  " " + valor + " resulta em " + target_code + " " +  quantidadeConvertida );
            } else {
                System.out.println("Não foi possível realizar a conversão. Tente novamente.");
            }
        }
    }
}
