package test;

import ai.AIMethods;
import system.Hai;
import system.HaiType;
import system.MajanHai;
import system.TehaiList;

public class AITest {
	public static void main(String[] args) {
		TehaiList tlist = new TehaiList();
		tlist.add(MajanHai.ITI_MAN);
		tlist.add(MajanHai.NI_MAN);
		tlist.add(MajanHai.SAN_MAN);
		tlist.add(MajanHai.YO_MAN);
		tlist.add(MajanHai.AKA_GO_MAN);
		tlist.add(MajanHai.ROKU_MAN);
		tlist.add(MajanHai.NANA_MAN);
		tlist.add(MajanHai.HATI_MAN);
		tlist.add(MajanHai.KYU_MAN);
		tlist.add(MajanHai.HAKU);
		tlist.add(MajanHai.HATU);
		tlist.add(MajanHai.KYU_PIN);
		tlist.add(MajanHai.ITI_SOU);
		//ツモ牌
		tlist.add(MajanHai.HAKU);
		
		System.out.println(tlist.toString());
		System.out.println(AIMethods.getInvalidHaiList(tlist));
	}
}
