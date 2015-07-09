package com.grijesh.test.qrkeygenerator;

import com.grijesh.qrgenerator.exception.ValidationException;
import com.grijesh.qrkeygenerator.impl.QRKeyGeneratorImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by grijesh on 6/7/15.
 */
public class TestQRKeyGenerator {


    @Test(expected = ValidationException.InvalidInputException.class)
    public void qr_key_length_lessthan0_shouldThrowExeption(){
        QRKeyGeneratorImpl.createKey(-1);
    }

    @Test
    public void qr_key_create_key(){
        //sut
        String key = QRKeyGeneratorImpl.createKey(10);
        //behaviour
        Assert.assertNotNull(key);
        Assert.assertTrue(key.length()==10);
    }

}
