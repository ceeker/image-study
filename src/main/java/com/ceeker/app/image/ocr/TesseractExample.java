package com.ceeker.app.image.ocr;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

/**
 * @author vectorzhang
 * @desc 中文识别很差,
 * 可以用jTessBoxEditor进行训练，从而提高识别率
 * 参考：https://www.cnblogs.com/wzben/p/5930538.html
 * https://www.cnblogs.com/cnlian/p/5765871.html
 * @date 2018/6/25 17:09
 */
public class TesseractExample {
    public static void main( String[] args ) {
//        System.setProperty("TESSDATA_PREFIX", "E:\\study\\java_study\\image_study\\target\\classes\\");

        File file = new File("E:\\study\\java_study\\image_study\\src\\main\\java\\com\\ceeker\\app\\image\\ocr\\5.png");
        ITesseract instance = new Tesseract();
        try {
            //设置训练库的位置
            instance.setDatapath("E:\\study\\java_study\\image_study\\src\\main\\java\\com\\ceeker\\app\\image\\ocr\\tessdata");
            //设置识别语言
//            instance.setLanguage("eng");
            instance.setLanguage("chi_sim");
            String result = instance.doOCR(file);
            System.out.println(result);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }
}
