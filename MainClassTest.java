import org.junit.Assert;
import org.junit.Test;

public class MainClassTest {
    private static final int expectedValue = 14;

    @Test
    public void testGetLocalNumber() {
        MainClass mc = new MainClass();
        Assert.assertEquals("getLocalNumber return not 14",
                            mc.getLocalNumber(),
                            expectedValue);
    }
}
