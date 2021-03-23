package com.potatorice.boot.basic.entity;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
//@runwith(springrunner.class) junit4的写法
@ExtendWith(SpringExtension.class)
@SpringBootTest
class FamilyTest {
    @Resource
    private Family family;

    @Test
    void testFamily() {
        log.info("family:" + family);
        log.info("father:" + family.getFather());
        log.info("mother:" + family.getMother());
        log.info("child:" + family.getChild());

        Father father = Father.builder().name("jackson").age(33).build();
        String[] alias = new String[]{"lovely", "alice"};
        Mother mother = Mother.builder().name("MyLittlePony").alias(Arrays.asList(alias)).build();
        Friend[] friends = {Friend.builder().hobby("football").gender("male").build(),Friend.builder().hobby("sing").gender("female").build()};
        List<Friend> friendList = Arrays.asList(friends);
        Child child = Child.builder().name("jack").age(5).friends(friendList).build();
        Family expectedFamily = Family.builder().familyName("happy familyhappy familyhappy family").father(father).mother(mother).child(child).build();

        //策四family对象，断言，判断Object对象是否相等
        assertEquals(expectedFamily, family);
    }
}