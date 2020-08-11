package com.edinsson.tarea3_4.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.edinsson.tarea3_4.R;
import com.edinsson.tarea3_4.modelo.Contact;
import com.edinsson.tarea3_4.util.DatePickerFragment;
import com.google.android.material.textfield.TextInputEditText;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;

public class ConctactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conctact);
        showToolBar("", false);
    }

    public void showToolBar(String tittle, boolean upButton) {
        androidx.appcompat.widget.Toolbar toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    public void showDatePicker(View view) {
        showDatePickerDialog();
    }

    private void showDatePickerDialog() {
        DatePickerFragment datePickerFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                final String dateSelected = day + "/" + (month + 1) + "/" + year;
                TextInputEditText textInputEditText = (TextInputEditText) findViewById(R.id.date);
                textInputEditText.setText(dateSelected);
            }
        });

        datePickerFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void sendMessage(View view){

        Properties properties = new Properties();
        Session session = Session.getDefaultInstance(properties, null);

        /*properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.user", "edinssonalexismontoyacuadros@gmail.com");
        properties.put("mail.smtp.clave", "avatar12");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", "587");*/

        TextView textView = (TextView) findViewById(R.id.mail);
        TextView message1 = (TextView) findViewById(R.id.contact_description);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("edinssonalexismontoyacuadros@gmail.com"));
            message.setSubject("Prueba");
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(textView.getText().toString()));
            message.setText(message1.getText().toString());
            Transport.send(message);
        }catch (Exception e){
            Toast toast = Toast.makeText(this, "Algo falló", Toast.LENGTH_SHORT);
            toast.show();
            e.printStackTrace();
        }
    }
}