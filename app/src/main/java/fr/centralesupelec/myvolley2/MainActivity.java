package fr.centralesupelec.myvolley2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageRequest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asks to the singleton class MySingleton to send back the RequestQueue
        RequestQueue queue = MySingleton.getInstance(this.getApplicationContext()).
                getRequestQueue();

        ImageRequest ir = new ImageRequest("https://helpx.adobe.com/content/dam/help/en/stock/how-to/visual-reverse-image-search/jcr_content/main-pars/image/visual-reverse-image-search-v2_intro.jpg", new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                // callback
                // Here you should code what has to be done
                // with the obtaine image from Volley
                // In this example, I change an imageView
                // For a ListView, you should add this image
                // in the ArrayAdapter
                Log.i("JFL", "I got an answer !");
                Log.i("JFL", ""+ response.toString());
                ImageView iv = (ImageView)findViewById(R.id.imageView);
                iv.setImageBitmap(response);
            }
        }, 400, 300, null, null);

        // Add a request to the queue
        MySingleton.getInstance(this).addToRequestQueue(ir);


    }
}
