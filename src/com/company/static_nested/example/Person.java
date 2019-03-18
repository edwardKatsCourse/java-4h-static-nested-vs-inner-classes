package com.company.static_nested.example;

import java.util.Random;

public class Person {

    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Name: %s | Age: %s",
                this.name,
                this.age);
    }




    static class PersonRandomGenerator {

        private Integer minAge;
        private Integer maxAge;

        private String[] names = new String[]{
                "David",
                "Marry",
                "Sarah",
                "James",
                "Michael",
                "Moshe",
                "Peter",
                "John"
        };

        public PersonRandomGenerator(Integer minAge, Integer maxAge) {
            this.minAge = minAge;
            this.maxAge = maxAge;
        }

        public PersonRandomGenerator() {
            this.minAge = 18;
            this.maxAge = 120;
        }

        private Integer getRandomAge() {
            Random r = new Random();

            int result = r.nextInt(this.maxAge - this.minAge) + this.minAge;
            return result;
        }

        private String getRandomName() {
            Random random = new Random();
            int result = random.nextInt(names.length); //from 5 elements -> 0..4
            return names[result];

        }

        public Person getRandomPerson() {
            return new Person(getRandomName(), getRandomAge());
        }

        public Person [] getRandomPersons(Integer count) {
            Person[] persons = new Person[count];

            for (int i = 0; i < persons.length; i++) {
                persons[i] = getRandomPerson();
            }

            return persons;
        }

//        public static void main(String[] args) {
//            Random random = new Random();
//            for (int i = 0; i < 100; i++) {
//                int result = random.nextInt(100); //0..99
//                System.out.println(result);
//            }
//        }
    }
}


class TestApplication {

    public static void main(String[] args) {
        Person person = new Person
                .PersonRandomGenerator()
                .getRandomPerson();

        System.out.println(person);

        System.out.println("-----------");

        Person [] people = new Person
                .PersonRandomGenerator(25, 35)
                .getRandomPersons(20);

        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i].toString());
        }
    }
}