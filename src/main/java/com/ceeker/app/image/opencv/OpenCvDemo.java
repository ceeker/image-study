package com.ceeker.app.image.opencv;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.SystemUtils;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

/**
 * @author vectorzhang
 * @desc
 * @date 2018/6/25 13:50
 */
@Slf4j
public class OpenCvDemo {
    public static final String X86 = "32";


    public static final String LIB_PATTERN = "lib/opencv/%s/%s.dll";

    public static final ImageUtils IMAGE_FILTERS = new ImageUtils();

    static {
        boolean isOsWindows = SystemUtils.IS_OS_WINDOWS;
        if (!isOsWindows) {
            log.error("is not windows!");
            System.exit(1);
        }
        //32或64位
        String dataModel = System.getProperty("sun.arch.data.model", "32");
        String libDir = X86.equalsIgnoreCase(dataModel) ? "x86" : "x64";
        String libPath = String.format(LIB_PATTERN, libDir, Core.NATIVE_LIBRARY_NAME);
        String path = OpenCvDemo.class.getClassLoader().getResource(libPath).getPath();
        log.info("opencv lib path={}", path);
        System.load(path);

        String osArch = SystemUtils.OS_ARCH;
        System.out.println(String.format(" prop: isOsWindows=%s,osArch=%s", isOsWindows, osArch));
        //注意程序运行的时候需要在VM option添加该行 指明opencv的dll文件所在路径
        //-Djava.library.path=$PROJECT_DIR$\opencv\x64
    }

    public static void main( String[] args ) {
        Mat src = Imgcodecs.imread("E:\\study\\java_study\\opencv_study\\src\\main\\resources\\imgs\\card.jpg");
        System.out.println("width:" + src.cols());
        System.out.println(src);
        Mat inverse = IMAGE_FILTERS.inverse(src);
        Imgcodecs.imwrite("test.jpg", inverse);


    }


}
