/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author SUPPER LOQ
 */
public class RoomDTO {

    private int roomId;
    private int cinemaId;
    private String name;
    private int capacity;

    public RoomDTO() {
    }

    public RoomDTO(int roomId, int cinemaId, String name, int capacity) {
        this.roomId = roomId;
        this.cinemaId = cinemaId;
        this.name = name;
        this.capacity = capacity;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "RoomDTO{" + "roomId=" + roomId + ", cinemaId=" + cinemaId + ", name=" + name + ", capacity=" + capacity + '}';
    }
}
