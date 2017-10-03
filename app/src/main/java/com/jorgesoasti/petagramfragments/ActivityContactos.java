package com.jorgesoasti.petagramfragments;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ActivityContactos extends AppCompatActivity {

    String correo;
    String contrasena;

    EditText mensaje;
    Button enviar;
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);

        mensaje = findViewById(R.id.edtMensaje);
        enviar = findViewById(R.id.btnEnviar);

        correo = "jorgesoasti@gmail.com";
        contrasena = "";

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                Properties properties = new Properties();
                properties.put("mail.smtp.host", "smtp.googlemail.com");
                properties.put("mail.smtp.socketFactory.port", "465");
                properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.port", "465");

                try{

                    session = Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return  new PasswordAuthentication(correo, contrasena);
                        }
                    });

                    if (session!=null){
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(correo));
                        message.setSubject("Prueba de JavaMail");
                        message.setRecipient(Message.RecipientType.TO, new InternetAddress("jorgesoasti@gmail.com"));
                        message.setContent(mensaje.getText().toString(), "text/html; charset=utf-8");

                        Transport.send(message);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }
}
