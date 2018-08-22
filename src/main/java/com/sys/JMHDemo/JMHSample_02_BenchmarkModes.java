package com.sys.JMHDemo;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * 测试注解 @BenchmarkMode 和 @OutputTimeUnit
 * 
 * @author Administrator
 *
 */
public class JMHSample_02_BenchmarkModes {

	/**
	 * 吞吐量模式
	 * 
	 * @throws InterruptedException
	 */
	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void measureThroughput() throws InterruptedException {
		TimeUnit.MICROSECONDS.sleep(100);
	}

	/**
	 * 平均时间
	 * 
	 * @throws InterruptedException
	 */
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public void measureAvgTime() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(100);
	}

	/**
	 * 随机抽样
	 * 
	 * @throws InterruptedException
	 */
	@Benchmark
	@BenchmarkMode(Mode.SampleTime)
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public void measureSamples() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(100);
	}

	/**
	 * 单次
	 * 
	 * @throws InterruptedException
	 */
	@Benchmark
	@BenchmarkMode(Mode.SingleShotTime)
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public void measureSingleShot() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(100);
	}

	/*
	 * 多模式一次测试 We can also ask for multiple benchmark modes at once. All the tests
	 * above can be replaced with just a single test like this:
	 */
	@Benchmark
	@BenchmarkMode({ Mode.Throughput, Mode.AverageTime, Mode.SampleTime, Mode.SingleShotTime })
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public void measureMultiple() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(100);
	}

	/*
	 * 测试所有模式 Or even...
	 */
	@Benchmark
	@BenchmarkMode(Mode.All)
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public void measureAll() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(100);
	}

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(JMHSample_02_BenchmarkModes.class.getSimpleName())
				.warmupIterations(5).measurementIterations(5).forks(1).build();
		new Runner(opt).run();
	}

}
