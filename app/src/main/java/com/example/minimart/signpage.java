package com.example.minimart;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.minimart.HelperClasses.UniqueUserHelperClass;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

import static android.view.View.OnClickListener;

public class signpage extends AppCompatActivity {

    EditText sfname,slname,semail,stp,sid,pass,compass;
    TextView forpword;
    FloatingActionButton sinemenu;
    ProgressBar spb;

    //Firebase
    FirebaseAuth fAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String signEmail, signNIC;

    String saveUserEmail, ConfirmPassword, saveUserPassword,
            saveUserFName , saveUserLName, saveUserPhone, saveUserNIC;


    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_signpage );

        sfname = findViewById ( R.id.sfname);
        slname = findViewById ( R.id.slname);
        semail = findViewById ( R.id.semail);
        stp = findViewById ( R.id.stp);
        sid = findViewById ( R.id.sid);
        pass = findViewById ( R.id.pass);
        compass = findViewById ( R.id.compass);
        sinemenu = findViewById ( R.id.sinemenu);
        fAuth = FirebaseAuth.getInstance ();
        spb = findViewById ( R.id.spb);

        if(fAuth.getCurrentUser() !=null){
            startActivity ( new Intent ( getApplicationContext(),Mainmenu.class  ) );
            finish();
        }

        sinemenu.setOnClickListener ( new OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {

                 saveUserEmail = semail.getText ().toString ().trim ();
                 ConfirmPassword = compass.getText ().toString ().trim ();
                 saveUserPassword = pass.getText ().toString ().trim ();
                 saveUserFName = sfname.getText ().toString ().trim ();
                 saveUserLName = slname.getText  ().toString ().trim ();
                 saveUserPhone = stp.getText ().toString ().trim ();
                 saveUserNIC = sid.getText ().toString ().trim ();


                if(TextUtils.isEmpty ( saveUserFName )){
                    sfname.setError("First Name Is Required.");
                    return;
                }
                if(saveUserFName.length ()<5){
                    sfname.setError("Please use long name");
                    return;
                }

                if(TextUtils.isEmpty ( saveUserLName )){
                    slname.setError("Last Name Is Required.");
                    return;
                }

                if(saveUserLName.length ()<5){
                    slname.setError("Please use long name");
                    return;
                }

                if(TextUtils.isEmpty (saveUserEmail)){
                    semail.setError("Email Is Required.");
                    return;
                }

                if(saveUserEmail.length ()<8){
                    semail.setError("Password Must Be >=8 Characters");
                    return;
                }

                if(TextUtils.isEmpty (saveUserPhone)){
                    stp.setError("Phone Number Is Required.");
                    return;
                }
                if(saveUserPhone.length ()<10){
                    stp.setError("Phone Number Must Be 10 Characters");
                    return;
                }

                if(TextUtils.isEmpty (saveUserNIC)){
                    sid.setError("Your NIC Is Required.");
                    return;
                }
                if(saveUserNIC.length ()<9){
                    sid.setError("Please Recheck Your Nic Number");
                    return;
                }

                if(TextUtils.isEmpty(saveUserPassword ))
                {
                    pass.setError("Enter your password");

                }

                if(TextUtils.isEmpty(ConfirmPassword ))
                {
                    compass.setError("Enter your confirmation password");

                }
                if (compass.equals(pass))
                {
                    Toast.makeText(signpage.this, "Password do not match", Toast.LENGTH_SHORT).show();
                }

                checkUserNIC();


            }
        } );



    }

    public void checkUserNIC ( ) {

        spb.setVisibility ( View.VISIBLE );
        firebaseDatabase = FirebaseDatabase.getInstance ();
        databaseReference = firebaseDatabase.getReference ("userNIC");

        //Get unique user
        signEmail = semail.getText ().toString ().trim ();
        signNIC = sid.getText ().toString ().trim ();
        
        final UniqueUserHelperClass uniqueUserHelperClass = new UniqueUserHelperClass ( signNIC, signEmail );
        
        databaseReference.addListenerForSingleValueEvent ( new ValueEventListener ( ) {
            @Override
            public void onDataChange ( @NonNull DataSnapshot snapshot ) {
                if (snapshot.child ( uniqueUserHelperClass.getUserNIC ()).exists ()){
                    Toast.makeText ( signpage.this , "Sorry.. this NIC already registered" , Toast.LENGTH_SHORT ).show ( );
                    spb.setVisibility ( View.INVISIBLE );
                } else{
                    saveUserToDatabase();
                }
            }

            @Override
            public void onCancelled ( @NonNull DatabaseError error ) {
                Toast.makeText ( signpage.this , "Sorry.. Please try again.." , Toast.LENGTH_SHORT ).show ( );
                spb.setVisibility ( View.INVISIBLE );
            }
        } );

    }

    private void saveUserToDatabase ( ) {

        spb.setVisibility ( View.VISIBLE );
        String authEmail = semail.getText ( ).toString ( ).trim ( );
        String authPassword = pass.getText ( ).toString ( ).trim ( );

        fAuth.createUserWithEmailAndPassword ( authEmail , authPassword ).addOnCompleteListener ( new OnCompleteListener<AuthResult> ( ) {
            @Override
            public void onComplete ( @NonNull Task<AuthResult> task ) {
                if (task.isSuccessful ( )) {
                    String userID = FirebaseAuth.getInstance ( ).getCurrentUser ( ).getUid ( );
                    databaseReference = FirebaseDatabase.getInstance ( ).getReference ( "Users" ).child ( signNIC.toString ( ) );


                    HashMap<String, String> hashMap1 = new HashMap<> ( );
                    hashMap1.put ( "Firs Name" , saveUserFName );
                    hashMap1.put ( "Last Name" , saveUserLName );
                    hashMap1.put ( "Email" , saveUserEmail );
                    hashMap1.put ( "Phone" , saveUserPhone );
                    hashMap1.put ( "NIC" , saveUserNIC );
                    hashMap1.put ( "Password" , saveUserPassword );

                    firebaseDatabase.getInstance ( ).getReference ( "Users" ).child ( saveUserNIC )
                            .setValue ( hashMap1 ).addOnCompleteListener ( new OnCompleteListener<Void> ( ) {
                        @Override
                        public void onComplete ( @NonNull Task<Void> task ) {
                            spb.setVisibility ( View.INVISIBLE );
                            Toast.makeText ( signpage.this , "Your Account is created Successfully" , Toast.LENGTH_SHORT ).show ( );
                            startActivity ( new Intent ( getApplicationContext (),Mainmenu.class  ) );
                        }
                    } );


                } else {
                    Toast.makeText ( signpage.this , "Error ! " + task.getException ( ).getMessage ( ) , Toast.LENGTH_SHORT ).show ( );
                    Toast.makeText ( signpage.this , "Error ! Your Account is created Unsuccessfully" , Toast.LENGTH_SHORT ).show ( );
                    spb.setVisibility ( View.GONE );
                }

            }
        } );


    }

}