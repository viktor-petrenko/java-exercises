package exercises.hamcrest;

import static org.hamcrest.Matchers.is;
import exercises.hamcrest.SoftHamcrestAssert;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class SoftHamcrestTest {

    @Test
    public void testHardAssert() {
        Assertions.assertThat("1").isGreaterThan("0");

        // SoftHamcrestAssert h = new SoftHamcrestAssert();
        // h.assertThat("Three", 2 * 2, is(3));
        // h.assertThat("Five",  2 * 2, is(5));
    }

    @Test
    public void testSoftAssert() {
        SoftHamcrestAssert h = new SoftHamcrestAssert();
        h.assertThat("Three", 2 * 2, is(3));
        h.assertThat("Five",  2 * 2, is(5));
        h.assertAll();
    }
}