package pegadaCarbono1;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerirPegada gerirPegada = new GerirPegada();
        Map<String, String> usuarios = new HashMap<>();


        usuarios.put("user1", "123");
        usuarios.put("user2", "123");


        System.out.println("Bem-vindo ao sistema de login!");

        String inputUsername, inputPassword;

        do {
            System.out.print("Insira o username: ");
            inputUsername = scanner.nextLine();
            System.out.print("Insira a password: ");
            inputPassword = scanner.nextLine();

            if (usuarios.containsKey(inputUsername) && usuarios.get(inputUsername).equals(inputPassword)) {
                System.out.println("Login bem sucedido!");
                break;
            } else {
                System.out.println("O Login falhou. Insira uma conta registada.");
            }
        } while (true);

        
        
        int option = -1;
        while (option != 0) {
            System.out.println("Menu:");
            System.out.println("1- Registar Água");
            System.out.println("2- Registar Gás");
            System.out.println("3- Registar Transporte");
            System.out.println("4- Registar Eletricidade");
            System.out.println("5- Calcular Pegada");
            System.out.println("6- Consultar Gastos");
            System.out.println("7- Definir Metas");
            System.out.println("8- Adicionar comentário anónimo");
            System.out.println("9- Mostrar comentários da comunidade");
            System.out.println("0- Terminar");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        System.out.print("Quantos litros de água foram gastos? (Este mês)");
                        if (scanner.hasNextDouble()) {
                            double agua = scanner.nextDouble();
                            gerirPegada.RegistarAgua(agua);
                            if (agua <= 3300) {
                                System.out.println("Está de acordo com as metas das Nações Unidas. Parabéns!");
                            } else if (agua <= 4200) {
                                System.out.println("Está um pouco acima das metas das Nações Unidas. Deve reduzir o consumo.");
                                System.out.println("Reduza o tempo do banho: \nTomar banhos mais curtos ajuda a economizar água. Considere instalar um temporizador no chuveiro para monitorar o tempo do banho.");
                            } else {
                                System.out.println("Está muito acima das metas das Nações Unidas. Tem de reduzir o consumo.");
                                System.out.println("Repare fugas: \nVerifique regularmente se existem fugas em canos, torneiras e chuveiros. Até mesmo pequenas fugas podem resultar em grande desperdício.");
                            }
                        } else {
                            System.out.println("Valor inválido para água.");
                            scanner.next(); 
                        }
                        break;
                    case 2:
                        System.out.print("Quantos metros cúbicos de gás foram gastos? (Este mês)");
                        if (scanner.hasNextDouble()) {
                            double gas = scanner.nextDouble();
                            gerirPegada.RegistarGas(gas);
                            if (gas <= 10) {
                                System.out.println("Está de acordo com as metas das Nações Unidas. Parabéns!");
                            } else if (gas <= 14) {
                                System.out.println("Está um pouco acima das metas das Nações Unidas. Deve reduzir o consumo.");
                                System.out.println("Aquecimento de água: \nReduza a temperatura do aquecedor de água para o nível mais baixo confortável. Isso reduz os gastos de gás.");
                            } else {
                                System.out.println("Está muito acima das metas das Nações Unidas. Tem de reduzir o consumo.");
                                System.out.println("Chuveiros eficientes: \nInstale chuveiros de baixo fluxo para reduzir o consumo de água quente durante o banho, o que por sua vez reduzirá a quantidade de gás utilizada para aquecer a mesma.");
                            }
                        } else {
                            System.out.println("Valor inválido para gás.");
                            scanner.next();
                        }
                        break;
                    case 3:
                        System.out.print("Quantos litros de gasolina foram gastos? (Este mês)");
                        if (scanner.hasNextDouble()) {
                            double gasolina = scanner.nextDouble();
                            gerirPegada.RegistarTransporte(gasolina);
                            if (gasolina <= 400) {
                                System.out.println("Está de acordo com as metas das Nações Unidas. Parabéns!");
                            } else if (gasolina <= 800) {
                                System.out.println("Está um pouco acima das metas das Nações Unidas. Deve reduzir o consumo.");
                                System.out.println("Dirija de forma eficiente: \nEvite acelerar ou travar bruscamente. Mantenha uma velocidade constante sempre que possível");
                            } else {
                                System.out.println("Está muito acima das metas das Nações Unidas. Tem de reduzir o consumo.");
                                System.out.println("Reduza o peso: Remova objetos desnecessários do seu veículo. Quanto mais peso o carro carrega, mais combustível consome.");
                            }
                        } else {
                            System.out.println("Valor inválido para gasolina.");
                            scanner.next();
                        }
                        break;
                    case 4:
                        System.out.print("Quantos kWh de eletricidade foram gastos? (Este mês)");
                        if (scanner.hasNextDouble()) {
                            double eletricidade = scanner.nextDouble();
                            gerirPegada.RegistarEletricidade(eletricidade);
                            if (eletricidade <= 110) {
                                System.out.println("Está de acordo com as metas das Nações Unidas. Parabéns!");
                            } else if (eletricidade <= 180) {
                                System.out.println("Está um pouco acima das metas das Nações Unidas. Deve reduzir o consumo.");
                                System.out.println("Troque para lâmpadas de LED: \nLâmpadas LED consomem significativamente menos energia do que lâmpadas incandescentes e duram muito mais tempo.");
                            } else {
                                System.out.println("Está muito acima das metas das Nações Unidas. Tem de reduzir o consumo.");
                                System.out.println("Aproveite a luz natural: \nManter cortinas e persianas abertas durante o dia permite que a luz natural entre, reduzindo a necessidade de iluminação artificial.");
                            }
                        } else {
                            System.out.println("Valor inválido para eletricidade.");
                            scanner.next();
                        }
                        break;
                    case 5:
                        double pegadaTotal = gerirPegada.CalcularPegada();
                        if (pegadaTotal != -1) {
                        	
                            System.out.println("Sua pegada de carbono total é: " + pegadaTotal + " kg CO2");
                            if (pegadaTotal <= 165) {
                                System.out.println("Está de acordo com as metas das Nações Unidas. Parabéns!");
                            } else if (pegadaTotal <= 200) {
                                System.out.println("Está um pouco acima das metas das Nações Unidas. Deve reduzir o consumo.");
                            } else {
                                System.out.println("Está muito acima das metas das Nações Unidas. Tem de reduzir o consumo.");
                            }
                            
                        }
                        break;
                    case 6:
                        gerirPegada.ConsultarGastos();
                        break;
                    case 7:
                        System.out.println("Definir Metas:");
                        System.out.print("Digite a meta desejada de consumo de água em kg CO2: ");
                        double metaAgua = scanner.nextDouble();
                        System.out.print("Digite a meta desejada de consumo de gás em kg CO2: ");
                        double metaGas = scanner.nextDouble();
                        System.out.print("Digite a meta desejada de consumo de gasolina em kg CO2: ");
                        double metaGasolina = scanner.nextDouble();
                        System.out.print("Digite a meta desejada de consumo de eletricidade em kg CO2: ");
                        double metaEletricidade = scanner.nextDouble();

                        double diferencaAgua = metaAgua - gerirPegada.getValores().getAgua();
                        double diferencaGas = metaGas - gerirPegada.getValores().getGas();
                        double diferencaGasolina = metaGasolina - gerirPegada.getValores().getGasolina();
                        double diferencaEletricidade = metaEletricidade - gerirPegada.getValores().getEletricidade();

                        System.out.println("Diferença entre a meta estabelecida e o gasto efetivo:");
                        System.out.println("Água: " + diferencaAgua + " kg CO2");
                        System.out.println("Gás: " + diferencaGas + " kg CO2");
                        System.out.println("Gasolina: " + diferencaGasolina + " kg CO2");
                        System.out.println("Eletricidade: " + diferencaEletricidade + " kg CO2");
                        break;
                        
                    case 8:
                    	GerirPegada.AdicionarComents();
                    break;
                    
                    case 9:
                    	GerirPegada.ImprimirComents();
                    break;
                    
                    case 0:
                        System.out.println("Terminando...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } else {
                System.out.println("Opção inválida. Por favor, insira um número.");
                scanner.next();
            }
        }

        scanner.close();
    }
}
