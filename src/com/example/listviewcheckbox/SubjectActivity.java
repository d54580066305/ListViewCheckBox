package com.example.listviewcheckbox;

import java.util.HashMap;
import java.util.List;
import com.example.listviewcheckbox.adapter.SubjectAdapter;
import com.example.listviewcheckbox.adapter.SubjectAdapter.ViewHolder;
import com.example.listviewcheckbox.entity.SubjectItem;
import com.example.listviewcheckbox.service.DataService;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class SubjectActivity extends Activity {

	private ListView lvSubject;
	private SubjectAdapter subjectAdapter;
	private List<SubjectItem> list;
	private Button btnAdd;
	// �������浥ѡ���⵱ǰѡ�е���Ŀ�������û����л�ѡ��ͬһ������������ѡ��ʱ�ܹ���֮ǰѡ�е���Ŀ��״̬����Ϊδѡ״̬
	private HashMap<String, String> radioButtonSelectedMaps;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_subject_activity);
		lvSubject = (ListView) findViewById(R.id.lv_subject);
		btnAdd = (Button) findViewById(R.id.btn_add);
		//������Դ��ȡͶƱ�������Ŀ��Ϣ
		list = DataService.getSubjectItems();
		subjectAdapter = new SubjectAdapter(list, this);
		lvSubject.setAdapter(subjectAdapter);
		radioButtonSelectedMaps = new HashMap<String, String>();
		// �ύͶƱ�¼�����
		btnAdd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String selectValues="ѡ����Ϣ:";
				//�����û�ѡ����Ŀ�����Ը���ʵ�������ȡѡ����Ŀ���κ���Ϣ
				for (int i = 0; i < list.size(); i++) {
					if(subjectAdapter.getSubjectItemMap().get(list.get(i).getItemId()))
					{
						selectValues+="��ĿID:"+list.get(i).getItemId()+"��Ŀ����:"+list.get(i).getItemName();
					}
					
				}
				Toast.makeText(SubjectActivity.this, selectValues.equals("ѡ����Ϣ:")?"δѡ���κ���Ϣ":selectValues, Toast.LENGTH_LONG).show();
			}
		});

		// ListView�ؼ�ÿһ�е���¼�����
		lvSubject.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				ViewHolder viewHolder = (ViewHolder) view.getTag();
				// �����ǰ���Ƕ�ѡ��Ŀ
				if (viewHolder.tvIsMultiChoice.getText().equals("true")) {
					viewHolder.cbSubjectItem.toggle();
					subjectAdapter.getSubjectItemMap().put(viewHolder.tvSubjectItemId.getText().toString(),viewHolder.cbSubjectItem.isChecked());

				} 
				
				//�����ǰ��Ϊ��ѡ��Ŀ��ע�ⵥѡ��Ŀѡ�к���Ҫ��ͬһ�������Ѿ�ѡ�е���Ŀ����Ϊδѡ��״̬
				else {
					String currentSubjectIdSelected=viewHolder.tvSubjectId.getText().toString();
					String currentSubjectItemId=viewHolder.tvSubjectItemId.getText().toString();
					//�жϸõ�ѡ�����Ƿ����Ѿ�ѡ����Ŀ���������Ҫ������ѡ��״̬����Ϊδѡ��
					if (radioButtonSelectedMaps.containsKey(currentSubjectIdSelected)) {
						subjectAdapter.getSubjectItemMap().put(radioButtonSelectedMaps.get(currentSubjectIdSelected),false);

					}
					//����ǰѡ�е���Ŀ����Ϊ�õ�ѡ�����ѡ����Ŀ
					radioButtonSelectedMaps.put(currentSubjectIdSelected,currentSubjectItemId);
					viewHolder.rbSubjectItem.toggle();
					subjectAdapter.getSubjectItemMap().put(currentSubjectItemId,viewHolder.rbSubjectItem.isChecked());
					//����ListView
					updateListView();

				}
			
			}});

	}
	
	/**
	 * ����ListView
	 */
	private void updateListView()
	{
		subjectAdapter.notifyDataSetChanged();
	}

}
