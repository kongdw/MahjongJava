package junit;

import static system.hai.MajanHai.GO_MAN;
import static system.hai.MajanHai.GO_SOU;
import static system.hai.MajanHai.HATI_MAN;
import static system.hai.MajanHai.ITI_MAN;
import static system.hai.MajanHai.KYU_MAN;
import static system.hai.MajanHai.KYU_SOU;
import static system.hai.MajanHai.NAN;
import static system.hai.MajanHai.NANA_MAN;
import static system.hai.MajanHai.NANA_SOU;
import static system.hai.MajanHai.NI_MAN;
import static system.hai.MajanHai.NI_PIN;
import static system.hai.MajanHai.ROKU_MAN;
import static system.hai.MajanHai.ROKU_SOU;
import static system.hai.MajanHai.SAN_MAN;
import static system.hai.MajanHai.SAN_PIN;
import static system.hai.MajanHai.TON;
import static system.hai.MajanHai.YO_MAN;
import static system.hai.MajanHai.YO_PIN;

import java.util.Arrays;

import org.junit.Test;

import system.algo.PatternMethod;
import system.hai.Hai;
import system.hai.NMentsu1Janto;
import system.hai.TehaiList;

public class NMentsu1JantoTest {
	static TehaiList list1;
	static TehaiList list2;
	static TehaiList list3;
	
	// 1,1,1,2,3

	static {
		PatternMethod.loadClass();
		
		// 1,2,2,2,3,3,3,4,4, TON,TON,TON, NAN,NAN
		// 一盃口
		list1 = new TehaiList(Arrays.asList(new Hai[] { ITI_MAN, NI_MAN, NI_MAN, NI_MAN, SAN_MAN, SAN_MAN, SAN_MAN, YO_MAN, YO_MAN, TON, TON, TON, NAN, NAN }));

		// 2,3,4,4,5,6, 二,三,四, ５,６,７,９,９
		list2 = new TehaiList(Arrays.asList(new Hai[] { NI_MAN, SAN_MAN, YO_MAN, YO_MAN, GO_MAN, ROKU_MAN, NI_PIN, SAN_PIN, YO_PIN, GO_SOU, ROKU_SOU, NANA_SOU, KYU_SOU, KYU_SOU }));

		// 1,2,2,3,3,3,4,4,5,6,7,8,9,9
		list3 = new TehaiList(Arrays.asList(new Hai[] { ITI_MAN, NI_MAN, NI_MAN, SAN_MAN, SAN_MAN, SAN_MAN, YO_MAN, YO_MAN, GO_MAN, ROKU_MAN, NANA_MAN, HATI_MAN, KYU_MAN, KYU_MAN }));

	}

	@Test
	public void test() {
		NMentsu1Janto nmj = NMentsu1Janto.newInstanceFromSyuntsu(list1);
		nmj = NMentsu1Janto.newInstanceFromSyuntsu(list2);
		nmj = NMentsu1Janto.newInstanceFromKotsu(list2);
		nmj = NMentsu1Janto.newInstanceFromSyuntsu(list3);
		System.out.println(nmj);
	}
}
