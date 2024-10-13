package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.lenient;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");
    }

    @Test
    public void getName_returns_correct_name() {
        assert (team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void testEquals_SameObject() {
        Team team = new Team("team1");
        team.addMember("member1");
        team.addMember("member2");
        assertTrue(team.equals(team)); // Should return true because it's the same object
    }

    @Test
    public void testEquals_SameObjectDifferentInstance() {
        Team team1 = new Team("team1");
        String team2 = "team2";
        assertTrue(!(team1.equals(team2)));
    }

    @Test
    public void testEquals_BothFieldsEqual() {
        Team team1 = new Team("team1");
        team1.addMember("member1");
        team1.addMember("member2");
        Team team2 = new Team("team1");
        team2.addMember("member1");
        team2.addMember("member2");
        assertTrue(team1.equals(team2));
    }

    @Test
    public void testEquals_SameNameDifferentMembers() {
        Team team1 = new Team("team1");
        team1.addMember("member1");
        team1.addMember("member2");
        Team team2 = new Team("team1");
        team2.addMember("member1");
        assertTrue(!(team1.equals(team2)));
    }

    @Test
    public void testEquals_DifferentNameSameMembers() {
        Team team1 = new Team("team1");
        team1.addMember("member1");
        team1.addMember("member2");
        Team team2 = new Team("team2");
        team2.addMember("member1");
        team2.addMember("member2");
        assertTrue(!(team1.equals(team2)));
    }

    @Test
    public void testEquals_DifferentObjects() {
        Team team1 = new Team("team1");
        team1.addMember("member1");
        team1.addMember("member2");
        Team team2 = new Team("team2");
        team2.addMember("member1");
        assertTrue(!(team1.equals(team2)));
    }

    @Test
    public void testHashCode() {
        Team team1 = new Team("team");
        team1.addMember("member1");
        team1.addMember("member2");
        Team team2 = new Team("team");
        team2.addMember("member1");
        team2.addMember("member2");
        assertEquals(team1.hashCode(), team2.hashCode());
    }

    @Test
    public void testHashCodeMutation() {
        Team t = new Team("t");
        int result = t.hashCode();
        int expectedResult = 117;
        assertEquals(expectedResult, result);
    }

}
