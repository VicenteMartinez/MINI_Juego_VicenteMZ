package mx.edu.ittepic.mini_u3_theflowers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class juego extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(new Lienzo(this));
        if( getIntent().getBooleanExtra("Exit me", false)){
            finish();
            Intent intent2 = new Intent();
            intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            return; // add this to prevent from doing unnecessary stuffs
        }
    }
}
