package android.klien.priv.androidmonitor.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.klien.priv.androidmonitor.R;
import android.klien.priv.androidmonitor.vo.AndroidTaskInfo;

import java.util.ArrayList;
import java.util.List;

public class AndroidTaskUtil{

    /**
     * 获取当前运行的进程数
     * @param context
     * @return
     */
    public static int getRunningProcesses(Context context){
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        return manager.getRunningAppProcesses().size();
    }

    /**
     * 获取当前可用内存
     * @param context
     * @return
     */
    public static long getAvailMemory(Context context){
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo info = new ActivityManager.MemoryInfo();
        manager.getMemoryInfo(info);
        return info.availMem;
    }

    /**
     * 获取任务列表
     * @param context
     * @return
     */
    public static List<AndroidTaskInfo> getTaskInfos(Context context){
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        PackageManager pm = context.getPackageManager();

        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = am.getRunningAppProcesses();

        //返回集合
        List<AndroidTaskInfo> retTaskInfoList  = new ArrayList<AndroidTaskInfo>();

        for(ActivityManager.RunningAppProcessInfo info : runningAppProcesses){
            AndroidTaskInfo taskInfo = new AndroidTaskInfo();
            //进程名称
            String packageName = info.processName;
            taskInfo.setPackage_name(packageName);
            try {
                ApplicationInfo applicationInfo = pm.getApplicationInfo(packageName, 0);
                //图标
                Drawable task_icon = applicationInfo.loadIcon(pm);
                if(task_icon == null){
                    //taskInfo.setTask_icon(context.getResources().getDrawable(R.drawable.ic_launcher));
                }else{
                    taskInfo.setTask_icon(task_icon);
                }
                //名称
                String task_name = applicationInfo.loadLabel(pm).toString();
                taskInfo.setTask_name(task_name);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }

            //进程id
            int pid = info.pid;
            taskInfo.setPid(pid);
            //获取进程占用的内存
            android.os.Debug.MemoryInfo[] processMemoryInfo = am.getProcessMemoryInfo(new int[]{pid});
            android.os.Debug.MemoryInfo memoryInfo  = processMemoryInfo[0];
            long totalPrivateDirty = memoryInfo.getTotalPrivateDirty(); //KB
            taskInfo.setTask_memory(totalPrivateDirty);
            retTaskInfoList.add(taskInfo);
        }
        return retTaskInfoList;
    }
}
