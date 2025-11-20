package com.rubenalba.nicestart;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mycontext = findViewById(R.id.mycontext);
        registerForContextMenu(mycontext);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item1) {
            Toast toast = Toast.makeText(this, "Item copied",
                    Toast.LENGTH_LONG);
            toast.show();
        } else if (item.getItemId() == R.id.item2) {
            Toast toast2 = Toast.makeText(this, "Downloading item...",
                    Toast.LENGTH_LONG);
            toast2.show();
        }
        return false;
    }
}