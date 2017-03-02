package android.klien.priv.androidmonitor.vo;

import android.graphics.drawable.Drawable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@ToString
public class AndroidTaskInfo {
    private Drawable task_icon;
    private String task_name;
    private long task_memory;
    private String package_name;
    private int pid;
}
