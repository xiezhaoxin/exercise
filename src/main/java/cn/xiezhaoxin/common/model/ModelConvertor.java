package cn.xiezhaoxin.common.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;

public abstract class ModelConvertor<T1 extends BaseBean, T2 extends BaseVO> {
	private static String[] defaultIgnores = {"createDate", "isDel",
			"deleteDate" };

	public abstract String[] getIgnoreProperties();

	public abstract T1 getNewPO();

	public abstract T2 getNewVO();

	public T1 convert2PO(T2 vo) {
		if(vo == null){
			return null;
		}
		T1 po = getNewPO();
		copyProperties(vo, po);
		return po;
	}

	public void copyProperties(T2 vo, T1 po) {
		BeanUtils.copyProperties(vo, po, jointIgnoreProperties());
	}

	public T2 convert2VO(T1 po) {
		if(po == null){
			return null;
		}
		T2 vo = getNewVO();
		BeanUtils.copyProperties(po, vo, getIgnoreProperties());
		return vo;
	}

	public List<T2> convert2VOes(Collection<T1> poes) {
		List<T2> voes = new ArrayList<T2>();
		for (T1 t : poes) {
			voes.add(convert2VO(t));
		}

		return voes;
	}

	public List<T1> convert2POes(Collection<T2> voes) {
		List<T1> poes = new ArrayList<T1>();
		for (T2 t : voes) {
			poes.add(convert2PO(t));
		}

		return poes;
	}

	private String[] jointIgnoreProperties() {
		String[] all = new String[getIgnoreProperties().length
				+ defaultIgnores.length];

		System.arraycopy(defaultIgnores, 0, all, 0, defaultIgnores.length);
		System.arraycopy(getIgnoreProperties(), 0, all, defaultIgnores.length,
				getIgnoreProperties().length);

		return all;
	}

}
