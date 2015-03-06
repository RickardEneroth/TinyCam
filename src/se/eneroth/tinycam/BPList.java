package se.eneroth.tinycam;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;

import se.eneroth.R;
import android.app.Activity;
import android.content.Intent;
import android.net.ParseException;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * 
 * @author Rickard Eneroth, Beamon Consulting, 2013
 * 
 */
public class BPList extends Activity implements OnItemClickListener {

	private Activity activity;
	List<NameAndUrl> list = new ArrayList<NameAndUrl>();
	/**
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);        
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		activity = this;		
		setContentView(R.layout.bplist);
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("fredrik_anundsson", "Anundsson, Fredrik");
		map.put("frank_artschwager", "Artschwager, Frank");
		map.put("johan_axelsson", "Axelsson, Johan");
		map.put("caroline_berg", "Berg, Caroline");
		map.put("ulrika_berglund", "Berglund, Ulrika");
		map.put("adam_boman", "Boman, Adam");
		map.put("sofia_bravander", "Br�vander, Sofia ");
		map.put("caroline_caesar", "Caesar, Caroline");
		map.put("ben_counsell", "Counsell, Ben");
		map.put("maria_dahlquist", "Dahlquist, Maria");
		map.put("stefan", "Dressler, Stefan");
		map.put("kristofer_ekbom", "Ekbom, Kristofer");
		map.put("rickard_eneroth", "Eneroth, Rickard");
		map.put("maryam_engelbrecht", "Engelbrecht, Maryam");
		map.put("ake_c_engquist", "Engquist, �ke C.");
		map.put("jorgen_eskelid", "Eskelid, J�rgen");
		map.put("behnosh_esni", "Esni, Behnosh");
		map.put("lars", "Frank, Lars");
		map.put("johan_furuheim", "Furuheim, Johan");
		map.put("cj_hammar", "Hammar, Carl-Johan");
		map.put("helena_harris", "Harris, Helena");
		map.put("david_holmstrand", "Holmstrand, David");
		map.put("daniel_json_lindh", "J:son Lindh, Daniel");
		map.put("fredrik_jagerskogh", "J�gerskogh, Fredrik");
		map.put("malin_kar", "Karlsson, Malin");
		map.put("marcus_kremel", "Kremel, Marcus");
		map.put("lotta_laestadius", "Laestadius, Lotta");
		map.put("daniel_lapidus", "Lapidus, Daniel");
		map.put("mathias_lindberg", "Lindberg, Mathias");
		map.put("joacim_lindback", "Lindb�ck, Joacim");
		map.put("maria_lindstrom", "Lindstr�m, Maria");
		map.put("fredrik_lindva", "Lindvall, Fredrik");
		map.put("rebecca_lindvall", "Lindvall, Rebecca");
		map.put("mia_living", "Living, Mia");
		map.put("marta_munoz", "Mu�oz, Marta");
		map.put("marcus_nilsson", "Nilsson, Marcus");
		map.put("christoffer_nordvall", "Nordvall, Christoffer");
		map.put("malin_norrstrand", "Norrstrand, Malin");
		map.put("tommie_nygren", "Nygren, Tommie");
		map.put("jonah_olsson", "Olsson, Jonah");
		map.put("jonas", "Osk�, Jonas");
		map.put("gustaf_rosell", "Rosell, Gustaf");
		map.put("ellika_skohg", "Skohg, Ellika");
		map.put("maria_stensdotter", "Stensdotter, Maria");
		map.put("mats_thor", "Thor, Mats");
		map.put("johan_timander", "Timander, Johan ");
		map.put("fredrik_westmark", "Westmark, Fredrik");
		map.put("ulrica_wikren", "Wikren, Ulrica");
		map.put("carolinne_wiman", "Wiman, Carolinn");
		
		ListView listView = (ListView) findViewById(R.id.bplist);
		
		Set<String> s = map.keySet();
		Object[] l = s.toArray();
		for(int i = 0; i < map.size(); i++) {
			NameAndUrl bpItem = new NameAndUrl(map.get(l[i]), "http://beamonconsulting.se/medarbetare/" + l[i] + "/");
			list.add(bpItem);
		}
		NameAndUrlListAdapter listAdapter = new NameAndUrlListAdapter(this, list);
		listView.setAdapter(listAdapter);
		listView.setOnItemClickListener(this);
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {   
		final String httpsURL = list.get(arg2).getFixedUrl();
		final DefaultHttpClient client = new DefaultHttpClient();
		final HttpPost httppost = new HttpPost(httpsURL);

		try {
			
			if (android.os.Build.VERSION.SDK_INT > 9) { 
				StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build(); 
				StrictMode.setThreadPolicy(policy); 
			}
			
			//sending the request and retrieving the response:
			HttpResponse response = client.execute(httppost);
				
			Intent i = new Intent(Intent.ACTION_VIEW);
			i.setData(Uri.parse(httpsURL));
			startActivity(i);
			
			//startActivity(new Intent(activity, ShowBp.class).putExtra("url", getResponseBody(response)));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	


	public static String getResponseBody(HttpResponse response) {

		String response_text = null;

		HttpEntity entity = null;

		try {

			entity = response.getEntity();

			response_text = _getResponseBody(entity);

		} catch (ParseException e) {

			e.printStackTrace();

		} catch (IOException e) {

			if (entity != null) {

				try {

					entity.consumeContent();

				} catch (IOException e1) {

				}

			}

		}

		return response_text;

	}
 
	public static String _getResponseBody(final HttpEntity entity)
			throws IOException, ParseException {

		if (entity == null) {
			throw new IllegalArgumentException("HTTP entity may not be null");
		}

		InputStream instream = entity.getContent();

		if (instream == null) {
			return "";
		}

		if (entity.getContentLength() > Integer.MAX_VALUE) {
			throw new IllegalArgumentException(

			"HTTP entity too large to be buffered in memory");
		}

		String charset = getContentCharSet(entity);

		if (charset == null) {

			charset = HTTP.DEFAULT_CONTENT_CHARSET;

		}

		Reader reader = new InputStreamReader(instream, charset);

		StringBuilder buffer = new StringBuilder();

		try {

			char[] tmp = new char[1024];

			int l;

			while ((l = reader.read(tmp)) != -1) {

				buffer.append(tmp, 0, l);

			}

		} finally {

			reader.close();

		}

		return buffer.toString();

	}
 
	public static String getContentCharSet(final HttpEntity entity)
			throws ParseException {

		if (entity == null) {
			throw new IllegalArgumentException("HTTP entity may not be null");
		}

		String charset = null;

		if (entity.getContentType() != null) {

			HeaderElement values[] = entity.getContentType().getElements();

			if (values.length > 0) {

				NameValuePair param = values[0].getParameterByName("charset");

				if (param != null) {

					charset = param.getValue();

				}

			}

		}

		return charset;

	}
 

	
	
	public void onResume() {
		super.onResume();
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}
	
}
