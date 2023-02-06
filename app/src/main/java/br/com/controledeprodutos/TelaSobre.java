package br.com.controledeprodutos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TelaSobre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_sobre);

        Intent it = getIntent();
        String nome = it.getStringExtra("p_nome");
        double valorTotal = it.getDoubleExtra("p_vtotal", 0);
        TextView tv_sobre = findViewById(R.id.tv_sobre);
        tv_sobre.setText(nome + " | " + valorTotal);
    }

    public void voltar_tela(View v) {
        this.finish();
    }
}