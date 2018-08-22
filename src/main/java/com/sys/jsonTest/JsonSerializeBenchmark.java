package com.sys.jsonTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import com.sys.jsonTest.model.FullName;
import com.sys.jsonTest.model.Person;
import com.sys.jsonTest.utils.FastJsonUtil;
import com.sys.jsonTest.utils.GsonUtil;
import com.sys.jsonTest.utils.JacksonUtil;
import com.sys.jsonTest.utils.JsonLibUtil;

/**
 * JSON序列化性能基准测试
 * 
 * @author Administrator
 *
 */
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Benchmark)
public class JsonSerializeBenchmark {

	@Param({ "1000", "10000", "100000" })
	private int count;

	private Person person;

	public static void main(String[] args) throws RunnerException {
		Options op = new OptionsBuilder().include(JsonSerializeBenchmark.class.getSimpleName()).forks(1)
				.warmupIterations(0).build();
		new Runner(op).run();
	}

	@Benchmark
	public void JsonLib() {
		for (int i = 0; i < count; i++) {
			JsonLibUtil.bean2Json(person);
		}
	}

	@Benchmark
	public void Gson() {
		for (int i = 0; i < count; i++) {
			GsonUtil.bean2Json(person);
		}
	}

	@Benchmark
	public void FastJson() {
		for (int i = 0; i < count; i++) {
			FastJsonUtil.bean2Json(person);
		}
	}

	@Benchmark
	public void Jsckson() {
		for (int i = 0; i < count; i++) {
			JacksonUtil.bean2Json(person);
		}
	}

	@Setup
	public void prepare() {
		List<Person> friends = new ArrayList<Person>();
		friends.add(createAPerson("夏明", null));
		friends.add(createAPerson("Bob", null));
		friends.add(createAPerson("小二", null));
		person = createAPerson("张三", friends);
	}

	private Person createAPerson(String name, List<Person> friends) {
		Person newPerson = new Person();
		newPerson.setName(name);
		newPerson.setFullName(new FullName("zhangsan_first", "zhangsan_middle", "zhangsan_last"));
		newPerson.setAge(25);
		List<String> hobbies = new ArrayList<String>();
		hobbies.add("篮球");
		hobbies.add("游泳");
		hobbies.add("coding");
		newPerson.setHobbies(hobbies);
		Map<String, String> clothes = new HashMap<String, String>();
		clothes.put("coat", "NIKE");
		clothes.put("trousers", "adidas");
		clothes.put("shoes", "安踏");
		newPerson.setClothes(clothes);
		newPerson.setFriends(friends);
		return newPerson;
	}

	@TearDown
	public void shutdown() {

	}

}
