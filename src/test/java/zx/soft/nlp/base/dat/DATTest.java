package zx.soft.nlp.base.dat;

import org.junit.Test;

public class DATTest {

	@Test
	public void makerTest() throws Exception {
		DATMaker dat = new DATMaker();

		dat.maker("pinyin.dic");

		dat.saveText("pinyin.dat");

		dat.save("pinyin.obj");
	}

	@Test
	public void loadTest() throws Exception {
		long start = System.currentTimeMillis();
		DoubleArrayTire load = DoubleArrayTire.load("pinyin.obj");
		System.out.println(load.getItem("龙麝"));
		System.out.println("load obj use time " + (System.currentTimeMillis() - start));
	}

	@Test
	public void loadTextTest() throws Exception {
		long start = System.currentTimeMillis();
		DoubleArrayTire load = DoubleArrayTire.loadText("pinyin.dat");
		System.out.println(load.getItem("龙麝"));
		System.out.println("load obj use time " + (System.currentTimeMillis() - start));
	}

}
