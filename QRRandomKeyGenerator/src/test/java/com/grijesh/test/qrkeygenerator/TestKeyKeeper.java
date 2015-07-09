package com.grijesh.test.qrkeygenerator;

import com.grijesh.qrkeygenerator.cache.QRKeyKeeper;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by grijesh on 9/7/15.
 */
public class TestKeyKeeper {

    private QRKeyKeeper keyKeeper=null;

    @Before
    public void init(){
        keyKeeper = QRKeyKeeper.getInstance();
    }

    @Test
    public void test_get_cache(){
        keyKeeper.put("1","asdas");
        System.out.println(keyKeeper.get("1"));
    }
}
