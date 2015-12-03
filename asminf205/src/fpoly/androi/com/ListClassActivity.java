package fpoly.androi.com;


import java.util.List;



import model.LopHoc;
import DAO.ClassDAO;
import DAO.StudentDAO;
import adapter.ClassAdapter;
import adapter.StudentAdapter;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class ListClassActivity extends ActionBarActivity {
ClassDAO daoclass;
ClassAdapter adapterClass;
List<LopHoc> livClass;

ListView lvlop;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_class);
		lvlop = (ListView) findViewById(R.id.listclass);
		
		daoclass = new ClassDAO(this);
		livClass = daoclass.getLop();
		
		
		adapterClass = new ClassAdapter(this, livClass);
		lvlop.setAdapter(adapterClass);
		
		lvlop.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,	long id) {
				
				String malop = livClass.get(position).MaLop;

				Intent intent = new Intent(ListClassActivity.this, ListStudentActivity.class);
				
				Bundle b = new Bundle();
				
				b.putString("malop", malop);
				intent.putExtra("lop", b);
				startActivity(intent);
			}
		});
		


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_class, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


}
