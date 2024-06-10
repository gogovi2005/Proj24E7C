package pegadaCarbono1;

import java.util.Scanner;
import java.util.ArrayList;

public class GerirPegada {
    private Tipo valores;
    private Comentarios coments;
    private double metaAgua;
    private double metaGas;
    private double metaGasolina;
    private double metaEletricidade;
    static ArrayList<Comentarios> listaComents = new ArrayList<>();

    public GerirPegada() {
        this.valores = new Tipo(0, 0, 0, 0);
        this.metaAgua = 0;
        this.metaGas = 0;
        this.metaGasolina = 0;
        this.metaEletricidade = 0;
    }

    public Tipo getValores() {
        return valores;
    }

    public void RegistarAgua(double litros) {
        double carbono = litros * 0.0003;
        valores.setAgua(valores.getAgua() + carbono);
    }

    public void RegistarGas(double metrosCubicos) {
        double carbono = metrosCubicos * 2.1;
        valores.setGas(valores.getGas() + carbono);
    }

    public void RegistarTransporte(double litrosGasolina) {
        double carbono = litrosGasolina * 2.3;
        valores.setGasolina(valores.getGasolina() + carbono);
    }

    public void RegistarEletricidade(double kWh) {
        double carbono = kWh * 0.5;
        valores.setEletricidade(valores.getEletricidade() + carbono);
    }

    public double CalcularPegada() {
        double totalCarbono = valores.getAgua() + valores.getGasolina() + valores.getGas() + valores.getEletricidade();

        if (valores.getAgua() == 0 || valores.getGasolina() == 0 || valores.getGas() == 0 || valores.getEletricidade() == 0) {
            System.out.println("Todos os registros devem ser completados antes de calcular a pegada de carbono.");
            return -1;
        }

        return totalCarbono;
    }

    public void ConsultarGastos() {
        System.out.println("Gastos de Carbono:");
        System.out.println("Água: " + valores.getAgua() + " kg CO2");
        System.out.println("Gás: " + valores.getGas() + " kg CO2");
        System.out.println("Gasolina: " + valores.getGasolina() + " kg CO2");
        System.out.println("Eletricidade: " + valores.getEletricidade() + " kg CO2");
    }

    public void DefinirMetas() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a meta desejada de consumo de água em kg CO2: ");
        this.metaAgua = scanner.nextDouble();
        System.out.print("Digite a meta desejada de consumo de gás em kg CO2: ");
        this.metaGas = scanner.nextDouble();
        System.out.print("Digite a meta desejada de consumo de gasolina em kg CO2: ");
        this.metaGasolina = scanner.nextDouble();
        System.out.print("Digite a meta desejada de consumo de eletricidade em kg CO2: ");
        this.metaEletricidade = scanner.nextDouble();
    }

    public void VerificarMetas() {
        System.out.println("Diferença entre a meta estabelecida e o gasto efetivo:");
        System.out.println("Água: " + (metaAgua - valores.getAgua()) + " kg CO2");
        System.out.println("Gás: " + (metaGas - valores.getGas()) + " kg CO2");
        System.out.println("Gasolina: " + (metaGasolina - valores.getGasolina()) + " kg CO2");
        System.out.println("Eletricidade: " + (metaEletricidade - valores.getEletricidade()) + " kg CO2");
    }

    public void CompararPegada(GerirPegada outroUsuario) {
        double minhaPegada = this.CalcularPegada();
        double outraPegada = outroUsuario.CalcularPegada();

        if (minhaPegada != -1 && outraPegada != -1) {
            System.out.println("Sua pegada de carbono: " + minhaPegada + " kg CO2");
            System.out.println("Pegada de carbono do outro usuário: " + outraPegada + " kg CO2");

            if (minhaPegada < outraPegada) {
                System.out.println("Sua pegada de carbono é menor.");
            } else if (minhaPegada > outraPegada) {
                System.out.println("Sua pegada de carbono é maior.");
            } else {
                System.out.println("Suas pegadas de carbono são iguais.");
            }
        } else {
            System.out.println("Não foi possível comparar as pegadas de carbono. Verifique se todos os registros estão completos.");
        }
    }
    public static void AdicionarComents() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Qual a data?");
    	String data = scanner.nextLine();
    	System.out.println("Digite o seu comentário");
    	String comentario = scanner.nextLine();
    	listaComents.add(new Comentarios(data, comentario));
    }
    public static void ImprimirComents() {
    	for(Comentarios comentPrint : listaComents) {
    		System.out.println(comentPrint);
    	   	}
    }
    public void EstadoCritico() {
    	if(valores.getAgua() > valores.getGasolina() && valores.getAgua() > valores.getGas() && valores.getAgua() > valores.getEletricidade()) {
    		System.out.println("O seu gasto mais elevado é o de água. Experimente reduzir o fluxo de água das suas torneiras");
    	}
    	if(valores.getGasolina() > valores.getAgua() && valores.getGasolina() > valores.getGas() && valores.getGasolina() > valores.getEletricidade()) {
    		System.out.println("O seu gasto mais elevado é o de gasolina. Experimente andar mais em transportes públicos");
    	}
    	if(valores.getGas() > valores.getGasolina() && valores.getGas() > valores.getAgua() && valores.getGas() > valores.getEletricidade()) {
    		System.out.println("O seu gasto mais elevado é o de gás. Experimente tomar banho sem aquecer demasiado a água");
    	}
    	if (valores.getEletricidade() > valores.getAgua() && valores.getEletricidade() > valores.getGas() && valores.getEletricidade() > valores.getGasolina()) {
    		System.out.println("O seu gasto mais elevado é o de eletricidade. Experimente desligar as luzes sempre que não está numa certa divisão");
    	}
    }
}