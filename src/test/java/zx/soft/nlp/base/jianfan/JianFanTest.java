package zx.soft.nlp.base.jianfan;

import org.junit.Test;

import zx.soft.nlp.base.lang.jianfan.JianFan;

public class JianFanTest {

	@Test
	public void test() {
		System.out.println(JianFan.f2J(JianFan.j2F("草莓是红色的"))); ;
		System.out.println(JianFan.j2F(JianFan.j2F("草莓是红色的")));;
	}

}
