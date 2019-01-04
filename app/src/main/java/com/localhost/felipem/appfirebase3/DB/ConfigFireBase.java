package com.localhost.felipem.appfirebase3.DB;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfigFireBase {

    private static DatabaseReference referenciaFireBase;
    private static FirebaseAuth autenticacao;


    public static DatabaseReference getDatabase() {

        if (referenciaFireBase == null) {
            referenciaFireBase = FirebaseDatabase.getInstance().getReference();
        }
        return referenciaFireBase;

    }

    public static FirebaseAuth getFirebaseAutenticacao() {
        if (autenticacao == null) {
            autenticacao = FirebaseAuth.getInstance();
        }
        return autenticacao;
    }

}
