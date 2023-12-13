package edu.ua.cs.cs200.project4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MemberRecords {

  private List<Member> members;

  public MemberRecords() {
    members = new ArrayList<>();
    // Load members from the file on initialization
    loadMembersFromFile();
  }

  public Member getMember(int memberID) {
    for (Member member : members) {
      if (member.getMemberID() == memberID) {
        return member;
      }
    }
    return null; // Member not found
  }

  public void addMember(Member member) {
    members.add(member);
    saveMembersToFile(); // Save the updated list to the file
  }

  public void removeMember(int memberID) {
    Member existingMember = getMember(memberID);
    if (existingMember != null) {
      members.remove(existingMember);
      saveMembersToFile(); // Save the updated list to the file
    }
  }

  public List<Member> getAllMembers() {
    return members;
  }

  private void loadMembersFromFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader("members.txt"))) {
      String line;
      while ((line = reader.readLine()) != null) {
        members.add(new Member(line));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void saveMembersToFile() {
    try (PrintWriter writer = new PrintWriter(new FileWriter("members.txt"))) {
      for (Member member : members) {
        writer.println(member.toString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}