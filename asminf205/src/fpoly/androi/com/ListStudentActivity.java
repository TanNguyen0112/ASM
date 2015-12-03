package fpoly.androi.com;

import java.util.List;

import model.LopHoc;
import model.Student;
import DAO.ClassDAO;
import DAO.StudentDAO;
import adapter.ClassAdapter;
import adapter.StudentAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ListStudentActivity extends ActionBarActivity {
	StudentDAO daoclass;
	StudentAdapter adapterClass;
	List<Student> livClass;

	ListView lvlop;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_list_class);
			lvlop = (ListView) findViewById(R.id.listclass);
			
			daoclass = new StudentDAO(this);
			livClass = daoclass.getStudent();
			
			
			adapterClass = new StudentAdapter(this, livClass);
			lvlop.setAdapter(adapterClass);
			
//			lvlop.setOnItemClickListener(new OnItemClickListener(){
//				@Override
//				public void onItemClick(AdapterView<?> parent, View view, int position,	long id) {
//					
//					String malop = livClass.get(position).MaLop;
//
//					Intent intent = new Intent( ListStudentActivity.this, ListClassActivity.class);
//					
//					Bundle b = new Bundle();
//					
//					b.putString("malop", malop);
//					intent.putExtra("lop", b);
//					startActivity(intent);
//				}
//			});
//			


		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_student, menu);
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
