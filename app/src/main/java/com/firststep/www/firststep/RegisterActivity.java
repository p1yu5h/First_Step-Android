package com.firststep.www.firststep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import static android.widget.Toast.makeText;

public class RegisterActivity extends AppCompatActivity implements OnItemSelectedListener {

    EditText parentName, studentName, emailId, mobileNumber;
    Button registerButton;
    String center;

    final String url = "http://192.168.1.102:8080/adduser";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        spinnerFill();

        parentName = findViewById(R.id.parent_name);
        studentName = findViewById(R.id.student_name);
        emailId = findViewById(R.id.email_id);
        mobileNumber = findViewById(R.id.mobile_number);
        registerButton = findViewById(R.id.register_button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDataToServer(url, studentName.getText().toString(),
                        parentName.getText().toString(),
                        emailId.getText().toString(),
                        mobileNumber.getText().toString(), center);
            }
        });

    }

    public void spinnerFill() {
        Spinner spinner = (Spinner) findViewById(R.id.center_choices);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.center_choices, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }


    public void sendDataToServer(String posturl, String studentName, String parentName, String emailId, String mobileNumber, String center) {
        try {
            RequestQueue requestQueue = Volley.newRequestQueue(this);

            JSONObject userDetails = new JSONObject();
            userDetails.put("studentName", studentName);
            userDetails.put("parentName", parentName);
            userDetails.put("emailId", emailId);
            userDetails.put("mobileNumber", mobileNumber);
            userDetails.put("center", center);


            final String mRequestBody = userDetails.toString();
            Log.i("json", mRequestBody);

            StringRequest stringRequest = new StringRequest(Request.Method.POST, posturl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast toast = Toast.makeText(RegisterActivity.this, response, Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_VERTICAL| Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                    Log.i("response", response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("LOG_VOLLEY", error.toString());
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {
                        return mRequestBody == null ? null : mRequestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", mRequestBody, "utf-8");
                        return null;
                    }
                }

                @Override
                protected Response<String> parseNetworkResponse(NetworkResponse response) {
                    String responseString = "";
                    if (response != null) {

                        responseString = String.valueOf(response.statusCode);

                    }
                    return super.parseNetworkResponse(response);
                    //Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
                }
            };
            Log.e("request", stringRequest.toString());

            requestQueue.add(stringRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        center = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
