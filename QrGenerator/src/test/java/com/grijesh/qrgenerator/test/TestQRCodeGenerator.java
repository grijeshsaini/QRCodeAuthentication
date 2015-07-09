package com.grijesh.qrgenerator.test;

import com.grijesh.qrgenerator.contract.QRCodeGenerator;
import com.grijesh.qrgenerator.exception.ValidationException;
import com.grijesh.qrgenerator.impl.QRCodeImpl;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;

/**
 * Created by Grijesh Saini on 5/7/15.
 *
 */
public class TestQRCodeGenerator {

    private QRCodeGenerator qrCodeGenerator;

    //private File file;

    @Before
    public void before(){
        qrCodeGenerator = QRCodeImpl.getInstance();
        //file = new File("/home/grijesh/qrcode.PNG");
    }

    //todo This test case needs to be changed (Can be used for Integration Testing)
   /* @Test
    public void testCodeGenerator(){
        try {
            InputStream inputStream = qrCodeGenerator.createQRCode("First Git Hub Application", 400, 400);
            FileUtils.copyInputStreamToFile(inputStream, file);
        }catch (Exception e){
            Assert.fail();
        }
    }*/

    @Test(expected = ValidationException.InvalidInputException.class)
    public void test_height_lessthanzero_shouldThrowValidationException(){
        qrCodeGenerator.createQRCode("Testing",-1,400);
    }

    @Test(expected = ValidationException.InvalidInputException.class)
    public void test_width_lessthanzero_shouldThrowValidationException(){
        qrCodeGenerator.createQRCode("Testing",400,-1);
    }

    @Test(expected = ValidationException.InvalidInputException.class)
    public void test_text_null_shouldThrowValidationException(){
        qrCodeGenerator.createQRCode(null,400,-1);
    }

    @Test
    public void test_singleton(){
        QRCodeGenerator qrCodeGenerator1 =  QRCodeImpl.getInstance();
        Assert.assertTrue(qrCodeGenerator1==qrCodeGenerator);
    }
}
