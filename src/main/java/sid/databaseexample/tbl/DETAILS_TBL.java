package sid.databaseexample.tbl;

/**
 * Created by Siddhesh on 7/20/2017.
 */

public class DETAILS_TBL {

    public DETAILS_TBL(){};

    public static final String TBL_NAME = "DETAILS_TBL";
    public static final String ID = "ID";
    public static final String NAME = "NAME";
    public static final String MOBILE_NUMBER = "MOBILE_NUMBER";

    private static final String CREATE_TBL =
            (new StringBuffer()).append("create table ").append(TBL_NAME).append(" ( ")
            .append(ID).append(" numeric primary key , ")
            .append(NAME).append(" text , ")
            .append(MOBILE_NUMBER).append(" text );").toString();

    private static final String DROP_TBL = "DROP TABLE IF EXISTS "+TBL_NAME;

    public static String createTable(){
        return CREATE_TBL;
    }

    public static String dropTable(){
        return DROP_TBL;
    }
}
