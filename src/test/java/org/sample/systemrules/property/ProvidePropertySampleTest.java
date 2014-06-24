package org.sample.systemrules.property;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ProvideSystemProperty;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by kaakaa_hoe on 2014/06/24.
 */
@RunWith(Enclosed.class)
public class ProvidePropertySampleTest {
    public static class 値指定 {
        @Rule
        public final ProvideSystemProperty properties = new ProvideSystemProperty("MyProperties", "MyValue");

        @Rule
        public final ProvideSystemProperty andProperties = new ProvideSystemProperty("AndProperties1", "AndValue1").and("AndProperties2", "AndValue2");

        @Test
        public void プロパティ値設定のテスト(){
            assertThat(System.getProperty("MyProperties"), is("MyValue"));
        }

        @Test
        public void プロパティ値設定のテスト_and指定(){
            assertThat(System.getProperty("AndProperties1"), is("AndValue1"));
            assertThat(System.getProperty("AndProperties2"), is("AndValue2"));
        }
    }

    public static class ファイル指定 {
        // @Rule
        //public final ProvideSystemProperty properties = ProvideSystemProperty.fromResource("sample.properties");

        @Test
        public void プロパティ値設定のテスト_リソースファイル読み込み(){
            assertThat(System.getProperty("PropertyFromResource"), is("ValueFromResourceFile"));
        }
    }
}
