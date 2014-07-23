package zx.soft.nlp.base.lang.jianfan;

import zx.soft.nlp.base.dic.DicManager;
import zx.soft.nlp.base.tire.GetWord;
import zx.soft.nlp.base.tire.domain.Forest;
import zx.soft.nlp.base.util.StringUtil;

/**
 * 简体繁体相互转换
 * Created by ansj on 4/1/14.
 */
public class JianFan {

	private static final Forest J2F_FOREST = DicManager.getJ2fForest();

	private static final Forest F2J_FOREST = DicManager.getF2jForest();

	/**
	 * 简体转繁体
	 * @param str
	 * @return
	 */
	public static String j2F(String str) {
		return toCover(J2F_FOREST , str);
	}

	/**
	 * 繁体转简体
	 * @param str
	 * @return
	 */
	public static String f2J(String str) {
		return toCover(F2J_FOREST , str);
	}

	private static String toCover(Forest forest ,String str) {
		if (StringUtil.isBlank(str)) {
			return str;
		}

		GetWord word = forest.getWord(str);

		StringBuilder sb = new StringBuilder(str.length());

		String temp = null;
		int beginOffe = 0;
		while ((temp = word.getFrontWords()) != null) {
			sb.append(str.substring(beginOffe, word.offe));
			sb.append(word.getParam(0));
			beginOffe = word.offe + temp.length();
		}

		if (beginOffe < str.length()) {
			sb.append(str.substring(beginOffe, str.length()));
		}
		return sb.toString();
	}


	public static void main(String[] args) {
		System.out.println(JianFan.f2J("士多啤梨士多啤梨輸入簡體字,點下面繁體字按鈕進行在線轉換123"));

		System.out.println(JianFan.j2F("草莓草莓草莓输入简体字,点下面繁体字按钮进行在线转换123草莓"));
	}

}
