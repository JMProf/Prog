import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CuentaTest {

    private Cuenta cuenta;

    @BeforeEach
    public void nuevaCuenta(){
        cuenta = new Cuenta ("ES21099865462528660871295", 1000);
    }

    @Test
    public void testGetNumero(){
        String resultadoEsperado = "ES21099865462528660871295";
        String resultado = cuenta.getNumero();
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testGetSaldo(){
        float resultadoEsperado = 1000;
        float resultado = cuenta.getSaldo();
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testSetNumero(){
        String numCta = "0987654321";
        cuenta.setNumero(numCta);
        String resultadoEsperado = "0987654321";
        String resultado = cuenta.getNumero();
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testSetSaldo(){
        Cuenta instance = new Cuenta("1234567890", 1000);
        float saldoCta = 2000;
        instance.setSaldo(saldoCta);
        float resultadoEsperado = 2000;
        float resultado = instance.getSaldo();
        assertEquals(resultadoEsperado, resultado);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -100, 100})
    public void testIngresarDinero(int number){
        Cuenta cuenta = new Cuenta("1234567890", 1000);
        cuenta.ingresarDinero(number);
        assertEquals(1000+number, cuenta.getSaldo());
    }
    
    @Test
    public void testExtraerDinero() {
        try{
        Cuenta cuenta = new Cuenta ("ES21099865462528660871295", 100);
        cuenta.extraerDinero(120);
        fail ("ERROR. Se debería haber lanzado una excepción al resultar un saldo negativo");
        }
        catch (ArithmeticException ae) {
        // Prueba correcta
        }
    }
}
