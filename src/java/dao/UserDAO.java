/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.UserDTO;
import utils.DbUtils;

/**
 *
 * @author SUPPER LOQ
 */
public class UserDAO {

    private static final String LOGIN_USER = "SELECT * FROM Users WHERE email = ? AND password = ?";
    private static final String GET_ALL_USERS = "SELECT * FROM Users";
    private static final String GET_USER_BY_EMAIL = "SELECT user_id, name, role_id FROM Users WHERE email = ?";
    private static final String REGISTER_USER = "INSERT INTO Users (name, email, password, phone, role_id) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_PROFILE = "UPDATE Users SET name = ?, password = ?, phone = ?, role_id = ? WHERE email = ?";
    private static final String DELETE_USER = "DELETE FROM Users WHERE user_id = ?";

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public UserDAO() {
    }

    public boolean login(String username, String password) {
        try {
            UserDTO user = getUserByUsername(username);
            if (user != null) {
                if (user.getPassword().equals(password)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    // register
    public boolean register(UserDTO user) {
        try {
            conn = DbUtils.getConnection();
            ps = conn.prepareStatement(REGISTER_USER);

            ps.setString(1, user.getName());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public UserDTO getUserByUsername(String username) {
        String sql = LOGIN_USER;
        try {
            conn = DbUtils.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            rs = ps.executeQuery();

            while (rs.next()) {
                UserDTO user = new UserDTO();
                user.setName(rs.getString(1));
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));

                return user;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return null;
    }

    // get all user
    public List<UserDTO> getAllUser() {
        List<UserDTO> list = new ArrayList<>();

        try {
            conn = DbUtils.getConnection();
            ps = conn.prepareStatement(GET_ALL_USERS);
            rs = ps.executeQuery();

            while (rs.next()) {
                UserDTO user = new UserDTO();
                user.setName(rs.getString(1));
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));
                list.add(user);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public boolean updatePassword(String username, String newPass) {
        String sql = "UPDATE tblUsers SET Password = ? WHERE Username = ?";
        try {
            conn = DbUtils.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, newPass);
            ps.setString(2, username);

            return (ps.executeUpdate() > 0);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            closeResources(conn, ps, rs);
        }
    }

    // đòng conn, ps, rs
    private void closeResources(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
