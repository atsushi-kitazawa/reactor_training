package com.example.reactor.training;

import java.util.Arrays;

import reactor.core.publisher.Flux;

public class FluxTest {
	public static void main(String[] args) {
//		System.out.println("FluxTest");

		Flux<String> seq1 = Flux.just("aaa", "bbb", "ccc");
		seq1.subscribe(s -> {
			System.out.println(s.toUpperCase());
		});

		Flux<String> seq2 = Flux
				.fromIterable(Arrays.asList("aaa", "bbb", "ccc")).map(s -> {
					if ("ccc".equals(s))
						throw new RuntimeException("error!");
					return s;
				});
		seq2.subscribe(s -> System.out.println(s),
				e -> System.err.println(e));
	}
}
