package pegadaCarbono1;

public class Tipo {
    private double agua;
    private double gasolina;
    private double gas;
    private double eletricidade;

    private double aguaCarbono;
    private double gasolinaCarbono;
    private double gasCarbono;
    private double eletricidadeCarbono;

    public Tipo(double agua, double gasolina, double gas, double eletricidade) {
        this.agua = agua;
        this.gasolina = gasolina;
        this.gas = gas;
        this.eletricidade = eletricidade;
        this.aguaCarbono = 0;
        this.gasolinaCarbono = 0;
        this.gasCarbono = 0;
        this.eletricidadeCarbono = 0;
    }

    public double getAgua() {
        return agua;
    }

    public void setAgua(double agua) {
        this.agua = agua;
    }

    public double getGasolina() {
        return gasolina;
    }

    public void setGasolina(double gasolina) {
        this.gasolina = gasolina;
    }

    public double getGas() {
        return gas;
    }

    public void setGas(double gas) {
        this.gas = gas;
    }

    public double getEletricidade() {
        return eletricidade;
    }

    public void setEletricidade(double eletricidade) {
        this.eletricidade = eletricidade;
    }

    public double getAguaCarbono() {
        return aguaCarbono;
    }

    public void setAguaCarbono(double aguaCarbono) {
        this.aguaCarbono = aguaCarbono;
    }

    public double getGasolinaCarbono() {
        return gasolinaCarbono;
    }

    public void setGasolinaCarbono(double gasolinaCarbono) {
        this.gasolinaCarbono = gasolinaCarbono;
    }

    public double getGasCarbono() {
        return gasCarbono;
    }

    public void setGasCarbono(double gasCarbono) {
        this.gasCarbono = gasCarbono;
    }

    public double getEletricidadeCarbono() {
        return eletricidadeCarbono;
    }

    public void setEletricidadeCarbono(double eletricidadeCarbono) {
        this.eletricidadeCarbono = eletricidadeCarbono;
    }
}
