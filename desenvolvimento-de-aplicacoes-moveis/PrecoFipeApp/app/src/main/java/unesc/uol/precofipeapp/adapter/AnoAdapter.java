package unesc.uol.precofipeapp.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import unesc.uol.precofipeapp.R;
import unesc.uol.precofipeapp.api.model.Ano;
import unesc.uol.precofipeapp.api.model.Marca;

public class AnoAdapter extends BaseAdapter {

    private Activity activity;
    private List<Ano> anos;

    public AnoAdapter() {
    }

    public AnoAdapter(final Activity activity, final List<Ano> anos) {
        this.activity = activity;
        this.anos = anos;
    }

    @Override
    public int getCount() {
        return anos.size();
    }

    @Override
    public Object getItem(int position) {
        return anos.get(position);
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
        textNome.setText(anos.get(position).getNome());

        TextView textCodigo = convertView.findViewById(R.id.textCodigo);
        textCodigo.setText("" + anos.get(position).getCodigo());

        return convertView;
    }
}
