package br.com.controledeprodutos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double v_tacas, v_pratos, v_facas, v_garfos, v_total;
    CheckBox cb_tacas, cb_pratos, cb_facas, cb_garfos;
    EditText et_tacas, et_pratos, et_facas, et_garfos;
    TextView tv_resultado;
    Button btn_calcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_tacas = findViewById(R.id.et_tacas);
        et_facas = findViewById(R.id.et_facas);
        et_garfos = findViewById(R.id.et_garfos);
        et_pratos = findViewById(R.id.et_pratos);

        cb_facas = findViewById(R.id.cb_facas);
        cb_garfos = findViewById(R.id.cb_garfos);
        cb_tacas = findViewById(R.id.cb_tacas);
        cb_pratos = findViewById(R.id.cb_pratos);

        btn_calcular = findViewById(R.id.btn_calculo);

        tv_resultado = findViewById(R.id.tv_resultado);

        v_facas = 0.25;
        v_garfos = 0.5;
        v_pratos = 1.0;
        v_tacas = 0.75;
        v_total = 0.0;

        cb_tacas.setText(cb_tacas.getText().toString() + v_tacas);
        cb_pratos.setText(cb_pratos.getText().toString() + v_pratos);
        cb_garfos.setText(cb_garfos.getText().toString() + v_garfos);
        cb_facas.setText(cb_facas.getText().toString() + v_facas);
    }

    public void Calcular(View v) {
        v_total = 0.0;

        if(cb_tacas.isChecked())
            v_total += v_tacas * Double.parseDouble(et_tacas.getText().toString());
        if(cb_facas.isChecked())
            v_total += v_facas * Double.parseDouble(et_facas.getText().toString());
        if(cb_garfos.isChecked())
            v_total += v_garfos * Double.parseDouble(et_garfos.getText().toString());
        if(cb_pratos.isChecked())
            v_total += v_pratos * Double.parseDouble(et_pratos.getText().toString());

        tv_resultado.setText("Valor total: R$" + v_total);

        //Toast.makeText(this, "Valor da locação calculada.", Toast.LENGTH_SHORT).show();
        AlertDialog.Builder caixaMensg = new AlertDialog.Builder(this);
        caixaMensg.setMessage("Valor da locacao calculada");
        caixaMensg.setNeutralButton("Ok", null);
        caixaMensg.show();

    }

    public void abrir_tela_sobre(View v) {
        Intent it_telaSobre = new Intent(this, TelaSobre.class);
        it_telaSobre.putExtra("p_nome", "Jef" );
        it_telaSobre.putExtra("p_vtotal", v_total );
        startActivity(it_telaSobre);
    }
}