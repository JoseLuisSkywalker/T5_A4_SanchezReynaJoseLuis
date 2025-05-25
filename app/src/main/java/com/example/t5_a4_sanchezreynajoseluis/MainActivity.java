package com.example.t5_a4_sanchezreynajoseluis;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    RadioButton radioButtonBinario, radioButtonOctal, radioButtonHexadecimal;
    RadioGroup radioGroup;

    EditText cajaNumero, cajaNumeroBinario, cajaNumeroOctal, cajaNumeroHexadecimal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

            radioButtonBinario = findViewById(R.id.radioButton5);
            radioButtonOctal = findViewById(R.id.radioButton6);
            radioButtonHexadecimal = findViewById(R.id.radioButton7);
            radioGroup = findViewById(R.id.radioGroup);

            radioButtonBinario.setOnClickListener(this);
            radioButtonOctal.setOnClickListener(this);
            radioButtonHexadecimal.setOnClickListener(this);

            cajaNumero = findViewById(R.id.editTextText);

            cajaNumeroBinario = findViewById(R.id.editTextText3);
            cajaNumeroOctal = findViewById(R.id.editTextText4);
            cajaNumeroHexadecimal = findViewById(R.id.editTextText2);

            //hablilitar y deshabilitar

            cajaNumeroBinario.setEnabled(false);
            cajaNumeroOctal.setEnabled(false);
            cajaNumeroHexadecimal.setEnabled(false);



    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.radioButton5){
            cajaNumeroBinario.setEnabled(true);
            convertirBinario(cajaNumero.getText().toString());
            borrarCaja(cajaNumeroOctal);
            borrarCaja(cajaNumeroHexadecimal);
        }else if(v.getId() == R.id.radioButton6){
            cajaNumeroOctal.setEnabled(true);
            convertirOctal(cajaNumero.getText().toString());
            borrarCaja(cajaNumeroBinario);
            borrarCaja(cajaNumeroHexadecimal);

        }else if(v.getId() == R.id.radioButton7){
            cajaNumeroHexadecimal.setEnabled(true);
            convertirHexadecimal(cajaNumero.getText().toString());
            borrarCaja(cajaNumeroBinario);
            borrarCaja(cajaNumeroOctal);

        }

    }

    public void convertirBinario(String texto){
        if(!validacionNumero(texto)){
            return;
        }
        int numeroEntero = Integer.parseInt(texto);
        String numeroConvertido = Integer.toBinaryString(numeroEntero);
        cajaNumeroBinario.setText(numeroConvertido);

    }

    public void convertirOctal(String texto){
        if(!validacionNumero(texto)){
            return;
        }
        int numeroEntero = Integer.parseInt(texto);
        String numeroConvertido = Integer.toOctalString(numeroEntero);
        cajaNumeroOctal.setText(numeroConvertido);
    }

    public void convertirHexadecimal(String texto){
        if(!validacionNumero(texto)){
            return;
        }
        int numeroEntero = Integer.parseInt(texto);
        String numeroConvertido = Integer.toHexString(numeroEntero);
        cajaNumeroHexadecimal.setText(numeroConvertido);
    }




    public Boolean validacionNumero(String texto){
        if(texto.isEmpty()) {
            borrarCaja(cajaNumero);
            Toast.makeText(this, "Ingresa un número tontuelo! ", Toast.LENGTH_LONG).show();
            return false;
        }
        for(int i = 0; i < texto.length(); i++){
            char c =  texto.charAt(i);
            if (c < '0'|| c > '9') {
                borrarCaja(cajaNumero);
                Toast.makeText(this, "Solo se permiten números enteros.", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
    }

    public void borrarCaja(EditText caja){
        caja.setText("");

    }


}