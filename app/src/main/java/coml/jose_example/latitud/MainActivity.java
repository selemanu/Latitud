package coml.jose_example.latitud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText lat1,log1,lat2,log2;
    private TextView res;
    private Button cal;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lat1 = findViewById(R.id.latitud1);
        log1 = findViewById(R.id.longitud1);
        lat2 = findViewById(R.id.latitud2);
        log2 = findViewById(R.id.longitud2);

        res = findViewById(R.id.resultado);

        cal = findViewById(R.id.bt_calcular);

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double lat1d = Double.parseDouble(lat1.getText()+"");
                double log1d = Double.parseDouble(log1.getText()+"");
                double lat2d = Double.parseDouble(lat2.getText()+"");
                double log2d = Double.parseDouble(log2.getText()+"");


                double fina = distanciaCoord(lat1d,log1d,lat2d,log2d);

                res.setText(fina+"");
            }
        });
    }

    public static double distanciaCoord(double lat1, double lng1, double lat2, double lng2) {
        //double radioTierra = 3958.75;//en millas
        double radioTierra = 6371;//en kilómetros
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
        double distancia = radioTierra * va2;

        return distancia;
    }
}
