package com.ceeker.app.image.ocr;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.net.URISyntaxException;

/**
 * @author vectorzhang
 * @desc 中文识别很差,
 * 可以用jTessBoxEditor进行训练，从而提高识别率
 * 训练：https://www.cnblogs.com/wzben/p/5930538.html
 * https://www.cnblogs.com/cnlian/p/5765871.html
 * windows安装程序下载：https://github.com/UB-Mannheim/tesseract/wiki
 * @date 2018/6/25 17:09
 */
public class TesseractExample {

    public static void main( String[] args ) throws URISyntaxException {
//        System.setProperty("TESSDATA_PREFIX", "E:\\study\\java_study\\image_study\\target\\classes\\");
        String tessdata = Thread.currentThread().getContextClassLoader().getResource("tessdata").getFile();
        String absolutePath = new File(tessdata).getAbsolutePath();
        tessdata = tessdata.substring(1);
        String pic = Thread.currentThread().getContextClassLoader().getResource("imgs/6.png").getFile();
        File imgFile = new File(pic);
        ITesseract instance = new Tesseract();
        System.out.println(String.format("tessdata path=%s,imgFile=%s", tessdata, imgFile));
        try {
            //设置训练库的位置
            instance.setDatapath(absolutePath);
            //设置识别语言
            instance.setLanguage("chi_sim");
            String result = instance.doOCR(imgFile);
            System.out.println("ocr result:" + result);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }
}
