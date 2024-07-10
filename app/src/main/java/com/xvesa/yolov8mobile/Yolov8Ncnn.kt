package com.xvesa.yolov8mobile

import android.content.res.AssetManager
import android.view.Surface

class Yolov8Ncnn {
    external fun loadModel(mgr: AssetManager?, modelid: Int, cpugpu: Int): Boolean
    external fun openCamera(facing: Int): Boolean
    external fun closeCamera(): Boolean
    external fun setOutputWindow(surface: Surface?): Boolean

    companion object {
        init {
            System.loadLibrary("yolov8ncnn")
        }
    }
}
