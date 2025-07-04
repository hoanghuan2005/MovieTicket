/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author SUPPER LOQ
 */
public class SeatDTO {

    private int seatId;
    private int roomId;
    private char seatRow;
    private int seatNumber;
    private String seatType;

    public SeatDTO() {
    }

    public SeatDTO(int seatId, int roomId, char seatRow, int seatNumber, String seatType) {
        this.seatId = seatId;
        this.roomId = roomId;
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public char getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(char seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    @Override
    public String toString() {
        return "SeatDTO{" + "seatId=" + seatId + ", roomId=" + roomId + ", seatRow=" + seatRow + ", seatNumber=" + seatNumber + ", seatType=" + seatType + '}';
    }
}
