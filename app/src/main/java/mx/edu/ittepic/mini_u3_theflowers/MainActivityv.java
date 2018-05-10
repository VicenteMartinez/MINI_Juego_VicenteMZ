package mx.edu.ittepic.mini_u3_theflowers;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivityv extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mainv);

        if( getIntent().getBooleanExtra("Exit me", false)){
            finish();
            return; // add this to prevent from doing unnecessary stuffs
        }



    }
    public void jugar(View v){
        Intent ListSong = new Intent(getApplicationContext(), juego.class);
        startActivity(ListSong);

    }
    public void acercade(View v){
        AlertDialog.Builder alerta=new AlertDialog.Builder(this);
        alerta.setTitle("Acerca de...")
                .setMessage("Equipo: \n Vicente Martinez Zavala")
                .setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        alerta.show();
    }
    public void exit(View v){
        AlertDialog.Builder alerta=new AlertDialog.Builder(this);
        alerta.setTitle("ATENCION!")
                .setMessage("Esta seguro que desea salir?")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent ListSong = new Intent(getApplicationContext(), Main2Activity.class);
                        startActivity(ListSong);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        alerta.show();
    }
}
