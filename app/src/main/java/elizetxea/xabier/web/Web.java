package elizetxea.xabier.web;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Web extends AppCompatActivity {
    private EditText editTextURL;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        editTextURL = (EditText) findViewById(R.id.URL_Text);
        textViewResult = (TextView) findViewById(R.id.textViewResult);
    }

    public void connect(View view) {
        String url = editTextURL.getText().toString();
    }

    private class WebReaderTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... url) {
            return WebReader.getUrl(url[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            textViewResult.setText(s);
        }
    }
}
