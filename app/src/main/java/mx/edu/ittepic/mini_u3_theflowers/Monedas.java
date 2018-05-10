package mx.edu.ittepic.mini_u3_theflowers;

import android.os.CountDownTimer;

/**
 * Created by fraaa on 29/10/2017.
 */

public class Monedas {
    float xmo,ymo;
    Boolean separo1=false;
    CountDownTimer t;
    boolean movimiento=true;
    public Monedas(Lienzo1 v){
        xmo=(float) (Math.random()*1700);
        ymo=(float)(Math.random()*30);
        final Lienzo1 li=v;
        t = new CountDownTimer(10,1) {
            @Override
            public void onTick(long l) {

                //x+=5;
                if (movimiento==true){
                    ymo+=15;
                }

                if (ymo>=950){
                    ymo=(float)(Math.random()*20);
                    xmo=(float)(Math.random()*1700);
                }

                li.invalidate();
            }

            @Override
            public void onFinish() {parar();}

        };
        parar();

    }
    public void parar(){
        if(separo1){
            t.cancel();
        }else {
            t.start();
        }
    }

}
