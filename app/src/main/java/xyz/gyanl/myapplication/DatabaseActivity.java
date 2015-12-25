package xyz.gyanl.myapplication;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import xyz.gyanl.myapplication.database.WordsDbHelper;
import xyz.gyanl.myapplication.database.WordsDbSchema;

public class DatabaseActivity extends ActionBarActivity {

    TextView idView;
    EditText productBox;
    //EditText quantityBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        //idView = (TextView) findViewById(R.id.productID);
        productBox = (EditText) findViewById(R.id.productnoun);
        //quantityBox = (EditText) findViewById(R.id.productQuantity);
    }

    public void newProduct (View view) {
        WordsDbHelper wordsDbHelper = new WordsDbHelper(this, null, null, 1);

        //int quantity =
          //      Integer.parseInt(quantityBox.getText().toString());

       WordsDbSchema wordsDbSchema = new WordsDbSchema(productBox.getText().toString());

        wordsDbHelper.addProduct(wordsDbSchema);
        productBox.setText("");
        //quantityBox.setText("");
    }

    public void lookupProduct (View view) {
        WordsDbHelper wordsDbHelper = new WordsDbHelper(this, null, null, 1);

        WordsDbSchema wordsDbSchema =
                wordsDbHelper.findNoun(productBox.getText().toString());

        //if (wordsDbSchema != null) {
        //idView.setText(String.valueOf(product.getID()));

        //    quantityBox.setText(String.valueOf(product.getQuantity()));

    }

    /*public void removeProduct (View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null,
                null, 1);

        boolean result = dbHandler.deleteProduct(
                productBox.getText().toString());

        if (result)
        {
            idView.setText("Record Deleted");
            productBox.setText("");
            quantityBox.setText("");
        }
        else
            idView.setText("No Match Found");
    } */

}
