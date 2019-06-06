package com.tgy.jmx;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Java8过滤器(Filter)
 *
 *
 * @author DragonSwimDiving
 * @program jmx
 * @Date 2019-06-05 10:00
 **/

public class Java8FilterTest {
    private static class Person {
        private String name;
        private int age;

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
  /**1、在Java之前对List进行过滤的方式**/
/*
  public static void main(String[] args) {

      List<Person> peoples = Arrays.asList(
              new Person("java", 22),
              new Person("js", 35),
              new Person("css", 31)
      );

      Person result = getStudentByName(peoples, "java");
      System.out.println(result.toString());

  }

    private static Person getStudentByName(List<Person> peoples, String name) {
        Person result = null;
        for (Person person : peoples) {
            if (name.equals(person.getName())) {
                result = person;
            }
        }
        return result;
    }

*/

    /**1、在Java之前对List进行过滤的方式**/

  //2、在Java8使用Filter过滤List
    public static void main(String[] args) {

        List<Person> peoples = Arrays.asList(
                new Person("java", 22),
                new Person("js", 35),
                new Person("css", 31),
                new Person("spring",20)
        );

        Person result1 = peoples.stream()
                .filter(p -> "java".equals(p.getName()))
                .findAny()
                .orElse(null);
        System.out.println(result1.toString());

        Person result2 = peoples.stream()
                .filter(p -> "spring".equals(p.getName()))
                .findAny()
                .orElse(null);
        System.out.println(result2.toString());

        Person result3 = peoples.stream()
                .filter((p) -> "java".equals(p.getName()) && 22 == p.getAge())
                .findAny()
                .orElse(null);
        System.out.println(result3.toString());

        // 使用map收集
        String name = peoples.stream()
                .filter(p -> "js".equals(p.getName()))
                .map(Person::getName)
                .findAny()
                .orElse("");
        System.out.println("---------"+name);
        System.out.println("---------");

        List<String> names = peoples.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        names.forEach(System.out::println);
    }

  /**2、在Java8使用Filter过滤List**/
}
