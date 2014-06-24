package org.sample.systemrules.exit;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.Assertion;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.internal.CheckExitCalled;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by kaakaa_hoe on 2014/06/24.
 */
public class SystemExitSample {
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    private static String result;

    @Before
    public void setUp(){
        result = "Normal";
    }

    @Test
    public void システム終了のテスト_正常終了(){
        exit.expectSystemExit();
        System.exit(0);
    }

    @Test
    public void システム終了のテスト_異常終了(){
        exit.expectSystemExit();
        System.exit(1);
    }

    @Test
    public void システム終了のテスト_システム終了しない(){
        exit.expectSystemExit();
    }

    @Test
    public void システム終了時の戻り値のテスト_正常終了(){
        exit.expectSystemExitWithStatus(0);
        System.exit(0);
    }

    @Test
    public void システム終了時の戻り値のテスト_異常終了(){
        exit.expectSystemExitWithStatus(255);
        System.exit(255);
    }

    @Test
    public void システム終了時の戻り値のテスト_戻り値が異なる(){
        exit.expectSystemExitWithStatus(0);
        System.exit(255);
    }

    @Test
    public void システム終了時の状態のテスト(){
        exit.expectSystemExit();
        exit.checkAssertionAfterwards(new Assertion(){
            @Override
            public void checkAssertion() throws Exception {
                assertThat(result, is("Abort"));
            }
        });

        result = "Abort";
        System.exit(1);
    }

    @Test
    public void システム終了時の状態のテスト_assetion失敗(){
        exit.expectSystemExit();
        exit.checkAssertionAfterwards(new Assertion(){
            @Override
            public void checkAssertion() throws Exception {
                assertThat(result, is("Abort"));
            }
        });

        result = "Error";
        System.exit(255);
    }
}
