package mz123;

import java.sql.*;

public class TestBazy {

    public static void main(String[] args) {


        System.out.println("Test");
        try {
            Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("select * from mztest");

            while (res.next()) {
                int id = res.getInt("ID");
                String name = res.getString("NAME");
                String desc = res.getString("DESC");
                System.out.println("" + id + " " + name + " " + desc);
            }
            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //test wątków
        for (int i = 0; i < 10; i++) {
            CountingThread ct = new CountingThread();
            ct.start();
        }

    }
}
