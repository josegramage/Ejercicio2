package es.schooleando.ejercicio2;

import android.os.AsyncTask;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.os.SystemClock.sleep;

public class MainActivity extends AppCompatActivity {
    private Button botonDescarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonDescarga = (Button)findViewById(R.id.botonDescarga);
    }

    public void onClickBotonDescarga(View view) {
        //llamamos al asynctask
        new Ejercicio2_AsyncTask().execute();
    }

    public class Ejercicio2_AsyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {

            new Thread(new Runnable() {

                @Override
                public void run() {
                    //el tiempo de espera dentro del thread
                     sleep(10000);
                }

            }).start();

            return null;
        }

        protected void onPostExecute(Void String) {
            //en la ejecución cambiamos el botón
            botonDescarga.setText("Descargado!");
            botonDescarga.setEnabled(false);

        }
    }


}
