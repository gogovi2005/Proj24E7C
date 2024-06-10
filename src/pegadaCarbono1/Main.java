package pegadaCarbono1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerirPegada gerirPegada = new GerirPegada();
        Map<String, String> usuarios = new HashMap<>();
        Map<String, GerirPegada> dadosUsuarios = new HashMap<>();
        int cont = 0;

        usuarios.put("user1", "123");
        usuarios.put("user2", "123");

        dadosUsuarios.put("user1", new GerirPegada());
        dadosUsuarios.put("user2", new GerirPegada());

        String inputUsername = "";
        boolean isLoggedIn = false;

        while (true) {
            if (!isLoggedIn) {
                System.out.println("Bem-vindo ao sistema de login!");

                System.out.print("Insira o username: ");
                inputUsername = scanner.nextLine();
                System.out.print("Insira a password: ");
                String inputPassword = scanner.nextLine();

                if (usuarios.containsKey(inputUsername) && usuarios.get(inputUsername).equals(inputPassword)) {
                    System.out.println("Login bem sucedido!");
                    gerirPegada = dadosUsuarios.get(inputUsername);
                    isLoggedIn = true;
                } else {
                    System.out.println("O Login falhou. Insira uma conta registada.");
                }
            }

            int option = -1;
            while (isLoggedIn && option != 0) {
                System.out.println("Menu:");
                System.out.println("1- Registar Água");
                System.out.println("2- Registar Gás");
                System.out.println("3- Registar Transporte");
                System.out.println("4- Registar Eletricidade");
                System.out.println("5- Calcular Pegada");
                System.out.println("6- Consultar Gastos");
                System.out.println("7- Definir Metas");
                System.out.println("8- Verificar Metas");
                System.out.println("9- Comparar Pegada de Carbono");
                System.out.println("10- Adicionar Comentário Anónimo");
                System.out.println("11- Visualizar comentários da comunidade");
                System.out.println("12- Logout");
                System.out.println("0- Terminar");

                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                    scanner.nextLine(); // Consome a nova linha

                    switch (option) {
                        case 1:
                            System.out.print("Quantos litros de água foram gastos? (Este mês) ");
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
                            System.out.print("Quantos metros cúbicos de gás foram gastos? (Este mês) ");
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
                                    System.out.println("Instalação de termostatos programáveis: \nInstale e configure termostatos programáveis para ajustar a temperatura automaticamente quando você não estiver em casa.");
                                }
                            } else {
                                System.out.println("Valor inválido para gás.");
                                scanner.next();
                            }
                            break;
                        case 3:
                            System.out.print("Quantos litros de gasolina foram gastos? (Este mês) ");
                            if (scanner.hasNextDouble()) {
                                double gasolina = scanner.nextDouble();
                                gerirPegada.RegistarTransporte(gasolina);
                                if (gasolina <= 40) {
                                    System.out.println("Está de acordo com as metas das Nações Unidas. Parabéns!");
                                } else if (gasolina <= 55) {
                                    System.out.println("Está um pouco acima das metas das Nações Unidas. Deve reduzir o consumo.");
                                    System.out.println("Evitar o uso excessivo do ar condicionado: \nO ar condicionado pode reduzir a eficiência do combustível. Use-o com moderação.");
                                } else {
                                    System.out.println("Está muito acima das metas das Nações Unidas. Tem de reduzir o consumo.");
                                    System.out.println("Manutenção regular do veículo: \nMantenha o seu veículo em boas condições com revisões regulares e mantenha os pneus devidamente calibrados.");
                                }
                            } else {
                                System.out.println("Valor inválido para gasolina.");
                                scanner.next();
                            }
                            break;
                        case 4:
                            System.out.print("Quantos kWh de eletricidade foram gastos? (Este mês) ");
                            if (scanner.hasNextDouble()) {
                                double eletricidade = scanner.nextDouble();
                                gerirPegada.RegistarEletricidade(eletricidade);
                                if (eletricidade <= 100) {
                                    System.out.println("Está de acordo com as metas das Nações Unidas. Parabéns!");
                                } else if (eletricidade <= 150) {
                                    System.out.println("Está um pouco acima das metas das Nações Unidas. Deve reduzir o consumo.");
                                    System.out.println("Uso de aparelhos eficientes: \nSubstitua aparelhos antigos por modelos mais eficientes em termos energéticos que consomem menos eletricidade.");
                                } else {
                                    System.out.println("Está muito acima das metas das Nações Unidas. Tem de reduzir o consumo.");
                                    System.out.println("Uso de iluminação eficiente: \nTroque lâmpadas incandescentes por lâmpadas LED que consomem menos energia e duram mais.");
                                }
                            } else {
                                System.out.println("Valor inválido para eletricidade.");
                                scanner.next();
                            }
                            break;
                        case 5:
                            double pegadaTotal = gerirPegada.CalcularPegada();
                            if (pegadaTotal != -1) {
                                System.out.println("A sua pegada de carbono total é: " + pegadaTotal + " kg CO2");
                                if(cont == 0) {
                                	double pegadaAntiga = pegadaTotal;
                                }
                                cont = cont + 1;
                            }
                            break;
                        case 6:
                            gerirPegada.ConsultarGastos();
                            gerirPegada.EstadoCritico();
                        break;
                        case 7:
                            gerirPegada.DefinirMetas();
                        break;
                        case 8:
                            gerirPegada.VerificarMetas();
                        break;
                        case 9:
                            System.out.print("Digite o username do outro usuário para comparar: ");
                            String outroUsuario = scanner.nextLine();
                            if (dadosUsuarios.containsKey(outroUsuario)) {
                                gerirPegada.CompararPegada(dadosUsuarios.get(outroUsuario));
                            } else {
                                System.out.println("Usuário não encontrado.");
                            }
                            break;
                        case 10:
                            gerirPegada.AdicionarComents();
                        break;
                        case 11:
                            gerirPegada.ImprimirComents();
                        break;
                        case 12:
                            isLoggedIn = false;
                            System.out.println("Logout bem sucedido!");
                            break;
                        case 0:
                            System.out.println("Terminando...");
                            isLoggedIn = false;
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                } else {
                    System.out.println("Opção inválida. Por favor, insira um número.");
                    scanner.next();
                }
            }

            if (option == 0) {
                break;
            }
        }

        scanner.close();
    }
}
