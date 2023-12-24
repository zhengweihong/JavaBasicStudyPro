package P02_Framework.JUnit.calculatorTest;

import P02_Framework.JUnit.calculator.Calculator;
import org.junit.*;

/**
 * @author : ZWH 2021/5/13
 * @version : 1.0
 */
public class calculatorTest {
    @Before
    public void calculatorTestBefore() {
        System.out.println("Before");
    }
    @After
    public void calculatorTestAfter() {
        System.out.println("After");
    }

    @Test
    public void testAdd() {
        int result = new Calculator().add(10,30);
        Assert.assertEquals(40,result);
    }
}