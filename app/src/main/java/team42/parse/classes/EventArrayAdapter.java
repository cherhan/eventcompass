package team42.parse.classes;
import java.util.List;

import com.eventcompass.cherhan.eventcompass.EventPageMarathon;
import com.eventcompass.cherhan.eventcompass.R;
import com.parse.ParseObject;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class EventArrayAdapter extends ArrayAdapter<ParseObject> {
    private static final String TAG = "EventArrayAdapter";
    private final Context _context;
    private final int _listViewElementResourceId;
    private final List<ParseObject> _ob;

    public EventArrayAdapter(Context context, int listViewElementResourceId,
                             List<ParseObject> ob) {
        super(context, listViewElementResourceId, ob);
        this._context = context;
        this._listViewElementResourceId = listViewElementResourceId;
        _ob = ob;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) _context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(_listViewElementResourceId, parent,
                false);

//		thumb
//		textTitle
//		textDesc
//		textPrivacy
//		
        ImageView imageViewThumb = (ImageView) rowView.findViewById(R.id.thumb);
        TextView textViewTitle = (TextView) rowView.findViewById(R.id.textTitle);
        TextView textViewDesc = (TextView) rowView.findViewById(R.id.textDesc);
        TextView textViewPrivacy = (TextView) rowView.findViewById(R.id.textPrivacy);

        // Assigns images into each imageView
        String imageFileName = "a";
        int resourceID = 2;
        imageFileName = imageFileName + String.valueOf(position+1);
        resourceID = _context.getResources().getIdentifier(imageFileName,
                "drawable", _context.getPackageName());
        Bitmap bitmap = BitmapFactory.decodeResource(_context.getResources(),
                resourceID);
        imageViewThumb.setImageBitmap(bitmap);

        textViewTitle.setText(_ob.get(position).getString("Title"));
        textViewDesc.setText(_ob.get(position).getString("Description"));
        textViewPrivacy.setText(_ob.get(position).getString("Privacy"));

        rowView.setOnClickListener(rowViewOnClickListener);
        return rowView;
    }

    View.OnClickListener rowViewOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent myIntent = new Intent(_context, EventPageMarathon.class);
            _context.startActivity(myIntent);
        }
    };

}

