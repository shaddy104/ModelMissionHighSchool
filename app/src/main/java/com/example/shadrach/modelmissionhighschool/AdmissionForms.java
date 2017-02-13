package com.example.shadrach.modelmissionhighschool;

import android.app.ProgressDialog;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class AdmissionForms extends AppCompatActivity {

    ImageView imageView;
    Button button;
    String image_url = "http://www.modelmissionschools.com/images/kg_form.jpg";
    String image_url1="http://www.modelmissionschools.com/images/Primary_form.jpg";
    String image_url2="http://www.modelmissionschools.com/images/highschool_form.jpg";
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission_forms);

        button = (Button)findViewById(R.id.download_btn);
        imageView = (ImageView)findViewById(R.id.imageView_form);


        Bundle webforms = getIntent().getExtras();
        if(webforms == null){
            return;
        }
        url = webforms.getString("url");

        /*WebSettings webSettings = forms.getSettings();
        webSettings.setJavaScriptEnabled(true);
        forms.getSettings().setLoadsImagesAutomatically(true);
        forms.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        forms.getSettings().setAllowContentAccess(true);
        forms.getSettings().setAllowFileAccess(true);
        forms.getSettings().setAllowFileAccessFromFileURLs(true);
        forms.loadUrl(url);*/

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadTask downloadTask = new DownloadTask();
                if (image_url.equals(url)){
                    downloadTask.execute(image_url);
                }
                else if (image_url1.equals(url)){
                    downloadTask.execute(image_url1);
                }
                else if (image_url2.equals(url)){
                    downloadTask.execute(image_url2);
                }
                else {
                    Toast.makeText(AdmissionForms.this,"can not download",Toast.LENGTH_LONG).show();
                }
                //copyAssets();
            }
        });
    }

    class DownloadTask extends AsyncTask<String,Integer,String>
    {

        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(AdmissionForms.this);
            progressDialog.setTitle("Download in progress...wait till a download complete message appears");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setMax(100);
            progressDialog.setProgress(0);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            String path = params[0];
            int file_length = 0;
            try {
                URL url = new URL(path);
                URLConnection urlConnection = url.openConnection();
                urlConnection.connect();
                file_length = urlConnection.getContentLength();
                File new_folder = new File("sdcard/MMHS");
                if (!new_folder.exists()) {
                    new_folder.mkdir();
                }


                if (path.equals(image_url)) {
                    File input_file = new File(new_folder, "LKG_form.jpg");
                    InputStream inputStream = new BufferedInputStream(url.openStream(), 8192);
                    byte[] data = new byte[1024];
                    int total = 0;
                    int count = 0;
                    OutputStream outputStream = new FileOutputStream(input_file);
                    while ((count = inputStream.read()) != -1) {
                        total += count;
                        outputStream.write(data, 0, count);
                        int progress = (int) total * 100 / file_length;
                        publishProgress(progress);
                    }
                    inputStream.close();
                    outputStream.close();
                } else if (path.equals(image_url1)) {
                    File input_file = new File(new_folder, "PRIMARY_form.jpg");
                    InputStream inputStream = new BufferedInputStream(url.openStream(), 8192);
                    byte[] data = new byte[1024];
                    int total = 0;
                    int count = 0;
                    OutputStream outputStream = new FileOutputStream(input_file);
                    while ((count = inputStream.read()) != -1) {
                        total += count;
                        outputStream.write(data, 0, count);
                        int progress = (int) total * 100 / file_length;
                        publishProgress(progress);
                    }
                    inputStream.close();
                    outputStream.close();
                } else if (path.equals(image_url2)) {
                    File input_file = new File(new_folder, "HighSchool_form.jpg");
                    InputStream inputStream = new BufferedInputStream(url.openStream(), 8192);
                    byte[] data = new byte[1024];
                    int total = 0;
                    int count = 0;
                    OutputStream outputStream = new FileOutputStream(input_file);
                    while ((count = inputStream.read()) != -1) {
                        total += count;
                        outputStream.write(data, 0, count);
                        int progress = (int) total * 100 / file_length;
                        publishProgress(progress);
                    }
                    inputStream.close();
                    outputStream.close();
                }


                /*InputStream inputStream = new BufferedInputStream(url.openStream(), 8192);
                byte[] data = new byte[1024];
                int total = 0;
                int count = 0;
                OutputStream outputStream = new FileOutputStream(input_file);
                while ((count = inputStream.read()) != -1) {
                    total += count;
                    outputStream.write(data, 0, count);
                    int progress = (int) total * 100 / file_length;
                    publishProgress(progress);
                }
                inputStream.close();
                outputStream.close();*/
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "Download complete...";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressDialog.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            progressDialog.hide();
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
            String path = "sdcard/MMHS/LKG_form.jpg";
            imageView.setImageDrawable(Drawable.createFromPath(path));
        }
    }

    /*private void copyAssets(){
        AssetManager assetManager=getAssets();
        String[] files = null;
        try {
            files = assetManager.list("Files");
        }catch (Exception e){
            Log.e("Tag", e.getMessage());
        }
        for (String fileName : files) {
            System.out.println("Files=>"+fileName);
            InputStream in = null;
            OutputStream out = null;

            try {
                in = assetManager.open("Files/"+fileName);
                out = new FileOutputStream(Environment.getExternalStorageDirectory().toString()+"/"+fileName);
                copyFiles(in,out);
                in.close();
                in=null;
                out.flush();
                out.close();
                out = null;
            }catch (Exception e){
                Log.e("Tag", e.getMessage());
            }
        }
    }
    private void copyFiles(InputStream in,OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read=in.read(buffer))!=-1){
            out.write(buffer, 0, read);
        }
    }*/
}
