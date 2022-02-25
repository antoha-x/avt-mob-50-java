import org.junit.Assert;
import org.junit.Test;

public class MainClassTest {
    private static final int expectedValueTest1 = 14;
    private static final int expectedValueTest2 = 45;

    MainClass mc = new MainClass();

    @Test
    public void testGetLocalNumber() {
        Assert.assertEquals("getLocalNumber return not 14", mc.getLocalNumber(), expectedValueTest1);
    }

    @Test
    public void testGetClassNumber() {
        Assert.assertTrue("getClassNumber return less than 45",
                    mc.getClassNumber() > expectedValueTest2);
    }
}
