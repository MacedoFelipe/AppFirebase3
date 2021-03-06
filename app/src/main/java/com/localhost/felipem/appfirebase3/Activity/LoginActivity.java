package com.localhost.felipem.appfirebase3.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.localhost.felipem.appfirebase3.DB.ConfigFireBase;
import com.localhost.felipem.appfirebase3.Entidades.Usuarios;
import com.localhost.felipem.appfirebase3.R;

public class LoginActivity extends AppCompatActivity {


    private EditText edtEmail;
    private EditText edtSenha;
    private Button btnLogar;

    private FirebaseAuth autenticacao;

    private Usuarios usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        edtEmail = (EditText)findViewById(R.id.edtEmail);
        edtSenha = (EditText)findViewById(R.id.edtSenha);
        btnLogar = (Button)findViewById(R.id.btnLogar);

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtEmail.getText().toString().equals("") && !edtSenha.getText().toString().equals("")) {

                    usuarios = new Usuarios();
                    usuarios.setEmail(edtEmail.getText().toString());
                    usuarios.setSenha(edtSenha.getText().toString());

                    validarLogin();

                } else {
                    Toast.makeText(LoginActivity.this, "Preencha os campos de Login e Senha", Toast.LENGTH_SHORT);
                }
            }
        });
    }

    private void validarLogin(){

        autenticacao = ConfigFireBase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword(usuarios.getEmail(), usuarios.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    abrirTelaPrincipal();
                    Toast.makeText(LoginActivity.this, "Login efetuado com sucesso!", Toast.LENGTH_SHORT);
                }

            }
        });
    }


    public void abrirTelaPrincipal() {

        Intent abrirTelaPrincipal = new Intent(LoginActivity.this, PrincipalActivity.class);
        startActivity(abrirTelaPrincipal);

    }
}
