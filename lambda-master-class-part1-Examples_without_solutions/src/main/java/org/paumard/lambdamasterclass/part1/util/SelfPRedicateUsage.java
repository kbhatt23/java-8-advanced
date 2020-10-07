package org.paumard.lambdamasterclass.part1.util;

import static org.assertj.core.api.Assertions.assertThat;

public class SelfPRedicateUsage {
public static void main(String[] args) {
	SelfPredicate<String> p1 = s -> s.length() == 4;
	SelfPredicate<String> p2 = s -> s.startsWith("J");
	SelfPredicate<String> p3 = p1.xor(p2);
	
	assertThat(p3.test("True")).isTrue();
    assertThat(p3.test("Julia")).isTrue();
    assertThat(p3.test("Java")).isFalse();
    
}
}
