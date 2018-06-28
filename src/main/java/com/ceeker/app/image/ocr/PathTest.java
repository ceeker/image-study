package com.ceeker.app.image.ocr;

/**
 * @author vectorzhang
 * @desc
 * @date 2018/6/28 14:00
 */
public class PathTest {
    public static void main( String[] args ) {
        String tessdata =Thread.currentThread().getContextClassLoader().getResource("tessdata").getPath();
        System.out.println(tessdata);

    }
}
