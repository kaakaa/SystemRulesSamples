package org.sample.systemrules.sysout;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.sample.systemrules.sysout.SystemOutSample;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class SystemOutSampleTest {
    private SystemOutSample target;

    private static final String newLine = System.getProperty("line.separator");

    @Before
    public void setUp(){
        target =new SystemOutSample();
    }

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Test
    public void 標準出力のテスト(){
        // when
        System.out.print("Hello SystemRules!");

        // then
        assertThat(log.getLog(), is("Hello SystemRules!"));
    }

    @Test
    public void 呼び出し先メソッドの標準出力のテスト(){
        // when
        target.say();

        // then
        assertThat(log.getLog(), is("Hi!" + newLine));
    }

    @Test
    public void 呼び出し先メソッドの標準出力のテスト_複数行(){
        // when
        target.sayMultiLine();

        // then
        assertThat(log.getLog(), is("Hi!" + newLine + "Bye!" + newLine));
    }

    @Test
    public void 呼び出し先メソッドの標準出力のテスト_複数行_assertを分かりやすく(){
        // when
        target.sayMultiLine();

        // then
        List<String> actualLog = Arrays.asList(log.getLog().split(newLine));
        assertThat(actualLog, contains("Hi!", "Bye!"));
    }

    @Test
    public void 途中で一度ログをクリアする(){
        // when
        target.sayMultiLine();
        log.clear();;
        target.say();

        // then
        List<String> actualLog = Arrays.asList(log.getLog().split(newLine));
        assertThat(actualLog, contains("Hi!"));
    }
}