package pt.olxchallenge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

/**
 * Created by Ruben Pereira on 14-04-2015.
 */
public class OlxListAdapter extends ArrayAdapter<Object> {

    private String[] items;
    private Context context;


    public OlxListAdapter(Context context, int textViewResourceId, String[] objects) {

        super(context, textViewResourceId, objects);
        this.context = context;
        this.items = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.olx_list_item, parent, false); //TODO remove xlarge

        String item = items[position];

        TextView textViewTitle = (TextView) convertView.findViewById(R.id.textItemTitle);
        textViewTitle.setText("A cena mais marada!!!");

        TextView textViewPrice = (TextView) convertView.findViewById(R.id.textItemPrice);
        textViewPrice.setText("4€");

        TextView textViewDate = (TextView) convertView.findViewById(R.id.textViewItemDate);
        textViewDate.setText("Hoje");

        TextView textViewLocation = (TextView) convertView.findViewById(R.id.textViewItemLocation);
        textViewLocation.setText("Aqui");

        return convertView;
    }
}