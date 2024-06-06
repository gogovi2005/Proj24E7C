
package pegadaCarbono1;
/**
 * Grupo 7C
 */
import java.util.Scanner;

public class GerirPegada {
    private Tipo valores;
    private double metaAgua;
    private double metaGas;
    private double metaGasolina;
    private double metaEletricidade;

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
        scanner.close();
    }

    public void VerificarMetas() {
        System.out.println("Diferença entre a meta estabelecida e o gasto efetivo:");
        System.out.println("Água: " + (metaAgua - valores.getAgua()) + " kg CO2");
        System.out.println("Gás: " + (metaGas - valores.getGas()) + " kg CO2");
        System.out.println("Gasolina: " + (metaGasolina - valores.getGasolina()) + " kg CO2");
        System.out.println("Eletricidade: " + (metaEletricidade - valores.getEletricidade()) + " kg CO2");
    }
}
