package com.example.rober.myapplicationangoti;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnKeyListener{
    private int numeroSorteado;
    private TextView mensagem;
    private EditText entrada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preparacaoInicial();

    }
    private void preparacaoInicial(){
        numeroSorteado = (int) (Math.random() *101);

        mensagem = (TextView) findViewById(R.id.mensagem );
        entrada = (EditText) findViewById(R.id.entrada);
        entrada.setOnKeyListener(this);
    }


    @Override
    public boolean onKey(View view, int keycode, KeyEvent keyEvent) {
        if(keycode==KeyEvent.KEYCODE_ENTER && keyEvent.getAction()== keyEvent.ACTION_UP){
            verificar();
            return true;
        }
        return false;
    }

    private void verificar() {
        int numero = Integer.parseInt(entrada.getText().toString());
        if (numero == numeroSorteado)
            mensagem.setText(R.string.Texto2);
        else if (numero> numeroSorteado)
            mensagem.setText(R.string.texto3);
        else
             mensagem.setText(R.string.texto4);
    }
}
