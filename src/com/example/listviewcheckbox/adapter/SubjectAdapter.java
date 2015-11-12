package com.example.listviewcheckbox.adapter;

import java.util.HashMap;
import java.util.List;

import com.example.listviewcheckbox.R;
import com.example.listviewcheckbox.entity.SubjectItem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class SubjectAdapter extends BaseAdapter {
	
	private List<SubjectItem> list;
	private Context context;
	//�洢�����������Ŀ��ѡ��״̬����������������Ի�ȡѡ�е���Ŀ��Ϣ
    private HashMap<String,Boolean> subjectItemMap;
    private LayoutInflater inflater;
	
	public class ViewHolder{
	   //ͶƱ����id�ؼ�
	   public TextView tvSubjectId;
	   //ͶƱ�������ƿؼ�
	   public TextView tvSubjectName;
	   //ͶƱ��Ŀ���ƿؼ�
	   public TextView tvSubjectItemName;
	   //ͶƱ��Ŀid�ؼ�
	   public TextView tvSubjectItemId;
	   //ͶƱ�������ͣ���ѡ���ѡ���ؼ�
	   public TextView tvIsMultiChoice;
	   //ѡ��CheckBox�ؼ�����������Ϊ��ѡʱ��ʾ��
	   public CheckBox cbSubjectItem;
	   //ѡ��RadioButton�ؼ�����������Ϊ��ѡʱ��ʾ��
	   public RadioButton rbSubjectItem;
		
	}
	
	public SubjectAdapter(List<SubjectItem> list,Context context)
	{
		this.list=list;
		this.context=context;
		 inflater = LayoutInflater.from(context);
		this.subjectItemMap=new HashMap<String, Boolean>();
		//��ʼ��subjectItemMap��Ĭ��������ĿΪδѡ��״̬
		for (int i = 0; i < list.size(); i++) {
			this.subjectItemMap.put(list.get(i).getItemId(), false);
		}
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder = null;
    	SubjectItem item = list.get(position);
		if(convertView!=null&&convertView.getId()==R.id.lv_subject)
		{
			viewHolder=(ViewHolder)convertView.getTag();
		}
		else {
			viewHolder = new ViewHolder();
			convertView=inflater.inflate(R.layout.listview_subject_item, null);
			viewHolder.tvSubjectId=(TextView)convertView.findViewById(R.id.tv_subject_id);
			viewHolder.tvSubjectName=(TextView) convertView.findViewById(R.id.tv_subject_name);
			viewHolder.tvSubjectItemId = (TextView) convertView.findViewById(R.id.tv_subject_item_id);
			viewHolder.tvSubjectItemName = (TextView) convertView.findViewById(R.id.tv_subject_item_name);
			viewHolder.cbSubjectItem = (CheckBox) convertView.findViewById(R.id.cb_subject_item);
			viewHolder.rbSubjectItem = (RadioButton) convertView.findViewById(R.id.rb_subject_item);
			viewHolder.tvIsMultiChoice = (TextView) convertView.findViewById(R.id.tv_is_multi_choice );
			
		}
		
		//�����Ŀ����Ϊ�վ����ص�ǰ��Ĳ�Ʒ���ƣ�����������Ŀֻ�����һ������Ŀ���ֲ�Ʒ����
		if(item.getSubjectName().equals(""))
		{
			viewHolder.tvSubjectName.setVisibility(View.GONE);
		}
		else {
			viewHolder.tvSubjectName.setText(item.getSubjectName());
		}
		
		viewHolder.tvSubjectItemId.setText(item.getItemId());
		viewHolder.tvSubjectId.setText(item.getSubjectId());
		viewHolder.tvSubjectItemName.setText(item.getItemName());
		viewHolder.tvIsMultiChoice.setText(item.getIsMultiChoice().toString());
		//��ǰ��ĿΪ��ѡ��Ŀ
		if(item.getIsMultiChoice().toString().equals("true"))
		{
			viewHolder.cbSubjectItem.setVisibility(View.VISIBLE);
			viewHolder.rbSubjectItem.setVisibility(View.GONE);
			viewHolder.cbSubjectItem.setChecked(this.subjectItemMap.get(item.getItemId()));
			
		}
		//��ǰ��ĿΪ��ѡ��Ŀ
		else {
			viewHolder.cbSubjectItem.setVisibility(View.GONE);
			viewHolder.rbSubjectItem.setVisibility(View.VISIBLE);
			viewHolder.rbSubjectItem.setChecked(this.subjectItemMap.get(item.getItemId()));
		}
		convertView.setTag(viewHolder);
        return convertView;
	}
	
	/**
	 * ��ȡ�����������Ŀ��ѡ��״̬����
	 * @return
	 */
	 public  HashMap<String,Boolean> getSubjectItemMap() {
	        return this.subjectItemMap;
	    }


}
