package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.e.Events;
import com.example.android.e.R;
import com.example.android.e.Restaurant;

import java.util.ArrayList;

/**
 * Created by Admin on 4/10/2016.
 */
public class EventsAdapter extends ArrayAdapter<Restaurant>  {
    private Context _c;
    private ArrayList<Restaurant> _r = new ArrayList<Restaurant>();

    private int template;

    public EventsAdapter(Context context, int resource, int textViewResourceId, ArrayList<Restaurant> objects) {
        super(context, resource, textViewResourceId, objects);
        _c = context;
        _r.addAll(objects);
        template = resource;

    }

    public View getView(int index, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) _c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.resource_template, null);
            TextView txt = (TextView) convertView.findViewById(R.id.list_item_name);
            Restaurant r = _r.get(index);
            txt.setText(r.getName());
            convertView.setTag(r);
        }
        return convertView;
    }


}
