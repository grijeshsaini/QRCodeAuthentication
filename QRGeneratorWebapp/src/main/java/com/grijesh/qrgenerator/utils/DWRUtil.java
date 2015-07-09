package com.grijesh.qrgenerator.utils;

import com.grijesh.qrgenerator.contract.QRCodeGenerator;
import com.grijesh.qrgenerator.impl.QRCodeImpl;
import com.grijesh.qrkeygenerator.cache.QRKeyKeeper;
import com.grijesh.qrkeygenerator.impl.QRKeyGeneratorImpl;
import org.apache.commons.io.IOUtils;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;

/**
 * Created by grijesh on 9/7/15.
 */
public class DWRUtil {

    public String getImage(){
        try {
            QRCodeGenerator qrCodeGenerator = QRCodeImpl.getInstance();
            String key = QRKeyGeneratorImpl.createKey(20);
            QRKeyKeeper keyKeeper = QRKeyKeeper.getInstance();
            keyKeeper.put(key,"inactive");
            InputStream inputStream = qrCodeGenerator.createQRCode("http://"+ "192.168.1.5"+":8080/qrcode/login/"+ key, 200, 200);
            return  "data:image/png;base64,"+
                    DatatypeConverter.printBase64Binary(IOUtils.toByteArray(inputStream));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
