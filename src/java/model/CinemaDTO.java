/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author SUPPER LOQ
 */
public class CinemaDTO {

    private int cinemaId;
    private String name;
    private String address;
    private String city;
    private String phone;

    public CinemaDTO() {
    }

    public CinemaDTO(int cinemaId, String name, String address, String city, String phone) {
        this.cinemaId = cinemaId;
        this.name = name;
        this.address = address;
        this.city = city;
        this.phone = phone;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "CinemaDTO{" + "cinemaId=" + cinemaId + ", name=" + name + ", address=" + address + ", city=" + city + ", phone=" + phone + '}';
    }
}
