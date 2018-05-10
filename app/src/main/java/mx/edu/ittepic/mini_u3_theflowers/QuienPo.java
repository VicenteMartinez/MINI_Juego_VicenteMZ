package mx.edu.ittepic.mini_u3_theflowers;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by vicen on 30/10/2017.
 */

public class QuienPo extends AppCompatActivity {
    private MediaPlayer reproductor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reproductor=MediaPlayer.create(this,R.raw.fondopoke);
        reproductor.setLooping(true);
        reproductor.start();
        setContentView(new Lienzo1(this));

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(reproductor.isPlaying()){
            reproductor.stop();
            reproductor.release();
        }
    }
    @Override
    protected void onResume(){
        super.onResume();
        reproductor.start();
    }
    @Override
    protected void onPause(){
        super.onPause();
        reproductor.pause();
    }
}

