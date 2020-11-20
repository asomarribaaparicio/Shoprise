package com.example.shoprise;

public class Marca {

    private static String marcaNombre;
    private Integer marcaImage;
    private static String marcaUrl;

    public Marca( Integer marcaImage , String marcaNombre, String marcaUrl) {

        this.marcaImage = marcaImage;
        this.marcaNombre = marcaNombre;
        this.marcaUrl = marcaUrl;
    }


    public Integer getMarcaImage() {
        return marcaImage;
    }

    public void setMarcaImage(Integer marcaImage) {
        this.marcaImage = marcaImage;
    }

    public static String getMarcaNombre() {
        return marcaNombre;
    }

    public void setMarcaNombre(String marcaNombre) { this.marcaNombre = marcaNombre; }

    public static String getMarcaUrl() {return marcaUrl;}

    public void setMarcaUrl(String marcaUrl) {this.marcaUrl = marcaUrl; }


}

