package com.sys.JMHDemo;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class JMHFirstBenchmark {

	// 对要被测试性能的代码加注解，说明该方法是要被测试性能的
	@Benchmark
	public int sleepAWhile() {
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void main(String[] args) throws RunnerException {
		Options options = new OptionsBuilder().include(JMHFirstBenchmark.class.getSimpleName()).forks(1)
				.warmupIterations(3).measurementIterations(3).build();
		new Runner(options).run();
		

	}

}
