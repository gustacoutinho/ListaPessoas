package com.example.loginteste;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class PessoaAdapter extends BaseAdapter {

    private List<Pessoa> pessoas;
    private Activity activity;

    public PessoaAdapter(Activity activity, List<Pessoa> pessoas) {
        this.activity = activity;
        this.pessoas = pessoas;
    }

    @Override
    public int getCount() {
        return pessoas.size();
    }

    @Override
    public Object getItem(int i) { return pessoas.get(i); }

    @Override
    public long getItemId(int i) {
        return pessoas.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View viewAdapter = activity.getLayoutInflater().inflate(R.layout.item, viewGroup, false);

        TextView nome = viewAdapter.findViewById(R.id.txtNome);
        TextView cpf = viewAdapter.findViewById(R.id.txtCpf);
        TextView telefone = viewAdapter.findViewById(R.id.txtTelefone);

        Pessoa a = pessoas.get(i);
        nome.setText(a.getNome());
        cpf.setText(a.getCpf());
        telefone.setText(a.getTelefone());

        return viewAdapter;
    }
}
