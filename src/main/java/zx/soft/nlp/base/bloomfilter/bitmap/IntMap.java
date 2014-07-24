package zx.soft.nlp.base.bloomfilter.bitmap;

import zx.soft.nlp.base.bloomfilter.iface.BitMap;

/**
 * 
 * @author wanggang
 *
 */
public class IntMap implements BitMap {

	private static final int MAX = Integer.MAX_VALUE;

	public IntMap() {
		ints = new int[93750000];
	}

	public IntMap(int size) {
		ints = new int[size];
	}

	private int[] ints = null;

	@Override
	public void add(long i) {
		int r = (int) (i / 32);
		int c = (int) (i % 32);
		ints[r] = ints[r] | (1 << c);
	}

	@Override
	public boolean contains(long i) {
		int r = (int) (i / 32);
		int c = (int) (i % 32);
		if ((((ints[r] >>> c)) & 1) == 1) {
			return true;
		}
		return false;
	}

	@Override
	public void remove(long i) {
		int r = (int) (i / 32);
		int c = (int) (i % 32);
		ints[r] = ints[r] & (((1 << (c + 1)) - 1) ^ MAX);
	}

}
