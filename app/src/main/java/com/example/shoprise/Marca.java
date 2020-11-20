package com.example.shoprise;

public class Marca {

    private static String marcaNombre;
    private Integer marcaImage;

    public Marca( Integer marcaImage , String marcaNombre) {

        this.marcaImage = marcaImage;
        this.marcaNombre = marcaNombre;
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

    public void setMarcaNombre(String marcaNombre) {
        this.marcaNombre = marcaNombre;
    }
}

