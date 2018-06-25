package com.ceeker.app.image.ocr;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

/**
 * @author vectorzhang
 * @desc
 * @date 2018/6/25 17:09
 */
public class TesseractExample {
    public static void main( String[] args ) {
        System.setProperty("TESSDATA_PREFIX", "E:\\study\\java_study\\opencv_study\\target\\classes\\");

        File file = new File("E:\\study\\java_study\\opencv_study\\target\\classes\\imgs\\card.jpg");
        ITesseract instance = new Tesseract();
        try {
            //设置训练库的位置
            instance.setDatapath("E:\\study\\java_study\\opencv_study\\target\\classes\\tessdata\\");
            //设置识别语言
            instance.setLanguage("eng");
            String result = instance.doOCR(file);
            System.out.println(result);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }
}
