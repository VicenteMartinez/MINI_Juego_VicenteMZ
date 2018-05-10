package mx.edu.ittepic.mini_u3_theflowers;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by vicen on 25/10/2017.
 */

public class Lienzo extends View {
    CountDownTimer timer;
    boolean movimiento,play;
    float inflar;
    int gx,gy,g2x,g2y,mov,gb1x,gb1y,gb2x,gb2y;
    Bitmap bosque, globo1,globo2,pika2,squa;
    public Lienzo(Context context) {
        super(context);
        movimiento = true;
        play=true;
        gx=198;
        gy=270;
        g2x=198; g2y=270; mov=0; gb1x=700; gb1y=300; gb2x=700; gb2y=1200;

        timer=new CountDownTimer(10000,5) {
            @Override
            public void onTick(long l) {
                if(play==true) {
                    if(gx>350){
                        play=false;

                        AlertDialog.Builder alerta=new AlertDialog.Builder(getContext());
                        alerta.setTitle("GAME OVER!")
                                .setMessage("HAS PERDIDO")
                                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = new Intent(getContext(), MainActivityv.class);
                                        getContext().startActivity(intent);
                                    }
                                });
                        alerta.show();
                    }

                    inflar = (float) (Math.random() * 50);
                    if (inflar > 5 && inflar < 11) {
                        gx = gx + 1;
                        gy = gy + 1;
                    }
                    if (inflar <= 5) {
                        gx = gx + 2;
                        gy = gy + 3;
                    }
                    if (inflar >= 11 && inflar < 21) {
                        gx = gx + 3;
                        gy = gy + 4;
                    }
                    if (inflar >= 21) {
                    }
                    if (movimiento == true) {
                        mov += 2;
                        gx += 2;
                        gy += 2;
                        g2x += 2;
                        g2y += 2;
                        if (mov >= 10) {
                            movimiento = false;
                            mov = 0;
                        }
                    } else {
                        mov += 2;
                        gx -= 2;
                        gy -= 2;
                        g2x -= 2;
                        g2y -= 2;
                        if (mov >= 10) {
                            mov = 0;
                            movimiento = true;
                        }
                    }
                }


                invalidate();//vuelve a ejecutar el onDraw
            }
            @Override
            public void onFinish() {
                timer.start();
            }
        };
        timer.start();//Invocar ejecucion en segundo pano

        bosque= BitmapFactory.decodeResource(getResources(),R.drawable.poqueball);
        globo1= BitmapFactory.decodeResource(getResources(),R.drawable.bonba1);
        globo2= BitmapFactory.decodeResource(getResources(),R.drawable.bomba2);
        pika2= BitmapFactory.decodeResource(getResources(),R.drawable.pikachuinfla1);
        squa= BitmapFactory.decodeResource(getResources(),R.drawable.squareinfla1);
    }
    public void onDraw(Canvas c){
        Paint p=new Paint();
        p.setColor(Color.GREEN);
        bosque = Bitmap.createScaledBitmap(bosque, getWidth(), getHeight(), false);
        c.drawBitmap(bosque,0,0,p);

        globo1 = Bitmap.createScaledBitmap(globo1, gx, gy, false);
        c.drawBitmap(globo1,600,200,p);

        globo2 = Bitmap.createScaledBitmap(globo2, g2x, g2y, false);
        c.drawBitmap(globo2,600,1100,p);

        pika2 = Bitmap.createScaledBitmap(pika2, 318, 318, false);
        c.drawBitmap(pika2,250,1200,p);

        squa = Bitmap.createScaledBitmap(squa, 348, 260, false);
        c.drawBitmap(squa,200,300,p);

    }
    public boolean onTouchEvent(MotionEvent e){
        float x= e.getX(); //obtienes la cordenada de toque en x
        float y= e.getY(); //en y
        //el toque tiene tres eventoso cituaciones
        //presionar, arrastrar y soltar
        switch (e.getAction()) {//me regresa el evento

            case MotionEvent.ACTION_DOWN:
                //esto es presionar
                if(y>1000){
                    inflar = (float) (Math.random()*15);
                    if(inflar>5 && inflar<11){g2x=g2x+2;g2y=g2y+2;}
                    if(inflar<=5){g2x=g2x+3;g2y=g2y+4;}
                    if(inflar>=11){g2x=g2x+4;g2y=g2y+5;}
                }

                if (g2x>350){
                    play=false;

                    AlertDialog.Builder alerta=new AlertDialog.Builder(getContext());
                    alerta.setTitle("WINNER!")
                            .setMessage("HAS GANADO")
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    Intent intent = new Intent(getContext(), MainActivityv.class);
                                    getContext().startActivity(intent);

                                    Intent intent2 = new Intent(getContext(), MainActivityv.class);
                                    intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    intent2.putExtra("Exit me", true);


                                }
                            });
                    alerta.show();
                }

                break;


        }
        return true;
    }
}
