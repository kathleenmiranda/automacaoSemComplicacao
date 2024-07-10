package transferencia;

public class Conta {
    String agencia;
    String numeroConta;
    double saldo;
    Cliente cliente;

    public Conta(Cliente cliente, double saldo, String numeroConta, String agencia) {
        this.cliente = cliente;
        this.saldo = saldo;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void realizarDeposito(double valor){
        saldo += valor;
    }

    public boolean realizarSaque(double valor){
        if(valor > saldo){
            return false;
        }
        saldo -= valor;
        return true;
    }

    public boolean realizarTransferencia(double valor, Conta destino){
        if(realizarSaque(valor)){
            destino.realizarDeposito(valor);
            return true;
        }
        return false;



    }
}
