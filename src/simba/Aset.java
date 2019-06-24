/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simba;

/**
 *
 * @author aria
 */
class Aset {
    String nama;
    String jml;
    String nilai;
    String kondisi;
    String id;

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJml(String jml) {
        this.jml = jml;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getNama() {
        return nama;
    }

    public String getJml() {
        return jml;
    }

    public String getNilai() {
        return nilai;
    }

    public String getKondisi() {
        return kondisi;
    }

    public String getId() {
        return id;
    }
    
}
