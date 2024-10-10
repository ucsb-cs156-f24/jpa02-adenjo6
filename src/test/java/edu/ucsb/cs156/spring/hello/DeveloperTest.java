package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from
        // https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()), "Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Aden", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("adenjo6", Developer.getGithubId());
    }
    
    @Test
    public void getTeam_returns_correct_team() {
        Team team = Developer.getTeam();
        assertEquals("f24-11", team.getName());
        assertEquals(6, team.getMembers().size());
        assertTrue(team.getMembers().contains("Aden"));
        assertTrue(team.getMembers().contains("Brian"));
        assertTrue(team.getMembers().contains("Frank"));
        assertTrue(team.getMembers().contains("John"));
        assertTrue(team.getMembers().contains("Jonathan"));
        assertTrue(team.getMembers().contains("Samuel"));
    }
}
