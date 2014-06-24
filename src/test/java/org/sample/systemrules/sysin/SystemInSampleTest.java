package org.sample.systemrules.sysin;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * Created by kaakaa_hoe on 2014/06/24.
 */
public class SystemInSampleTest {
    private final String lineSeparator = System.getProperty("line.separator");

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void 標準入力のテスト(){
        systemInMock.provideText("1" + lineSeparator + "2" + lineSeparator);
        assertThat(SystemInSample.summerizeFromSystemInput(), is(3));
    }
}
