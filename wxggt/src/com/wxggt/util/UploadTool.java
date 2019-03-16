package com.wxggt.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import sun.misc.BASE64Decoder;

/***
 * 閫氳繃base64瀛椾覆涓婁紶鍥剧墖鐨勫伐鍏风被
 * 
 * @author Slience
 * 
 */
public class UploadTool {
    /**
     * 涓婁紶鍥剧墖
     * 
     * @param base64
     * 鍥剧墖缂栫爜鍚庣殑瀛楃涓�
     * @return 涓婁紶鎴愬姛鍚庣殑鏂囦欢鍚�
     */
    @SuppressWarnings("deprecation")
    public static String upload(String uId, String base64) {
        HttpServletRequest request = ServletActionContext.getRequest();
        // upload鏄浘鐗囦笂浼犺矾寰�
        String dir = request.getRealPath("/upload/headFace/" + uId);
        File fileLocation = new File(dir);
        // 鍒ゆ柇涓婁紶璺緞鏄惁瀛樺湪锛屽鏋滀笉瀛樺湪灏卞垱寤�
        if (!fileLocation.exists()) {
            boolean isCreated = fileLocation.mkdir();
            if (!isCreated) {
                System.out.println("鐩綍鍒涘缓澶辫触");
                // 鐩爣涓婁紶鐩綍鍒涘缓澶辫触,鍙仛鍏朵粬澶勭悊,渚嬪鎶涘嚭鑷畾涔夊紓甯哥瓑,涓�鑸簲璇ヤ笉浼氬嚭鐜拌繖绉嶆儏鍐点��
                return null;
            }
        }
        if (base64.indexOf("jpeg") != -1) {
            // base64瀛椾覆涓湁jpeg瀛椾覆锛岃繖鏄竴涓�4涓瓧鐨勶紝鑰屾垜杩欓噷鏄妸base64瀛椾覆鐨勬寚瀹氫綅缃殑瀛椾覆鏉ヤ綔涓轰笂浼�
            // 鏂囦欢绫诲瀷鐨勫垽鏂緷鎹紝鎵�浠ュ湪澶ч儴鍒嗛兘鏄笁涓瓧鐨勬枃浠剁被鍨嬩笅灏卞緱鎶妀peg鏀规垚jpg浜�
            base64 = base64.replaceFirst("jpeg", "jpg");
        }
        // 鐢熸垚涓�涓敮涓�鐨勬枃浠跺悕
        String upName = "headFace" + "." + base64.substring(11, 14);
        FileOutputStream out;
        String iconBase64 = base64.substring(22);
        try {
            byte[] buffer = new BASE64Decoder().decodeBuffer(iconBase64);
            out = new FileOutputStream(dir + "/" + upName);
            out.write(buffer);
            out.close();
            return upName;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
