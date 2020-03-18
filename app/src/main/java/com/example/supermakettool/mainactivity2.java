package com.example.supermakettool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

public class mainactivity2 extends AppCompatActivity {

    RecyclerView recycler;
        RecyclerView.Adapter adap;
        ArrayList<Canasta> listaCard;


        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_canasta);

            /*
            recycler=(RecyclerView)findViewById(R.id.recycler);
            recycler.setHasFixedSize(true);
            recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

            Thread tr=new Thread()
            {
                @Override
                public void run() {

                    String NAMESPACE="http://tempuri.org/";
                    String URL="http://10.0.0.12/Publicaciones/WebServiceCarrito.asmx";
                    String METHOD_NAME="listarProductos";
                    String SOAP_ACTION="http://tempuri.org/listarProductos";

                    SoapObject request=new SoapObject(NAMESPACE,METHOD_NAME);

                    SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
                    envelope.dotNet=true;
                    envelope.setOutputSoapObject(request);
                    HttpTransportSE transporte=new HttpTransportSE(URL);

                    try
                    {
                        transporte.call(SOAP_ACTION,envelope);
                        final SoapObject soap=(SoapObject)envelope.getResponse();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                listarProductos(soap);
                            }
                        });
                    }catch (Exception e)
                    {

                    }

                }
            };
            tr.start();
            */


        }

        public void listarProductos(SoapObject soap)
        {
            listaCard=new ArrayList<Canasta>();
            for (int i=0;i<soap.getPropertyCount();i++)
            {
                SoapObject reg=(SoapObject)soap.getProperty(i);
                Canasta e1=new Canasta(reg.getProperty(0).toString(),reg.getProperty(1).toString(),reg.getProperty(3).toString(),Double.parseDouble(reg.getProperty(4).toString()),reg.getProperty(5).toString());


                listaCard.add(e1);
            }
            adap=new Adaptador(listaCard,getApplication());
            recycler.setAdapter(adap);
        }

}
