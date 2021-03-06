package cn.lytcom.cameraview;

import android.content.Context;
import android.view.WindowManager;

import java.util.Set;

abstract class CameraImpl {

    CameraListener mCameraListener;
    AutoFitTextureView mTextureView;
    Context mContext;
    WindowManager mWindowManager;

    CameraImpl(CameraListener cameraListener, AutoFitTextureView autoFitTextureView) {
        mContext = autoFitTextureView.getContext().getApplicationContext();
        mCameraListener = cameraListener;
        mTextureView = autoFitTextureView;
        mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
    }

    /**
     * @return {@code true} if the implementation was able to start the camera session.
     */
    abstract boolean start();

    abstract void stop();

    abstract boolean isCameraOpened();

    abstract Set<AspectRatio> getSupportedAspectRatios();

    /**
     * @return {@code true} if the aspect ratio was changed.
     */
    abstract boolean setAspectRatio(AspectRatio ratio);

    abstract AspectRatio getAspectRatio();

    abstract void setFacing(int facing);

    abstract int getFacing();

    abstract void setAutoFocus(boolean autoFocus);

    abstract boolean getAutoFocus();

    abstract void setFlash(int flash);

    abstract int getFlash();

    abstract void takePicture();

    abstract boolean isRecordingVideo();

    abstract void startRecordingVideo();

    abstract void stopRecordingVideo();

}
