package com.example.dio.service.impl;

import com.example.dio.service.QRcodeGeneratorservice;
import com.example.dio.utility.QRcodeGenerator;
import com.google.zxing.WriterException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class QRcodegeneratorserviceImpl  implements QRcodeGeneratorservice {


    @Override
    public byte[] generateQR(String url) throws IOException, WriterException {
        return QRcodeGenerator.generateQR(url,250,250);
    }
}
