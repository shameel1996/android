package com.example.vmatchu;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.VideoView;

public class Splash extends Activity {


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        try {
//            VideoView videoHolder =findViewById(R.id.vv);
//          //  RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)videoHolder.getLayoutParams();
////            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
////            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, 0);
//         //   videoHolder.setLayoutParams(layoutParams);
//
//            Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splash);
//            videoHolder.setVideoURI(video);
//
//            videoHolder.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                public void onCompletion(MediaPlayer mp) {
//                    jump();
//                }
//            });
//            videoHolder.start();
//        } catch (Exception ex) {
//            jump();
//        }
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        jump();
//        return true;
//    }
//
//    private void jump() {
//        if (isFinishing())
//            return;
//        startActivity(new Intent(this, signInActivity.class));
//        finish();
//    }
}
