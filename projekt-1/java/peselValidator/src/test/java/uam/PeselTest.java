package uam;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PeselTest {

    @Test
    public void testPeselIsTooShort() {
        var pesel = "4908302951";

        var isValid = PeselValidatorClass.isValidPesel(pesel);

        assertFalse(isValid);
    }

    @Test
    public void testPeselIsTooLong() {
        var pesel = "490830295111";

        var isValid = PeselValidatorClass.isValidPesel(pesel);

        assertFalse(isValid);
    }

    @Test
    public void testPeselContainsCharacters() {
        var pesel = "4908302951a";

        var isValid = PeselValidatorClass.isValidPesel(pesel);

        assertFalse(isValid);
    }

    @Test
    public void testPeselIsNull() {
        String pesel = null;

        var isValid = PeselValidatorClass.isValidPesel(pesel);

        assertFalse(isValid);
    }

    @Test
    public void testNotValidPesel() {
        String pesel = "49083029510";

        var isValid = PeselValidatorClass.isValidPesel(pesel);

        assertFalse(isValid);
    }

    @Test
    public void testValidPesel() {
        String pesel = "49083029511";

        var isValid = PeselValidatorClass.isValidPesel(pesel);

        assertTrue(isValid);
    }

}
