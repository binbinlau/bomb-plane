package binbinlau.plane.util;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author LiuBin
 * @Date 2019/7/11 16:15
 **/
public class FileUtil {

    /**
     *  下载文件
     * @Author LiuBin
     * @Date 2019/7/11  16:22
     * @Param [filePath]
     * @return org.springframework.http.ResponseEntity<java.lang.Object>
     **/
    public static ResponseEntity<Object> downloadFile(String fileName) throws IOException {
        File file = new File(fileName);
        return downloadFile(file);
    }

    public static ResponseEntity<Object> downloadFile(File file) throws IOException {
        if (file == null) return null;
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(
                MediaType.parseMediaType("application/txt")).body(resource);
        return responseEntity;
    }

    /**
     *  上传文件
     * @Author LiuBin
     * @Date 2019/7/11  16:44
     * @Param [src, des]
     * @return void
     **/
    public static void uploadFile(File file, String des) {
        File convertFile = new File(des);
        InputStream fin = null;
        FileOutputStream fout = null;
        try {
            fin = new FileInputStream(file);
            convertFile.createNewFile();
            fout = new FileOutputStream(convertFile);
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = fin.read(buffer)) > 0) {
                fout.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fin.close();
                fout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
