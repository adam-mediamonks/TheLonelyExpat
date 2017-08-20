package ie.moses.thelonelyexpat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar _toolbar;
    @BindView(R.id.events_list) RecyclerView _eventsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(_toolbar);

        Event event = new Event();
        event.title = "Duolingo together!";
        event.description = "Let's get together in the park and practice our Dutch together Duolingo style!";
        event.time = System.currentTimeMillis() + DateTimeUtils.ONE_WEEK;

        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        database.child("events").setValue(event);//,
//                (databaseError, databaseReference) -> {
//                    if(databaseError == null) {
//                        Log.i("mo", "success");
//                    }else {
//                        throw databaseError.toException();
//                    }
//                });

//        _eventsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        _eventsRecyclerView.setAdapter(new FirebaseRecyclerAdapter() {
//            @Override protected void populateViewHolder(final RecyclerView.ViewHolder viewHolder, final Object model, final int position) {
//
//            }
//        });
    }

    @OnClick(R.id.fab)
    public void addEvent() {
        Toast.makeText(this, "Add event", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
