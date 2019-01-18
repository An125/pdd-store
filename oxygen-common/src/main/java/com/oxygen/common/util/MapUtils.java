package com.oxygen.common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @描述：Map工具类
 * @作者： wu.liang
 * @日期：Mar 15, 2018
 */
public class MapUtils {
	
	/**
	 * 对 map 根据 key 进行排序 ASCII 顺序
	 * @描述：
	 * @作者：Wu.Liang
	 * @param map	无序的map
	 * @return
	 */
	public static SortedMap<String, Object> sortMap(Map<String, Object> map) {
		List<Map.Entry<String, Object>> infoIds = new ArrayList<Map.Entry<String, Object>>(map.entrySet());
		// 排序
		Collections.sort(infoIds, new Comparator<Map.Entry<String, Object>>() {
			public int compare(Map.Entry<String, Object> o1, Map.Entry<String, Object> o2) {
				return (o1.getKey()).toString().compareTo(o2.getKey());
			}
		});
		SortedMap<String, Object> sortmap = new TreeMap<String, Object>();
		for (int i = 0; i < infoIds.size(); i++) {
			String[] split = infoIds.get(i).toString().split("=");
			sortmap.put(split[0], split[1]);
		}
		return sortmap;
	}
}
