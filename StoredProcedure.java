package sample;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class StoredProcedure {
    /**
     * 1 user_login
     *
     * @param conn       conn the current database that is using, for this case is always team32
     * @param i_username i_username the user name that we want to type in
     * @param i_password i_password the password that we want to type in
     * @return the result set from table UserLogin
     * @throws java.sql.SQLException throw java.sql.SQLException
     */
    public ResultSet user_login(Connection conn, String i_username, String i_password) throws java.sql.SQLException {

        Statement st = conn.createStatement();

        if (i_username != null) {
            i_username = new String("\"" + i_username + "\"");
        }

        if (i_password != null) {
            i_password = new String("\"" + i_password + "\"");
        }

        String sql1 = new String("call team32.user_login(" +
                i_username + "," + i_password +
                ");");

        st.executeQuery(sql1);

        String sql2 = new String("SELECT * FROM team32.UserLogin;");
        ResultSet rs = st.executeQuery(sql2);
        return rs;
    }

    /**
     * 3 user_register
     *
     * @param conn        conn the current database that is using, for this case is always team32
     * @param i_username  i_username the user name that we want to type in
     * @param i_password  i_password the password that we want to type in
     * @param i_firstname i_firstname
     * @param i_lastname  i_lastname
     * @throws java.sql.SQLException throw java.sql.SQLException
     */
    public void user_register(Connection conn, String i_username, String i_password, String i_firstname, String i_lastname) throws java.sql.SQLException {

        Statement st = conn.createStatement();

        if (i_username != null) {
            i_username = new String("\"" + i_username + "\"");
        }

        if (i_password != null) {
            i_password = new String("\"" + i_password + "\"");
        }

        if (i_firstname != null) {
            i_firstname = new String("\"" + i_firstname + "\"");
        }

        if (i_lastname != null) {
            i_lastname = new String("\"" + i_lastname + "\"");
        }

        String sql1 = new String("call team32.user_register(" +
                i_username + "," + i_password + "," + i_firstname + "," + i_lastname +
                ");");


        st.executeQuery(sql1);

    }

    /**
     * 4 customer_only_register
     *
     * @param conn        conn the current database that is using, for this case is always team32
     * @param i_username  i_username the user name that we want to type in
     * @param i_password  i_password the password that we want to type in
     * @param i_firstname i_firstname
     * @param i_lastname  i_lastname
     * @throws java.sql.SQLException throw java.sql.SQLException
     */
    public void customer_only_register(Connection conn, String i_username, String i_password, String i_firstname, String i_lastname) throws java.sql.SQLException {

        Statement st = conn.createStatement();

        if (i_username != null) {
            i_username = new String("\"" + i_username + "\"");
        }

        if (i_password != null) {
            i_password = new String("\"" + i_password + "\"");
        }

        if (i_firstname != null) {
            i_firstname = new String("\"" + i_firstname + "\"");
        }

        if (i_lastname != null) {
            i_lastname = new String("\"" + i_lastname + "\"");
        }

        String sql1 = new String("call team32.customer_only_register(" +
                i_username + "," + i_password + "," + i_firstname + "," + i_lastname +
                ");");

        st.executeQuery(sql1);

    }

    /**
     * 4 customer_add_credit_card
     *
     * @param conn            conn the current database that is using, for this case is always team32
     * @param i_username      i_username the user name that we want to type in
     * @param i_creditCardNum i_creditCardNum the user name that we want to type in
     * @throws java.sql.SQLException throw java.sql.SQLException
     */
    public void customer_add_credit_card(Connection conn, String i_username, String i_creditCardNum) throws java.sql.SQLException {

        Statement st = conn.createStatement();

        if (i_username != null) {
            i_username = new String("\"" + i_username + "\"");
        }
        if (i_creditCardNum != null) {
            i_creditCardNum = new String("\"" + i_creditCardNum + "\"");
        }

        String sql1 = new String("call team32.customer_add_creditcard(" +
                i_username + "," + i_creditCardNum +
                ");");

        st.executeQuery(sql1);

    }

    /**
     * 5 manager_only _register
     *
     * @param conn         conn the current database that is using, for this case is always team32
     * @param i_username   i_username the user name that we want to type in
     * @param i_password   i_password the password that we want to type in
     * @param i_firstname  i_firstname
     * @param i_lastname   i_lastname
     * @param i_comName    i_comName
     * @param i_empStreet  i_empStreet
     * @param i_empCity    i_empCity
     * @param i_empState   i_empState
     * @param i_empZipcode i_empZipcode
     * @throws java.sql.SQLException throw java.sql.SQLException
     */
    public void manager_only_register(Connection conn, String i_username, String i_password, String i_firstname, String i_lastname, String i_comName, String i_empStreet, String i_empCity, String i_empState, String i_empZipcode) throws java.sql.SQLException {

        Statement st = conn.createStatement();

        if (i_username != null) {
            i_username = new String("\"" + i_username + "\"");
        }
        if (i_password != null) {
            i_password = new String("\"" + i_password + "\"");
        }
        if (i_firstname != null) {
            i_firstname = new String("\"" + i_firstname + "\"");
        }
        if (i_lastname != null) {
            i_lastname = new String("\"" + i_lastname + "\"");
        }
        if (i_comName != null) {
            i_comName = new String("\"" + i_comName + "\"");
        }
        if (i_empStreet != null) {
            i_empStreet = new String("\"" + i_empStreet + "\"");
        }
        if (i_empCity != null) {
            i_empCity = new String("\"" + i_empCity + "\"");
        }
        if (i_empState != null) {
            i_empState = new String("\"" + i_empState + "\"");
        }
        if (i_empZipcode != null) {
            i_empZipcode = new String("\"" + i_empZipcode + "\"");
        }

        String sql1 = new String("call team32.manager_only_register(" +
                i_username + "," + i_password + "," + i_firstname + "," + i_lastname + "," + i_comName + "," + i_empStreet + "," + i_empCity + "," + i_empState + "," + i_empZipcode +
                ");");
        System.out.println(sql1);
        st.executeQuery(sql1);

    }

    /**
     * 6 manager_customer_register
     *
     * @param conn         conn the current database that is using, for this case is always team32
     * @param i_username   i_username the user name that we want to type in
     * @param i_password   i_password the password that we want to type in
     * @param i_firstname  i_firstname
     * @param i_lastname   i_lastname
     * @param i_comName    i_comName
     * @param i_empStreet  i_empStreet
     * @param i_empCity    i_empCity
     * @param i_empState   i_empState
     * @param i_empZipcode i_empZipcode
     * @throws java.sql.SQLException throw java.sql.SQLException
     */
    public void manager_customer_register(Connection conn, String i_username, String i_password, String i_firstname, String i_lastname, String i_comName, String i_empStreet, String i_empCity, String i_empState, String i_empZipcode) throws java.sql.SQLException {

        Statement st = conn.createStatement();

        if (i_username != null) {
            i_username = new String("\"" + i_username + "\"");
        }
        if (i_password != null) {
            i_password = new String("\"" + i_password + "\"");
        }
        if (i_firstname != null) {
            i_firstname = new String("\"" + i_firstname + "\"");
        }
        if (i_lastname != null) {
            i_lastname = new String("\"" + i_lastname + "\"");
        }
        if (i_comName != null) {
            i_comName = new String("\"" + i_comName + "\"");
        }
        if (i_empStreet != null) {
            i_empStreet = new String("\"" + i_empStreet + "\"");
        }
        if (i_empCity != null) {
            i_empCity = new String("\"" + i_empCity + "\"");
        }
        if (i_empState != null) {
            i_empState = new String("\"" + i_empState + "\"");
        }
        if (i_empZipcode != null) {
            i_empZipcode = new String("\"" + i_empZipcode + "\"");
        }

        String sql1 = new String("call team32.manager_customer_register(" +
                i_username + "," + i_password + "," + i_firstname + "," + i_lastname + "," + i_comName + "," + i_empStreet + "," + i_empCity + "," + i_empState + "," + i_empZipcode +
                ");");
        System.out.println(sql1);
        st.executeQuery(sql1);

    }

    /**
     * 6 Manager-Customer add credit card
     *
     * @param conn            conn the current database that is using, for this case is always team32
     * @param i_username      i_username the user name that we want to type in
     * @param i_creditCardNum i_creditCardNum the user name that we want to type in
     * @throws java.sql.SQLException throw java.sql.SQLException
     */
    public void manager_customer_add_creditcard(Connection conn, String i_username, String i_creditCardNum) throws java.sql.SQLException {

        Statement st = conn.createStatement();
        if (i_username != null) {
            i_username = new String("\"" + i_username + "\"");
        }
        if (i_creditCardNum != null) {
            i_creditCardNum = new String("\"" + i_creditCardNum + "\"");
        }

        String sql1 = new String("call team32.manager_customer_add_credictcard(" +
                i_username + "," + i_creditCardNum +
                ");");
        System.out.println(sql1);
        st.executeQuery(sql1);

    }

    /**
     * 13a admin_approve_user
     *
     * @param conn       conn the current database that is using, for this case is always team32
     * @param i_username i_username the user name that we want to type in
     * @throws java.sql.SQLException throw java.sql.SQLException
     */
    public void admin_approve_user(Connection conn, String i_username) throws java.sql.SQLException {

        Statement st = conn.createStatement();

        if (i_username != null) {
            i_username = new String("\"" + i_username + "\"");
        }

        String sql1 = new String("call team32.admin_approve_user(" +
                i_username +
                ");");

        st.executeQuery(sql1);

    }

    /**
     * 13b admin_decline_user
     *
     * @param conn       conn the current database that is using, for this case is always team32
     * @param i_username i_username the user name that we want to type in
     * @throws java.sql.SQLException throw java.sql.SQLException
     */
    public void admin_decline_user(Connection conn, String i_username) throws java.sql.SQLException {

        Statement st = conn.createStatement();

        if (i_username != null) {
            i_username = new String("\"" + i_username + "\"");
        }

        String sql1 = new String("call team32.admin_decline_user(" +
                i_username +
                ");");

        st.executeQuery(sql1);

    }

    /**
     * 13c admin_filter_user
     *
     * @param conn            conn the current database that is using, for this case is always team32
     * @param i_username      i_username the user username
     * @param i_status        i_status the user status
     * @param i_sortBy        i_sortBy the category that we want to see
     * @param i_sortDirection i_sortDirection the direction that we want to see
     * @return the result set from table AdFilterUser
     * @throws java.sql.SQLException throw java.sql.SQLException
     */
    public ResultSet admin_filter_user(Connection conn, String i_username, String i_status, String i_sortBy, String i_sortDirection) throws java.sql.SQLException {

        Statement st = conn.createStatement();

        if (i_username != null) {
            i_username = new String("\"" + i_username + "\"");
        }
        if (i_status != null) {
            i_status = new String("\"" + i_status + "\"");
        }
        if (i_sortBy != null) {
            i_sortBy = new String("\"" + i_sortBy + "\"");
        }
        if (i_sortDirection != null) {
            i_sortDirection = new String("\"" + i_sortDirection + "\"");
        }

        String sql1 = new String("call team32.admin_filter_user(" +
                i_username + "," + i_status + "," + i_sortBy + "," + i_sortDirection +
                ");");

        st.executeQuery(sql1);

        String sql2 = new String("SELECT * FROM team32.AdFilterUser;");
        ResultSet rs = st.executeQuery(sql2);
        return rs;
    }

    /**
     * 14 admin_filter_company
     *
     * @param conn            conn the current database that is using, for this case is always team32
     * @param i_comName       i_comName the company username
     * @param i_minCity       i_minCity the mininum number of cities
     * @param i_maxCity       i_mii_maxCity the maximum number of cities
     * @param i_minTheater    i_minTheater the mininum number of theaters
     * @param i_maxTheater    i_maxTheater the maximum number of theaters
     * @param i_minEmployee   i_minEmployee the mininum number of employees
     * @param i_maxEmployee   i_maxEmployee maximum number of employees
     * @param i_sortBy        i_sortBy the category that we want to see
     * @param i_sortDirection i_sortDirection the direction that we want to see
     * @return the result set from table AdFilterCom
     * @throws java.sql.SQLException throw java.sql.SQLException
     */
    public ResultSet admin_filter_company(Connection conn, String i_comName, String i_minCity, String i_maxCity, String i_minTheater, String i_maxTheater, String i_minEmployee, String i_maxEmployee, String i_sortBy, String i_sortDirection) throws java.sql.SQLException {

        Statement st = conn.createStatement();
        if (i_comName != null) {
            i_comName = new String("\"" + i_comName + "\"");
        }
        if (i_sortBy != null) {
            i_sortBy = new String("\"" + i_sortBy + "\"");
        }
        if (i_sortDirection != null) {
            i_sortDirection = new String("\"" + i_sortDirection + "\"");
        }
        if (i_minCity.equals("")) {
            i_minCity = new String("null");
        }
        if (i_maxCity.equals("")) {
            i_maxCity = new String("null");
        }
        if (i_minTheater.equals("")) {
            i_minTheater = new String("null");
        }
        if (i_maxTheater.equals("")) {
            i_maxTheater = new String("null");
        }
        if (i_minEmployee.equals("")) {
            i_minEmployee = new String("null");
        }
        if (i_maxEmployee.equals("")) {
            i_maxEmployee = new String("null");
        }
        String sql1 = new String("call team32.admin_filter_company(" +
                i_comName + "," + i_minCity + "," + i_maxCity + "," + i_minTheater + "," + i_maxTheater + "," + i_minEmployee + "," + i_maxEmployee + "," + i_sortBy + "," + i_sortDirection +
                ");");
        System.out.println(sql1);
        st.executeQuery(sql1);

        String sql2 = new String("SELECT * FROM team32.AdFilterCom;");
        ResultSet rs = st.executeQuery(sql2);
        return rs;
    }

    /**
     * 15 admin_create_theater
     *
     * @param conn              conn the current database that is using, for this case is always team32
     * @param i_thName          theater name
     * @param i_comName         company name
     * @param i_thStreet        theater street
     * @param i_thCity          theater city
     * @param i_thState         theater state
     * @param i_thZipcode       theater zipcode
     * @param i_capacity        theater capacity
     * @param i_managerUsername the manager's username of the theater
     * @throws java.sql.SQLException throw exception
     */
    public void admin_create_theater(Connection conn, String i_thName, String i_comName, String i_thStreet, String i_thCity, String i_thState, String i_thZipcode, String i_capacity, String i_managerUsername) throws java.sql.SQLException {
        Statement st = conn.createStatement();
        if (i_thName != null) {
            i_thName = new String("\"" + i_thName + "\"");
        }
        if (i_comName != null) {
            i_comName = new String("\"" + i_comName + "\"");
        }
        if (i_thStreet != null) {
            i_thStreet = new String("\"" + i_thStreet + "\"");
        }
        if (i_thCity != null) {
            i_thCity = new String("\"" + i_thCity + "\"");
        }
        if (i_thState != null) {
            i_thState = new String("\"" + i_thState + "\"");
        }
        if (i_thZipcode != null) {
            i_thZipcode = new String("\"" + i_thZipcode + "\"");
        }
        // i_capacity is int, so no not need a ""
        if (i_managerUsername != null) {
            i_managerUsername = new String("\"" + i_managerUsername + "\"");
        }
        String sql1 = new String("call team32.admin_create_theater(" +
                i_thName + "," + i_comName + "," + i_thStreet + "," + i_thCity + "," + i_thState + "," + i_thZipcode + "," + i_capacity + "," + i_managerUsername + ");");
        System.out.println(sql1);
        st.executeQuery(sql1);
    }


    /**
     * 16a admin_view_comDetail_emp
     *
     * @param conn      conn the current database that is using, for this case is always team32
     * @param i_comName i_comName the company name that we want
     * @return the result set from table AdComDetailEmp
     * @throws java.sql.SQLException throw java.sql.SQLException
     */
    public ResultSet admin_view_comDetail_emp(Connection conn, String i_comName) throws java.sql.SQLException {

        Statement st = conn.createStatement();
        if (i_comName != null) {
            i_comName = new String("\"" + i_comName + "\"");
        }
        String sql1 = new String("call team32.admin_view_comDetail_emp(" +
                i_comName +
                ");");

        st.executeQuery(sql1);

        String sql2 = new String("SELECT * FROM team32.AdComDetailEmp;");
        ResultSet rs = st.executeQuery(sql2);
        return rs;
    }

    /**
     * 16b admin_view_comDetail_th
     *
     * @param conn      conn the current database that is using, for this case is always team32
     * @param i_comName i_comName the company name that we want
     * @return the result set from table AdComDetailTh
     * @throws java.sql.SQLException throw java.sql.SQLException
     */
    public ResultSet admin_view_comDetail_th(Connection conn, String i_comName) throws java.sql.SQLException {

        Statement st = conn.createStatement();
        if (i_comName != null) {
            i_comName = new String("\"" + i_comName + "\"");
        }
        String sql1 = new String("call team32.admin_view_comDetail_th(" +
                i_comName +
                ");");

        st.executeQuery(sql1);

        String sql2 = new String("SELECT * FROM team32.AdComDetailTh;");
        ResultSet rs = st.executeQuery(sql2);
        return rs;
    }

    /**
     * 17 admin_create_mov
     *
     * @param conn          database
     * @param i_movName     the movie name
     * @param i_movDuration the movie duration
     * @param i_movRelease  the movie release data
     * @throws java.sql.SQLException
     */
    public void admin_create_mov(Connection conn, String i_movName, int i_movDuration, String i_movRelease) throws java.sql.SQLException {
        Statement st = conn.createStatement();
        if (i_movName != null) {
            i_movName = new String("\"" + i_movName + "\"");
        }
        if (i_movRelease != null) {
            i_movRelease = new String("\"" + i_movRelease + "\"");
        }
        String sql1 = new String("call team32.admin_create_mov(" +
                i_movName + "," + i_movDuration + "," + i_movRelease +
                ");");
        //System.out.println(sql1);
        st.executeQuery(sql1);
    }

    /**
     * 18 manager_filter_th
     *
     * @param conn                database
     * @param i_manUsername       manage username
     * @param i_movName           movie name
     * @param i_minMovDuration    min
     * @param i_maxMovDuration    max
     * @param i_minMovReleaseDate min
     * @param i_maxMovReleaseDate max
     * @param i_minMovPlayDate    min
     * @param i_maxMovPlayDate    max
     * @param i_includeNotPlayed  this is a boolean
     * @return
     * @throws java.sql.SQLException
     */
    public ResultSet manager_filter_th(Connection conn, String i_manUsername, String i_movName, String i_minMovDuration, String i_maxMovDuration, String i_minMovReleaseDate, String i_maxMovReleaseDate, String i_minMovPlayDate, String i_maxMovPlayDate, String i_includeNotPlayed) throws java.sql.SQLException {
        Statement st = conn.createStatement();
        if (i_manUsername != null) {
            i_manUsername = new String("\"" + i_manUsername + "\"");
        }
        if (i_movName != null) {
            i_movName = new String("\"" + i_movName + "\"");
        }
        if (i_minMovDuration.equals("")) {
            i_minMovDuration = new String("null");
        }
        if (i_maxMovDuration.equals("")) {
            i_maxMovDuration = new String("null");
        }
        if (!i_minMovReleaseDate.equals("null")) {
            i_minMovReleaseDate = new String("\"" + i_minMovReleaseDate + "\"");
        }
        if (!i_maxMovReleaseDate.equals("null")) {
            i_maxMovReleaseDate = new String("\"" + i_maxMovReleaseDate + "\"");
        }
        if (!i_minMovPlayDate.equals("null")) {
            i_minMovPlayDate = new String("\"" + i_minMovPlayDate + "\"");
        }
        if (!i_maxMovPlayDate.equals("null")) {
            i_maxMovPlayDate = new String("\"" + i_maxMovPlayDate + "\"");
        }
        String sql1 = new String("call team32.manager_filter_th(" +
                i_manUsername + ", " + i_movName + "," + i_minMovDuration + "," + i_maxMovDuration + "," + i_minMovReleaseDate + "," + i_maxMovReleaseDate + "," + i_minMovPlayDate + "," + i_maxMovPlayDate + "," + i_includeNotPlayed +
                ");");

        System.out.println(sql1);
        st.executeQuery(sql1);

        System.out.println(sql1);


        String sql2 = new String("SELECT * FROM team32.manFilterTh;");
        ResultSet rs = st.executeQuery(sql2);
        return rs;
    }

    /**
     * 19 manager_schedule_mov
     *
     * @param conn             the database
     * @param i_manUsername    the manager user name
     * @param i_movName        the movie name
     * @param i_movReleaseDate the movie release date
     * @param i_movPlayDate    the movie play date
     * @throws java.sql.SQLException throws
     */
    public void manager_schedule_mov(Connection conn, String i_manUsername, String i_movName, String i_movReleaseDate, String i_movPlayDate) throws java.sql.SQLException {
        Statement st = conn.createStatement();
        if (i_manUsername != null) {
            i_manUsername = new String("\"" + i_manUsername + "\"");
        }
        if (i_movName != null) {
            i_movName = new String("\"" + i_movName + "\"");
        }
        if (i_movReleaseDate != null) {
            i_movReleaseDate = new String("\"" + i_movReleaseDate + "\"");
        }
        if (i_movPlayDate != null) {
            i_movPlayDate = new String("\"" + i_movPlayDate + "\"");
        }

        String sql1 = new String("call team32.manager_schedule_mov(" +
                i_manUsername + "," + i_movName + "," + i_movReleaseDate + "," + i_movPlayDate +
                ");");
        System.out.println(sql1);
        st.executeQuery(sql1);
    }

    /**
     * 20a customer_filter_mov
     *
     * @param conn             the database
     * @param i_movName        movie name
     * @param i_comName        company name
     * @param i_city           city
     * @param i_state          state
     * @param i_minMovPlayDate min
     * @param i_maxMovPlayDate max
     * @return cosFilterMovie
     * @throws java.sql.SQLException throws
     */
    public ResultSet customer_filter_mov(Connection conn, String i_movName, String i_comName, String i_city, String i_state, String i_minMovPlayDate, String i_maxMovPlayDate) throws java.sql.SQLException {
        Statement st = conn.createStatement();
        if (i_movName != null) {
            i_movName = new String("\"" + i_movName + "\"");
        }
        if (i_comName != null) {
            i_comName = new String("\"" + i_comName + "\"");
        }
        if (i_city != null) {
            i_city = new String("\"" + i_city + "\"");
        }
        if (i_state != null) {
            i_state = new String("\"" + i_state + "\"");
        }
        if (!i_minMovPlayDate.equals("null")) {
            i_minMovPlayDate = new String("\"" + i_minMovPlayDate + "\"");
        }
        if (!i_maxMovPlayDate.equals("null")) {
            i_maxMovPlayDate = new String("\"" + i_maxMovPlayDate + "\"");
        }
        String sql1 = new String("call team32.customer_filter_mov(" +
                i_movName + "," + i_comName + "," + i_city + "," + i_state + "," + i_minMovPlayDate + "," + i_maxMovPlayDate +
                ");");
        System.out.println(sql1);
        st.executeQuery(sql1);

        String sql2 = new String("SELECT * FROM team32.cosFilterMovie;");
        ResultSet rs = st.executeQuery(sql2);
        return rs;
    }

    /**
     * 20b customer_view_mov
     *
     * @param conn             database
     * @param i_creditCardNum  card number
     * @param i_movName        mov name
     * @param i_movReleaseDate release date
     * @param i_thName         theater name
     * @param i_comName        company name
     * @param i_movPlayDate    playdate
     * @throws java.sql.SQLException throws
     */
    public void customer_view_mov(Connection conn, String i_creditCardNum, String i_movName, String i_movReleaseDate, String i_thName, String i_comName, String i_movPlayDate) throws java.sql.SQLException {
        Statement st = conn.createStatement();
        if (i_creditCardNum != null) {
            i_creditCardNum = new String("\"" + i_creditCardNum + "\"");
        }
        if (i_movName != null) {
            i_movName = new String("\"" + i_movName + "\"");
        }
        if (i_movReleaseDate != null) {
            i_movReleaseDate = new String("\"" + i_movReleaseDate + "\"");
        }
        if (i_thName != null) {
            i_thName = new String("\"" + i_thName + "\"");
        }
        if (i_comName != null) {
            i_comName = new String("\"" + i_comName + "\"");
        }
        if (i_movPlayDate != null) {
            i_movPlayDate = new String("\"" + i_movPlayDate + "\"");
        }
        String sql1 = new String("call team32.customer_view_mov(" +
                i_creditCardNum + "," + i_movName + "," + i_movReleaseDate + "," + i_thName + "," + i_comName + "," + i_movPlayDate +
                ");");
        //System.out.println(sql1);
        st.executeQuery(sql1);

    }

    /**
     * 21 customer_view_history
     *
     * @param conn          database
     * @param i_cusUsername customer user name
     * @return CosViewHistory
     * @throws java.sql.SQLException throws
     */
    public ResultSet customer_view_history(Connection conn, String i_cusUsername) throws java.sql.SQLException {
        Statement st = conn.createStatement();
        if (i_cusUsername != null) {
            i_cusUsername = new String("\"" + i_cusUsername + "\"");
        }
        String sql1 = new String("call team32.customer_view_history(" +
                i_cusUsername +
                ");");

        st.executeQuery(sql1);

        String sql2 = new String("SELECT * FROM team32.CosViewHistory;");
        ResultSet rs = st.executeQuery(sql2);
        return rs;
    }

    /**
     * 22a user_filter_th
     *
     * @param conn        database
     * @param i_thName    theater name
     * @param i_comName   company name
     * @param i_city city
     * @param i_state  state
     * @return UserFilterTh
     * @throws java.sql.SQLException throws
     */
    public ResultSet user_filter_th(Connection conn, String i_thName, String i_comName, String i_city, String i_state) throws java.sql.SQLException {
        Statement st = conn.createStatement();
        if (i_thName != null) {
            i_thName = new String("\"" + i_thName + "\"");
        }
        if (i_comName != null) {
            i_comName = new String("\"" + i_comName + "\"");
        }
        if (i_city != null) {
            i_city = new String("\"" + i_city + "\"");
        }
        if (i_state != null) {
            i_state = new String("\"" + i_state + "\"");
        }
        String sql1 = new String("call team32.user_filter_th(" +
                i_thName + "," + i_comName + "," + i_city + "," + i_state +
                ");");

        st.executeQuery(sql1);

        String sql2 = new String("SELECT * FROM team32.UserFilterTh;");
        ResultSet rs = st.executeQuery(sql2);
        return rs;
    }

    /**
     * 22b user_visit_th
     *
     * @param conn        conn the current database that is using, for this case is always team32
     * @param i_thName    i_thName the theater name that we want to type in
     * @param i_comName   i_comName the company username
     * @param i_visitDate i_visitDate the people visit date
     * @param i_username  i_username people username
     * @throws java.sql.SQLException throw java.sql.SQLException
     */
    public void user_visit_th(Connection conn, String i_thName, String i_comName, String i_visitDate, String i_username) throws java.sql.SQLException {

        Statement st = conn.createStatement();

        if (i_thName != null) {
            i_thName = new String("\"" + i_thName + "\"");
        }
        if (i_comName != null) {
            i_comName = new String("\"" + i_comName + "\"");
        }
        if (!i_visitDate.equals("null")) {
            i_visitDate = new String("\"" + i_visitDate + "\"");
        }
        if (i_username != null) {
            i_username = new String("\"" + i_username + "\"");
        }

        String sql1 = new String("call team32.user_visit_th(" +
                i_thName + "," + i_comName + "," + i_visitDate + "," + i_username +
                ");");

        st.executeQuery(sql1);

    }

    /**
     * 23 User filter visit history
     *
     * @param conn           conn the current database that is using, for this case is always team32
     * @param i_username     i_username people username
     * @param i_minVisitDate i_minVisitDate the minimum visit date
     * @param i_maxVisitDate i_maxVisitDate the maximum visit date
     * @return the result set from table UserVisitHistory
     * @throws java.sql.SQLException throw java.sql.SQLException
     */
    public ResultSet user_filter_visitHistory(Connection conn, String i_username, String i_minVisitDate, String i_maxVisitDate, String i_comName) throws java.sql.SQLException {

        Statement st = conn.createStatement();

        if (i_username != null) {
            i_username = new String("\"" + i_username + "\"");
        }
        if (!i_minVisitDate.equals("null")) {
            i_minVisitDate = new String("\"" + i_minVisitDate + "\"");
        }
        if (!i_maxVisitDate.equals("null")) {
            i_maxVisitDate = new String("\"" + i_maxVisitDate + "\"");
        }
        if (i_comName != null) {
            i_comName = new String("\"" + i_comName + "\"");
        }
        String sql1 = new String("call team32.user_filter_visitHistory(" +
                i_username + "," + i_minVisitDate + "," + i_maxVisitDate + "," + i_comName +
                ");");
        System.out.println(sql1);
        st.executeQuery(sql1);

        String sql2 = new String("SELECT * FROM team32.UserVisitHistory;");
        ResultSet rs = st.executeQuery(sql2);
        return rs;
    }
    public void test_for_phase4(Connection conn, String i_comName) throws Exception{
        Statement st = conn.createStatement();
        if (i_comName != null) {
            i_comName = new String("\"" + i_comName + "\"");
        }
        String sql1 = new String("call team32.test_for_phase4(" +
                i_comName +
                ");");
        st.executeQuery(sql1);
        //String sql2 = new String("SELECT * FROM team32.screen16comName");
       // ResultSet rs1 = st.executeQuery(sql2);
        //return rs1;
    }

}




