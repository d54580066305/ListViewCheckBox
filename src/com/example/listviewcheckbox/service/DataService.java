package com.example.listviewcheckbox.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.listviewcheckbox.entity.SubjectItem;

public class DataService {
	
	/**
	 * ģ������ݿ���ȡͶƱ������Ŀ������Դ
	 * @return
	 */
	public static List<SubjectItem> getSubjectItems()
	{
		List<SubjectItem> list = new ArrayList<SubjectItem>();
		HashMap<String, Boolean> subjectMap=new HashMap<String, Boolean>();
		for (int i = 0; i < 3; i++) {
			
			for (int j = 0; j < 3; j++) {
				
				SubjectItem item = new SubjectItem();
				item.setSubjectId(i+"");
				if(subjectMap.containsKey(item.getSubjectId()))
				{
					item.setSubjectName("");
				}
				else
				{
					item.setSubjectName("ͶƱ����"+i);
					subjectMap.put(item.getSubjectId(), true);
				}
				
				item.setItemId(i+""+j);
				item.setItemName("��Ŀ����"+i+""+j);
				item.setIsMultiChoice(i%2==1?true:false);
				list.add(item);
				
			}
		}
		return list;
	}

}
