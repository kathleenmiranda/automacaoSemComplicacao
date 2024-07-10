package transferencia;

public class Cliente {

    private String nome;
    private String cpf;
    private String rg;

    public Cliente(String rg, String cpf, String nome) {
        this.rg = rg;
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
}
