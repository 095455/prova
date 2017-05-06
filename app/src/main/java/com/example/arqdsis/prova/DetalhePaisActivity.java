package com.example.arqdsis.prova;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by heitor on 05/05/2017.
 * Métodos para setar as textviews e carregar a imagem da bandeira do pais selecionado
 */
public class DetalhePaisActivity {
    TextView textViewNome, textViewEmail, textViewFone;
    ImageView imagemCliente;
    PaisesRequester clienteRequester;
    Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detallhe_cliente);
        textViewNomedopais = (TextView) findViewById(R.id.txt_noemdopais);
        textViewImagemban = (TextView) findViewById(R.id.txt_imagemban);
        textViewArea = (TextView) findViewById(R.id.txt_area);
        textViewPopulacao = (ImageView) findViewById(R.id.txt.populacao);
        Intent intent = getIntent();
        cliente = (Cliente) intent.getSerializableExtra(ListarClientesActivity.CLIENTE);

        textViewNomedopais.setText(paises.getNomedopais());
        textViewArea.setText(paises.getArea());
        textViewPopulacao.setText(paises.getPopulacao());

        clienteRequester = new ClienteRequester();

        new DownloadImage().execute(MainActivity.SERVIDOR
                + MainActivity.APPSTRING
                + "/img/" + cliente.getImagem()+".jpg");

    }

    private class DownloadImage extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                return clienteRequester.getImage(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        public void onPostExecute(Bitmap result) {
            imagemCliente.setImageBitmap(result);
        }
    }
}
