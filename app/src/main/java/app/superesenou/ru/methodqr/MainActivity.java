package app.superesenou.ru.methodqr;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
   int flag=1;
    EditText a11,a12,a13,a14,a15,a16,a17;
    EditText a21,a22,a23,a24,a25,a26,a27;
    EditText a31,a32,a33,a34,a35,a36,a37;
    EditText a41,a42,a43,a44,a45,a46,a47;
    EditText a51,a52,a53,a54,a55,a56,a57;
    EditText a61,a62,a63,a64,a65,a66,a67;
    EditText a71,a72,a73,a74,a75,a76,a77;
    Spinner spinner;
    TextView textMatrix,result;
    Button btn1;
    ArrayAdapter<CharSequence> adapter;
    private  double[][] QR;
    private double[] Rdiag;
    double[][] Q;   double[][] R1;
    boolean Yes=false;
    double EPSILON = 0.000001;
    double [][]X;
    Button clinBtn;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.solve);
        result=(TextView)findViewById(R.id.result);
        spinner=(Spinner)findViewById(R.id.spinner);
        clinBtn=(Button)findViewById(R.id.cleanup);

        adapter=ArrayAdapter.createFromResource(this,R.array.country_name,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        a11=(EditText)findViewById(R.id.a11);
        a12=(EditText)findViewById(R.id.a12);
        a13=(EditText)findViewById(R.id.a13);
        a14=(EditText)findViewById(R.id.a14);
        a15=(EditText)findViewById(R.id.a15);
        a16=(EditText)findViewById(R.id.a16);
        a17=(EditText)findViewById(R.id.a17);
        a21=(EditText)findViewById(R.id.a21);
        a22=(EditText)findViewById(R.id.a22);
        a23=(EditText)findViewById(R.id.a23);
        a24=(EditText)findViewById(R.id.a24);
        a25=(EditText)findViewById(R.id.a25);
        a26=(EditText)findViewById(R.id.a26);
        a27=(EditText)findViewById(R.id.a27);
        a31=(EditText)findViewById(R.id.a31);
        a32=(EditText)findViewById(R.id.a32);
        a33=(EditText)findViewById(R.id.a33);
        a34=(EditText)findViewById(R.id.a34);
        a35=(EditText)findViewById(R.id.a35);
        a36=(EditText)findViewById(R.id.a36);
        a37=(EditText)findViewById(R.id.a37);
        a41=(EditText)findViewById(R.id.a41);
        a42=(EditText)findViewById(R.id.a42);
        a43=(EditText)findViewById(R.id.a43);
        a44=(EditText)findViewById(R.id.a44);
        a45=(EditText)findViewById(R.id.a45);
        a46=(EditText)findViewById(R.id.a46);
        a47=(EditText)findViewById(R.id.a47);
        a51=(EditText)findViewById(R.id.a51);
        a52=(EditText)findViewById(R.id.a52);
        a53=(EditText)findViewById(R.id.a53);
        a54=(EditText)findViewById(R.id.a54);
        a55=(EditText)findViewById(R.id.a55);
        a56=(EditText)findViewById(R.id.a56);
        a57=(EditText)findViewById(R.id.a57);
        a61=(EditText)findViewById(R.id.a61);
        a62=(EditText)findViewById(R.id.a62);
        a63=(EditText)findViewById(R.id.a63);
        a64=(EditText)findViewById(R.id.a64);
        a65=(EditText)findViewById(R.id.a65);
        a66=(EditText)findViewById(R.id.a66);
        a67=(EditText)findViewById(R.id.a67);
        a71=(EditText)findViewById(R.id.a71);
        a72=(EditText)findViewById(R.id.a72);
        a73=(EditText)findViewById(R.id.a73);
        a74=(EditText)findViewById(R.id.a74);
        a75=(EditText)findViewById(R.id.a75);
        a76=(EditText)findViewById(R.id.a76);
        a77=(EditText)findViewById(R.id.a77);
        btn1=(Button)findViewById(R.id.solve);
        result=(TextView)findViewById(R.id.result);
        spinner=(Spinner)findViewById(R.id.spinner);
        clinBtn=(Button)findViewById(R.id.cleanup);

        adapter=ArrayAdapter.createFromResource(this,R.array.country_name,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {


                if(position==0){
                    clean();
                    invisible();
                    array2();

                    btn1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                             result.setText("");
                             isEmpty2();
                            if(flag==0){
                                  Toast.makeText(MainActivity.this, "Не все поля заполнены", Toast.LENGTH_SHORT).show();
                                   flag=1;
                            }
                            else {
                                a21.setVisibility(View.VISIBLE);
                                a21.setText(a12.getText());
                                double [][]arrays2=new double[2][2];
                                getData2(arrays2,2,2);
                                QRDecomposition (arrays2,2,2);
                                getH(2,2);
                                getR(2,2);
                                getQ(arrays2,2,2);
                                solve(arrays2,2,2);
                                 computeVV(2,2);

                            }

                        }
                    });
                }
                else if(position==1){
                    clean();
                    invisible();
                    array3();
                    btn1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            result.setText("");
                            isEmpty3();
                            if(flag==0){
                                Toast.makeText(MainActivity.this, "Не все поля заполнены", Toast.LENGTH_SHORT).show();
                                flag=1;
                            }
                            else {
                                a21.setVisibility(View.VISIBLE);
                                a21.setText(a12.getText());
                                a31.setVisibility(View.VISIBLE);
                                a31.setText(a13.getText());
                                a32.setVisibility(View.VISIBLE);
                                a32.setText(a23.getText());
                                double [][]arrays2=new double[3][3];
                                getData3(arrays2,3,3);
                                QRDecomposition (arrays2,3,3);
                                getQ(arrays2,3,3);
                                getR(3,3);
                                solve(arrays2,3,3);
                                computeVV(3,3);
                            }

                        }
                    });
                }
                else if(position==2){
                    clean();
                    invisible();
                    array4();
                    btn1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            result.setText("");
                            isEmpty4();
                            if(flag==0){
                                Toast.makeText(MainActivity.this, "Не все поля заполнены", Toast.LENGTH_SHORT).show();
                                flag=1;
                            }
                            else {
                                a21.setVisibility(View.VISIBLE);
                                a21.setText(a12.getText());
                                a31.setVisibility(View.VISIBLE);
                                a31.setText(a13.getText());
                                a32.setVisibility(View.VISIBLE);
                                a32.setText(a23.getText());
                                a41.setVisibility(View.VISIBLE);
                                a41.setText(a14.getText());
                                a42.setVisibility(View.VISIBLE);
                                a42.setText(a24.getText());
                                a43.setVisibility(View.VISIBLE);
                                a43.setText(a34.getText());
                                double [][]arrays2=new double[4][4];
                                getData4(arrays2,4,4);
                                QRDecomposition (arrays2,4,4);
                                getQ(arrays2,4,4);
                                getR(4,4);
                                solve(arrays2,4,4);
                                computeVV(4,4);

                            }

                        }
                    });
                }
                else if(position==3){
                    clean();
                    invisible();
                    array5();
                    btn1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            result.setText("");
                            isEmpty5();
                            if(flag==0){
                                 Toast.makeText(MainActivity.this, "Не все поля заполнены", Toast.LENGTH_SHORT).show();
                                flag=1;
                            }
                            else {
                                a21.setVisibility(View.VISIBLE);
                                a21.setText(a12.getText());
                                a31.setVisibility(View.VISIBLE);
                                a31.setText(a13.getText());
                                a32.setVisibility(View.VISIBLE);
                                a32.setText(a23.getText());
                                a41.setVisibility(View.VISIBLE);
                                a41.setText(a14.getText());
                                a42.setVisibility(View.VISIBLE);
                                a42.setText(a24.getText());
                                a43.setVisibility(View.VISIBLE);
                                a43.setText(a34.getText());
                                a51.setVisibility(View.VISIBLE);
                                a51.setText(a15.getText());
                                a52.setVisibility(View.VISIBLE);
                                a52.setText(a25.getText());
                                a53.setVisibility(View.VISIBLE);
                                a53.setText(a35.getText());
                                a54.setVisibility(View.VISIBLE);
                                a54.setText(a45.getText());
                                double [][]arrays2=new double[5][5];
                                getData5(arrays2,5,5);
                                QRDecomposition (arrays2,5,5);
                                getQ(arrays2,5,5);
                                getR(5,5);
                                solve(arrays2,5,5);
                                computeVV(5,5);

                            }

                        }
                    });
                }
                else if(position==4){
                    clean();
                    invisible();
                    array6();
                    btn1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            result.setText("");
                            isEmpty6();
                            if(flag==0){
                                Toast.makeText(MainActivity.this, "Не все поля заполнены", Toast.LENGTH_SHORT).show();
                                flag=1;
                            }
                            else {
                                a21.setVisibility(View.VISIBLE);
                                a21.setText(a12.getText());
                                a31.setVisibility(View.VISIBLE);
                                a31.setText(a13.getText());
                                a32.setVisibility(View.VISIBLE);
                                a32.setText(a23.getText());
                                a41.setVisibility(View.VISIBLE);
                                a41.setText(a14.getText());
                                a42.setVisibility(View.VISIBLE);
                                a42.setText(a24.getText());
                                a43.setVisibility(View.VISIBLE);
                                a43.setText(a34.getText());
                                a51.setVisibility(View.VISIBLE);
                                a51.setText(a15.getText());
                                a52.setVisibility(View.VISIBLE);
                                a52.setText(a25.getText());
                                a53.setVisibility(View.VISIBLE);
                                a53.setText(a35.getText());
                                a54.setVisibility(View.VISIBLE);
                                a54.setText(a45.getText());
                                a61.setVisibility(View.VISIBLE);
                                a61.setText(a16.getText());
                                a62.setVisibility(View.VISIBLE);
                                a62.setText(a26.getText());
                                a63.setVisibility(View.VISIBLE);
                                a63.setText(a36.getText());
                                a64.setVisibility(View.VISIBLE);
                                a64.setText(a46.getText());
                                a65.setVisibility(View.VISIBLE);
                                a65.setText(a56.getText());
                                double [][]arrays2=new double[6][6];
                                getData6(arrays2,6,6);
                                QRDecomposition (arrays2,6,6);
                                getQ(arrays2,6,6);
                                getR(6,6);
                                solve(arrays2,6,6);
                                computeVV(6,6);

                            }

                        }
                    });
                }
                else if(position==5){
                    clean();
                    invisible();
                    array7();
                    btn1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            result.setText("");
                            isEmpty7();
                            if(flag==0){
                                Toast.makeText(MainActivity.this, "Не все поля заполнены", Toast.LENGTH_SHORT).show();
                                flag=1;
                            }
                            else {
                                a21.setVisibility(View.VISIBLE);
                                a21.setText(a12.getText());
                                a31.setVisibility(View.VISIBLE);
                                a31.setText(a13.getText());
                                a32.setVisibility(View.VISIBLE);
                                a32.setText(a23.getText());
                                a41.setVisibility(View.VISIBLE);
                                a41.setText(a14.getText());
                                a42.setVisibility(View.VISIBLE);
                                a42.setText(a24.getText());
                                a43.setVisibility(View.VISIBLE);
                                a43.setText(a34.getText());
                                a51.setVisibility(View.VISIBLE);
                                a51.setText(a15.getText());
                                a52.setVisibility(View.VISIBLE);
                                a52.setText(a25.getText());
                                a53.setVisibility(View.VISIBLE);
                                a53.setText(a35.getText());
                                a54.setVisibility(View.VISIBLE);
                                a54.setText(a45.getText());
                                a61.setVisibility(View.VISIBLE);
                                a61.setText(a16.getText());
                                a62.setVisibility(View.VISIBLE);
                                a62.setText(a26.getText());
                                a63.setVisibility(View.VISIBLE);
                                a63.setText(a36.getText());
                                a64.setVisibility(View.VISIBLE);
                                a64.setText(a46.getText());
                                a65.setVisibility(View.VISIBLE);
                                a65.setText(a56.getText());
                                a71.setVisibility(View.VISIBLE);
                                a71.setText(a17.getText());
                                a72.setVisibility(View.VISIBLE);
                                a72.setText(a27.getText());
                                a73.setVisibility(View.VISIBLE);
                                a73.setText(a37.getText());
                                a74.setVisibility(View.VISIBLE);
                                a74.setText(a47.getText());
                                a75.setVisibility(View.VISIBLE);
                                a75.setText(a57.getText());
                                a76.setVisibility(View.VISIBLE);
                                a76.setText(a67.getText());
                                double [][]arrays2=new double[7][7];
                                getData7(arrays2,7,7);
                                QRDecomposition (arrays2,7,7);
                                getQ(arrays2,7,7);
                                getR(7,7);
                                solve(arrays2,7,7);
                                computeVV(7,7);
                            }
                        }
                    });
                }
                else if(position==6){

                }
                }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
              Intent intent =new Intent(MainActivity.this,QrAlghoritm.class);
              startActivity(intent);
        }

         else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

                  finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    void  array2(){
        a11.setVisibility(View.VISIBLE);
        a12.setVisibility(View.VISIBLE);
        a22.setVisibility(View.VISIBLE);

    }
    void array3(){
        a11.setVisibility(View.VISIBLE);
        a12.setVisibility(View.VISIBLE);
        a13.setVisibility(View.VISIBLE);
       // a21.setVisibility(View.VISIBLE);
        a22.setVisibility(View.VISIBLE);
        a23.setVisibility(View.VISIBLE);
      //  a31.setVisibility(View.VISIBLE);
      //  a32.setVisibility(View.VISIBLE);
        a33.setVisibility(View.VISIBLE);
    }
    void array4(){
        a11.setVisibility(View.VISIBLE);
        a12.setVisibility(View.VISIBLE);
        a13.setVisibility(View.VISIBLE);
        a14.setVisibility(View.VISIBLE);
      //  a21.setVisibility(View.VISIBLE);
        a22.setVisibility(View.VISIBLE);
        a23.setVisibility(View.VISIBLE);
        a24.setVisibility(View.VISIBLE);
      //  a31.setVisibility(View.VISIBLE);
     //   a32.setVisibility(View.VISIBLE);
        a33.setVisibility(View.VISIBLE);
        a34.setVisibility(View.VISIBLE);
      //  a41.setVisibility(View.VISIBLE);
      //  a42.setVisibility(View.VISIBLE);
      //  a43.setVisibility(View.VISIBLE);
        a44.setVisibility(View.VISIBLE);
    }
    void  array5(){
        a11.setVisibility(View.VISIBLE);
        a12.setVisibility(View.VISIBLE);
        a13.setVisibility(View.VISIBLE);
        a14.setVisibility(View.VISIBLE);
        a15.setVisibility(View.VISIBLE);
       // a21.setVisibility(View.VISIBLE);
        a22.setVisibility(View.VISIBLE);
        a23.setVisibility(View.VISIBLE);
        a24.setVisibility(View.VISIBLE);
        a25.setVisibility(View.VISIBLE);
      //  a31.setVisibility(View.VISIBLE);
     //   a32.setVisibility(View.VISIBLE);
        a33.setVisibility(View.VISIBLE);
        a34.setVisibility(View.VISIBLE);
        a35.setVisibility(View.VISIBLE);
     //   a41.setVisibility(View.VISIBLE);
    //    a42.setVisibility(View.VISIBLE);
     //   a43.setVisibility(View.VISIBLE);
        a44.setVisibility(View.VISIBLE);
        a45.setVisibility(View.VISIBLE);
      //  a51.setVisibility(View.VISIBLE);
      //  a52.setVisibility(View.VISIBLE);
      //  a53.setVisibility(View.VISIBLE);
      //  a54.setVisibility(View.VISIBLE);
        a55.setVisibility(View.VISIBLE);
    }
    void array6(){
        a11.setVisibility(View.VISIBLE);
        a12.setVisibility(View.VISIBLE);
        a13.setVisibility(View.VISIBLE);
        a14.setVisibility(View.VISIBLE);
        a15.setVisibility(View.VISIBLE);
        a16.setVisibility(View.VISIBLE);

        //  a21.setVisibility(View.VISIBLE);
        a22.setVisibility(View.VISIBLE);
        a23.setVisibility(View.VISIBLE);
        a24.setVisibility(View.VISIBLE);
        a25.setVisibility(View.VISIBLE);
        a26.setVisibility(View.VISIBLE);

        //   a31.setVisibility(View.VISIBLE);
        //   a32.setVisibility(View.VISIBLE);
        a33.setVisibility(View.VISIBLE);
        a34.setVisibility(View.VISIBLE);
        a35.setVisibility(View.VISIBLE);
        a36.setVisibility(View.VISIBLE);

        //  a41.setVisibility(View.VISIBLE);
        //  a42.setVisibility(View.VISIBLE);
        //  a43.setVisibility(View.VISIBLE);
        a44.setVisibility(View.VISIBLE);
        a45.setVisibility(View.VISIBLE);
        a46.setVisibility(View.VISIBLE);

        //  a51.setVisibility(View.VISIBLE);
        //   a52.setVisibility(View.VISIBLE);
        //  a53.setVisibility(View.VISIBLE);
        //  a54.setVisibility(View.VISIBLE);
        a55.setVisibility(View.VISIBLE);
        a56.setVisibility(View.VISIBLE);

        //   a61.setVisibility(View.VISIBLE);
        //   a62.setVisibility(View.VISIBLE);
        //  a63.setVisibility(View.VISIBLE);
        //    a64.setVisibility(View.VISIBLE);
        //   a65.setVisibility(View.VISIBLE);
        a66.setVisibility(View.VISIBLE);



    }
    void array7(){
        a11.setVisibility(View.VISIBLE);
        a12.setVisibility(View.VISIBLE);
        a13.setVisibility(View.VISIBLE);
        a14.setVisibility(View.VISIBLE);
        a15.setVisibility(View.VISIBLE);
        a16.setVisibility(View.VISIBLE);
        a17.setVisibility(View.VISIBLE);
      //  a21.setVisibility(View.VISIBLE);
        a22.setVisibility(View.VISIBLE);
        a23.setVisibility(View.VISIBLE);
        a24.setVisibility(View.VISIBLE);
        a25.setVisibility(View.VISIBLE);
        a26.setVisibility(View.VISIBLE);
        a27.setVisibility(View.VISIBLE);
     //   a31.setVisibility(View.VISIBLE);
     //   a32.setVisibility(View.VISIBLE);
        a33.setVisibility(View.VISIBLE);
        a34.setVisibility(View.VISIBLE);
        a35.setVisibility(View.VISIBLE);
        a36.setVisibility(View.VISIBLE);
        a37.setVisibility(View.VISIBLE);
      //  a41.setVisibility(View.VISIBLE);
      //  a42.setVisibility(View.VISIBLE);
      //  a43.setVisibility(View.VISIBLE);
        a44.setVisibility(View.VISIBLE);
        a45.setVisibility(View.VISIBLE);
        a46.setVisibility(View.VISIBLE);
        a47.setVisibility(View.VISIBLE);
      //  a51.setVisibility(View.VISIBLE);
     //   a52.setVisibility(View.VISIBLE);
      //  a53.setVisibility(View.VISIBLE);
      //  a54.setVisibility(View.VISIBLE);
        a55.setVisibility(View.VISIBLE);
        a56.setVisibility(View.VISIBLE);
        a57.setVisibility(View.VISIBLE);
     //   a61.setVisibility(View.VISIBLE);
     //   a62.setVisibility(View.VISIBLE);
      //  a63.setVisibility(View.VISIBLE);
    //    a64.setVisibility(View.VISIBLE);
     //   a65.setVisibility(View.VISIBLE);
        a66.setVisibility(View.VISIBLE);
        a67.setVisibility(View.VISIBLE);
      //  a71.setVisibility(View.VISIBLE);
      //  a72.setVisibility(View.VISIBLE);
     //   a73.setVisibility(View.VISIBLE);
      //  a74.setVisibility(View.VISIBLE);
     //   a75.setVisibility(View.VISIBLE);
     //   a76.setVisibility(View.VISIBLE);
        a77.setVisibility(View.VISIBLE);

    }
    void invisible(){
        a11.setVisibility(View.INVISIBLE);
        a12.setVisibility(View.INVISIBLE);
        a13.setVisibility(View.INVISIBLE);
        a14.setVisibility(View.INVISIBLE);
        a15.setVisibility(View.INVISIBLE);
        a16.setVisibility(View.INVISIBLE);
        a17.setVisibility(View.INVISIBLE);
        a21.setVisibility(View.INVISIBLE);
        a22.setVisibility(View.INVISIBLE);
        a23.setVisibility(View.INVISIBLE);
        a24.setVisibility(View.INVISIBLE);
        a25.setVisibility(View.INVISIBLE);
        a26.setVisibility(View.INVISIBLE);
        a27.setVisibility(View.INVISIBLE);
        a31.setVisibility(View.INVISIBLE);
        a32.setVisibility(View.INVISIBLE);
        a33.setVisibility(View.INVISIBLE);
        a34.setVisibility(View.INVISIBLE);
        a35.setVisibility(View.INVISIBLE);
        a36.setVisibility(View.INVISIBLE);
        a37.setVisibility(View.INVISIBLE);
        a41.setVisibility(View.INVISIBLE);
        a42.setVisibility(View.INVISIBLE);
        a43.setVisibility(View.INVISIBLE);
        a44.setVisibility(View.INVISIBLE);
        a45.setVisibility(View.INVISIBLE);
        a46.setVisibility(View.INVISIBLE);
        a47.setVisibility(View.INVISIBLE);
        a51.setVisibility(View.INVISIBLE);
        a52.setVisibility(View.INVISIBLE);
        a53.setVisibility(View.INVISIBLE);
        a54.setVisibility(View.INVISIBLE);
        a55.setVisibility(View.INVISIBLE);
        a56.setVisibility(View.INVISIBLE);
        a57.setVisibility(View.INVISIBLE);
        a61.setVisibility(View.INVISIBLE);
        a62.setVisibility(View.INVISIBLE);
        a63.setVisibility(View.INVISIBLE);
        a64.setVisibility(View.INVISIBLE);
        a65.setVisibility(View.INVISIBLE);
        a66.setVisibility(View.INVISIBLE);
        a67.setVisibility(View.INVISIBLE);
        a71.setVisibility(View.INVISIBLE);
        a72.setVisibility(View.INVISIBLE);
        a73.setVisibility(View.INVISIBLE);
        a74.setVisibility(View.INVISIBLE);
        a75.setVisibility(View.INVISIBLE);
        a76.setVisibility(View.INVISIBLE);
        a77.setVisibility(View.INVISIBLE);
    }
    void clean(){
       result.setText("");
        a11.setText("");
        a12.setText("");
        a13.setText("");
        a14.setText("");
        a15.setText("");
        a16.setText("");
        a17.setText("");
        a21.setText("");
        a22.setText("");
        a23.setText("");
        a24.setText("");
        a25.setText("");
        a26.setText("");
        a27.setText("");
        a31.setText("");
        a32.setText("");
        a33.setText("");
        a34.setText("");
        a35.setText("");
        a36.setText("");
        a37.setText("");
        a41.setText("");
        a42.setText("");
        a43.setText("");
        a44.setText("");
        a45.setText("");
        a46.setText("");
        a47.setText("");
        a51.setText("");
        a52.setText("");
        a53.setText("");
        a54.setText("");
        a55.setText("");
        a56.setText("");
        a57.setText("");
        a61.setText("");
        a62.setText("");
        a63.setText("");
        a64.setText("");
        a65.setText("");
        a66.setText("");
        a67.setText("");
        a71.setText("");
        a72.setText("");
        a73.setText("");
        a74.setText("");
        a75.setText("");
        a76.setText("");
        a77.setText("");
    }

    void getData2(double[][]arrays2,int m,int n){

        double  newa11 = Double.parseDouble(a11.getText().toString());
        arrays2[0][0]= newa11;
        double   newa12 = Double.parseDouble(a12.getText().toString());
        arrays2[0][1]= newa12;
        double  newa21 = Double.parseDouble(a21.getText().toString());
        arrays2[1][0]= newa21;
        double newa22 = Double.parseDouble(a22.getText().toString());
        arrays2[1][1]= newa22;

    }
    void getData3(double[][]arrays2,int m,int n){
        double  newa11 = Double.parseDouble(a11.getText().toString());
        arrays2[0][0]= newa11;
        double   newa12 = Double.parseDouble(a12.getText().toString());
        arrays2[0][1]= newa12;
        double  newa13 = Double.parseDouble(a13.getText().toString());
        arrays2[0][2]=newa13;
        double  newa21 = Double.parseDouble(a21.getText().toString());
        arrays2[1][0]= newa21;
        double newa22 = Double.parseDouble(a22.getText().toString());
        arrays2[1][1]= newa22;
        double  newa23 = Double.parseDouble(a23.getText().toString());
        arrays2[1][2]=newa23;
        double  newa31 = Double.parseDouble(a31.getText().toString());
        arrays2[2][0]=newa31;
        double  newa32 = Double.parseDouble(a32.getText().toString());
        arrays2[2][1]=newa32;
        double  newa33 = Double.parseDouble(a33.getText().toString());
        arrays2[2][2]=newa33;
    }
    void getData4(double [][]arrays2,int m,int n){
        double  newa11 = Double.parseDouble(a11.getText().toString());
        arrays2[0][0]= newa11;
        double   newa12 = Double.parseDouble(a12.getText().toString());
        arrays2[0][1]= newa12;
        double  newa13 = Double.parseDouble(a13.getText().toString());
        arrays2[0][2]=newa13;
        double  newa14 = Double.parseDouble(a14.getText().toString());
        arrays2[0][3]=newa14;

        double  newa21 = Double.parseDouble(a21.getText().toString());
        arrays2[1][0]= newa21;
        double newa22 = Double.parseDouble(a22.getText().toString());
        arrays2[1][1]= newa22;
        double  newa23 = Double.parseDouble(a23.getText().toString());
        arrays2[1][2]=newa23;
        double  newa24 = Double.parseDouble(a24.getText().toString());
        arrays2[1][3]=newa24;

        double  newa31 = Double.parseDouble(a31.getText().toString());
        arrays2[2][0]=newa31;
        double  newa32 = Double.parseDouble(a32.getText().toString());
        arrays2[2][1]=newa32;
        double  newa33 = Double.parseDouble(a33.getText().toString());
        arrays2[2][2]=newa33;
        double  newa34 = Double.parseDouble(a34.getText().toString());
        arrays2[2][3]=newa34;

        double  newa41 = Double.parseDouble(a41.getText().toString());
        arrays2[3][0]=newa41;
        double  newa42 = Double.parseDouble(a42.getText().toString());
        arrays2[3][1]=newa42;
        double  newa43 = Double.parseDouble(a43.getText().toString());
        arrays2[3][2]=newa43;
        double  newa44 = Double.parseDouble(a44.getText().toString());
        arrays2[3][3]=newa44;
    }
    void getData5(double [][]arrays2,int m,int n){
        double  newa11 = Double.parseDouble(a11.getText().toString());
        arrays2[0][0]= newa11;
        double   newa12 = Double.parseDouble(a12.getText().toString());
        arrays2[0][1]= newa12;
        double  newa13 = Double.parseDouble(a13.getText().toString());
        arrays2[0][2]=newa13;
        double  newa14 = Double.parseDouble(a14.getText().toString());
        arrays2[0][3]=newa14;
        double  newa15 = Double.parseDouble(a15.getText().toString());
        arrays2[0][4]=newa15;

        double  newa21 = Double.parseDouble(a21.getText().toString());
        arrays2[1][0]= newa21;
        double newa22 = Double.parseDouble(a22.getText().toString());
        arrays2[1][1]= newa22;
        double  newa23 = Double.parseDouble(a23.getText().toString());
        arrays2[1][2]=newa23;
        double  newa24 = Double.parseDouble(a24.getText().toString());
        arrays2[1][3]=newa24;
        double  newa25 = Double.parseDouble(a25.getText().toString());
        arrays2[1][4]=newa25;

        double  newa31 = Double.parseDouble(a31.getText().toString());
        arrays2[2][0]=newa31;
        double  newa32 = Double.parseDouble(a32.getText().toString());
        arrays2[2][1]=newa32;
        double  newa33 = Double.parseDouble(a33.getText().toString());
        arrays2[2][2]=newa33;
        double  newa34 = Double.parseDouble(a34.getText().toString());
        arrays2[2][3]=newa34;
        double  newa35 = Double.parseDouble(a35.getText().toString());
        arrays2[2][4]=newa35;

        double  newa41 = Double.parseDouble(a41.getText().toString());
        arrays2[3][0]=newa41;
        double  newa42 = Double.parseDouble(a42.getText().toString());
        arrays2[3][1]=newa42;
        double  newa43 = Double.parseDouble(a43.getText().toString());
        arrays2[3][2]=newa43;
        double  newa44 = Double.parseDouble(a44.getText().toString());
        arrays2[3][3]=newa44;
        double  newa45 = Double.parseDouble(a45.getText().toString());
        arrays2[3][4]=newa45;

        double  newa51 = Double.parseDouble(a51.getText().toString());
        arrays2[4][0]=newa51;
        double  newa52 = Double.parseDouble(a52.getText().toString());
        arrays2[4][1]=newa52;
        double  newa53 = Double.parseDouble(a53.getText().toString());
        arrays2[4][2]=newa53;
        double  newa54 = Double.parseDouble(a54.getText().toString());
        arrays2[4][3]=newa54;
        double  newa55 = Double.parseDouble(a55.getText().toString());
        arrays2[4][4]=newa55;
    }
    void getData6(double [][]arrays2,int m,int n){
        double  newa11 = Double.parseDouble(a11.getText().toString());
        arrays2[0][0]= newa11;
        double   newa12 = Double.parseDouble(a12.getText().toString());
        arrays2[0][1]= newa12;
        double  newa13 = Double.parseDouble(a13.getText().toString());
        arrays2[0][2]=newa13;
        double  newa14 = Double.parseDouble(a14.getText().toString());
        arrays2[0][3]=newa14;
        double  newa15 = Double.parseDouble(a15.getText().toString());
        arrays2[0][4]=newa15;
        double  newa16 = Double.parseDouble(a16.getText().toString());
        arrays2[0][5]=newa16;

        double  newa21 = Double.parseDouble(a21.getText().toString());
        arrays2[1][0]= newa21;
        double newa22 = Double.parseDouble(a22.getText().toString());
        arrays2[1][1]= newa22;
        double  newa23 = Double.parseDouble(a23.getText().toString());
        arrays2[1][2]=newa23;
        double  newa24 = Double.parseDouble(a24.getText().toString());
        arrays2[1][3]=newa24;
        double  newa25 = Double.parseDouble(a25.getText().toString());
        arrays2[1][4]=newa25;
        double  newa26 = Double.parseDouble(a26.getText().toString());
        arrays2[1][5]=newa26;

        double  newa31 = Double.parseDouble(a31.getText().toString());
        arrays2[2][0]=newa31;
        double  newa32 = Double.parseDouble(a32.getText().toString());
        arrays2[2][1]=newa32;
        double  newa33 = Double.parseDouble(a33.getText().toString());
        arrays2[2][2]=newa33;
        double  newa34 = Double.parseDouble(a34.getText().toString());
        arrays2[2][3]=newa34;
        double  newa35 = Double.parseDouble(a35.getText().toString());
        arrays2[2][4]=newa35;
        double  newa36 = Double.parseDouble(a15.getText().toString());
        arrays2[2][5]=newa36;

        double  newa41 = Double.parseDouble(a41.getText().toString());
        arrays2[3][0]=newa41;
        double  newa42 = Double.parseDouble(a42.getText().toString());
        arrays2[3][1]=newa42;
        double  newa43 = Double.parseDouble(a43.getText().toString());
        arrays2[3][2]=newa43;
        double  newa44 = Double.parseDouble(a44.getText().toString());
        arrays2[3][3]=newa44;
        double  newa45 = Double.parseDouble(a45.getText().toString());
        arrays2[3][4]=newa45;
        double  newa46 = Double.parseDouble(a46.getText().toString());
        arrays2[3][5]=newa46;

        double  newa51 = Double.parseDouble(a51.getText().toString());
        arrays2[4][0]=newa51;
        double  newa52 = Double.parseDouble(a52.getText().toString());
        arrays2[4][1]=newa52;
        double  newa53 = Double.parseDouble(a53.getText().toString());
        arrays2[4][2]=newa53;
        double  newa54 = Double.parseDouble(a54.getText().toString());
        arrays2[4][3]=newa54;
        double  newa55 = Double.parseDouble(a55.getText().toString());
        arrays2[4][4]=newa55;
        double  newa56 = Double.parseDouble(a56.getText().toString());
        arrays2[4][5]=newa56;

        double  newa61 = Double.parseDouble(a61.getText().toString());
        arrays2[5][0]=newa61;
        double  newa62 = Double.parseDouble(a62.getText().toString());
        arrays2[5][1]=newa62;
        double  newa63 = Double.parseDouble(a63.getText().toString());
        arrays2[5][2]=newa63;
        double  newa64 = Double.parseDouble(a64.getText().toString());
        arrays2[5][3]=newa64;
        double  newa65 = Double.parseDouble(a65.getText().toString());
        arrays2[5][4]=newa65;
        double  newa66 = Double.parseDouble(a66.getText().toString());
        arrays2[5][5]=newa66;



    }
    void getData7(double [][]arrays2,int m,int n){

        double  newa11 = Double.parseDouble(a11.getText().toString());
        arrays2[0][0]= newa11;
        double   newa12 = Double.parseDouble(a12.getText().toString());
        arrays2[0][1]= newa12;
        double  newa13 = Double.parseDouble(a13.getText().toString());
        arrays2[0][2]=newa13;
        double  newa14 = Double.parseDouble(a14.getText().toString());
        arrays2[0][3]=newa14;
        double  newa15 = Double.parseDouble(a15.getText().toString());
        arrays2[0][4]=newa15;
        double  newa16 = Double.parseDouble(a16.getText().toString());
        arrays2[0][5]=newa16;
        double  newa17 = Double.parseDouble(a17.getText().toString());
        arrays2[0][6]=newa17;


        double  newa21 = Double.parseDouble(a21.getText().toString());
        arrays2[1][0]= newa21;
        double newa22 = Double.parseDouble(a22.getText().toString());
        arrays2[1][1]= newa22;
        double  newa23 = Double.parseDouble(a23.getText().toString());
        arrays2[1][2]=newa23;
        double  newa24 = Double.parseDouble(a24.getText().toString());
        arrays2[1][3]=newa24;
        double  newa25 = Double.parseDouble(a25.getText().toString());
        arrays2[1][4]=newa25;
        double  newa26 = Double.parseDouble(a26.getText().toString());
        arrays2[1][5]=newa26;
        double  newa27 = Double.parseDouble(a27.getText().toString());
        arrays2[1][6]=newa27;


        double  newa31 = Double.parseDouble(a31.getText().toString());
        arrays2[2][0]=newa31;
        double  newa32 = Double.parseDouble(a32.getText().toString());
        arrays2[2][1]=newa32;
        double  newa33 = Double.parseDouble(a33.getText().toString());
        arrays2[2][2]=newa33;
        double  newa34 = Double.parseDouble(a34.getText().toString());
        arrays2[2][3]=newa34;
        double  newa35 = Double.parseDouble(a35.getText().toString());
        arrays2[2][4]=newa35;
        double  newa36 = Double.parseDouble(a15.getText().toString());
        arrays2[2][5]=newa36;
        double  newa37 = Double.parseDouble(a37.getText().toString());
        arrays2[2][6]=newa37;

        double  newa41 = Double.parseDouble(a41.getText().toString());
        arrays2[3][0]=newa41;
        double  newa42 = Double.parseDouble(a42.getText().toString());
        arrays2[3][1]=newa42;
        double  newa43 = Double.parseDouble(a43.getText().toString());
        arrays2[3][2]=newa43;
        double  newa44 = Double.parseDouble(a44.getText().toString());
        arrays2[3][3]=newa44;
        double  newa45 = Double.parseDouble(a45.getText().toString());
        arrays2[3][4]=newa45;
        double  newa46 = Double.parseDouble(a46.getText().toString());
        arrays2[3][5]=newa46;
        double  newa47 = Double.parseDouble(a47.getText().toString());
        arrays2[3][6]=newa47;

        double  newa51 = Double.parseDouble(a51.getText().toString());
        arrays2[4][0]=newa51;
        double  newa52 = Double.parseDouble(a52.getText().toString());
        arrays2[4][1]=newa52;
        double  newa53 = Double.parseDouble(a53.getText().toString());
        arrays2[4][2]=newa53;
        double  newa54 = Double.parseDouble(a54.getText().toString());
        arrays2[4][3]=newa54;
        double  newa55 = Double.parseDouble(a55.getText().toString());
        arrays2[4][4]=newa55;
        double  newa56 = Double.parseDouble(a56.getText().toString());
        arrays2[4][5]=newa56;
        double  newa57 = Double.parseDouble(a57.getText().toString());
        arrays2[4][6]=newa57;

        double  newa61 = Double.parseDouble(a61.getText().toString());
        arrays2[5][0]=newa61;
        double  newa62 = Double.parseDouble(a62.getText().toString());
        arrays2[5][1]=newa62;
        double  newa63 = Double.parseDouble(a63.getText().toString());
        arrays2[5][2]=newa63;
        double  newa64 = Double.parseDouble(a64.getText().toString());
        arrays2[5][3]=newa64;
        double  newa65 = Double.parseDouble(a65.getText().toString());
        arrays2[5][4]=newa65;
        double  newa66 = Double.parseDouble(a66.getText().toString());
        arrays2[5][5]=newa66;
        double  newa67 = Double.parseDouble(a67.getText().toString());
        arrays2[5][6]=newa67;

        double  newa71 = Double.parseDouble(a71.getText().toString());
        arrays2[6][0]=newa71;
        double  newa72 = Double.parseDouble(a72.getText().toString());
        arrays2[6][1]=newa72;
        double  newa73 = Double.parseDouble(a73.getText().toString());
        arrays2[6][2]=newa73;
        double  newa74 = Double.parseDouble(a74.getText().toString());
        arrays2[6][3]=newa74;
        double  newa75 = Double.parseDouble(a75.getText().toString());
        arrays2[6][4]=newa75;
        double  newa76 = Double.parseDouble(a76.getText().toString());
        arrays2[6][5]=newa76;
        double  newa77 = Double.parseDouble(a77.getText().toString());
        arrays2[6][6]=newa77;

    }



    void  isEmpty2(){

        if (a11.length()==0 || a12.length()==0||a22.length()==0){
            flag=0;
        }
    }
    void isEmpty3(){
        isEmpty2();
        if(a13.length()==0||a23.length()==0||a33.length()==0){
            flag=0;
        }
    }
    void isEmpty4(){
        isEmpty3();
        if(a14.length()==0||a24.length()==0||a34.length()==0||a44.length()==0){
            flag=0;
        }
    }
    void isEmpty5(){
        isEmpty4();
        if(a15.length()==0||a25.length()==0||a35.length()==0||a45.length()==0 ||a55.length()==0){
            flag=0;
        }
    }

    void isEmpty6(){
        isEmpty5();
        if(a16.length()==0||a26.length()==0||a36.length()==0||a46.length()==0 ||a56.length()==0||a66.length()==0){
            flag=0;
        }
    }

    void isEmpty7(){
        isEmpty6();
        if(a17.length()==0||a27.length()==0||a37.length()==0||a47.length()==0 ||a57.length()==0||a67.length()==0||a77.length()==0){
            flag=0;
        }
    }

    void QRDecomposition (double arrays2[][],int m,int n) {
        // Initialize.
        QR=new double[n][m];
        QR = arrays2;
        Rdiag = new double[n];
        for (int k = 0; k < n; k++) {
            // Compute 2-norm of k-th column without under/overflow.
            double nrm = 0;
            for (int i = k; i < m; i++) {
                nrm = Maths.hypot(nrm,QR[i][k]);
            }
            if (nrm != 0.0) {
                // Form k-th Householder vector.
                if (QR[k][k] < 0) {
                    nrm = -nrm;
                }
                for (int i = k; i < m; i++) {
                    QR[i][k] /= nrm;
                }
                QR[k][k] += 1.0;

                // Apply transformation to remaining columns.
                for (int j = k+1; j < n; j++) {
                    double s = 0.0;
                    for (int i = k; i < m; i++) {
                        s += QR[i][k]*QR[i][j];
                    }
                    s = -s/QR[k][k];
                    for (int i = k; i < m; i++) {
                        QR[i][j] += s*QR[i][k];
                    }
                }
            }
            Rdiag[k] = -nrm;
        }
       /* for(int i=0; i<m;i++) {
            for(int j=0; j<n;j++) {
                //String s = String.format("%.3f",QR[i][j]);
              //  QR[i][j] = Double.parseDouble(s);
                result.append(String.valueOf(QR[i][j])+"|");

            }
            result.append("\n");
        }*/
    }
    void  getQ (double arrays2[][],int m,int n) {
         Q =new double[m][n];
        for (int k = n-1; k >= 0; k--) {
            for (int i = 0; i < m; i++) {
                Q[i][k] = 0.0;
            }
            Q[k][k] = 1.0;
            for (int j = k; j < n; j++) {
                if (QR[k][k] != 0) {
                    double s = 0.0;
                    for (int i = k; i < m; i++) {
                        s += QR[i][k]*Q[i][j];
                    }
                    s = -s/QR[k][k];
                    for (int i = k; i < m; i++) {
                        Q[i][j] += s*QR[i][k];
                    }
                }
            }
        }
        result.append("\n");
        result.append("Результаты: Q\n");
        for(int i=0; i<m;i++) {
            for(int j=0; j<n;j++) {

                String s = String.format("%.3f", Q[i][j]*(-1));
                result.append(s+"\t\t");
            }
             result.append("\n");
        }

    }
    void getH ( int m,int n) {

        double[][] H = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= j) {
                    H[i][j] = QR[i][j];
                } else {
                    H[i][j] = 0.0;
                }
            }
        }
       /* result.append("\n");
        result.append("Result H \n");
        for(int i=0; i<m;i++) {
            for(int j=0; j<n;j++) {
                String s = String.format("%.3f", H[i][j]);
                result.append(s+"\t\t");
            }
           result.append("\n");
        }*/

    }
    void getR (int m, int n) {

        R1 = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    R1[i][j] = QR[i][j];
                } else if (i == j) {
                    R1[i][j] = Rdiag[i];
                } else {
                    R1[i][j] = 0.0;
                }
            }
        }
        result.append("\n");
        result.append("Результат: R\n");
        for(int i=0; i<m;i++) {
            for(int j=0; j<n;j++) {
                String s = String.format("%.2f", R1[i][j]*(-1));
                result.append(s+"\t\t");
            }
            result.append("\n");
        }
    }

    void solve (double [][]array, int  m,int n) {
        X=new double[n][m];
        result.append("\n");
        result.append("Результаты: R*Q\n");
        String s = null;
        for(int i=0; i<m;i++) {
            for(int j=0; j<n;j++) {
                for(int k=0;k<n;k++){
                    X[i][j]+=R1[i][k]*(-1)*Q[k][j]*(-1);
                 s = String.format("%.2f", X[i][j]);
                }
                result.append(s+"\t\t");
            }
            result.append("\n");
        }
    Double s1;
        result.append("Собственное значение: \n");
        for(int i=0; i<m;i++) {
            for(int j=0; j<n;j++) {
                if(i!=j){
                    if(X[i][j]>= EPSILON){
                        Yes=false;
                    }else{
                        Yes=true;
                    } }
               else{
                s1 = X[i][j];
                result.append(Math.round(s1)+"\n");
                }
            }
        }
    }

    void computeVV(int m,int n){
        while (!Yes){
            QRDecomposition(X,m,n);
            getQ(X,m,n);
            getR(m,n);
            solve(X,m,n);
        }
    }


    public void onClickbtn(View view) {
        if(view.getId()==R.id.cleanup){
            clean();
        }
    }
}


