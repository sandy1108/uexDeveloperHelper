package com.test;

import android.content.Context;
import android.content.Intent;

import org.zywx.wbpalmstar.base.BDebug;
import org.zywx.wbpalmstar.engine.EBrowserView;
import org.zywx.wbpalmstar.engine.universalex.EUExBase;

public class EUExDeveloperHelper extends EUExBase {

    private static final String TAG = "uexDeveloperHelper";

    public EUExDeveloperHelper(Context context, EBrowserView view) {
        super(context, view);
    }

    // ============= 分割线 ==============
    // 以下为生命周期事件监听方法，按需声明，不需要的话就不用声明。

    /**
     * 用于监听Application的onCreate事件，需要的写好这个方法用来接收引擎的通知。
     * 利用此方法可以解决绝大部分需要自定义Application的情况（AppCan插件中不允许自定义Application）
     *
     * @param context ApplicationContext上下文实例
     */
    public static void onApplicationCreate(Context context) {
        BDebug.i(TAG, TAG + " onApplicationCreate");
    }

    /**
     * 对应加载插件的引擎Activity的生命周期方法onCreate
     *
     * @param context 加载插件的引擎ActivityContext实例
     */
    public static void onActivityCreate(Context context) {
        BDebug.i(TAG, TAG + " onActivityCreate");
    }

    /**
     * 对应加载插件的引擎Activity的生命周期方法onStart
     *
     * @param context 加载插件的引擎ActivityContext实例
     */
    public static void onActivityStart(Context context) {
        BDebug.i(TAG, TAG + " onActivityStart");
    }

    /**
     * 对应加载插件的引擎Activity的生命周期方法onRestart
     *
     * @param context 加载插件的引擎ActivityContext实例
     */
    public static void onActivityReStart(Context context) {
        BDebug.i(TAG, TAG + " onActivityReStart");
    }

    /**
     * 对应加载插件的引擎Activity的生命周期方法onResume
     *
     * @param context 加载插件的引擎ActivityContext实例
     */
    public static void onActivityResume(Context context) {
        BDebug.i(TAG, TAG + " onActivityResume");
    }

    /**
     * 对应加载插件的引擎Activity的生命周期方法onPause
     *
     * @param context 加载插件的引擎ActivityContext实例
     */
    public static void onActivityPause(Context context) {
        BDebug.i(TAG, TAG + " onActivityPause");
    }

    /**
     * 对应加载插件的引擎Activity的生命周期方法onStop
     *
     * @param context 加载插件的引擎ActivityContext实例
     */
    public static void onActivityStop(Context context) {
        BDebug.i(TAG, TAG + " onActivityStop");
    }

    /**
     * 对应加载插件的引擎Activity的生命周期方法onDestroy
     *
     * @param context 加载插件的引擎ActivityContext实例
     */
    public static void onActivityDestroy(Context context) {
        BDebug.i(TAG, TAG + " onActivityDestroy");
    }

    // 以上为生命周期事件监听方法，按需声明，不需要的话就不用声明。
    // ============= 分割线 ==============

    /**
     * 用于执行JS回调方法
     *
     * @param methodName 回调方法名
     * @param jsonData 回调json数据
     */
    private void callBackPluginJs(String methodName, String jsonData){
        String js = SCRIPT_HEADER + "if(" + methodName + "){"
                + methodName + "('" + jsonData + "');}";
        onCallback(js);
    }

    /**
     * 用于执行JS回调方法（数据为JSON object）
     * 推荐此方式，防止极个别情况下，回调数据中存在异常字符导致JS处理错误 by yipeng
     *
     * @param methodName 回调方法名
     * @param jsonData 回调json数据
     */
    private void callBackPluginJsWithJsonObject(String methodName, String jsonData){
        String js = SCRIPT_HEADER + "if(" + methodName + "){"
                + methodName + "(" + jsonData + ");}";
        // 是否看出与上面方法的区别？传参的括号内少了单引号，这样可以让JS收到回调时拿到的就是一个JS的object，而无需使用JSON.parse
        onCallback(js);
    }

    // clean something
    @Override
    protected boolean clean() {
        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

}
