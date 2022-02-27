import org.junit.Assert;
import org.junit.Test;

public class MainClassTest {
    private static final int expectedValueTest1 = 14;
    private static final int expectedValueTest2 = 45;
    private static final String expectedValueTest3 = "%sello";
    private static final String firstLetterTest3 = "h";

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

    @Test
    public void testGetClassString() {
        String smallLetter = String.format(expectedValueTest3, firstLetterTest3);
        String bigLetter = String.format(expectedValueTest3, firstLetterTest3.toUpperCase());

        String errorMessage = "getClassString does not contain the substring: " +
                String.format(expectedValueTest3, firstLetterTest3.toUpperCase()) +
                ", " +
                String.format(expectedValueTest3, firstLetterTest3);

        Assert.assertTrue(errorMessage,
                mc.getClassString().contains(bigLetter) ||
                        mc.getClassString().contains(smallLetter));
    }
}
