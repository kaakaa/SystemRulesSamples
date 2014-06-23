package org.sample.systemrules.property;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ClearSystemProperties;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by kaakaa_hoe on 2014/06/23.
 */
@RunWith(Enclosed.class)
public class ClearPropertiesSampleTest {

    public static class SystemRules使用時 {
        @Rule
        public final ClearSystemProperties javaHomeIsCleared = new ClearSystemProperties("user.country");

        @Test
        public void ロケールのテスト(){
            assertThat(System.getProperty("user.country"), is(nullValue()));
        }
    }

    public static class 通常時 {
        @Test
        public void ロケールのテスト(){
            assertThat(System.getProperty("user.country"), is("JP"));
        }
    }
}
