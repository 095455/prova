package com.example.arqdsis.prova;

import java.io.Serializable;

/**
 * Created by heitor on 05/05/2017.
 * Definição dos campos de cada pais
 */
public class Paises  implements Serializable, Comparable<Paises> {
    private Integer id;
    private String nomedopais;
    private String imagemban;
    private String area;
    private String populacao;
    private String moedas;

    public Paises(Integer id, String nomedopais, String imagemban, String area, String populacao, String moedas) {
        this.id = id;
        this.nomedopais = nomedopais;
        this.imagemban = imagemban;
        this.area = area;
        this.populacao = populacao;
        this.moedas = moedas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomedopais() {
        return nomedopais;
    }

    public void setNomedopais(String nomedopais) {
        this.nomedopais = nomedopais;
    }

    public String getImagemban() {
        return imagemban;
    }

    public void setImagemban(String imagemban) {
        this.imagemban = imagemban;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getImagem() {
        String foto = this.imagemban.replace('@', '_');
        return foto.replace('.', '_');
    }

    @Override
    public int compareTo(Paises paises) {
        return 0;
    }
}