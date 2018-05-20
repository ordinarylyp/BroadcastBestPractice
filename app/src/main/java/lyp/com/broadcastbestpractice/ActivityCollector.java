package lyp.com.broadcastbestpractice;


import android.app.Activity;

import java.util.ArrayList;
import java.util.List;



public class ActivityCollector {   //活动管理器
    public static List<Activity> activities=new ArrayList<>();
    public static void addActivity (Activity activity){
        activities.add(activity);    //将创建活动添加到活动管理器
    }
    public static void removeActivity(Activity activity){
        activities.remove(activity);   //移除活动
    }
    public static void finishAll(){
        for (Activity activity:activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}

