package com.jason.firework.study.base.inputfilterutil;

import org.junit.Test;

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2018/1/31$ 14:17$
 * <p/>
 */
public class JuntTestTest {
    @Test
    public void newBankcardFormat() throws Exception {
        int i= 1;
        String s = "1212 121212";

            System.out.println(InputFilters.newBankcardFormat(s,"+"));


    }
}