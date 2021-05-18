package com.example.loginteste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Contacts;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private EditText cpf;
    private EditText telefone;
    private PessoaDAO pessoaDAO;
    private Pessoa pessoa = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.edtNome);
        cpf = findViewById(R.id.edtCPF);
        telefone = findViewById(R.id.edtTelefone);
        pessoaDAO = new PessoaDAO(this);

        Intent it = getIntent();
        if (it.hasExtra("pessoa")){
            pessoa = (Pessoa) it.getSerializableExtra("pessoa");
            nome.setText(pessoa.getNome());
            cpf.setText(pessoa.getCpf());
            telefone.setText(pessoa.getTelefone());
        }

    }

    public void salvar(View view){

        if (pessoa == null) {
            pessoa = new Pessoa();
            pessoa.setNome(nome.getText().toString());
            pessoa.setCpf(cpf.getText().toString());
            pessoa.setTelefone(telefone.getText().toString());

            long id = pessoaDAO.inserir(pessoa);
            Toast.makeText(this, "Pessoa inserido com ID " + id, Toast.LENGTH_SHORT).show();
        } else {
            pessoa.setNome(nome.getText().toString());
            pessoa.setCpf(cpf.getText().toString());
            pessoa.setTelefone(telefone.getText().toString());

            pessoaDAO.atualizar(pessoa);
            Toast.makeText(this, "Dados atualizados", Toast.LENGTH_SHORT).show();
        }
    }
}

