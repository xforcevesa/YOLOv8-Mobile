package com.xvesa.yolov8mobile

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.graphics.PixelFormat
import android.os.Bundle
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : Activity(), SurfaceHolder.Callback {
    private val yolov8Ncnn = Yolov8Ncnn()
    private var facing = 0

    private var spinnerModel: Spinner? = null
    private var spinnerCPUGPU: Spinner? = null
    private var currentModel = 0
    private var currentCpuGpu = 0

    private var cameraView: SurfaceView? = null

    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        cameraView = findViewById<View>(R.id.camera_view) as SurfaceView

        cameraView!!.holder.setFormat(PixelFormat.RGBA_8888)
        cameraView!!.holder.addCallback(this)

        val buttonSwitchCamera = findViewById<View>(R.id.btn_switch_camera) as Button
        buttonSwitchCamera.setOnClickListener {
            val new_facing = 1 - facing
            yolov8Ncnn.closeCamera()

            yolov8Ncnn.openCamera(new_facing)
            facing = new_facing
        }

        spinnerModel = findViewById<View>(R.id.spinner_model) as Spinner
        spinnerModel!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                arg0: AdapterView<*>?,
                arg1: View,
                position: Int,
                id: Long
            ) {
                if (position != currentModel) {
                    currentModel = position
                    reload()
                }
            }

            override fun onNothingSelected(arg0: AdapterView<*>?) {
            }
        }

        spinnerCPUGPU = findViewById<View>(R.id.spinner_cpu_gpu) as Spinner
        spinnerCPUGPU!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                arg0: AdapterView<*>?,
                arg1: View,
                position: Int,
                id: Long
            ) {
                if (position != currentCpuGpu) {
                    currentCpuGpu = position
                    reload()
                }
            }

            override fun onNothingSelected(arg0: AdapterView<*>?) {
            }
        }

        reload()
    }

    private fun reload() {
        val ret_init = yolov8Ncnn.loadModel(assets, currentModel, currentCpuGpu)
        if (!ret_init) {
            Log.e("MainActivity", "yolov8ncnn loadModel failed")
        }
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        yolov8Ncnn.setOutputWindow(holder.surface)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
    }

    public override fun onResume() {
        super.onResume()

        if (ContextCompat.checkSelfPermission(
                applicationContext,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_DENIED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                REQUEST_CAMERA
            )
        }

        yolov8Ncnn.openCamera(facing)
    }

    public override fun onPause() {
        super.onPause()

        yolov8Ncnn.closeCamera()
    }

    companion object {
        const val REQUEST_CAMERA: Int = 100
    }
}
