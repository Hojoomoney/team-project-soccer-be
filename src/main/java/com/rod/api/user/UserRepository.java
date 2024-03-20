package com.rod.api.user;

import com.rod.api.enums.Messenger;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    private UserRepository() throws SQLException {
        conn = null;
        pstmt = null;
        rs = null;
    }

    public List<User> findAll() throws SQLException {
        List<User> members = new ArrayList<>();
        String sql = "select * from members";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        if (rs.next()){
            do{
                members.add(User.builder()
                        .username(rs.getString("username"))
                        .password(rs.getString("password"))
                        .name(rs.getString("name"))
                        .phone(rs.getString("phone"))
                        .job(rs.getString("job"))
                        .height(rs.getString("height"))
                        .weight(rs.getString("weight"))
                        .build());
            }while(rs.next());

        } else {
            System.out.println("데이터가 없습니다.");
        }

        return members;
    }

    public Messenger createMemberTable() throws SQLException {
        String sql = "CREATE TABLE Members (\n" +
                "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    username VARCHAR(20) NOT NULL,\n" +
                "    password VARCHAR(20) NOT NULL,\n" +
                "    name VARCHAR(20),\n" +
                "    phone VARCHAR(20),\n" +
                "    job VARCHAR(20),\n" +
                "    height VARCHAR(20),\n" +
                "    weight VARCHAR(20)\n" +
                ")";
        pstmt = conn.prepareStatement(sql);
        return (pstmt.executeUpdate() == 0) ? Messenger.SUCCESS : Messenger.FAIL ;
    }

    public String deleteMemberTable() throws SQLException {
        String sql = "DROP TABLE Members";
        pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate();
        return "회원테이블 삭제 성공";
    }

    public Messenger save(User user) throws SQLException {
        String sql = "INSERT INTO Members (username, password, name, phone, job, height, weight)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,user.getUsername());
        pstmt.setString(2,user.getPassword());
        pstmt.setString(3,user.getName());
        pstmt.setString(4,user.getPhone());
        pstmt.setString(5,user.getJob());
        pstmt.setString(6,user.getHeight());
        pstmt.setString(7,user.getWeight());
        return (pstmt.executeUpdate() > 0) ? Messenger.SUCCESS : Messenger.FAIL;
    }
}
