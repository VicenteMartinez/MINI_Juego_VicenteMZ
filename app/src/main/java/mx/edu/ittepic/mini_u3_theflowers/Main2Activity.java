package mx.edu.ittepic.mini_u3_theflowers;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
    private ImageView imageView;
    private AnimationDrawable CactusAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.menudo);

        imageView =(ImageView) findViewById(R.id.animation);
        if (imageView == null) throw new AssertionError();

        imageView.setVisibility(View.INVISIBLE);
        imageView.setBackgroundResource(R.drawable.frame_animation_list);

        CactusAnimation = (AnimationDrawable) imageView.getBackground();
        CactusAnimation.setOneShot(true);
        CactusAnimation.start();

    }
    public void vicente2(View v){
        Intent ListSong = new Intent(getApplicationContext(), MainActivityv.class);
        startActivity(ListSong);
    }

    public void onStartBtnClick(View v) {
        imageView.setVisibility(View.VISIBLE);
        if (CactusAnimation.isRunning()) {
            CactusAnimation.stop();
        }
        CactusAnimation.start();
    }
    public void onStopBtnClick(View v) {
        CactusAnimation.stop();
    }
}