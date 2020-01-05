package Algorithms;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TokenBucketFilter {

	private long MAX_TOKENS = 0;
	private long availTokens = 0;
	private long lastRequest = System.currentTimeMillis();
	private long tokenDurationPeriod = 0;
	private boolean refillIntervally = true;

	public TokenBucketFilter(long maxTokens, long tokenDurationSeconds) {
		MAX_TOKENS = maxTokens;
		this.tokenDurationPeriod = tokenDurationSeconds;
	}

	public void setRefillTypeGreedy() {
		refillIntervally = false;
	}

	synchronized void tryConsume() throws InterruptedException {
		if (refillIntervally) {
			refillIntervally();
		} else {
			refillGreedily();
		}
		
		if (availTokens >= 1) {
			availTokens--;
			lastRequest = System.currentTimeMillis();
			System.out.println("Granting token to thread :" + Thread.currentThread().getName() + " at "
					+ System.currentTimeMillis() + "\nTokens left :" + availTokens);
		} 
		else {
			//You can either let the thread wait or die
			//Thread.sleep(1000);
		}

		
	}

	void refillIntervally() throws InterruptedException {
		long elapsedTime = (System.currentTimeMillis() - lastRequest) / 1000;

		if (elapsedTime >= tokenDurationPeriod) {
			availTokens = MAX_TOKENS;
		}
		
	}

	synchronized void refillGreedily() throws InterruptedException {
		long elapsedTime = (System.currentTimeMillis() - lastRequest) / 1000;

		if (elapsedTime >= tokenDurationPeriod) {
			availTokens = MAX_TOKENS;
		} else {
			availTokens += Math.min(MAX_TOKENS, elapsedTime * (MAX_TOKENS / tokenDurationPeriod));
		}

	}

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(10);
		TokenBucketFilter t = new TokenBucketFilter(5, 2);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 10; i++) {
			es.execute(new TokenUser(t));
		}

		es.shutdown();

	}

	static class TokenUser implements Runnable {
		private TokenBucketFilter t;

		public TokenUser(TokenBucketFilter t) {
			this.t = t;
		}

		@Override
		public void run() {
			try {
				t.tryConsume();
			} catch (InterruptedException e) {
				System.out.println("Error in " + Thread.currentThread().getName());
				e.printStackTrace();
			}

		}

	}

}
