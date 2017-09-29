package matheus.projetolistadecompras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botaoIniciar = (Button)findViewById(R.id.btIniciar);

        botaoIniciar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {

                EditText texto = (EditText)findViewById(R.id.nomeLista);

                if(texto.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"O nome da lista não pode estar vazio!",Toast.LENGTH_SHORT).show();
                }else {
                    Intent myIntent = new Intent(MainActivity.this, Main2Activity.class);

                    myIntent.putExtra("nome",texto.getText().toString());

                    MainActivity.this.startActivity(myIntent);
                }
            }
        });
    }
}
