package producerDemo.test;

import org.junit.Test;

public class TestHtml {
	@Test
	public void test() {
		String str="<span></span></br><h1></h1>";
		System.out.println(str.replaceAll("</?(?!/?br)[^>]*>", ""));
	}

}
