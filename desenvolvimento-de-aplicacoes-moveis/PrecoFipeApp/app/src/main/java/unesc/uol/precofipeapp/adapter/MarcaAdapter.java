package unesc.uol.precofipeapp.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import unesc.uol.precofipeapp.R;
import unesc.uol.precofipeapp.api.model.Marca;

public class MarcaAdapter extends BaseAdapter {

    private Activity activity;
    private List<Marca> marcas;

    public MarcaAdapter() {
    }

    public MarcaAdapter(final Activity activity, final List<Marca> marcas) {
        this.activity = activity;
        this.marcas = marcas;
    }

    @Override
    public int getCount() {
        return marcas.size();
    }

    @Override
    public Object getItem(int position) {
        return marcas.get(position);
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
        textNome.setText(marcas.get(position).getNome());

        TextView textCodigo = convertView.findViewById(R.id.textCodigo);
        textCodigo.setText("" + marcas.get(position).getCodigo());

        return convertView;
    }
}
