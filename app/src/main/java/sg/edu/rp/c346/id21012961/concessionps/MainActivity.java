package sg.edu.rp.c346.id21012961.concessionps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView lvConcession;
    AsyncHttpClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvConcession = findViewById(R.id.lvConcession);
        client = new AsyncHttpClient();
    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Concession_Details> alConcession = new ArrayList<Concession_Details>();

        client.get("https://data.gov.sg/api/action/datastore_search?resource_id=aeb8dce2-93b8-4227-afdd-a0c70d3c0079&limit=5", new JsonHttpResponseHandler() {

            String cardholder;
            int id;
            float hybrid;
            float bus;
            float train;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONObject jsonArrResult = response.getJSONObject("result");
                    JSONArray jsonArrRecords = jsonArrResult.getJSONArray("records");
                    for (int i = 0; i < jsonArrRecords.length(); i++) {
                        JSONObject jsonObjRecords = jsonArrRecords.getJSONObject(i);
                        cardholder = jsonObjRecords.getString("cardholders");
                        id = jsonObjRecords.getInt("_id");
                        hybrid = (float) jsonObjRecords.getDouble("hybrid_price");
                        bus = (float) jsonObjRecords.getDouble("bus_price");
                        train = (float) jsonObjRecords.getDouble("train_price");
                        Concession_Details concession = new Concession_Details(cardholder, id, hybrid, bus, train);
                        alConcession.add(concession);
                    }

                } catch (JSONException e) {

                }
                ArrayAdapter<Concession_Details> aaConcession = new ArrayAdapter<Concession_Details>(MainActivity.this, android.R.layout.simple_list_item_1, alConcession);
                lvConcession.setAdapter(aaConcession);
            }
        });
    }
}
