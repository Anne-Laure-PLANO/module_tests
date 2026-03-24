import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    // ------- Additions ------------

    @Test
    void addition_twoPositifs_returnSum() {
        int a = 5;
        int b = 9;

        int result = calculator.addNumbers(a, b);

        assertEquals(14, result);
    }


    @Test
    void addition_twoNegatifs_returnSum() {
        int a = -10;
        int b = -15;

        int result = calculator.addNumbers(a, b);
        assertEquals(-25, result);
    }


    @Test
    void addition_twoZero_returnSum() {
        int a = 0;
        int b = 0;
        int result = calculator.addNumbers(a, b);
        assertEquals(0, result);
    }

    // ------- Soustractions ----------

    @Test
    void soustract_twoPositifs_returnDifference() {
        int a = 6;
        int b = 5;

        int result = calculator.soustractNumber(a, b);
        assertEquals(1, result);
    }

    @Test
    void soustract_twoNegatifs_returnDifference() {
        int a = -15;
        int b = -10;

        int result = calculator.soustractNumber(a, b);

        assertEquals(-5, result);
    }

    @Test
    void soustract_resultNegatif_returnANegatif() {
        assertEquals(-3, calculator.soustractNumber(2, 5));
    }

    @Test
    void soustract_twoEqualsNumbers_returnZero() {
        assertEquals(0, calculator.soustractNumber(6, 6));
    }


    // ------------- Multiplications ------------

    @Test
    void multiply_twoPositifs_intresult(){
        assertEquals(30, calculator.multiplyNumbers(6,5));
    }

    @Test
    void multiply_twoNegatifs_intResult(){
        assertEquals(25, calculator.multiplyNumbers(-5, -5));
    }

    @Test
    void multiply_negatifAndPositif_intResult(){
        assertEquals(-36, calculator.multiplyNumbers(6,-6));
    }

    @Test
    void multiply_positifAndZero_returnZero(){
        assertEquals( 0 , calculator.multiplyNumbers(3,0));
    }

    // ---------- Divisions -------------

    @Test
    void divise_numSuperieurADenum_returnInt(){
        assertEquals(3, calculator.diviseNumbers(18,6));
    }

    @Test
    void divise_numInferieurADenum_returnFloat(){
        assertTrue(calculator.diviseNumbers(2,3)>=0);
    }

    @Test
    void divise_zeroIsDenominateur_returnException(){
        assertThrows(ArithmeticException.class, () -> calculator.diviseNumbers(10, 0));
    }

}
