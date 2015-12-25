package xyz.gyanl.myapplication.database;

/**
 * Created by manu on 25-12-2015.
 */
/*public class WordsDbSchema {
    public static final class Nouns {
        //database titled noun db
        public static final String Noun = "nouns database";

        //column entries in the database
        public static final class Cols {
            //name and count of nouns
            public static final String count = "count";
            public static final String name = "name";
        }
    }

    //public static final class Adjec {
    //  public static final String Adjec = "adjec";
    //}

} */

    //Defining schema for the database

public class WordsDbSchema {
    //private int count;
    private String _noun;

    public WordsDbSchema() {

    }

    public WordsDbSchema(String noun) {
        this._noun = noun;
    }

    public void setNoun(String noun) {
        this._noun = noun;
    }
    public String getNoun() {
        return _noun;
    }

}


