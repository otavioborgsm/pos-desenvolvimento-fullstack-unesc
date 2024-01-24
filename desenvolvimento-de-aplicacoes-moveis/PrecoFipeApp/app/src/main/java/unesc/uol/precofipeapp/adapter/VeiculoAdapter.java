package unesc.uol.precofipeapp.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import unesc.uol.precofipeapp.R;
import unesc.uol.precofipeapp.model.Veiculo;

public class VeiculoAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<Veiculo> arlVeiculos;

    public VeiculoAdapter() {
    }

    public VeiculoAdapter(final Activity activity, final ArrayList<Veiculo> arlVeiculos) {
        this.activity = activity;
        this.arlVeiculos = arlVeiculos;
    }

    @Override
    public int getCount() {
        return arlVeiculos.size();
    }

    @Override
    public Object getItem(int position) {
        return arlVeiculos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = activity.getLayoutInflater().inflate(R.layout.item_lista_veiculo, parent, false);
        }

        TextView textVeiculo = convertView.findViewById(R.id.textVeiculo);
        textVeiculo.setText(arlVeiculos.get(position).getNomeVeiculo());

        TextView textAnoFabricacao = convertView.findViewById(R.id.textAnoFabricacao);
        textAnoFabricacao.setText("" + arlVeiculos.get(position).getAnoFabricacao());

        return convertView;
    }
}
