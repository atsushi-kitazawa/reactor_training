package com.example.reactor.training;

import org.reactivestreams.Subscription;

import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

public class SubscriberTest<T> extends BaseSubscriber<T> {
	@Override
	protected void hookOnSubscribe(Subscription subscription) {
		System.out.println("hookOnSbscribe");
		request(1);
	}

	@Override
	protected void hookOnNext(T value) {
		System.err.println("hookOnNext:" + value);
		requestUnbounded();
	}

	public static void main(String[] args) {
		Flux<String> seq1 = Flux.just("aaa", "bbb", "ccc");
		SubscriberTest<String> sub = new SubscriberTest<>();
		seq1.subscribe(sub);
	}
}
