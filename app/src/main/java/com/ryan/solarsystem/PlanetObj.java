package com.ryan.solarsystem;

import org.rajawali3d.animation.Animation;
import org.rajawali3d.animation.RotateAroundAnimation3D;
import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.textures.ATexture;
import org.rajawali3d.materials.textures.Texture;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.primitives.Sphere;
import org.rajawali3d.scene.Scene;

public class PlanetObj extends Sphere {

    private final static int SEGMENT = 25;

    private Material mMaterial = new Material();

    private RotateAroundAnimation3D mRotateAroundAnim;

    private Scene mScene;

    public PlanetObj(Scene scene, String name, float radius, Vector3 position, int textureId) {
        super(radius, SEGMENT, SEGMENT);
        mScene = scene;
        try {
            mMaterial.addTexture(new Texture(name, textureId));
            mMaterial.setColorInfluence(0);
        } catch (ATexture.TextureException e) {
            e.printStackTrace();
        }

        this.setPosition(position.x, position.y, position.z);
        this.setMaterial(mMaterial);
        mScene.addChild(this);
    }

    public void setRotateAroundAnim(Vector3 center, Vector3.Axis axis, double distance, long duration) {
        mRotateAroundAnim = new RotateAroundAnimation3D(
                new Vector3(center.x, center.y, center.z),
                axis,
                distance
        );
        mRotateAroundAnim.setDurationMilliseconds(duration);
        mRotateAroundAnim.setRepeatMode(Animation.RepeatMode.INFINITE);
        mRotateAroundAnim.setTransformable3D(this);
        mScene.registerAnimation(mRotateAroundAnim);
    }

    public void startRotateAroundAnim() {
        mRotateAroundAnim.play();
    }


    public void stopRotateAroundAnim() {
        mRotateAroundAnim.pause();
    }


}
