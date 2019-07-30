package com.ryan.solarsystem;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewGroup;

/**
 zhuo_hf@foxmail.com
 */
public class MainActivity extends Activity {

    private RajawaliGLSurfaceView mGLSurfaceView;
    private RajawaliRenderer mRajawaliRenderer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mGLSurfaceView = new RajawaliGLSurfaceView(this);
        mGLSurfaceView.init(true, 16, 0);

        mRajawaliRenderer = new RajawaliRenderer(this);
        mGLSurfaceView.setSurfaceRenderer(mRajawaliRenderer);

        addContentView(mGLSurfaceView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mGLSurfaceView != null) {
            mGLSurfaceView.onResume();
        }
        if (mRajawaliRenderer != null) {
            mRajawaliRenderer.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mGLSurfaceView != null) {
            mGLSurfaceView.onPause();
        }
        if (mRajawaliRenderer != null) {
            mRajawaliRenderer.onPause();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mRajawaliRenderer != null) {
            mRajawaliRenderer.onTouchEvent(event);
        }
        return super.onTouchEvent(event);
    }
}
