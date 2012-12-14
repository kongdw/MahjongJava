package ai;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import system.Functions;
import system.Hai;
import system.HaiType;
import system.Kyoku;
import system.MajanHai;
import system.SuType;
import system.TehaiList;

/**
 * AIに用いる様々なお便利メソッドを持つクラス。
 * 
 * @author shio
 * 
 */
public class AIMethods {

	/**
	 * その牌が完全不要牌かどうかを返す。
	 * @param hai 牌
	 * @param c 牌コレ
	 * @return　
	 */
	public static boolean isInvalid(Hai hai, Collection<? extends Hai> c) {

		HaiType haiType = hai.type();
		List<HaiType> nearHaiTypeList = getNearHaiTypeList(haiType);
		List<HaiType> haiTypeList = HaiType.toHaiTypeList(c);
		haiTypeList.remove(haiType);
		haiTypeList.retainAll(nearHaiTypeList);
		if (haiTypeList.size() != 0)
			return false;
		return true;
	}

	/**
	 * 手牌リストの中から完全不要牌のリストを返す。
	 * 
	 * @param c 牌コレ
	 * @return　孤立した牌のリスト
	 */
	public static List<Hai> getInvalidHaiList(Collection<? extends Hai> c) {
		List<Hai> isolatedHaiList = new ArrayList<Hai>();
		for (Hai hai : c) {
			if (isInvalid(hai, c)) {
				isolatedHaiList.add(hai);
			}
		}
		return isolatedHaiList;
	}

	/**
	 * 与えられたコレクションの中から最も有効でない牌を返す。
	 * 
	 * @param 牌のコレクション（主に孤立牌リスト）
	 * @return　最も有効でない牌
	 */
	public static Hai getHuyouHai(Collection<? extends Hai> c) {

		Hai tempHai = null;
		for (Hai hai : c) {
			if (hai.isSuhai() && hai.isYaotyuhai())
				return hai;
			if (tempHai == null) {
				tempHai = hai;
				continue;
			}
		}
		return tempHai;
	}

	/**
	 * その牌の付近の牌リスト(その牌と塔子を構成する牌リスト)を返す。
	 * ＊有効牌ではない！！！
	 * 
	 * @param haiType
	 * @return 付近の牌リスト
	 */
	public static List<HaiType> getNearHaiTypeList(HaiType haiType) {
		List<HaiType> nearHaiTypeList = new ArrayList<HaiType>();
		nearHaiTypeList.add(haiType);
		if (haiType.isTsuhai()) {
			return nearHaiTypeList;
		}
		int num = haiType.number();
		SuType suType = haiType.suType();
		if (num < 8) {
			nearHaiTypeList.add(HaiType.valueOf(suType, num + 1));
			nearHaiTypeList.add(HaiType.valueOf(suType, num + 2));
			if (num != 1) {
				nearHaiTypeList.add(HaiType.valueOf(suType, num - 1));
				if (num != 2) {
					nearHaiTypeList.add(HaiType.valueOf(suType, num - 2));
				}
			}
		} else {
			nearHaiTypeList.add(HaiType.valueOf(suType, num - 1));
			nearHaiTypeList.add(HaiType.valueOf(suType, num - 2));
			if (num == 8) {
				nearHaiTypeList.add(HaiType.valueOf(suType, num + 1));
			}
		}
		return nearHaiTypeList;
	}
	
	public static List<Hai> getExtendedValidHaiList(Collection<? extends Hai> c){
		List<Hai> extendedValidHaiList = new ArrayList<Hai>();
		
		return extendedValidHaiList;
	}
}
