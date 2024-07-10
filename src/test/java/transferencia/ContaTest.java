package transferencia;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {
    Cliente nomeClienteUm;
    Cliente nomeClienteDois;
    Conta contaClienteUm;
    Conta contaClienteDois;

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Validação da transação entre duas contas")
    public void realizarTransacao(){
      nomeClienteUm = new Cliente("122344325","11111111111", "Maria do Bairro");
      nomeClienteDois = new Cliente("985455438", "11234567894","Aquamarine");

      contaClienteUm = new Conta(nomeClienteUm, 1900.00,"3345","23345");
      contaClienteDois = new Conta(nomeClienteDois,8970.00,"4556","X");

     contaClienteUm.realizarTransferencia(1000.00,contaClienteDois);

     assertEquals(900.00, contaClienteUm.getSaldo(), 000.01);
        System.out.println(contaClienteUm.saldo);
     assertEquals(9970.00, contaClienteDois.getSaldo());
 }

 @Test
    public void validarTransfereciaInvalida(){
        nomeClienteUm = new Cliente("122344325","11111111111", "Maria do Bairro");
        nomeClienteDois = new Cliente("985455438", "11234567894","Aquamarine");

        contaClienteUm = new Conta(nomeClienteUm, 1900.00,"3345","23345");
        contaClienteDois = new Conta(nomeClienteDois,8970.00,"4556","X");

        boolean resultado = contaClienteUm.realizarTransferencia(2000.00, contaClienteDois);
        assertFalse(resultado);
 }

}