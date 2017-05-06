package com.example.arqdsis.prova;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by heitor on 05/05/2017.
 * Metodo para popular as lists dos paises
 */
public class PaisesAdapter {

    Paises[] paises;
    Activity context;

    public PaisesAdapter(Activity context, Paises[] clientes) {
        this.context = context;
        this.paises = paises;
    }

    @Override
    public int getCount() {
        return paises.length;
    }

    @Override
    public Object getItem(int i) {
        if (i >= 0 && i < paises.length) {
            return paises[i];
        }
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View viewReciclada, ViewGroup viewGroup) {
        View view = viewReciclada;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_cliente, viewGroup, false);

            ImageView imagemban = (ImageView) view.findViewById(R.id.imagem_ban);
            TextView nomedopais = (TextView) view.findViewById(R.id.nomedopais);
            TextView area = (TextView) view.findViewById(R.id.area);
            TextView populacao = (TextView) view.findViewById(R.id.populacao);
            TextView moedas = (TextView) view.findViewById(R.id.moedas);
            //faz cache dos widgets na tagView para usar quando usar quando houver reciclagem
            view.setTag(new ViewHolder(fotoCliente, nomeCliente, detalheCliente));
        }
        //usar os widgets cacheados na tag da view reciclado
        ViewHolder holder = (ViewHolder) view.getTag();
        //carrega os novos valores
        Drawable foto = Imagem.getDrawable(context);
        holder.getImagemban().setImageDrawable(foto);
        holder.getNomedopais().setText(clientes[i].getNome());
        holder.getArea().setText(clientes[i].getFone() + "  -  " + clientes[i].getEmail());

        return view;
    }

}
