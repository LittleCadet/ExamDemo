package com.migu.schedule;

import com.migu.schedule.constants.ReturnCodeKeys;
import com.migu.schedule.info.TaskInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *类名和方法不能修改
 */
public class Schedule {

	private List<Integer> nodeList;
	
	private Map<Integer, Integer> map;
	

	public int init() {

		nodeList = new ArrayList<Integer>();
		map = new HashMap<Integer, Integer>();
		return ReturnCodeKeys.E001;
	}

	public int registerNode(int nodeId) {
		if (0 >= nodeId) {
			return ReturnCodeKeys.E004;
		}
		if (nodeList.contains(nodeId)) {
			return ReturnCodeKeys.E005;
		}

		nodeList.add(nodeId);
		return ReturnCodeKeys.E003;
	}

	public int unregisterNode(int nodeId) {
		if (null != map && map.containsKey(nodeId))
		{
			int taskId = map.get(nodeId);			
			map.remove(nodeId);
			
			if (map.containsKey(taskId))
			{
				int consumption = map.get(taskId);
				map.put(taskId, consumption);
			}
		}
		if (0 >= nodeId) {
			return ReturnCodeKeys.E004;
		}
		if (!nodeList.contains(nodeId)) {
			return ReturnCodeKeys.E007;
		}
		return ReturnCodeKeys.E006;
	}

	public int addTask(int taskId, int consumption) {
		return ReturnCodeKeys.E000;
	}

	public int deleteTask(int taskId) {
		
		return ReturnCodeKeys.E000;
	}

	public int scheduleTask(int threshold) {
		// 调度阈值非法
		if (0 > threshold) {
			return ReturnCodeKeys.E002;
		}

		// TODO 方法未实现
		return ReturnCodeKeys.E000;
	}

	public int queryTaskStatus(List<TaskInfo> tasks) {
		// TODO 方法未实现
		return ReturnCodeKeys.E000;
	}

}
