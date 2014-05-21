package fr.alainmuller.androidtestsample.app.ui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import fr.alainmuller.androidtestsample.app.R;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Action déclenchée par un clic sur le bouton GO
     * ON va afficher "Bonjour <nom>"
     *
     * @param view le bouton
     */
    public void sayHello(View view) {
        EditText etName = (EditText) findViewById(R.id.et_main_name);
        TextView tvMessage = (TextView) findViewById(R.id.tv_message);
        String msg = (etName.getText() != null && !etName.getText().toString().isEmpty()) ? etName.getText().toString() : "toi";

        tvMessage.setText("Bonjour " + msg);
    }
}
