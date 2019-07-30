package com.ryan.solarsystem;

import android.content.Context;
import android.graphics.Color;
import android.opengl.GLES20;
import android.util.Log;
import android.view.MotionEvent;

import org.rajawali3d.lights.DirectionalLight;
import org.rajawali3d.lights.PointLight;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.renderer.Renderer;

import java.util.logging.Logger;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


/**

 太阳-水星Mercury-金星Venus-地球Earth-火星Mars-木星Jupiter-土星Saturn-天王星Uranus-海王星Neptune-冥王星Pluto

 zhuo_hf@foxmail.com
 */
public class RajawaliRenderer extends Renderer {

    private PlanetObj mSun;
    private PlanetObj mMercury;
    private PlanetObj mVenus;
    private PlanetObj mEarth;
    private PlanetObj mMars;
    private PlanetObj mJupiter;
    private PlanetObj mSaturn;
    private PlanetObj mUranus;
    private PlanetObj mNeptune;
    private PlanetObj mPluto;

    public RajawaliRenderer(Context context) {
        super(context);
    }

    private void initLight() {
        PointLight light = new PointLight();
        light.setPosition(0, 0, 20);
        light.setPower(10);
        getCurrentScene().addLight(light);

        DirectionalLight directionalLight = new DirectionalLight(0f, 0f, -1f);
        directionalLight.setColor(1.0f, 1.0f, 1.0f);
        directionalLight.setPower(0.5f);
        getCurrentScene().addLight(directionalLight);
    }

    private void initCamera() {
        getCurrentCamera().enableLookAt();
        getCurrentCamera().setZ(10f);
        getCurrentCamera().setLookAt(0, 0, 0);
//        getCurrentCamera().setFieldOfView(36.0f);
        getCurrentCamera().setNearPlane(1);
        getCurrentCamera().setFarPlane(2500);
        getCurrentCamera().setOrientation(getCurrentCamera().getOrientation().inverse());
    }

    @Override
    protected void initScene() {
        // 初始化相机
        initCamera();
        // 初始化灯光
        initLight();
        // 设置场景背景
        getCurrentScene().setBackgroundColor(Color.BLACK);

        try {
            mSun = new PlanetObj(getCurrentScene(), "Sun", 0.8f,
                    new Vector3(0, 0 , 0),
                    R.drawable.sun);

            //-----------------------
            mMercury = new PlanetObj(getCurrentScene(), "Mercury", 0.1f,
                    new Vector3(1, 0 , 0),
                    R.drawable.mercury);
            mMercury.setRotateAroundAnim(
                    new Vector3(0, 0, 0),
                    Vector3.Axis.X,
                    1,
                    10000);
            mMercury.startRotateAroundAnim();

            //-----------------------
            mVenus = new PlanetObj(getCurrentScene(), "Venus", 0.3f,
                    new Vector3(2, 0 , 0),
                    R.drawable.venus);
            mVenus.setRotateAroundAnim(
                    new Vector3(0, 0, 0),
                    Vector3.Axis.X,
                    2,
                    8000);
            mVenus.startRotateAroundAnim();

            //-----------------------
            mEarth = new PlanetObj(getCurrentScene(), "Earth", 0.3f,
                    new Vector3(3, 0 , 0),
                    R.drawable.earth);
            mEarth.setRotateAroundAnim(
                    new Vector3(0, 0, 0),
                    Vector3.Axis.X,
                    3,
                    8000);
            mEarth.startRotateAroundAnim();

            //-----------------------
            mMars = new PlanetObj(getCurrentScene(), "Mars", 0.2f,
                    new Vector3(3.5, 0 , 0),
                    R.drawable.mars);
            mMars.setRotateAroundAnim(
                    new Vector3(0, 0, 0),
                    Vector3.Axis.X,
                    3.5,
                    6000);
            mMars.startRotateAroundAnim();

            //-----------------------
            mJupiter = new PlanetObj(getCurrentScene(), "Jupiter", 0.4f,
                    new Vector3(-1, 0 , 0),
                    R.drawable.jupiter);
            mJupiter.setRotateAroundAnim(
                    new Vector3(0, 0, 0),
                    Vector3.Axis.X,
                    1,
                    5000);
            mJupiter.startRotateAroundAnim();

            //-----------------------
            mSaturn = new PlanetObj(getCurrentScene(), "Saturn", 0.2f,
                    new Vector3(-2, 0 , 0),
                    R.drawable.saturn);
            mSaturn.setRotateAroundAnim(
                    new Vector3(0, 0, 0),
                    Vector3.Axis.X,
                    2,
                    4000);
            mSaturn.startRotateAroundAnim();

            //-----------------------
            mUranus = new PlanetObj(getCurrentScene(), "Uranus", 0.2f,
                    new Vector3(-3, 0 , 0),
                    R.drawable.uranus);
            mUranus.setRotateAroundAnim(
                    new Vector3(0, 0, 0),
                    Vector3.Axis.X,
                    3,
                    9000);
            mUranus.startRotateAroundAnim();

            //-----------------------
            mNeptune = new PlanetObj(getCurrentScene(), "Neptune", 0.2f,
                    new Vector3(-4, 0 , 0),
                    R.drawable.neptune);
            mNeptune.setRotateAroundAnim(
                    new Vector3(0, 0, 0),
                    Vector3.Axis.X,
                    4,
                    12000);
            mNeptune.startRotateAroundAnim();

            //-----------------------
            mPluto = new PlanetObj(getCurrentScene(), "Pluto", 0.1f,
                    new Vector3(-5, 0 , 0),
                    R.drawable.pluto);
            mPluto.setRotateAroundAnim(
                    new Vector3(0, 0, 0),
                    Vector3.Axis.X,
                    5,
                    11000);
            mPluto.startRotateAroundAnim();

        }
        catch (Exception e) {
            e.printStackTrace();
            Log.e("zhf","加载模型出错了！！"+e.getMessage());
        }
    }

    @Override
    public void onRenderFrame(GL10 gl) {
        super.onRenderFrame(gl);
        if (mSun != null) {
            mSun.rotate(Vector3.Axis.Y, 1.0f);
        }
        if (mMercury != null) {
            mMercury.rotate(Vector3.Axis.Y, 1.0f);
        }
        if (mVenus != null) {
            mVenus.rotate(Vector3.Axis.Y, 1.0f);
        }
        if (mEarth != null) {
            mEarth.rotate(Vector3.Axis.Y, 1.0f);
        }
        if (mMars != null) {
            mMars.rotate(Vector3.Axis.Y, 1.0f);
        }
        if (mJupiter != null) {
            mJupiter.rotate(Vector3.Axis.Y, 1.0f);
        }
        if (mSaturn != null) {
            mSaturn.rotate(Vector3.Axis.Y, 1.0f);
        }
        if (mUranus != null) {
            mUranus.rotate(Vector3.Axis.Y, 1.0f);
        }
        if (mNeptune != null) {
            mNeptune.rotate(Vector3.Axis.Y, 1.0f);
        }
        if (mPluto != null) {
            mPluto.rotate(Vector3.Axis.Y, 1.0f);
        }
//        if (mObjectGroup != null) {
//            mObjectGroup.rotate(Vector3.Axis.X, 0.05f);
//            mObjectGroup.rotate(Vector3.Axis.Y, 0.1f);
//        }
    }


    @Override
    public void onTouchEvent(MotionEvent event) {
    }


    @Override
    public void onRenderSurfaceCreated(EGLConfig config, GL10 gl, int width, int height) {
        super.onRenderSurfaceCreated(config, gl, width, height);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    }

    @Override
    public void onRenderSurfaceSizeChanged(GL10 gl, int width, int height) {
        super.onRenderSurfaceSizeChanged(gl, width, height);
    }

    @Override
    public void onOffsetsChanged(float xOffset, float yOffset, float xOffsetStep, float yOffsetStep, int xPixelOffset, int yPixelOffset) {

    }

}
