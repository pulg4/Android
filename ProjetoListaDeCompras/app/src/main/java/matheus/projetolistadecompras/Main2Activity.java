package matheus.projetolistadecompras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class Main2Activity extends AppCompatActivity {

    ProdutosAdapter adapter;
    ListView listView;
    ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button adicionar = (Button)findViewById(R.id.botaoAdicionar);

        Bundle args = getIntent().getExtras();

        getSupportActionBar().setTitle(args.getString("nome"));

        listView = (ListView)findViewById(R.id.listView);

        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listView.setTextFilterEnabled(true);

        Realm.init(this);
        realm = Realm.getDefaultInstance();

        final RealmResults<Produto> produtosRealmResults = realm.where(Produto.class).findAll();

        listaProdutos.addAll(realm.copyFromRealm(produtosRealmResults));

        adapter = new ProdutosAdapter(this,android.R.layout.simple_list_item_checked, listaProdutos);

        listView.setAdapter(adapter);

        adicionar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                EditText editNome = (EditText)findViewById(R.id.produtoNome);

                EditText editQuantidade = (EditText)findViewById(R.id.produtoQuantidade);

                CheckBox checkPerecivel = (CheckBox) findViewById(R.id.checkPerecivel);

                Spinner spinner = (Spinner)findViewById(R.id.categorias);

                String nomeProduto = editNome.getText().toString();

                String categoria =  spinner.getSelectedItem().toString();

                Integer quantidade = 1;

                if(!editQuantidade.getText().toString().isEmpty()) {
                    quantidade = Integer.parseInt(editQuantidade.getText().toString());
                }

                boolean perecivel = checkPerecivel.isChecked();
                Produto p = new Produto(quantidade,nomeProduto,perecivel,categoria);

                if(nomeProduto.isEmpty()){
                    Toast.makeText(Main2Activity.this, "Nome do produto obrigatorio", Toast.LENGTH_SHORT).show();
                } else {
                    int id = (int)realm.where(Produto.class).count()+1;
                    p.setId(id);

                    realm.beginTransaction();
                    realm.copyToRealm(p);
                    realm.commitTransaction();

                    listaProdutos.add(p);

                    adapter.notifyDataSetChanged();

                    editNome.setText("");

                    editQuantidade.setText("");
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position,long id) {
            }
        });
    }
}
