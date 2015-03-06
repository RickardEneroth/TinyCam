package se.eneroth.tinycam;

import java.util.List;

import se.eneroth.R;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class NameAndUrlListAdapter extends ArrayAdapter<NameAndUrl>{
	Activity activity;
	
	public NameAndUrlListAdapter(Activity activity, List<NameAndUrl> nameAndUrl) {        
		super(activity, 0, nameAndUrl);   
		this.activity = activity;
	}     
	
	@Override    
	public View getView(int position, View convertView, ViewGroup parent) {        
		Activity activity = (Activity) getContext();        
		LayoutInflater inflater = activity.getLayoutInflater();              
		View rowView = inflater.inflate(R.layout.text_row, null);        
		NameAndUrl nameAndUrl = getItem(position);                 
		TextView textView = (TextView) rowView.findViewById(R.id.text);        
		textView.setText(nameAndUrl.getName());          
		
		return rowView;    
	}
}
