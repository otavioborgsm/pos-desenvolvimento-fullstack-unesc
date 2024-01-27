package unesc.uol.precofipeapp.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import unesc.uol.precofipeapp.R;
import unesc.uol.precofipeapp.api.model.Modelo;

public class ModeloAdapter extends BaseAdapter {

    private Activity activity;
    private List<Modelo.Items> modelos;

    public ModeloAdapter() {
    }

    public ModeloAdapter(final Activity activity, final List<Modelo.Items> modelos) {
        this.activity = activity;
        this.modelos = modelos;
    }

    @Override
    public int getCount() {
        return modelos.size();
    }

    @Override
    public Object getItem(int position) {
        return modelos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = activity.getLayoutInflater().inflate(R.layout.item_lista, parent, false);
        }

        TextView textNome = convertView.findViewById(R.id.textNome);
        textNome.setText(modelos.get(position).getNome());

        TextView textCodigo = convertView.findViewById(R.id.textCodigo);
        textCodigo.setText("" + modelos.get(position).getCodigo());

        return convertView;
    }
}
