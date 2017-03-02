package android.klien.priv.androidmonitor.utils;

import java.text.DecimalFormat;

/**
 * Created by klien on 2017/2/16.
 */

public class TextFormatUtil {

    public static String formatByte(long data){

        float unit = 1024f;

        DecimalFormat format = new DecimalFormat("##.##");
        if(data < Math.pow(unit,1)){
            return data + "Byte";
        }
        else if (data < Math.pow(unit, 2)){
            return format.format(data/ Math.pow(unit,1)) + "KB";
        }
        else if (data < Math.pow(unit, 3)){
            return format.format(data/ Math.pow(unit, 2)) + "MB";
        }
        else if (data < Math.pow(unit, 4)){
            return format.format(data/ Math.pow(unit, 3)) + "GB";
        }
        else {
            return "oversize";
        }
    }
}
